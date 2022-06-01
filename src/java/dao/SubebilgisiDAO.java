/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kargo;
import entity.Subebilgisi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubebilgisiDAO extends DBConnection {

    private KargoDAO kargoDao;

    public Subebilgisi findByID(int id) {
        Subebilgisi c = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from subebilgisi where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Subebilgisi(rs.getInt("id"), rs.getString("ad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public void create(Subebilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into subebilgisi (ad,adres) values ('" + c.getAd() + "','" + c.getAdres() + "')";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(id) as mid from subebilgisi");
            rs.next();

            int subebilgisi_id = rs.getInt("mid");

            for (Kargo kat : c.getKargos()) {
                query = "insert into subebilgisi_kargo (subebilgisi_id, kargo_id) values (" + subebilgisi_id + ", " + kat.getId() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Subebilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update subebilgisi set ad='" + c.getAd() + "',adres='" + c.getAdres() + "'where id=" + c.getId();
            st.executeUpdate(query);

            st.executeUpdate("delete from subebilgisi_kargo where subebilgisi_id=" + c.getId());

            for (Kargo kat : c.getKargos()) {
                query = "insert into subebilgisi_kargo (subebilgisi_id, kargo_id) values (" + c.getId() + ", " + kat.getId() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Subebilgisi c) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from subebilgisi_kargo where subebilgisi_id=" + c.getId());
            String query = "delete from subebilgisi where id=" + c.getId();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as subebilgisi_count from subebilgisi";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("subebilgisi_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Subebilgisi> getList(int page, int pageSize) {
        List<Subebilgisi> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from subebilgisi order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Subebilgisi(rs.getInt("id"), this.getSubebilgisiKargos(rs.getInt("id")), rs.getString("ad"), rs.getString("adres")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public List<Kargo> getSubebilgisiKargos(int subebilgisi_id) {
        List<Kargo> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kargo where id in(select kargo_id from subebilgisi_kargo where subebilgisi_id=" + subebilgisi_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kargo(rs.getInt("id"), rs.getString("ad_soyad")));
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
