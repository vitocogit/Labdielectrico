/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.EnsayoDao;
import dao.EnsayoDaoImpl;
import dao.PatronDao;
import dao.PatronDaoImpl;
import dao.TipoEnsayoDao;
import dao.TipoEnsayoDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.Ensayo;
import modelo.Patron;
import modelo.TipoEnsayo;


/**
 *
 * @author vvaldez
 */
public class ensayoBean {
    
 private Ensayo ensayo;
 private int numeroensayocorrelativo;
 private List<SelectItem> selectOneItemPatron;
 private List<SelectItem> selectOneItemTipoEnsayo;

    public ensayoBean() {
        this.ensayo=new Ensayo();
    }

    public Ensayo getTipoensayo() {
        return ensayo;
    }

    public void setTipoensayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }

    public Ensayo getEnsayo() {
        return ensayo;
    }

    public void setEnsayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }

    public int getNumeroensayocorrelativo() throws Exception {
         EnsayoDao ensayodao=new EnsayoDaoImpl();
        this.numeroensayocorrelativo=ensayodao.numero_ensayo_correlativo();
        return numeroensayocorrelativo;
    }

    public void setNumeroensayocorrelativo(int numeroensayocorrelativo) {
        this.numeroensayocorrelativo = numeroensayocorrelativo;
    }
    
    //combobox 1
    public List<SelectItem> getSelectOneItemPatron() throws Exception {
         this.selectOneItemPatron=new ArrayList<SelectItem>();
       PatronDao dao=new PatronDaoImpl();
       List<Patron> patrones=dao.ListadoPatronSelectedOne();
       
         for (Patron p:patrones) {
             SelectItem selectItem=new SelectItem(p.getId_patron(),p.getDescripcion());
             this.selectOneItemPatron.add(selectItem);
         }
         
         return selectOneItemPatron;
    }  
    
    //combobox 2
    public List<SelectItem> getSelectOneItemTipoEnsayo() throws Exception {
         this. selectOneItemTipoEnsayo=new ArrayList<SelectItem>();
       TipoEnsayoDao dao=new  TipoEnsayoDaoImpl();
       List<TipoEnsayo> tipos_ensayos=dao.listadoTipoEnsayoSelectedOne();
       
         for (TipoEnsayo t :tipos_ensayos) {
             SelectItem selectItem=new SelectItem(t.getD_tipo_ensayo(),t.getDescripcion());
             this.selectOneItemTipoEnsayo.add(selectItem);
         }
        
        return selectOneItemTipoEnsayo;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.ensayo = new Ensayo();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        EnsayoDao dao = new EnsayoDaoImpl();
        String msg;
        FacesContext context = FacesContext.getCurrentInstance();
        loginBeans lg = context.getApplication().evaluateExpressionGet(context, "#{loginBeans}", loginBeans.class);
        
            if (this.getNumeroensayocorrelativo()!= 0) {
            this.ensayo.setCorrelativo(this.getNumeroensayocorrelativo());
        }
        
           this.ensayo.setId_sucursal_laboratorio(lg.getUsuario().getIdSucursal());
            this.ensayo.setId_tecnico_laboratorio(lg.getUsuario().getIdPersona()); 
            
        if (dao.agregarEnsayo(ensayo)) {
            msg = "Se creo correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {

            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

   
    
}

