/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Ensayo;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class EnsayoDaoImpl implements EnsayoDao {

    @Override
    public boolean agregarEnsayo(Ensayo ensayo) throws Exception {
        boolean resultado = false;
        String sql = "INSERT INTO lab_dielectrico.ensayos(correlativo, tipo_ensayo_id_tipo_ensayo, fecha_emision,n_fecha_solicitud, cantidad, temperatura_prom, humedad_prom,fecha_ejecucion, id_tecnico_laboratorio, id_sucursal_laboratorio, patron_id_patron, fecha_vencimiendo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, ensayo.getCorrelativo());
            ps.setInt(2, ensayo.getTipo_ensayo_id_tipo_ensayo());
            ps.setDate(3,new java.sql.Date(ensayo.getFecha_emision().getTime()));
            ps.setDate(4,new java.sql.Date(ensayo.getN_fecha_solicitud().getTime()));
            ps.setInt(5,ensayo.getCantidad());
            ps.setString(6,ensayo.getTemperatura_prom());
            ps.setString(7,ensayo.getHumedad_prom());
            ps.setDate(8,new java.sql.Date(ensayo.getFecha_ejecucion().getTime()));
            ps.setInt(9, ensayo.getId_tecnico_laboratorio());
            ps.setInt(10, ensayo.getId_sucursal_laboratorio());
            ps.setInt(11, ensayo.getPatron_id_patron());
            ps.setDate(12,new java.sql.Date(ensayo.getFecha_vencimiendo().getTime()));
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
    public boolean eliminarEnsayo(Ensayo ensayo) throws Exception {
         String sql="delete from lab_dielectrico.ensayos where id_ensayo=?";
        boolean resultado=false;
        ConexionBD con = new ConexionBD();
        try {
            PreparedStatement ps=con.getConnection().prepareStatement(sql);
            ps.setInt(1,ensayo.getId_ensayo());
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
    public boolean actualizarEnsayo(Ensayo ensayo) throws Exception {
         boolean resultado = false;
        String sql = "update lab_dielectrico.ensayo SET correlativo=?,tipo_ensayo_id_tipo_ensayo=?,fecha_emision=?,n_fecha_solicitud=?,cantidad=?,temperatura_prom=?,humedad_prom=?,fecha_ejecucion=?,id_tecnico_laboratorio=?,id_sucursal_laboratorio=?,patron_id_patron=?,fecha_vencimiendo=? where id_ensayo=?";

        ConexionBD con = new ConexionBD();
        try {

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, ensayo.getCorrelativo());
            ps.setInt(2, ensayo.getTipo_ensayo_id_tipo_ensayo());
            ps.setDate(3,new java.sql.Date(ensayo.getFecha_emision().getTime()));
            ps.setDate(4,new java.sql.Date(ensayo.getN_fecha_solicitud().getTime()));
            ps.setInt(5,ensayo.getCantidad());
            ps.setString(6,ensayo.getTemperatura_prom());
            ps.setString(7,ensayo.getHumedad_prom());
            ps.setDate(8,new java.sql.Date(ensayo.getFecha_ejecucion().getTime()));
            ps.setInt(9, ensayo.getId_tecnico_laboratorio());
            ps.setInt(10, ensayo.getId_sucursal_laboratorio());
            ps.setInt(11, ensayo.getPatron_id_patron());
            ps.setDate(12,new java.sql.Date(ensayo.getFecha_vencimiendo().getTime()));
            ps.setInt(13, ensayo.getId_ensayo());
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
    public List<Ensayo> listarEnsayos() throws Exception {
        List<Ensayo> listado_ensayos = new ArrayList<>();
       ConexionBD con=new ConexionBD();
        try {     
            String query = "SELECT id_ensayo,correlativo,tipo_ensayo_id_tipo_ensayo, fecha_emision,n_fecha_solicitud, cantidad, temperatura_prom, humedad_prom,fecha_ejecucion,id_tecnico_laboratorio, id_sucursal_laboratorio,patron_id_patron,fecha_vencimiendo,tp.descripcion as tipo_ensayo,p.nombres as nombres,p.apellidos as apellidos,s.nombre_sucursal as sucursal,pa.descripcion as patron FROM lab_dielectrico.ensayos e  \n"
                    + "inner join lab_dielectrico.tipo_ensayo tp on e.tipo_ensayo_id_tipo_ensayo=tp.id_tipo_ensayo \n"
                    + "inner join personal.personal p on e.id_tecnico_laboratorio=p.id_persona \n"
                    + "inner join sucursales.sucursales s on e.id_sucursal_laboratorio=s.id_sucursal \n"
                    + "inner join lab_dielectrico.patron pa on e.patron_id_patron=pa.id_patron" ;
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
               Ensayo e = new Ensayo();
                e.setId_ensayo(rs.getInt("id_ensayo"));
                e.setCorrelativo(rs.getInt("correlativo"));
                e.setTipo_ensayo_id_tipo_ensayo(rs.getInt("tipo_ensayo_id_tipo_ensayo"));
                e.setFecha_emision(rs.getDate("fecha_emision"));
                e.setN_fecha_solicitud(rs.getDate("n_fecha_solicitud"));
                e.setCantidad(rs.getInt("cantidad"));
                e.setTemperatura_prom(rs.getString("temperatura_prom"));
                e.setHumedad_prom(rs.getString("humedad_prom"));
                e.setFecha_ejecucion(rs.getDate("fecha_ejecucion"));
                e.setId_tecnico_laboratorio(rs.getInt("id_tecnico_laboratorio"));
                e.setId_sucursal_laboratorio(rs.getInt("id_sucursal_laboratorio"));
                e.setPatron_id_patron(rs.getInt("patron_id_patron"));
                e.setFecha_vencimiendo(rs.getDate("fecha_vencimiendo"));
                e.setTipoEnsayoDescripcion(rs.getString("tipo_ensayo"));
                e.setPersonaTecnicoLabNombre(rs.getString("nombres"));
                e.setPersonaTecnicoLabApellido(rs.getString("apellidos"));
                e.setSucursalNombre(rs.getString("sucursal"));
                e.setPatronDescripcion(rs.getString("patron"));
                listado_ensayos.add(e);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
          con.getConnection().close();
       }
        
        return listado_ensayos;

    }

    @Override
    public int numero_ensayo_correlativo() throws Exception {
       int ultimo_numero =0;
        ConexionBD con=new ConexionBD();
        try {
             Statement st = con.getConnection().createStatement();
            ResultSet res = st.executeQuery("select max(correlativo)+1 from lab_dielectrico.ensayos");
            while (res.next()) {
                int c = res.getInt(1);
                ultimo_numero = ultimo_numero + c;
        }
            
        }catch (SQLException e) {  
        }finally{
        con.getConnection().close();
        }
           
        return ultimo_numero;    
    }
  
}
