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
import modelo.ClienteExternos;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class ClienteExternosDaoImpl implements ClienteExternosDao  {

    @Override
    public boolean agregarClienteExternos(ClienteExternos cliente) throws Exception {
        boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.cliente_externos(cliente,negocio,direccion,ciudad) VALUES (?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getCliente());
            ps.setString(2, cliente.getNegocio());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4,cliente.getCiudad());
            
            int i = ps.executeUpdate();

            if (i > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean eliminarClienteExternos(ClienteExternos cliente) throws Exception {
        String sql="delete from lab_dielectrico.cliente_externos where id_cliente_externo=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,cliente.getId_cliente_externo());
            int i = ps.executeUpdate();
            if(i>0)
            {
              resultado=true;
             
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        finally{
          con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean actualizarClienteExternos(ClienteExternos cliente) throws Exception {
        boolean resultado = false;
       String sql="update lab_dielectrico.cliente_externos SET cliente=?,negocio=?,direccion=?,ciudad=?  where id_cliente_externo=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getCliente());
            ps.setString(2, cliente.getNegocio());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4,cliente.getCiudad());
            ps.setInt(5,cliente.getId_cliente_externo());
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                resultado=true;
            }
        } catch (SQLException e) {
             resultado=false;
        }finally{
          con.getConnection().close();
        }
        return resultado;
    }

    @Override
    public boolean clienteExiste(ClienteExternos cliente) throws Exception {
       boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select cliente from lab_dielectrico.cliente_externos where cliente=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,cliente.getCliente());
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
    public List<ClienteExternos> listarClienteExternos() throws Exception {
        List<ClienteExternos> listado_clientes = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_cliente_externo,cliente,negocio,direccion,ciudad FROM lab_dielectrico.cliente_externos";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                ClienteExternos c = new ClienteExternos();
                c.setId_cliente_externo(rs.getInt("id_cliente_externo"));
                c.setCliente(rs.getString("cliente"));
                c.setNegocio(rs.getString("negocio"));
                c.setDireccion(rs.getString("direccion"));
                c.setCiudad(rs.getString("ciudad"));
                listado_clientes.add(c);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_clientes;
    }

    @Override
    public List<ClienteExternos> listadoClienteExternosSelectedOne() throws Exception {
        List<ClienteExternos> listado_clientes = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_cliente_externo,cliente FROM lab_dielectrico.cliente_externos";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                ClienteExternos c = new ClienteExternos();
                c.setId_cliente_externo(rs.getInt("id_cliente_externo"));
                c.setCliente(rs.getString("cliente"));
                listado_clientes.add(c);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_clientes;
    }

    @Override
    public List<ClienteExternos> listadoSucursales() throws Exception {
        List<ClienteExternos> sucursales = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_sucursal,nombre_sucursal FROM sucursales.sucursales";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                ClienteExternos c = new ClienteExternos();
                c.setIdSucursal(rs.getInt("id_sucursal"));
                c.setSucursales(rs.getString("nombre_sucursal"));
                sucursales.add(c);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return sucursales;
    }
     
    
   
}
