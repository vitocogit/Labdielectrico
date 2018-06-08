/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pgcardenasg
 */
public class EstadosEpps implements java.io.Serializable {

    
     private Integer idEstadoEpp;
     private String descripcion;
     private String color;

    public EstadosEpps(Integer idEstadoEpp, String descripcion, String color) {
        this.idEstadoEpp = idEstadoEpp;
        this.descripcion = descripcion;
        this.color = color;
    }
    
    public EstadosEpps(){
      
    }
    

    public Integer getIdEstadoEpp() {
        return idEstadoEpp;
    }

    public void setIdEstadoEpp(Integer idEstadoEpp) {
        this.idEstadoEpp = idEstadoEpp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
