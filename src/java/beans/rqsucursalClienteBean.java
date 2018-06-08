/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClienteExternosDao;
import dao.ClienteExternosDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import modelo.ClienteExternos;

/**
 *
 * @author vvaldez
 */
public class rqsucursalClienteBean {
private List<SelectItem> selectOneItemClienteExterno;
    /**
     * Creates a new instance of rqSucursalClienteBean
     */
    public rqsucursalClienteBean() {
    }

    public List<SelectItem> getSelectOneItemClienteExterno() throws Exception {
        this.selectOneItemClienteExterno=new ArrayList<SelectItem>();
       ClienteExternosDao dao=new ClienteExternosDaoImpl();
       List<ClienteExternos> clientes=dao.listadoClienteExternosSelectedOne();
       
         for (ClienteExternos c:clientes) {
             SelectItem selectItem=new SelectItem(c.getId_cliente_externo(),c.getCliente());
             this.selectOneItemClienteExterno.add(selectItem);
         }
        
        
        return selectOneItemClienteExterno;
    }
    
    
    
}
