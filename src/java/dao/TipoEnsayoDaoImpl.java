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
import modelo.TipoEnsayo;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class TipoEnsayoDaoImpl implements TipoEnsayoDao {

    @Override
    public boolean agregarTipoEnsayo(TipoEnsayo tp) throws Exception {
       boolean resultado = false;
  

        String sql = "INSERT INTO lab_dielectrico.tipo_ensayo(descripcion,fecha_creacion,nombre_corto,parametro1,parametro2,parametro3) VALUES (?,?,?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
           ps.setString(1, tp.getDescripcion());
           ps.setDate(2,new java.sql.Date(tp.getFecha_creacion().getTime()));
           ps.setString(3, tp.getNombre_corto());
           ps.setString(4, tp.getParametro1());
           ps.setString(5, tp.getParametro2());
           ps.setString(6, tp.getParametro3());
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
    public boolean eliminarTipoEnsayo(TipoEnsayo tp) throws Exception {
        String sql="delete from lab_dielectrico.tipo_ensayo where id_tipo_ensayo=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,tp.getD_tipo_ensayo());
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
    public boolean actualizarTipoEnsayo(TipoEnsayo tp) throws Exception {
        boolean resultado = false;
       String sql="update lab_dielectrico.tipo_ensayo SET descripcion=?,fecha_creacion=?,nombre_corto=?,parametro1=?,parametro2=?,parametro3=?  where id_tipo_ensayo=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1, tp.getDescripcion());
           ps.setDate(2,new java.sql.Date(tp.getFecha_creacion().getTime()));
           ps.setString(3, tp.getNombre_corto());
           ps.setString(4, tp.getParametro1());
           ps.setString(5, tp.getParametro2());
           ps.setString(6, tp.getParametro3());
           ps.setInt(7,tp.getD_tipo_ensayo());
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
    public List<TipoEnsayo> listarTipoEnsayo() throws Exception {
       List<TipoEnsayo> listado_tipos_ensayo = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_tipo_ensayo,descripcion,fecha_creacion,nombre_corto,parametro1,parametro2,parametro3 FROM lab_dielectrico.tipo_ensayo";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
               TipoEnsayo t= new TipoEnsayo();
               t.setD_tipo_ensayo(rs.getInt("id_tipo_ensayo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFecha_creacion(rs.getDate("fecha_creacion"));
                t.setNombre_corto(rs.getString("nombre_corto"));
                t.setParametro1(rs.getString("parametro1"));
                t.setParametro2(rs.getString("parametro2"));
                t.setParametro3(rs.getString("parametro3"));
                listado_tipos_ensayo.add(t);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_tipos_ensayo; 
    }

    @Override
    public List<TipoEnsayo> listadoTipoEnsayoSelectedOne() throws Exception {
        List<TipoEnsayo> listado_tipos_ensayo = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_tipo_ensayo,descripcion FROM lab_dielectrico.tipo_ensayo";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
               TipoEnsayo t= new TipoEnsayo();
               t.setD_tipo_ensayo(rs.getInt("id_tipo_ensayo"));
                t.setDescripcion(rs.getString("descripcion"));
                listado_tipos_ensayo.add(t);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_tipos_ensayo; 
    }
    
}
