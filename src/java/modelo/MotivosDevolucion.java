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
public class MotivosDevolucion implements java.io.Serializable {
    
  private Integer id_motivo_devolucion;
  private String descripcion_motivo_devolucion;
  private String color;

    public MotivosDevolucion(Integer id_motivo_devolucion, String descripcion_motivo_devolucion, String color) {
        this.id_motivo_devolucion = id_motivo_devolucion;
        this.descripcion_motivo_devolucion = descripcion_motivo_devolucion;
        this.color = color;
    }

    public MotivosDevolucion() {
    }

    public Integer getId_motivo_devolucion() {
        return id_motivo_devolucion;
    }

    public void setId_motivo_devolucion(Integer id_motivo_devolucion) {
        this.id_motivo_devolucion = id_motivo_devolucion;
    }

    public String getDescripcion_motivo_devolucion() {
        return descripcion_motivo_devolucion;
    }

    public void setDescripcion_motivo_devolucion(String descripcion_motivo_devolucion) {
        this.descripcion_motivo_devolucion = descripcion_motivo_devolucion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
      
           
 
    
}
