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
public class ClienteExternos implements java.io.Serializable {
    
  private Integer id_cliente_externo;
  private String cliente;
  private String negocio;
  private String direccion;
  private String ciudad;
  // en caso de ser una sucursal en vez de cliente
  private Integer idSucursal;
  private String sucursales;

    public ClienteExternos(Integer id_cliente_externo, String cliente, String negocio, String direccion, String ciudad, Integer idSucursal, String sucursales) {
        this.id_cliente_externo = id_cliente_externo;
        this.cliente = cliente;
        this.negocio = negocio;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.idSucursal = idSucursal;
        this.sucursales = sucursales;
    }

    public ClienteExternos() {
    }

    public Integer getId_cliente_externo() {
        return id_cliente_externo;
    }

    public void setId_cliente_externo(Integer id_cliente_externo) {
        this.id_cliente_externo = id_cliente_externo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    

    public String getSucursales() {
        return sucursales;
    }

    public void setSucursales(String sucursales) {
        this.sucursales = sucursales;
    }

   
  
  
          
    
}
