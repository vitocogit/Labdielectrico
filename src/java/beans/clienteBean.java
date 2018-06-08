/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


import dao.ClienteDaoImpl;
import dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.Cliente;

/**
 *
 * @author victorgerman
 */
public class clienteBean {

  private List<Cliente> clientes;
  private List<Cliente> clientesbaja;
  private Cliente selectedCliente;
  private List<SelectItem> selectOneItemCliente;
   
  public clienteBean() {
        this.clientes =new ArrayList();
        this.clientesbaja =new ArrayList();
        this.selectedCliente=new Cliente();
     
    }
  
    

    public String limpiarformulario(){
        this.selectedCliente=new Cliente();
        return null;
    }  

    public List<Cliente> getClientes() throws Exception {
      
        ClienteDao clienteDao=new ClienteDaoImpl();
        this.clientes=clienteDao.listarClientes();
        return clientes;
        
        }
    

    public List<Cliente> getClientesbaja() throws Exception {
        ClienteDao clienteDao=new ClienteDaoImpl();
        this.clientesbaja=clienteDao.clienteDeshabilitado();
        return clientesbaja;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setClientesbaja(List<Cliente> clientesbaja) {
        this.clientesbaja = clientesbaja;
    }

    public Cliente getSelectedCliente()
    {
      return selectedCliente;
    }
    
      
     public List<SelectItem> getSelectOneItemCliente() throws Exception {
       this.selectOneItemCliente=new ArrayList<SelectItem>();
       ClienteDao clienteDao=new ClienteDaoImpl();
       List<Cliente> clientes=clienteDao.ListadoClientesSelectedOne();
         for (Cliente cliente:clientes) {
             SelectItem selectItem=new SelectItem(cliente.getCodCliente(),cliente.getRazonSocial());
             this.selectOneItemCliente.add(selectItem);
         }
         return selectOneItemCliente;
    }
     
   
    
    public void setSelectedCliente(Cliente selectedCliente)
    {
        this.selectedCliente=selectedCliente;
    } 

    
    /*INGRESAR*/
    
    public void btnCreateCliente(ActionEvent actionEvent) throws Exception
    {
    ClienteDao clientedao = new ClienteDaoImpl();   
    String msg;
    if(validarRut()==false){
        msg = "RUT INVALIDO";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }else {
    if(clientedao.clienteExiste(selectedCliente))
        {
             msg = "EL CLIENTE YA EXISTE";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }
        else {
          byte tipo_cliente=1;
           this.selectedCliente.setDeshabilitado(Boolean.FALSE);
           this.selectedCliente.setTipoCliente(tipo_cliente);
            if (clientedao.agregarCliente(selectedCliente)) {
                msg = "Se creo correctamente el registro";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                this.limpiarformulario();

            } else {
                msg = "Error al crear el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);

            }
        
           
        }
       
    }
    
     
    }
    
    public void btnUpdateCliente(ActionEvent actionEvent) throws Exception
    {
    ClienteDao clientedao = new ClienteDaoImpl();
    String msg;
    this.selectedCliente.setDeshabilitado(Boolean.FALSE);
    if(clientedao.actualizarCliente(this.selectedCliente)){
      msg="Se actualizo correctamente el registro";
      FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
      FacesContext.getCurrentInstance().addMessage(null, message);
    }  else {
      msg ="Error al actualizar el registro."; 
       FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
       
    }
    
    public void btnUpdateClienteBaja(ActionEvent actionEvent) throws Exception
    {
    ClienteDao clienteDao = new ClienteDaoImpl();
    String msg;
    this.selectedCliente.setDeshabilitado(Boolean.TRUE);
    if(clienteDao.actualizarCliente(this.selectedCliente)){
      msg="CLIENTE MARCADO COMO INACTIVO";
      FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
      FacesContext.getCurrentInstance().addMessage(null, message);
    }  else {
      msg ="ERROR NO SE PUDO MARCAR EL CLENTE COMO INACTIVO"; 
       FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
       
    }
    
    public void btnUpdateClienteActivo(ActionEvent actionEvent) throws Exception
    {
    ClienteDao clientedao = new ClienteDaoImpl();
    String msg;
    this.selectedCliente.setDeshabilitado(Boolean.FALSE);
    if(clientedao.actualizarCliente(this.selectedCliente)){
      msg="CLIENTE MARCADO COMO ACTIVO";
      FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
      FacesContext.getCurrentInstance().addMessage(null, message);
    }  else {
      msg ="ERROR NO SE PUDO MARCAR EL CLENTE COMO INACTIVO"; 
       FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
       
    }
    
    
    //VALIDA RUT ORIGINAL
 
    public static boolean validarRutORIGINAL(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
     
 
    public boolean validarRut() {
        Integer rutnumerico=this.selectedCliente.getRut();
        String digitoverificador=this.selectedCliente.getDvRut();
        String ruttexto=rutnumerico.toString();
        String rut=ruttexto+digitoverificador;
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public void btnValidaRut(ActionEvent actionEvent)
    {
        String msg;
        if(validarRut()==true)
        {
            msg = "RUT VALIDO";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        
        }else{
             msg ="RUT INVALIDO"; 
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
    
    
}