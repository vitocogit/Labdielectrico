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
public class ElementosEpps implements java.io.Serializable {
    
  private Integer id_epp;
  private Integer tipo_epps_id_tipo_epp;
  private Integer num_serie;
  private Integer estados_epps_id_estado;
  private Integer id_tecnico_ingresa;
  private Date fecha_ingreso;
  private Integer pertenece_suc_cliente;
  private Integer id_sucursal_id_cliente;
  private Date fecha_baja;
  private Integer id_persona_da_baja;
  private String sucursalNombre;
  private String tipoEnsayoDescripcion;
  private String personaTecnicoLabNombre;
  private String personaTecnicoLabApellido;
  private String estadoEppsDescripcion;
  private String tipoeppDescripcionCorta;
  private String tipoeppDescripcionCompleta;
  private String sucursalClienteNombte;
  private String personaDaBajaNombre;

    public ElementosEpps(Integer id_epp, Integer tipo_epps_id_tipo_epp, Integer num_serie, Integer estados_epps_id_estado, Integer id_tecnico_ingresa, Date fecha_ingreso, Integer pertenece_suc_cliente, Integer id_sucursal_id_cliente, Date fecha_baja, Integer id_persona_da_baja, String sucursalNombre, String tipoEnsayoDescripcion, String personaTecnicoLabNombre, String personaTecnicoLabApellido, String estadoEppsDescripcion, String tipoeppDescripcionCorta, String tipoeppDescripcionCompleta, String sucursalClienteNombte, String personaDaBajaNombre) {
        this.id_epp = id_epp;
        this.tipo_epps_id_tipo_epp = tipo_epps_id_tipo_epp;
        this.num_serie = num_serie;
        this.estados_epps_id_estado = estados_epps_id_estado;
        this.id_tecnico_ingresa = id_tecnico_ingresa;
        this.fecha_ingreso = fecha_ingreso;
        this.pertenece_suc_cliente = pertenece_suc_cliente;
        this.id_sucursal_id_cliente = id_sucursal_id_cliente;
        this.fecha_baja = fecha_baja;
        this.id_persona_da_baja = id_persona_da_baja;
        this.sucursalNombre = sucursalNombre;
        this.tipoEnsayoDescripcion = tipoEnsayoDescripcion;
        this.personaTecnicoLabNombre = personaTecnicoLabNombre;
        this.personaTecnicoLabApellido = personaTecnicoLabApellido;
        this.estadoEppsDescripcion = estadoEppsDescripcion;
        this.tipoeppDescripcionCorta = tipoeppDescripcionCorta;
        this.tipoeppDescripcionCompleta = tipoeppDescripcionCompleta;
        this.sucursalClienteNombte = sucursalClienteNombte;
        this.personaDaBajaNombre = personaDaBajaNombre;
    }

    public ElementosEpps() {
        this.fecha_ingreso=new java.util.Date();
    }

    public Integer getId_epp() {
        return id_epp;
    }

    public void setId_epp(Integer id_epp) {
        this.id_epp = id_epp;
    }

    public Integer getTipo_epps_id_tipo_epp() {
        return tipo_epps_id_tipo_epp;
    }

    public void setTipo_epps_id_tipo_epp(Integer tipo_epps_id_tipo_epp) {
        this.tipo_epps_id_tipo_epp = tipo_epps_id_tipo_epp;
    }

    public Integer getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(Integer num_serie) {
        this.num_serie = num_serie;
    }

    public Integer getEstados_epps_id_estado() {
        return estados_epps_id_estado;
    }

    public void setEstados_epps_id_estado(Integer estados_epps_id_estado) {
        this.estados_epps_id_estado = estados_epps_id_estado;
    }

    public Integer getId_tecnico_ingresa() {
        return id_tecnico_ingresa;
    }

    public void setId_tecnico_ingresa(Integer id_tecnico_ingresa) {
        this.id_tecnico_ingresa = id_tecnico_ingresa;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getPertenece_suc_cliente() {
        return pertenece_suc_cliente;
    }

    public void setPertenece_suc_cliente(Integer pertenece_suc_cliente) {
        this.pertenece_suc_cliente = pertenece_suc_cliente;
    }

    public Integer getId_sucursal_id_cliente() {
        return id_sucursal_id_cliente;
    }

    public void setId_sucursal_id_cliente(Integer id_sucursal_id_cliente) {
        this.id_sucursal_id_cliente = id_sucursal_id_cliente;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public Integer getId_persona_da_baja() {
        return id_persona_da_baja;
    }

    public void setId_persona_da_baja(Integer id_persona_da_baja) {
        this.id_persona_da_baja = id_persona_da_baja;
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

    public String getEstadoEppsDescripcion() {
        return estadoEppsDescripcion;
    }

    public void setEstadoEppsDescripcion(String estadoEppsDescripcion) {
        this.estadoEppsDescripcion = estadoEppsDescripcion;
    }

    public String getTipoeppDescripcionCorta() {
        return tipoeppDescripcionCorta;
    }

    public void setTipoeppDescripcionCorta(String tipoeppDescripcionCorta) {
        this.tipoeppDescripcionCorta = tipoeppDescripcionCorta;
    }

    public String getTipoeppDescripcionCompleta() {
        return tipoeppDescripcionCompleta;
    }

    public void setTipoeppDescripcionCompleta(String tipoeppDescripcionCompleta) {
        this.tipoeppDescripcionCompleta = tipoeppDescripcionCompleta;
    }

    public String getSucursalClienteNombte() {
        return sucursalClienteNombte;
    }

    public void setSucursalClienteNombte(String sucursalClienteNombte) {
        this.sucursalClienteNombte = sucursalClienteNombte;
    }

    public String getPersonaDaBajaNombre() {
        return personaDaBajaNombre;
    }

    public void setPersonaDaBajaNombre(String personaDaBajaNombre) {
        this.personaDaBajaNombre = personaDaBajaNombre;
    }

    
    
}
