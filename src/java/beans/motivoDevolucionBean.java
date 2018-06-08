/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.MotivoDevolucionDao;
import dao.MotivoDevolucionDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.MotivosDevolucion;
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
public class motivoDevolucionBean {
 private MotivosDevolucion mdevolucion;
 private List<MotivosDevolucion> listamotivos;
    /**
     * Creates a new instance of motivoDevolucionBean
     */
    public motivoDevolucionBean() {
        this.mdevolucion=new MotivosDevolucion();
        this.listamotivos=new ArrayList<MotivosDevolucion>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public MotivosDevolucion getMdevolucion() {
        return mdevolucion;
    }

    public void setMdevolucion(MotivosDevolucion mdevolucion) {
        this.mdevolucion = mdevolucion;
    }

    
    

    public List<MotivosDevolucion> getListamotivos() throws Exception {
         if (isPostBack() == false) {
            MotivoDevolucionDao mdao = new MotivoDevolucionDaoImpl();
            this.listamotivos = mdao.listarMotivosDevolucion();
            return listamotivos;
        } else {
            return listamotivos;
        }
    }

    public void setListamotivos(List<MotivosDevolucion> listamotivos) {
        this.listamotivos = listamotivos;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.mdevolucion = new MotivosDevolucion();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        MotivoDevolucionDao mdao = new MotivoDevolucionDaoImpl();
        String msg;

        if (mdao.agregarMotivosDevolucion(mdevolucion)) {

             MotivoDevolucionDao pdao2 = new  MotivoDevolucionDaoImpl();
            this.listamotivos = pdao2.listarMotivosDevolucion();
            this.setListamotivos(listamotivos);

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

        MotivoDevolucionDao mdao = new MotivoDevolucionDaoImpl();
        String msg;

        if (mdao.actualizarMotivosDevolucion(mdevolucion)) {
            
             MotivoDevolucionDao pdao2 = new  MotivoDevolucionDaoImpl();
            this.listamotivos = pdao2.listarMotivosDevolucion();
            this.setListamotivos(listamotivos);

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

         MotivoDevolucionDao mdao = new MotivoDevolucionDaoImpl();
        String msg;

        if (mdao.eliminarMotivosDevolucion(mdevolucion)) {
            
            MotivoDevolucionDao pdao2 = new  MotivoDevolucionDaoImpl();
            this.listamotivos = pdao2.listarMotivosDevolucion();
            this.setListamotivos(listamotivos);

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

