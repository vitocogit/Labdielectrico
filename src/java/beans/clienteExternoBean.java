/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClienteExternosDao;
import dao.ClienteExternosDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ClienteExternos;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 *
 * @author vvaldez
 */
public class clienteExternoBean {
 private ClienteExternos cliente;
 private List<ClienteExternos> listas;
    /**
     * Creates a new instance of clienteExternoBean
     */
    public clienteExternoBean() {
        this.cliente=new ClienteExternos();
        this.listas=new ArrayList<ClienteExternos>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public ClienteExternos getCliente() {
        return cliente;
    }

    public void setCliente(ClienteExternos cliente) {
        this.cliente = cliente;
    }

    public List<ClienteExternos> getListas() throws Exception {
         if (isPostBack() == false) {
            ClienteExternosDao ceDao = new ClienteExternosDaoImpl();
            this.listas = ceDao.listarClienteExternos();
            return listas;
        } else {
            return listas;
        }
    }

    public void setListas(List<ClienteExternos> listas) {
        this.listas = listas;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.cliente = new ClienteExternos();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        ClienteExternosDao pdao = new ClienteExternosDaoImpl();
        String msg;

        if (pdao.agregarClienteExternos(cliente)) {

             ClienteExternosDao pdao2 = new  ClienteExternosDaoImpl();
            this.listas = pdao2.listarClienteExternos();
            this.setListas(listas);

            msg = "Se creo correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {

            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    /*ACTUALIZAR*/
    public void btnUpdate(ActionEvent actionEvent) throws Exception {

        ClienteExternosDao pdao = new ClienteExternosDaoImpl();
        String msg;

        if (pdao.actualizarClienteExternos(cliente)) {
            
            ClienteExternosDao pdao2 = new  ClienteExternosDaoImpl();
            this.listas = pdao2.listarClienteExternos();
            this.setListas(listas);

            msg = "Se actualizo correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {

            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    public void btnDelete(ActionEvent actionEvent) throws Exception {

         ClienteExternosDao pdao = new ClienteExternosDaoImpl();
        String msg;

        if (pdao.eliminarClienteExternos(cliente)) {
            
            ClienteExternosDao pdao2 = new  ClienteExternosDaoImpl();
            this.listas = pdao2.listarClienteExternos();
            this.setListas(listas);

            msg = "Se elimino correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {

            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }
    
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
    
    
    
}
