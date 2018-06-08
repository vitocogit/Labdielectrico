/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Ensayo;

/**
 *
 * @author vvaldez
 */
public interface EnsayoDao {
    public boolean agregarEnsayo(Ensayo ensayo)throws Exception;
    public boolean eliminarEnsayo(Ensayo ensayo)throws Exception;
    public boolean actualizarEnsayo(Ensayo ensayo)throws Exception;
    public List<Ensayo>listarEnsayos() throws Exception; 
    public int numero_ensayo_correlativo() throws Exception;
}
