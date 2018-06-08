/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.EnsayoDao;
import dao.EnsayoDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Ensayo;
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
public class ensayosBean {
 private Ensayo ensayo;
 private List<Ensayo> listas;
    /**
     * Creates a new instance of ensayosBean
     */
    public ensayosBean() {
        this.ensayo=new Ensayo();
        this.listas=new ArrayList<Ensayo>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public Ensayo getEnsayo() {
        return ensayo;
    }

    public void setEnsayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }

 

    

    public List<Ensayo> getListas() throws Exception {
         if (isPostBack() == false) {
            EnsayoDao edao = new EnsayoDaoImpl();
            this.listas = edao.listarEnsayos();
            return listas;
        } else {
            return listas;
        }
    }

    public void setListas(List<Ensayo> listas) {
        this.listas = listas;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.ensayo = new Ensayo();
        return null;
    }
   

    /*ACTUALIZAR*/
    public void btnUpdate(ActionEvent actionEvent) throws Exception {

        EnsayoDao dao = new EnsayoDaoImpl();
        String msg;

        if (dao.actualizarEnsayo(ensayo)) {
            
            EnsayoDao dao2 = new  EnsayoDaoImpl();
            this.listas = dao2.listarEnsayos();
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

         EnsayoDao dao = new EnsayoDaoImpl();
        String msg;

        if (dao.eliminarEnsayo(ensayo)) {
            
            EnsayoDao dao2 = new  EnsayoDaoImpl();
            this.listas = dao2.listarEnsayos();
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
