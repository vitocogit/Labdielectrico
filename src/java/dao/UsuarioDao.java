/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;

/**
 *
 * @author vvaldez
 */
public interface UsuarioDao {
    public boolean buscarPorUsuario(Usuario usuario)throws Exception;
}
