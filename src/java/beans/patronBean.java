/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PatronDao;
import dao.PatronDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Patron;
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
public class patronBean {
 private Patron patron;
 private List<Patron> listapatrones;
    /**
     * Creates a new instance of patronBean
     */
    public patronBean() {
        this.patron=new Patron();
        this.listapatrones=new ArrayList<Patron>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public List<Patron> getListapatrones() throws Exception {
         if (isPostBack() == false) {
            PatronDao eppsDao = new PatronDaoImpl();
            this.listapatrones = eppsDao.listarPatrones();
            return listapatrones;
        } else {
            return listapatrones;
        }
    }

    public void setListapatrones(List<Patron> listapatrones) {
        this.listapatrones = listapatrones;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.patron = new Patron();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        PatronDao pdao = new PatronDaoImpl();
        String msg;

        if (pdao.agregarPatron(patron)) {

             PatronDao pdao2 = new  PatronDaoImpl();
            this.listapatrones = pdao2.listarPatrones();
            this.setListapatrones(listapatrones);

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

        PatronDao pdao = new PatronDaoImpl();
        String msg;

        if (pdao.actualizarPatron(patron)) {
            
            PatronDao pdao2 = new  PatronDaoImpl();
            this.listapatrones = pdao2.listarPatrones();
            this.setListapatrones(listapatrones);

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

         PatronDao pdao = new PatronDaoImpl();
        String msg;

        if (pdao.eliminarPatron(patron)) {
            
            PatronDao pdao2 = new  PatronDaoImpl();
            this.listapatrones = pdao2.listarPatrones();
            this.setListapatrones(listapatrones);

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
