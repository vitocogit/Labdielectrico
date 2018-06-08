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
public class GuiaDespacho implements java.io.Serializable {
    
  private Integer id_guia_despacho;
  private Integer id_persona_despacho;
  private Integer estado_despacho;
  private Integer id_persona_recepciona;
  private Date fecha_despacho;
  private Date fecha_recepcion;
  private Date fecha_anulacion;
  private Integer id_sucursal_destino;
  private Date fecha_creacion;
  private String numero_guia_correodechile;
  private String comentario_despacho;
  private String comentario_recepcion;
  private String numero_guia_despacho_sap;
  
  private String personaDespachoNombre;
  private String personaDespachoApellido;
  private String personaRecepcionNombre;
  private String personaRecepcionApellido;
  private String sucursalDestinoNombre;

    public GuiaDespacho(Integer id_guia_despacho, Integer id_persona_despacho, Integer estado_despacho, Integer id_persona_recepciona, Date fecha_despacho, Date fecha_recepcion, Date fecha_anulacion, Integer id_sucursal_destino, Date fecha_creacion, String numero_guia_correodechile, String comentario_despacho, String comentario_recepcion, String numero_guia_despacho_sap, String personaDespachoNombre, String personaDespachoApellido, String personaRecepcionNombre, String personaRecepcionApellido, String sucursalDestinoNombre) {
        this.id_guia_despacho = id_guia_despacho;
        this.id_persona_despacho = id_persona_despacho;
        this.estado_despacho = estado_despacho;
        this.id_persona_recepciona = id_persona_recepciona;
        this.fecha_despacho = fecha_despacho;
        this.fecha_recepcion = fecha_recepcion;
        this.fecha_anulacion = fecha_anulacion;
        this.id_sucursal_destino = id_sucursal_destino;
        this.fecha_creacion = fecha_creacion;
        this.numero_guia_correodechile = numero_guia_correodechile;
        this.comentario_despacho = comentario_despacho;
        this.comentario_recepcion = comentario_recepcion;
        this.numero_guia_despacho_sap = numero_guia_despacho_sap;
        this.personaDespachoNombre = personaDespachoNombre;
        this.personaDespachoApellido = personaDespachoApellido;
        this.personaRecepcionNombre = personaRecepcionNombre;
        this.personaRecepcionApellido = personaRecepcionApellido;
        this.sucursalDestinoNombre = sucursalDestinoNombre;
    }

   
    public GuiaDespacho() {
    }

    public Integer getId_guia_despacho() {
        return id_guia_despacho;
    }

    public void setId_guia_despacho(Integer id_guia_despacho) {
        this.id_guia_despacho = id_guia_despacho;
    }

    public Integer getId_persona_despacho() {
        return id_persona_despacho;
    }

    public void setId_persona_despacho(Integer id_persona_despacho) {
        this.id_persona_despacho = id_persona_despacho;
    }

    public Integer getEstado_despacho() {
        return estado_despacho;
    }

    public void setEstado_despacho(Integer estado_despacho) {
        this.estado_despacho = estado_despacho;
    }

    public Integer getId_persona_recepciona() {
        return id_persona_recepciona;
    }

    public void setId_persona_recepciona(Integer id_persona_recepciona) {
        this.id_persona_recepciona = id_persona_recepciona;
    }

    public Date getFecha_despacho() {
        return fecha_despacho;
    }

    public void setFecha_despacho(Date fecha_despacho) {
        this.fecha_despacho = fecha_despacho;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public Integer getId_sucursal_destino() {
        return id_sucursal_destino;
    }

    public void setId_sucursal_destino(Integer id_sucursal_destino) {
        this.id_sucursal_destino = id_sucursal_destino;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getNumero_guia_correodechile() {
        return numero_guia_correodechile;
    }

    public void setNumero_guia_correodechile(String numero_guia_correodechile) {
        this.numero_guia_correodechile = numero_guia_correodechile;
    }

    public String getComentario_despacho() {
        return comentario_despacho;
    }

    public void setComentario_despacho(String comentario_despacho) {
        this.comentario_despacho = comentario_despacho;
    }

    public String getComentario_recepcion() {
        return comentario_recepcion;
    }

    public void setComentario_recepcion(String comentario_recepcion) {
        this.comentario_recepcion = comentario_recepcion;
    }

    public String getNumero_guia_despacho_sap() {
        return numero_guia_despacho_sap;
    }

    public void setNumero_guia_despacho_sap(String numero_guia_despacho_sap) {
        this.numero_guia_despacho_sap = numero_guia_despacho_sap;
    }

    public String getPersonaDespachoNombre() {
        return personaDespachoNombre;
    }

    public void setPersonaDespachoNombre(String personaDespachoNombre) {
        this.personaDespachoNombre = personaDespachoNombre;
    }

    public String getPersonaDespachoApellido() {
        return personaDespachoApellido;
    }

    public void setPersonaDespachoApellido(String personaDespachoApellido) {
        this.personaDespachoApellido = personaDespachoApellido;
    }

    public String getPersonaRecepcionNombre() {
        return personaRecepcionNombre;
    }

    public void setPersonaRecepcionNombre(String personaRecepcionNombre) {
        this.personaRecepcionNombre = personaRecepcionNombre;
    }

    public String getPersonaRecepcionApellido() {
        return personaRecepcionApellido;
    }

    public void setPersonaRecepcionApellido(String personaRecepcionApellido) {
        this.personaRecepcionApellido = personaRecepcionApellido;
    }

    public String getSucursalDestinoNombre() {
        return sucursalDestinoNombre;
    }

    public void setSucursalDestinoNombre(String sucursalDestinoNombre) {
        this.sucursalDestinoNombre = sucursalDestinoNombre;
    }

    
  
  
    
}
