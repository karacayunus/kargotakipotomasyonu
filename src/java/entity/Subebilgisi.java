/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;


public class Subebilgisi {
    int id;
    
    private String ad;
    private String adres;
    
    private List<Kargo> kargos;

    public Subebilgisi() {
    }

    public Subebilgisi(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Subebilgisi(int id, List<Kargo> kar, String ad, String adres) {
        this.id = id;
        this.kargos = kar;
        this.ad = ad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Kargo> getKargos() {
        return kargos;
    }

    public void setKargos(List<Kargo> kargos) {
        this.kargos = kargos;
    }

    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subebilgisi other = (Subebilgisi) obj;
        return this.id == other.id;
    }

    
   

}
