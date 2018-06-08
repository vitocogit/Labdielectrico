/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import util.ConexionBD;

/**
 *
 * @author Victor
 */
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public boolean agregarCliente(Cliente cliente) throws Exception {
       boolean resultado = false;
      String sql="insert into  cliente(cod_cliente,rut,dv_rut,razon_social,direccion,comuna,ciudad,giro,telefono,email_contacto,deshabilitado,tipo_cliente) "
      + "values(NULL,?,?,?,?,?,?,?,?,?,?,?)";
      ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,cliente.getRut());
            ps.setString(2,cliente.getDvRut());
            ps.setString(3,cliente.getRazonSocial());
            ps.setString(4,cliente.getDireccion());
            ps.setString(5,cliente.getComuna());
            ps.setString(6,cliente.getCiudad());
            ps.setString(7,cliente.getGiro());
            ps.setString(8,cliente.getTelefono());
            ps.setString(9,cliente.getEmailContacto());
            ps.setBoolean(10,cliente.getDeshabilitado());
            ps.setByte(11,cliente.getTipoCliente());
            int i=ps.executeUpdate();
            if(i>0)
            {
              resultado=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultado=false;
        }finally{
          con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) throws Exception {
        String sql="delete from cliente where cod_cliente=?";
        boolean resultado=false;
        ConexionBD con=new ConexionBD();
        try {
          PreparedStatement ps=con.getConnection().prepareStatement(sql);
          ps.setInt(1,cliente.getCodCliente());
          int i=ps.executeUpdate();
          if(i>0)
          {
            return true;
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }finally{
           con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) throws Exception {
        boolean resultado = false;
       String sql="update cliente SET razon_social=?, direccion=?, comuna=?, ciudad=?, giro=?, telefono=?, email_contacto=?, deshabilitado=? where cod_cliente=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1,cliente.getRazonSocial());
            ps.setString(2,cliente.getDireccion());
            ps.setString(3,cliente.getComuna());
            ps.setString(4,cliente.getCiudad());
            ps.setString(5,cliente.getGiro());
            ps.setString(6,cliente.getTelefono());
            ps.setString(7,cliente.getEmailContacto());
            ps.setBoolean(8,cliente.getDeshabilitado());
            ps.setInt(9,cliente.getCodCliente());
            int i=ps.executeUpdate();
            if(i>0)
            {
                resultado=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
             resultado=false;
        }finally{
          con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean clienteExiste(Cliente cliente) throws Exception {
       boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select rut from cliente where rut=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1,cliente.getRut());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
              registroexiste=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return registroexiste;
    }

    @Override
    public List<Cliente> listarClientes() throws Exception {
        List<Cliente> clientes = new ArrayList<Cliente>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT cod_cliente,rut,dv_rut,razon_social,direccion,comuna,ciudad,giro,telefono,email_contacto,deshabilitado from cliente cli where cli.deshabilitado=0";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente cliente=new Cliente();
                cliente.setCodCliente(rs.getInt("cod_cliente"));
                cliente.setRut(rs.getInt("rut"));
                cliente.setDvRut(rs.getString("dv_rut"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setComuna(rs.getString("comuna"));
                cliente.setGiro(rs.getString("giro"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmailContacto(rs.getString("email_contacto"));
                cliente.setDeshabilitado(rs.getBoolean("deshabilitado"));
                clientes.add(cliente);
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return clientes;
    }

    @Override
    public List<Cliente> clienteDeshabilitado() throws Exception {
       List<Cliente> clientes = new ArrayList<Cliente>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT cod_cliente,rut,dv_rut,razon_social,direccion,comuna,ciudad,giro,telefono,email_contacto,deshabilitado from cliente cli where cli.deshabilitado=1";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente cliente=new Cliente();
                cliente.setCodCliente(rs.getInt("cod_cliente"));
                cliente.setRut(rs.getInt("rut"));
                cliente.setDvRut(rs.getString("dv_rut"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setComuna(rs.getString("comuna"));
                cliente.setGiro(rs.getString("giro"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmailContacto(rs.getString("email_contacto"));
                cliente.setDeshabilitado(rs.getBoolean("deshabilitado"));
                clientes.add(cliente);
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return clientes;
    }

    @Override
    public List<Cliente> ListadoClientesSelectedOne() throws Exception {
         List<Cliente> clientes = new ArrayList<Cliente>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT cod_cliente,razon_social,deshabilitado from cliente pro where pro.deshabilitado=0";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente cliente=new Cliente();
                cliente.setCodCliente(rs.getInt("cod_cliente"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                clientes.add(cliente);
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return clientes;
    
    }

    @Override
    //obtener un cliente por id  test
    public int findbycodcliente() throws Exception {
        int codcliente = 0;
        String sql ="select cod_cliente from cliente where cod_cliente=?";
        ConexionBD con=new ConexionBD();
        Cliente cliente=null;
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next())
            {
                int c = rs.getInt(1);
                 codcliente = codcliente+ c;
            }
        } 
        
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        return codcliente;
    }
    
}  


