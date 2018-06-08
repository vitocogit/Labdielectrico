/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.TipoEppDao;
import dao.TipoEppDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import modelo.TipoEpp;

/**
 *
 * @author vvaldez
 */
public class rqtipoEppBean {

     private List<SelectItem> selectOneItemTipoEpps;
     
    public rqtipoEppBean() {
    }
    
    //LLENAR COMBOBOX 
    public List<SelectItem> getSelectOneItemTipoEpp() throws Exception {
        this.selectOneItemTipoEpps=new ArrayList<SelectItem>();
       TipoEppDao dao=new TipoEppDaoImpl();
       List<TipoEpp> tiposeppselementos=dao.listadoTipoEppSelectedOne();
       
         for (TipoEpp t:tiposeppselementos) {
             SelectItem selectItem=new SelectItem(t.getId_tipo_epp(),t.getDescripcion_corta());
             this.selectOneItemTipoEpps.add(selectItem);
         }
         
         return selectOneItemTipoEpps;
    }
    
}
