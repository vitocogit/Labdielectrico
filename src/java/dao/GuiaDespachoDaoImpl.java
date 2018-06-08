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
import modelo.GuiaDespacho;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class GuiaDespachoDaoImpl implements GuiaDespachoDao {

    @Override
    public boolean agregarGuiaDespacho(GuiaDespacho guia) throws Exception {
        boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.guia_despacho(id_persona_despacho,estado_despacho,id_persona_recepciona,fecha_despacho,fecha_recepcion,fecha_anulacion,id_sucursal_destino,fecha_creacion,numero_guia_correodechile,comentario_despacho,comentario_recepcion,numero_guia_despacho_sap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";


        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, guia.getId_persona_despacho());
            ps.setInt(2, guia.getEstado_despacho());
            ps.setInt(3,guia.getId_persona_recepciona());
            ps.setDate(4,new java.sql.Date(guia.getFecha_despacho().getTime()));
            ps.setDate(5,new java.sql.Date(guia.getFecha_recepcion().getTime()));
            ps.setDate(6,new java.sql.Date(guia.getFecha_anulacion().getTime()));
            ps.setInt(7,guia.getId_sucursal_destino());
            ps.setDate(8,new java.sql.Date(guia.getFecha_creacion().getTime()));
            ps.setString(9, guia.getNumero_guia_correodechile());
            ps.setString(10, guia.getComentario_despacho());
            ps.setString(11, guia.getComentario_recepcion());
            ps.setString(12, guia.getNumero_guia_despacho_sap());
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
    public boolean eliminarGuiaDespacho(GuiaDespacho guia) throws Exception {
   
        String sql="delete from lab_dielectrico.guia_despacho where id_guia_despacho=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,guia.getId_guia_despacho());
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
    public boolean actualizarGuiaDespacho(GuiaDespacho guia) throws Exception {
       boolean resultado = false;
       String sql="update lab_dielectrico.guia_despacho SET id_persona_despacho=?,estado_despacho=?,id_persona_recepciona=?,fecha_despacho=?,fecha_recepcion=?,fecha_anulacion=?,id_sucursal_destino=?,fecha_creacion=?,numero_guia_correodechile=?,comentario_despacho=?,comentario_recepcion=?,numero_guia_despacho_sap=?  where id_guia_despacho=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1, guia.getId_persona_despacho());
            ps.setInt(2, guia.getEstado_despacho());
            ps.setInt(3,guia.getId_persona_recepciona());
            ps.setDate(4,new java.sql.Date(guia.getFecha_despacho().getTime()));
            ps.setDate(5,new java.sql.Date(guia.getFecha_recepcion().getTime()));
            ps.setDate(6,new java.sql.Date(guia.getFecha_anulacion().getTime()));
            ps.setInt(7,guia.getId_sucursal_destino());
            ps.setDate(8,new java.sql.Date(guia.getFecha_creacion().getTime()));
            ps.setString(9, guia.getNumero_guia_correodechile());
            ps.setString(10, guia.getComentario_despacho());
            ps.setString(11, guia.getComentario_recepcion());
            ps.setString(12, guia.getNumero_guia_despacho_sap());
            ps.setInt(13,guia.getId_guia_despacho());
            
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
    public List<GuiaDespacho> listarGuiaDespachos() throws Exception {
        List<GuiaDespacho> listado_guias = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_guia_despacho,id_persona_despacho,estado_despacho,id_persona_recepciona,fecha_despacho,fecha_recepcion,fecha_anulacion,id_sucursal_destino,fecha_creacion,numero_guia_correodechile,comentario_despacho,comentario_recepcion,numero_guia_despacho_sap,pd.nombres,pd.apellidos,pr.nombres,pr.apellidos,s.sucursal_nombre FROM lab_dielectrico.guia_despacho gd"
                    + "inner join personal.personal pd  on gd.id_persona_despacho=p.id_persona"
                    + "inner join personal.personal pr  on gd.id_persona_recepciona=p.id_persona"
                    + "inner join sucursales.sucursales s on gd.id_sucursal_destino=s.id_sucursal";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
            GuiaDespacho g = new GuiaDespacho();
            g.setId_guia_despacho(rs.getInt("id_guia_despacho"));
            g.setId_persona_despacho(rs.getInt("id_persona_despacho"));
            g.setEstado_despacho(rs.getInt("estado_despacho"));
            g.setId_persona_recepciona(rs.getInt("id_persona_recepciona"));   
            g.setFecha_despacho(rs.getDate("fecha_despacho"));
            g.setFecha_recepcion(rs.getDate("fecha_recepcion"));
            g.setFecha_anulacion(rs.getDate("fecha_anulacion"));
            g.setId_sucursal_destino(rs.getInt("id_sucursal_destino"));
            g.setFecha_creacion(rs.getDate("fecha_creacion"));
            g.setNumero_guia_correodechile(rs.getString("numero_guia_correodechile"));
            g.setComentario_despacho(rs.getString("comentario_despacho"));
            g.setComentario_recepcion(rs.getString("recepcion"));
            g.setNumero_guia_despacho_sap(rs.getString("numero_guia_despacho_sap"));
            g.setPersonaDespachoNombre(rs.getString("pd.nombres"));
            g.setPersonaDespachoApellido(rs.getString("pd.apellidos"));
            g.setPersonaRecepcionNombre(rs.getString("pr.nombres"));
            g.setPersonaRecepcionApellido(rs.getString("pr.apellidos"));
            g.setSucursalDestinoNombre(rs.getString("s.sucursal_nombre"));
            listado_guias.add(g);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_guias;
    }
    
    
    }
    

