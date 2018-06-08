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
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.EstadosEpps;
import util.ConexionBD;

@ManagedBean(name = "estadosEppsDaoImpl")
@ApplicationScoped

public class EstadosEppsDaoImpl implements EstadosEppsDao {

    @Override
    public boolean agregarEstadosEpps(EstadosEpps eepps) throws Exception {

        boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.estados_epps (descripcion,color) VALUES (?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);

            ps.setString(1, eepps.getDescripcion());
            ps.setString(2, eepps.getColor());

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
    public boolean eliminarEstadosEpps(EstadosEpps eepps) throws Exception {

        String sql="delete from lab_dielectrico.estados_epps where id_estado_epp=?";
        boolean resultado=false;
        ConexionBD con=new ConexionBD();
        try {
          
          PreparedStatement ps=con.getConnection().prepareStatement(sql);
          ps.setInt(1,eepps.getIdEstadoEpp());
          
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
    public boolean actualizarEstadosEpps(EstadosEpps eepps) throws Exception {
        
       boolean resultado = false;
       String sql="update lab_dielectrico.estados_epps SET descripcion=?,color=? where id_estado_epp=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            
            ps.setString(1, eepps.getDescripcion());
            ps.setString(2, eepps.getColor());
            ps.setInt(3, eepps.getIdEstadoEpp());
            
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
    public List<EstadosEpps> listarEstadosEpps() throws Exception {
        
        List<EstadosEpps> listEstados = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_estado_epp,descripcion,color FROM lab_dielectrico.estados_epps";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                EstadosEpps epps = new EstadosEpps();
                epps.setIdEstadoEpp(rs.getInt("id_estado_epp"));
                epps.setDescripcion(rs.getString("descripcion"));
                epps.setColor(rs.getString("color"));
                
                listEstados.add(epps);
            }
           
        } catch (SQLException e) {
        } 
        finally{
          con.getConnection().close();
       }
        
        return listEstados;
        
    }

    @Override
    public List<EstadosEpps> listadoEstadosEppsSelectedOne() throws Exception {
        
        List<EstadosEpps> listEstados = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_estado_epp,descripcion FROM lab_dielectrico.estados_epps";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                EstadosEpps epps = new EstadosEpps();
                epps.setIdEstadoEpp(rs.getInt("id_estado_epp"));
                epps.setDescripcion(rs.getString("descripcion"));
                
                listEstados.add(epps);
            }
           
        } catch (SQLException e) {
        } 
        finally{
          con.getConnection().close();
       }
        
        return listEstados;
    }

 
   
    
}
