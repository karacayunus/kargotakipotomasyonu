/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.AdresbilgisiDAO;
import entity.Adresbilgisi;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("adresbilgisiConverter")
public class AdresbilgisiConverter implements Converter {

    private AdresbilgisiDAO adresbilgisiDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Adresbilgisi c = this.getAdresbilgisiDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Adresbilgisi c = (Adresbilgisi) t;
        return String.valueOf(c.getId());
    }

    public AdresbilgisiDAO getAdresbilgisiDao() {
        if (adresbilgisiDao == null) {
            this.adresbilgisiDao = new AdresbilgisiDAO();
        }
        return adresbilgisiDao;
    }

    public void setadresbilgisiDao(AdresbilgisiDAO adresbilgisiDao) {
        this.adresbilgisiDao = adresbilgisiDao;
    }

   
}
