/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AdresbilgisiDAO;
import entity.Adresbilgisi;
import entity.Kargo;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "adresbilgisiBean")
@SessionScoped
public class AdresbilgisiBean implements Serializable {

    private Adresbilgisi entity;
    private AdresbilgisiDAO dao;
    private List<Adresbilgisi> list;

    public AdresbilgisiBean() {
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

    public List<Adresbilgisi> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public String getTitle(int id) {
        Adresbilgisi c = this.getDao().findByID(id);
        return c.getAd();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Adresbilgisi();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Adresbilgisi();
    }

    public void delete(Adresbilgisi p) {
        this.getDao().delete(p);
        entity = new Adresbilgisi();
    }

    public void clear() {
        entity = new Adresbilgisi();
    }

    
    public Adresbilgisi getEntity() {
        if (this.entity == null) {
            this.entity = new Adresbilgisi();
        }
        return entity;
    }

    public void setEntity(Adresbilgisi entity) {
        this.entity = entity;
    }

    public AdresbilgisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new AdresbilgisiDAO();
        }
        return dao;
    }

    public void setDao(AdresbilgisiDAO dao) {
        this.dao = dao;
    }

   

    public void setList(List<Adresbilgisi> list) {
        this.list = list;
    }

}
