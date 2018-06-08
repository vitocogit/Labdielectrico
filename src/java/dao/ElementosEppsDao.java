/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.ElementosEpps;

/**
 *
 * @author vvaldez
 */
public interface ElementosEppsDao {
  public boolean agregarElementosEpps(ElementosEpps epp)throws Exception;
    public boolean eliminarElementosEpps(ElementosEpps epp)throws Exception;
    public boolean actualizarElementosEpps(ElementosEpps epp)throws Exception;
    public boolean eppNSerieExiste(ElementosEpps epp) throws Exception;
    public List<ElementosEpps>listarElementosEpp() throws Exception;
}
