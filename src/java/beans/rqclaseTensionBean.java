/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClasesTensionDao;
import dao.ClasesTensionDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import modelo.ClasesTension;

/**
 *
 * @author vvaldez
 */
public class rqclaseTensionBean {

private List<SelectItem> selectOneItemClasesTension;

    public rqclaseTensionBean() {
    }
    
    //LLENAR COMBOBOX 
    public List<SelectItem> getSelectOneItemClasesTension() throws Exception {
        this.selectOneItemClasesTension=new ArrayList<SelectItem>();
       ClasesTensionDao dao=new ClasesTensionDaoImpl();
       List<ClasesTension> clases_tension_ensayo=dao.listadoTensionEnsayoSelectedOne();
       
         for (ClasesTension c:clases_tension_ensayo) {
             SelectItem selectItem=new SelectItem(c.getId_clase_tension(),c.getTension_ensayo());
             this.selectOneItemClasesTension.add(selectItem);
         }
         
         return selectOneItemClasesTension;
    }
    
}
