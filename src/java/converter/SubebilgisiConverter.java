/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.SubebilgisiDAO;
import entity.Subebilgisi;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("subebilgisiConverter")
public class SubebilgisiConverter implements Converter {

    private SubebilgisiDAO subebilgisiDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Subebilgisi c = this.getSubebilgisiDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Subebilgisi c = (Subebilgisi) t;
        return String.valueOf(c.getId());
    }

    public SubebilgisiDAO getSubebilgisiDao() {
        if (subebilgisiDao == null) {
            this.subebilgisiDao = new SubebilgisiDAO();
        }
        return subebilgisiDao;
    }

    public void setsubebilgisiDao(SubebilgisiDAO subebilgisiDao) {
        this.subebilgisiDao = subebilgisiDao;
    }

   
}
