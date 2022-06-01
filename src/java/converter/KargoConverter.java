/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KargoDAO;
import entity.Kargo;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("kargoConverter")
public class KargoConverter implements Converter {

    private KargoDAO kargoDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kargo c = this.getKargoDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kargo c = (Kargo) t;
        return String.valueOf(c.getId());
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
