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
import modelo.TipoEpp;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class TipoEppDaoImpl implements TipoEppDao {

    @Override
    public boolean agregarTipoEpp(TipoEpp te) throws Exception {
         boolean resultado = false;
  
       
        String sql = "INSERT INTO  lab_dielectrico.tipo_epp(descripcion_corta,descripcion_completa,marca,largo_tipo,clase) VALUES (?,?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

           PreparedStatement ps = con.getConnection().prepareStatement(sql);
           ps.setString(1,te.getDescripcion_corta());
           ps.setString(2, te.getDescripcion_completa());
           ps.setString(3, te.getMarca());
           ps.setString(4, te.getLargo_tipo());
           ps.setInt(5, te.getClase());
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
    public boolean eliminarTipoEpp(TipoEpp te) throws Exception {
       String sql="delete from lab_dielectrico.tipo_epp where id_tipo_epp=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,te.getId_tipo_epp());
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
    public boolean actualizarTipoEpp(TipoEpp te) throws Exception {
         boolean resultado = false;
       String sql="update lab_dielectrico.tipo_epp SET descripcion_corta=?,descripcion_completa=?,marca=?,largo_tipo=?,clase=?  where id_tipo_epp=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setString(1, te.getDescripcion_corta());
           ps.setString(2, te.getDescripcion_completa());
           ps.setString(3, te.getMarca());
           ps.setString(4, te.getLargo_tipo());
           ps.setInt(5, te.getClase());
           ps.setInt(6, te.getId_tipo_epp());
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
    public List<TipoEpp> listarTipoEpp() throws Exception {
      List<TipoEpp> listado_tipos_epp = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_tipo_epp,descripcion_corta,descripcion_completa,marca,largo_tipo,clase,c.clases as tension_clase,c.tension_ensayo as tension_ensayo FROM lab_dielectrico.tipo_epp as t \n"
                    + "inner join lab_dielectrico.clases_tension c on t.clase=c.id_clase_tension";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
               TipoEpp t= new TipoEpp();
               t.setId_tipo_epp(rs.getInt("id_tipo_epp"));
                t.setDescripcion_corta(rs.getString("descripcion_corta"));
                t.setDescripcion_completa(rs.getString("descripcion_completa"));
                t.setMarca(rs.getString("marca"));
                t.setLargo_tipo(rs.getString("largo_tipo"));
                 t.setClase(rs.getInt("clase"));
                 t.setClaseTensionClases(rs.getInt("tension_clase"));
                 t.setClaseTensionEnsayo(rs.getString("tension_ensayo"));
                listado_tipos_epp.add(t);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_tipos_epp;    
    }

    @Override
    public List<TipoEpp> listadoTipoEppSelectedOne() throws Exception {
        List<TipoEpp> listado_tipos_epp = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_tipo_epp,descripcion_corta FROM lab_dielectrico.tipo_epp";
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
               TipoEpp t= new TipoEpp();
               t.setId_tipo_epp(rs.getInt("id_tipo_epp"));
                t.setDescripcion_corta(rs.getString("descripcion_corta"));
                listado_tipos_epp.add(t);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_tipos_epp;    
    }
    
}
