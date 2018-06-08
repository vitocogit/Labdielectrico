/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClienteExternosDao;
import dao.ClienteExternosDaoImpl;
import java.util.List;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteExternos;

/**
 *
 * @author vvaldez
 */
public class rqsucursalBean {
   private List<SelectItem> selectOneItemSucursales;
    /**
     * Creates a new instance of rqsucursalBean
     */
    public rqsucursalBean() {
    }

    public List<SelectItem> getSelectOneItemSucursales() throws Exception {
          this.selectOneItemSucursales=new ArrayList<SelectItem>();
       ClienteExternosDao dao=new ClienteExternosDaoImpl();
       List<ClienteExternos> sucursales=dao.listadoSucursales();
       
         for (ClienteExternos s:sucursales) {
             SelectItem selectItem=new SelectItem(s.getIdSucursal(),s.getSucursales());
             this.selectOneItemSucursales.add(selectItem);
         }
        
        
        return selectOneItemSucursales;
    }

    
    
}
