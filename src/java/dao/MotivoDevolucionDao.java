/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.MotivosDevolucion;

/**
 *
 * @author vvaldez
 */
public interface MotivoDevolucionDao  {
    
 public boolean agregarMotivosDevolucion(MotivosDevolucion md)throws Exception;
 public boolean eliminarMotivosDevolucion(MotivosDevolucion md)throws Exception;
 public boolean actualizarMotivosDevolucion(MotivosDevolucion md)throws Exception;
 public List<MotivosDevolucion>listarMotivosDevolucion() throws Exception; 
 public List<MotivosDevolucion>listadoMotivosDevolucionDescripcionSelectedOne() throws Exception;   
    
}
