/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.ClasesTension;

/**
 *
 * @author vvaldez
 */
public interface ClasesTensionDao {
    
public boolean agregarClasesTension(ClasesTension clase)throws Exception;
    public boolean eliminarClasesTension(ClasesTension clase)throws Exception;
    public boolean actualizarClasesTension(ClasesTension clase)throws Exception;
    public boolean claseExiste(ClasesTension clase) throws Exception;
    public boolean tensionExiste(ClasesTension clase) throws Exception;
    public List<ClasesTension>listarClasesTensiones() throws Exception;
    public List<ClasesTension>listadoClasesTensionSelectedOne() throws Exception; 
    public List<ClasesTension>listadoTensionEnsayoSelectedOne() throws Exception;
    
}
