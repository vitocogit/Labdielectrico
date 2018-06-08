/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.TipoEpp;

/**
 *
 * @author vvaldez
 */
public interface TipoEppDao {
 public boolean agregarTipoEpp(TipoEpp te)throws Exception;
 public boolean eliminarTipoEpp(TipoEpp te)throws Exception;
 public boolean actualizarTipoEpp(TipoEpp te)throws Exception;
 public List<TipoEpp>listarTipoEpp() throws Exception; 
 public List<TipoEpp>listadoTipoEppSelectedOne() throws Exception;   
}
