/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Adresbilgisi {
    private int id;
    private Kargo kargo;
    private String ad;
    private String adres;

    public Adresbilgisi() {
    }

    public Adresbilgisi(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Adresbilgisi(int id, Kargo kargo, String ad, String adres) {
        this.id = id;
        this.kargo = kargo;
        this.ad = ad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kargo getKargo() {
        return kargo;
    }

    public void setKargo(Kargo kargo) {
        this.kargo = kargo;
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
        final Adresbilgisi other = (Adresbilgisi) obj;
        return this.id == other.id;
    }

}
