/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.EstadosEpps;

/**
 *
 * @author pgcardenasg
 */
public interface EstadosEppsDao {
    
    public boolean agregarEstadosEpps(EstadosEpps eepps)throws Exception;
    public boolean eliminarEstadosEpps(EstadosEpps eepps)throws Exception;
    public boolean actualizarEstadosEpps(EstadosEpps eepps)throws Exception;
    public List<EstadosEpps>listarEstadosEpps() throws Exception;
      public List<EstadosEpps>listadoEstadosEppsSelectedOne() throws Exception; 
    
}
