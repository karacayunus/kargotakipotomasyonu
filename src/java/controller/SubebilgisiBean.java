/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SubebilgisiDAO;
import entity.Adresbilgisi;
import entity.Subebilgisi;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "subebilgisiBean")
@SessionScoped
public class SubebilgisiBean implements Serializable {

    private Subebilgisi entity;
    private SubebilgisiDAO dao;
    private List<Subebilgisi> list;

    public SubebilgisiBean() {
    }
    private int page = 1;
    private int pageSize = 3;
    private int pageCount;
    
    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPagesize(int pagesize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pagecount) {
        this.pageCount = pageCount;
    }

    public List<Subebilgisi> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public String getTitle(int id) {
        Subebilgisi c = this.getDao().findByID(id);
        return c.getAd();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Subebilgisi();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Subebilgisi();
    }

    public void delete(Subebilgisi p) {
        this.getDao().delete(p);
        entity = new Subebilgisi();
    }

    public void clear() {
        entity = new Subebilgisi();
    }

    
    public Subebilgisi getEntity() {
        if (this.entity == null) {
            this.entity = new Subebilgisi();
        }
        return entity;
    }

    public void setEntity(Subebilgisi entity) {
        this.entity = entity;
    }

    public SubebilgisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new SubebilgisiDAO();
        }
        return dao;
    }

    public void setDao(SubebilgisiDAO dao) {
        this.dao = dao;
    }

   

    public void setList(List<Subebilgisi> list) {
        this.list = list;
    }

}
