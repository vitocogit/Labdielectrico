/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.TipoEppDao;
import dao.TipoEppDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.TipoEpp;
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
public class tipoEppBean {
 private TipoEpp tipoepp;
 private List<TipoEpp> listas;
    /**
     * Creates a new instance of tipoEppBean
     */
    public tipoEppBean() {
        this.tipoepp=new TipoEpp();
        this.listas=new ArrayList<TipoEpp>();
    }
    
    public boolean isPostBack() {
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public TipoEpp getTipoepp() {
        return tipoepp;
    }

    public void setTipoepp(TipoEpp tipoepp) {
        this.tipoepp = tipoepp;
    }
    
    public List<TipoEpp> getListas() throws Exception {
         if (isPostBack() == false) {
            TipoEppDao ceDao = new TipoEppDaoImpl();
            this.listas = ceDao.listarTipoEpp();
            return listas;
        } else {
            return listas;
        }
    }

    public void setListas(List<TipoEpp> listas) {
        this.listas = listas;
    }
    
    public String limpiarformulario() {
        //repalzar por tu objeto entity
        this.tipoepp = new TipoEpp();
        return null;
    }
    
    /*INGRESAR*/
    public void btnCreate(ActionEvent actionEvent) throws Exception {

        TipoEppDao dao = new TipoEppDaoImpl();
        String msg;

        if (dao.agregarTipoEpp(tipoepp)) {

             TipoEppDao dao2 = new  TipoEppDaoImpl();
            this.listas = dao2.listarTipoEpp();
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

        TipoEppDao dao = new TipoEppDaoImpl();
        String msg;

        if (dao.actualizarTipoEpp(tipoepp)) {
            
            TipoEppDao dao2 = new  TipoEppDaoImpl();
            this.listas = dao2.listarTipoEpp();
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

         TipoEppDao dao = new TipoEppDaoImpl();
        String msg;

        if (dao.eliminarTipoEpp(tipoepp)) {
            
            TipoEppDao dao2 = new  TipoEppDaoImpl();
            this.listas = dao2.listarTipoEpp();
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
