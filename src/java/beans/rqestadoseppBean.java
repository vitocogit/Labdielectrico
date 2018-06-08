/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.EstadosEppsDao;
import dao.EstadosEppsDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import modelo.EstadosEpps;

/**
 *
 * @author vvaldez
 */
@ManagedBean
@RequestScoped
public class rqestadoseppBean {
private List<SelectItem> selectOneItemEstadosEpps;
    /**
     * Creates a new instance of rqestadoseppBean
     */
    public rqestadoseppBean() {
    }

    public List<SelectItem> getSelectOneItemEstadosEpps() throws Exception {
        this.selectOneItemEstadosEpps=new ArrayList<SelectItem>();
       EstadosEppsDao dao=new EstadosEppsDaoImpl();
       List<EstadosEpps> estados_epps=dao.listadoEstadosEppsSelectedOne();
       
         for (EstadosEpps e:estados_epps) {
             SelectItem selectItem=new SelectItem(e.getIdEstadoEpp(),e.getDescripcion());
             this.selectOneItemEstadosEpps.add(selectItem);
         }
        
        return selectOneItemEstadosEpps;
    }
    
    
    
   
    
}
