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
public class Patron implements java.io.Serializable {
    
  private Integer id_patron;
  private String descripcion;
  private String marca;
  private String modelo;
  private Integer num_serie;
  private Date calibracion_vigente_hasta;

    public Patron(Integer id_patron, String descripcion, String marca, String modelo, Integer num_serie, Date calibracion_vigente_hasta) {
        this.id_patron = id_patron;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.calibracion_vigente_hasta = calibracion_vigente_hasta;
    }

    public Patron() {
    }

    public Integer getId_patron() {
        return id_patron;
    }

    public void setId_patron(Integer id_patron) {
        this.id_patron = id_patron;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(Integer num_serie) {
        this.num_serie = num_serie;
    }

    public Date getCalibracion_vigente_hasta() {
        return calibracion_vigente_hasta;
    }

    public void setCalibracion_vigente_hasta(Date calibracion_vigente_hasta) {
        this.calibracion_vigente_hasta = calibracion_vigente_hasta;
    }
    
  
  
}
