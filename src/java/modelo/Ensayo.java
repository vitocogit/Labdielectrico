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
public class Ensayo implements java.io.Serializable {
    
  private Integer id_ensayo;
  private Integer correlativo;
  private Integer tipo_ensayo_id_tipo_ensayo;
  private Date fecha_emision;
  private Date n_fecha_solicitud;
  private Integer cantidad;
  private String temperatura_prom;
  private String humedad_prom;
  private Date fecha_ejecucion;
  private Integer id_tecnico_laboratorio;
  private Integer id_sucursal_laboratorio;
  private Integer patron_id_patron;
  private Date fecha_vencimiendo;
  private String patronDescripcion;
  private String sucursalNombre;
  private String tipoEnsayoDescripcion;
  private String personaTecnicoLabNombre;
  private String personaTecnicoLabApellido;

    public Ensayo(Integer id_ensayo, Integer correlativo, Integer tipo_ensayo_id_tipo_ensayo, Date fecha_emision, Date n_fecha_solicitud, Integer cantidad, String temperatura_prom, String humedad_prom, Date fecha_ejecucion, Integer id_tecnico_laboratorio, Integer id_sucursal_laboratorio, Integer patron_id_patron, Date fecha_vencimiendo, String patronDescripcion, String sucursalNombre, String tipoEnsayoDescripcion, String personaTecnicoLabNombre, String personaTecnicoLabApellido) {
        this.id_ensayo = id_ensayo;
        this.correlativo = correlativo;
        this.tipo_ensayo_id_tipo_ensayo = tipo_ensayo_id_tipo_ensayo;
        this.fecha_emision = fecha_emision;
        this.n_fecha_solicitud = n_fecha_solicitud;
        this.cantidad = cantidad;
        this.temperatura_prom = temperatura_prom;
        this.humedad_prom = humedad_prom;
        this.fecha_ejecucion = fecha_ejecucion;
        this.id_tecnico_laboratorio = id_tecnico_laboratorio;
        this.id_sucursal_laboratorio = id_sucursal_laboratorio;
        this.patron_id_patron = patron_id_patron;
        this.fecha_vencimiendo = fecha_vencimiendo;
        this.patronDescripcion = patronDescripcion;
        this.sucursalNombre = sucursalNombre;
        this.tipoEnsayoDescripcion = tipoEnsayoDescripcion;
        this.personaTecnicoLabNombre = personaTecnicoLabNombre;
        this.personaTecnicoLabApellido = personaTecnicoLabApellido;
    }

    

    

    public Ensayo() {
    }

    public Integer getId_ensayo() {
        return id_ensayo;
    }

    public void setId_ensayo(Integer id_ensayo) {
        this.id_ensayo = id_ensayo;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getTipo_ensayo_id_tipo_ensayo() {
        return tipo_ensayo_id_tipo_ensayo;
    }

    public void setTipo_ensayo_id_tipo_ensayo(Integer tipo_ensayo_id_tipo_ensayo) {
        this.tipo_ensayo_id_tipo_ensayo = tipo_ensayo_id_tipo_ensayo;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getN_fecha_solicitud() {
        return n_fecha_solicitud;
    }

    public void setN_fecha_solicitud(Date n_fecha_solicitud) {
        this.n_fecha_solicitud = n_fecha_solicitud;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTemperatura_prom() {
        return temperatura_prom;
    }

    public void setTemperatura_prom(String temperatura_prom) {
        this.temperatura_prom = temperatura_prom;
    }

    public String getHumedad_prom() {
        return humedad_prom;
    }

    public void setHumedad_prom(String humedad_prom) {
        this.humedad_prom = humedad_prom;
    }

    public Date getFecha_ejecucion() {
        return fecha_ejecucion;
    }

    public void setFecha_ejecucion(Date fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public Integer getId_tecnico_laboratorio() {
        return id_tecnico_laboratorio;
    }

    public void setId_tecnico_laboratorio(Integer id_tecnico_laboratorio) {
        this.id_tecnico_laboratorio = id_tecnico_laboratorio;
    }

    public Integer getId_sucursal_laboratorio() {
        return id_sucursal_laboratorio;
    }

    public void setId_sucursal_laboratorio(Integer id_sucursal_laboratorio) {
        this.id_sucursal_laboratorio = id_sucursal_laboratorio;
    }

    public Integer getPatron_id_patron() {
        return patron_id_patron;
    }

    public void setPatron_id_patron(Integer patron_id_patron) {
        this.patron_id_patron = patron_id_patron;
    }

    public Date getFecha_vencimiendo() {
        return fecha_vencimiendo;
    }

    public void setFecha_vencimiendo(Date fecha_vencimiendo) {
        this.fecha_vencimiendo = fecha_vencimiendo;
    }

    public String getPatronDescripcion() {
        return patronDescripcion;
    }

    public void setPatronDescripcion(String patronDescripcion) {
        this.patronDescripcion = patronDescripcion;
    }

    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }

    public String getTipoEnsayoDescripcion() {
        return tipoEnsayoDescripcion;
    }

    public void setTipoEnsayoDescripcion(String tipoEnsayoDescripcion) {
        this.tipoEnsayoDescripcion = tipoEnsayoDescripcion;
    }

    public String getPersonaTecnicoLabNombre() {
        return personaTecnicoLabNombre;
    }

    public void setPersonaTecnicoLabNombre(String personaTecnicoLabNombre) {
        this.personaTecnicoLabNombre = personaTecnicoLabNombre;
    }

    public String getPersonaTecnicoLabApellido() {
        return personaTecnicoLabApellido;
    }

    public void setPersonaTecnicoLabApellido(String personaTecnicoLabApellido) {
        this.personaTecnicoLabApellido = personaTecnicoLabApellido;
    }

    
    
          
  
    
}
