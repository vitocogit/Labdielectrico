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
import modelo.Patron;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class PatronDaoImpl implements PatronDao {

    @Override
    public boolean agregarPatron(Patron patron) throws Exception {
       boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.patron (descripcion,marca,modelo,num_serie,calibracion_vigente_hasta) VALUES (?,?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, patron.getDescripcion());
            ps.setString(2, patron.getMarca());
            ps.setString(3, patron.getModelo());
            ps.setInt(4,patron.getNum_serie());
            ps.setDate(5,new java.sql.Date(patron.getCalibracion_vigente_hasta().getTime()));
            
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
    public boolean eliminarPatron(Patron patron) throws Exception {
        String sql="delete from lab_dielectrico.patron where id_patron=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,patron.getId_patron());
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
    public boolean actualizarPatron(Patron patron) throws Exception {
        boolean resultado = false;
       String sql="update lab_dielectrico.patron SET descripcion=?,marca=?,modelo=?,num_serie=?,calibracion_vigente_hasta=?  where id_patron=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1, patron.getDescripcion());
            ps.setString(2, patron.getMarca());
            ps.setString(3, patron.getModelo());
            ps.setInt(4,patron.getNum_serie());
            ps.setDate(5,new java.sql.Date(patron.getCalibracion_vigente_hasta().getTime()));
            ps.setInt(6, patron.getId_patron());
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
    public boolean patronDescripcionExiste(Patron patron) throws Exception {
        boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select descripcion from lab_dielectrico.patron where descripcion=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,patron.getDescripcion());
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
    public boolean patronMarcaExiste(Patron patron) throws Exception {
        boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select marca from lab_dielectrico.patron where marca=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,patron.getMarca());
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
    public boolean patronModeloExiste(Patron patron) throws Exception {
        boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select modelo from lab_dielectrico.patron where modelo=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,patron.getModelo());
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
    public boolean patronNSerieExiste(Patron patron) throws Exception {
        boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select num_serie from lab_dielectrico.patron where num_serie=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1,patron.getNum_serie());
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
    public List<Patron> listarPatrones() throws Exception {
        List<Patron> listado_patrones = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_patron,descripcion,marca,modelo,num_serie,calibracion_vigente_hasta FROM lab_dielectrico.patron";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Patron p = new Patron();
                p.setId_patron(rs.getInt("id_patron"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setMarca(rs.getString("marca"));
                p.setModelo(rs.getString("modelo"));
                p.setNum_serie(rs.getInt("num_serie"));
                p.setCalibracion_vigente_hasta(rs.getDate("calibracion_vigente_hasta"));
                listado_patrones.add(p);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_patrones;
    }

    @Override
    public List<Patron> ListadoPatronSelectedOne() throws Exception {
        List<Patron> select_patron = new ArrayList<Patron>();
        ConexionBD con=new ConexionBD();
        try {     
        String query = "SELECT id_patron,descripcion FROM lab_dielectrico.patron";
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Patron p=new Patron();
                p.setId_patron(rs.getInt("id_patron"));
                p.setDescripcion(rs.getString("descripcion"));
                select_patron.add(p);
             
            }
           
        } catch (SQLException ex) {
             ex.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        return select_patron;
    }

    
    
}
