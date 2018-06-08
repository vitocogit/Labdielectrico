/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author pgcardenasg
 */
public class TipoEnsayo implements java.io.Serializable {
    
  private Integer d_tipo_ensayo;
  private String descripcion;
  private Date fecha_creacion;
  private String nombre_corto;
  private String parametro1;
  private String parametro2;
  private String parametro3;

    public TipoEnsayo(Integer d_tipo_ensayo, String descripcion, Date fecha_creacion, String nombre_corto, String parametro1, String parametro2, String parametro3) {
        this.d_tipo_ensayo = d_tipo_ensayo;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.nombre_corto = nombre_corto;
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.parametro3 = parametro3;
    }

    

    public TipoEnsayo() {
    }

    public Integer getD_tipo_ensayo() {
        return d_tipo_ensayo;
    }

    public void setD_tipo_ensayo(Integer d_tipo_ensayo) {
        this.d_tipo_ensayo = d_tipo_ensayo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public String getParametro1() {
        return parametro1;
    }

    public void setParametro1(String parametro1) {
        this.parametro1 = parametro1;
    }

    public String getParametro2() {
        return parametro2;
    }

    public void setParametro2(String parametro2) {
        this.parametro2 = parametro2;
    }

    public String getParametro3() {
        return parametro3;
    }

    public void setParametro3(String parametro3) {
        this.parametro3 = parametro3;
    }
          
  
    
}
