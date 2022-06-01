 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kargo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KargoDAO extends DBConnection {

    public Kargo findByID(int id) {
        Kargo c = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kargo where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Kargo(rs.getInt("id"), rs.getString("ad_soyad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public void create(Kargo c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kargo (ad_soyad) values ('" + c.getAdSoyad() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Kargo c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kargo set ad_soyad='" + c.getAdSoyad() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Kargo c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kargo where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Kargo> getList() {
        List<Kargo> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kargo order by id asc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kargo(rs.getInt("id"), rs.getString("ad_soyad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}
