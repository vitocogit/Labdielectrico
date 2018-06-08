/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.TipoEnsayo;

/**
 *
 * @author vvaldez
 */
public interface TipoEnsayoDao {
  public boolean agregarTipoEnsayo(TipoEnsayo tp)throws Exception;
 public boolean eliminarTipoEnsayo(TipoEnsayo tp)throws Exception;
 public boolean actualizarTipoEnsayo(TipoEnsayo tp)throws Exception;
 public List<TipoEnsayo>listarTipoEnsayo() throws Exception; 
 public List<TipoEnsayo>listadoTipoEnsayoSelectedOne() throws Exception;   
}
