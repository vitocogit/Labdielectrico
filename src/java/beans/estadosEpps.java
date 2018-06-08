/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.EstadosEppsDaoImpl;
import dao.EstadosEppsDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.EstadosEpps;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;



/**
 *
 * @author pgcardenasg
 */
@ManagedBean
public class estadosEpps implements Serializable {

    private List<EstadosEpps> epps;
    private EstadosEpps entityEpps;

    /**
     * Creates a new instance of estadosEpps
     */
    public estadosEpps() {

        this.epps = new ArrayList();
        this.entityEpps = new EstadosEpps();

    }

    public EstadosEpps getEntityEpps() {
        return entityEpps;
    }

    public void setEpps(List<EstadosEpps> epps) {
        this.epps = epps;
    }

    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public void setEntityEpps(EstadosEpps entityEpps) {
        this.entityEpps = entityEpps;
    }

    public List<EstadosEpps> getEpps() throws Exception {

        if (isPostBack() == false) {
            EstadosEppsDao eppsDao = new EstadosEppsDaoImpl();
            this.epps = eppsDao.listarEstadosEpps();
            return epps;
        } else {
            return epps;
        }

    }

    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.entityEpps = new EstadosEpps();
        return null;
    }

    /*INGRESAR*/
    public void btnCreateEstadoEpp(ActionEvent actionEvent) throws Exception {

        EstadosEppsDao eppsDao = new EstadosEppsDaoImpl();
        String msg;

        if (eppsDao.agregarEstadosEpps(entityEpps)) {

            EstadosEppsDao eppsDao2 = new EstadosEppsDaoImpl();
            this.epps = eppsDao2.listarEstadosEpps();
            this.setEpps(epps);

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
    public void btnUpdateEstadoEpp(ActionEvent actionEvent) throws Exception {

        EstadosEppsDao eppsDao = new EstadosEppsDaoImpl();
        String msg;

        if (eppsDao.actualizarEstadosEpps(entityEpps)) {
            
            EstadosEppsDao eppsDao2 = new EstadosEppsDaoImpl();
            this.epps = eppsDao2.listarEstadosEpps();
            this.setEpps(epps);

            msg = "Se actualizo correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {

            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    public void btnDeleteEstadoEpp(ActionEvent actionEvent) throws Exception {

        EstadosEppsDao eppsDao = new EstadosEppsDaoImpl();
        String msg;

        if (eppsDao.eliminarEstadosEpps(entityEpps)) {
            
            EstadosEppsDao eppsDao2 = new EstadosEppsDaoImpl();
            this.epps = eppsDao2.listarEstadosEpps();
            this.setEpps(epps);

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
