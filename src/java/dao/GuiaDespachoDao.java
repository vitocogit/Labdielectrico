/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.GuiaDespacho;

/**
 *
 * @author vvaldez
 */
public interface GuiaDespachoDao {
  public boolean agregarGuiaDespacho(GuiaDespacho guia)throws Exception;
    public boolean eliminarGuiaDespacho(GuiaDespacho guia)throws Exception;
    public boolean actualizarGuiaDespacho(GuiaDespacho guia)throws Exception;
    public List<GuiaDespacho>listarGuiaDespachos() throws Exception;     
}
