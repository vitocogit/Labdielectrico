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
import modelo.MotivosDevolucion;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class MotivoDevolucionDaoImpl implements MotivoDevolucionDao {

    @Override
    public boolean agregarMotivosDevolucion(MotivosDevolucion md) throws Exception {
       boolean resultado = false;
  
        String sql = "INSERT INTO lab_dielectrico.motivos_devolucion(descripcion_motivo_devolucion,color) VALUES (?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, md.getDescripcion_motivo_devolucion());
            ps.setString(2, md.getColor());
            
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
    public boolean eliminarMotivosDevolucion(MotivosDevolucion md) throws Exception {
        String sql="delete from lab_dielectrico.motivos_devolucion where id_motivo_devolucion=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,md.getId_motivo_devolucion());
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
    public boolean actualizarMotivosDevolucion(MotivosDevolucion md) throws Exception {
       boolean resultado = false;
       String sql="update lab_dielectrico.motivos_devolucion SET descripcion_motivo_devolucion=?,color=?  where id_motivo_devolucion=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1, md.getDescripcion_motivo_devolucion());
            ps.setString(2, md.getColor());
            ps.setInt(3, md.getId_motivo_devolucion());
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
    public List<MotivosDevolucion> listarMotivosDevolucion() throws Exception {
       List<MotivosDevolucion> listado_motivos = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_motivo_devolucion,descripcion_motivo_devolucion,color FROM lab_dielectrico.motivos_devolucion";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                MotivosDevolucion m= new MotivosDevolucion();
                m.setId_motivo_devolucion(rs.getInt("id_motivo_devolucion"));
                m.setDescripcion_motivo_devolucion(rs.getString("descripcion_motivo_devolucion"));
                m.setColor(rs.getString("color"));
                listado_motivos.add(m);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_motivos;
    }

    @Override
    public List<MotivosDevolucion> listadoMotivosDevolucionDescripcionSelectedOne() throws Exception {
        List<MotivosDevolucion> listado_motivos = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_motivo_devolucion,descripcion_motivo_devolucion FROM lab_dielectrico.motivos_devolucion";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                MotivosDevolucion m= new MotivosDevolucion();
                m.setId_motivo_devolucion(rs.getInt("id_motivo_devolucion"));
                m.setDescripcion_motivo_devolucion(rs.getString("descripcion_motivo_devolucion"));
                listado_motivos.add(m);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_motivos;
    }
    
}
