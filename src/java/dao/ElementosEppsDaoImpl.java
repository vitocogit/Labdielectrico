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
import modelo.ElementosEpps;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class ElementosEppsDaoImpl implements ElementosEppsDao {

    @Override
    public boolean agregarElementosEpps(ElementosEpps epp) throws Exception {
         boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.elementos_epps (tipo_epps_id_tipo_epp,num_serie,estados_epps_id_estado,id_tecnico_ingresa,fecha_ingreso,pertenece_suc_cliente,id_sucursal_id_cliente) VALUES (?,?,?,?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, epp.getTipo_epps_id_tipo_epp());
            ps.setInt(2, epp.getNum_serie());
            ps.setInt(3, epp.getEstados_epps_id_estado());
            ps.setInt(4, epp.getId_tecnico_ingresa());
            ps.setDate(5,new java.sql.Date(epp.getFecha_ingreso().getTime()));
            ps.setInt(6, epp.getPertenece_suc_cliente());
            ps.setInt(7, epp.getId_sucursal_id_cliente());
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
    public boolean eliminarElementosEpps(ElementosEpps epp) throws Exception {
        String sql="delete from lab_dielectrico.elementos_epps where id_epp=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,epp.getId_epp());
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
    public boolean actualizarElementosEpps(ElementosEpps epp) throws Exception {
        boolean resultado = false;
       String sql="update lab_dielectrico.elementos_epps SET tipo_epps_id_tipo_epp=?,num_serie=?,estados_epps_id_estado=?,id_tecnico_ingresa=?,fecha_ingreso=?,pertenece_suc_cliente=?,id_sucursal_id_cliente=?,fecha_baja=?,id_persona_da_baja=?  where id_epp=?";
       
       ConexionBD con=new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1, epp.getTipo_epps_id_tipo_epp());
            ps.setInt(2, epp.getNum_serie());
            ps.setInt(3, epp.getEstados_epps_id_estado());
            ps.setInt(4, epp.getId_tecnico_ingresa());
            ps.setDate(5,new java.sql.Date(epp.getFecha_ingreso().getTime()));
            ps.setInt(6, epp.getPertenece_suc_cliente());
            ps.setInt(7, epp.getId_sucursal_id_cliente());
            ps.setDate(8,new java.sql.Date(epp.getFecha_baja().getTime()));
            ps.setInt(9, epp.getId_persona_da_baja());
            ps.setInt(10, epp.getId_epp());
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
    public boolean eppNSerieExiste(ElementosEpps epp) throws Exception {
        boolean registroexiste = false;
        ConexionBD con=new ConexionBD();
        String sql = "select num_serie from lab_dielectrico.elementos_epps where num_serie=?";     
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1,epp.getNum_serie());
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
    
    //FALTAN INNER JOIN
    public List<ElementosEpps> listarElementosEpp() throws Exception {
        List<ElementosEpps> listado_elementos = new ArrayList<>();
        ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_epp,tipo_epps_id_tipo_epp,num_serie,estados_epps_id_estado,id_tecnico_ingresa,fecha_ingreso,pertenece_suc_cliente,id_sucursal_id_cliente,fecha_baja,id_persona_da_baja FROM lab_dielectrico.elementos_epps e \n "
                    + "inner join lab_dielectrico.tipo_epp t on e.tipo_epps_id_tipo_epp=t.id_tipo_epp \n"
                    + "inner join lab_dielectrico.estados_epps es on e.estados_epps_id_estado=es.id_estado_epp \n"
                    + "inner join personal.personal p on e.id_tecnico_ingresa=p.id_persona \n"
                    + "left join sucursales.sucursales s on e.id_sucursal_id_cliente=s.id_sucursal \n"
                    + "left join personal.personal pe on e.id_persona_da_baja=pe.id_persona \n";
            
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                ElementosEpps ep = new ElementosEpps();
                ep.setId_epp(rs.getInt("id_epp"));
                ep.setTipo_epps_id_tipo_epp(rs.getInt("tipo_epps_id_tipo_epp"));
                ep.setNum_serie(rs.getInt("num_serie"));
                ep.setEstados_epps_id_estado(rs.getInt("estados_epps_id_estado"));
                ep.setId_tecnico_ingresa(rs.getInt("id_tecnico_ingresa"));
                ep.setFecha_ingreso(rs.getDate("fecha_ingreso"));
                ep.setPertenece_suc_cliente(rs.getInt("pertenece_suc_cliente"));
                ep.setId_sucursal_id_cliente(rs.getInt("id_sucursal_id_cliente"));
                ep.setFecha_baja(rs.getDate("fecha_baja"));
                ep.setId_persona_da_baja(rs.getInt("id_persona_da_baja"));              
                listado_elementos.add(ep);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_elementos;
    }

    
    
}
