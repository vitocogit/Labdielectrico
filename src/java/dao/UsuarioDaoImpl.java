/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import modelo.Usuario;
import util.ConexionBD;

/**
 *
 * @author vvaldez
 */
public class UsuarioDaoImpl implements UsuarioDao{

        public static String getMD5(String input) {
 try {
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] messageDigest = md.digest(input.getBytes());
 BigInteger number = new BigInteger(1, messageDigest);
 String hashtext = number.toString(16);

 while (hashtext.length() < 32) {
 hashtext = "0" + hashtext;
 }
 return hashtext;
 }
 catch (NoSuchAlgorithmException e) {
 throw new RuntimeException(e);
 }
 }
    
    @Override
    public boolean buscarPorUsuario(Usuario usuario) throws Exception {
       boolean resultado = false;
        String sql = "select id_persona,cargos_idcargo,sucursales_id_sucursal,comunas_id_comuna,nombres,apellidos,email,direccion,u.clave as clave,u.rol as rol   from personal.personal p"
                + " inner join personal.usuarios u on p.id_persona=u.personal_id_personal where p.email='" + usuario.getEmail() + "'and u.clave='" + getMD5(usuario.getClave()) + "'";
        ConexionBD con = new ConexionBD();
        String msg;

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                usuario.setIdPersona(rs.getInt("id_persona"));
                usuario.setIdCargo(rs.getInt("cargos_idcargo"));
                usuario.setIdSucursal(rs.getInt("sucursales_id_sucursal"));
                usuario.setIdComuna(rs.getInt("comunas_id_comuna"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRol(rs.getString("rol"));
                resultado=true;
            }
        }
        catch (NullPointerException e) {
            
        }
         catch (SQLException e) {
            e.printStackTrace();
           
        } finally { 
                 con.getConnection().close();
    }
        return resultado;
    }
    
    
}
