/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ElementosEppsDao;
import dao.ElementosEppsDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ElementosEpps;
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
public class elementoEppsBean {
 private ElementosEpps elementoepp;
 private List<ElementosEpps> listas;
    /**
     * Creates a new instance of elementoEppsBean
     */
    public elementoEppsBean() {
        this.elementoepp=new ElementosEpps();
        this.listas=new ArrayList<ElementosEpps>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public ElementosEpps getElementoepp() {
        return elementoepp;
    }

    public void setElementoepp(ElementosEpps elementoepp) {
        this.elementoepp = elementoepp;
    }

    
    
    public List<ElementosEpps> getListas() throws Exception {
         if (isPostBack() == false) {
            ElementosEppsDao eDao = new ElementosEppsDaoImpl();
            this.listas = eDao.listarElementosEpp();
            return listas;
        } else {
            return listas;
        }
    }

    public void setListas(List<ElementosEpps> listas) {
        this.listas = listas;
    }
    
    public String limpiarformulario() {
 
        this.elementoepp = new ElementosEpps();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        ElementosEppsDao dao = new ElementosEppsDaoImpl();
        String msg;
        FacesContext context = FacesContext.getCurrentInstance();
        loginBeans lg = context.getApplication().evaluateExpressionGet(context, "#{loginBeans}", loginBeans.class);
        this.elementoepp.setId_tecnico_ingresa(lg.getUsuario().getIdPersona());
        if (dao.agregarElementosEpps(elementoepp)) {

             ElementosEppsDao dao2 = new  ElementosEppsDaoImpl();
            this.listas = dao2.listarElementosEpp();
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

        ElementosEppsDao dao = new ElementosEppsDaoImpl();
        String msg;
          FacesContext context = FacesContext.getCurrentInstance();
        loginBeans lg = context.getApplication().evaluateExpressionGet(context, "#{loginBeans}", loginBeans.class);
        this.elementoepp.setId_tecnico_ingresa(lg.getUsuario().getIdPersona());
        if (dao.actualizarElementosEpps(elementoepp)) {
            
            ElementosEppsDao dao2 = new  ElementosEppsDaoImpl();
            this.listas = dao2.listarElementosEpp();
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

         ElementosEppsDao dao = new ElementosEppsDaoImpl();
        String msg;

        if (dao.eliminarElementosEpps(elementoepp)) {
            
            ElementosEppsDao dao2 = new  ElementosEppsDaoImpl();
            this.listas = dao2.listarElementosEpp();
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
