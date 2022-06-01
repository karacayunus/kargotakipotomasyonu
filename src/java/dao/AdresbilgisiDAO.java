/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kargo;
import entity.Adresbilgisi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdresbilgisiDAO extends DBConnection {

    private KargoDAO kargoDao;

    public Adresbilgisi findByID(int id) {
        Adresbilgisi c = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from adresbilgisi where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Adresbilgisi(rs.getInt("id"), rs.getString("ad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public void create(Adresbilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into adresbilgisi (kargo_id,ad,adres) values (" + c.getKargo().getId() + ",'" + c.getAd() + "','" + c.getAdres() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Adresbilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update adresbilgisi set kargo_id=" + c.getKargo().getId() + ",ad='" + c.getAd() + "',adres='" + c.getAdres() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Adresbilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from adresbilgisi where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
    
    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as adresbilgisi_count from adresbilgisi";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("adresbilgisi_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Adresbilgisi> getList(int page, int pageSize) {
        List<Adresbilgisi> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from adresbilgisi order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kargo c = this.getKargoDao().findByID(rs.getInt("kargo_id"));
                list.add(new Adresbilgisi(rs.getInt("id"), c, rs.getString("ad"), rs.getString("adres")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public KargoDAO getKargoDao() {
        if (kargoDao == null) {
            this.kargoDao = new KargoDAO();
        }
        return kargoDao;
    }

    public void setKargoDao(KargoDAO kargoDao) {
        this.kargoDao = kargoDao;
    }

}
