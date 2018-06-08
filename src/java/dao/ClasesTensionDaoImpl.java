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
import modelo.ClasesTension;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class ClasesTensionDaoImpl implements ClasesTensionDao {

    @Override
    public boolean agregarClasesTension(ClasesTension clase) throws Exception {
       boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.clases_tension (clases,tension_ensayo) VALUES (?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, clase.getClases());
            ps.setString(2, clase.getTension_ensayo());
            
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
    public boolean eliminarClasesTension(ClasesTension clase) throws Exception {
        String sql="delete from lab_dielectrico.clases_tension where id_clase_tension=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,clase.getId_clase_tension());
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
    public boolean actualizarClasesTension(ClasesTension clase) throws Exception {
        boolean resultado = false;
       String sql="update lab_dielectrico.clases_tension SET clases=?,tension_ensayo=?  where id_clase_tension=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1, clase.getClases());
            ps.setString(2, clase.getTension_ensayo());
            ps.setInt(3, clase.getId_clase_tension());
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
    public boolean claseExiste(ClasesTension clase) throws Exception {
         boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select clases from lab_dielectrico.clases_tension where clases=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1,clase.getClases());
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
    public boolean tensionExiste(ClasesTension clase) throws Exception {
       boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select tension_ensayo from lab_dielectrico.clases_tension where tension_ensayo=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,clase.getTension_ensayo());
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
    public List<ClasesTension> listarClasesTensiones() throws Exception {
        List<ClasesTension> listado_clases = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_clase_tension,clases,tension_ensayo FROM lab_dielectrico.clases_tension";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                ClasesTension c = new ClasesTension();
                c.setId_clase_tension(rs.getInt("id_clase_tension"));
                c.setClases(rs.getInt("clases"));
                c.setTension_ensayo(rs.getString("tension_ensayo"));
                listado_clases.add(c);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_clases;
    }

    @Override
    public List<ClasesTension> listadoClasesTensionSelectedOne() throws Exception {
       List<ClasesTension> select_clase = new ArrayList<ClasesTension>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT id_clase_tension,clases FROM lab_dielectrico.clases_tension";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ClasesTension c=new ClasesTension();
                c.setId_clase_tension(rs.getInt("id_clase_tension"));
                c.setClases(rs.getInt("clases"));
                select_clase.add(c);
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return select_clase;
    }

    @Override
    public List<ClasesTension> listadoTensionEnsayoSelectedOne() throws Exception {
        List<ClasesTension> select_tension_ensayo = new ArrayList<ClasesTension>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT id_clase_tension,tension_ensayo FROM lab_dielectrico.clases_tension";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ClasesTension c=new ClasesTension();
                c.setId_clase_tension(rs.getInt("id_clase_tension"));
                c.setTension_ensayo(rs.getString("tension_ensayo"));
                select_tension_ensayo.add(c);
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return select_tension_ensayo;
    }
    
    
    }
    
