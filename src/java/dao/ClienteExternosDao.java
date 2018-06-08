/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.ClienteExternos;

/**
 *
 * @author vvaldez
 */
public interface ClienteExternosDao {
    public boolean agregarClienteExternos(ClienteExternos cliente)throws Exception;
    public boolean eliminarClienteExternos(ClienteExternos cliente)throws Exception;
    public boolean actualizarClienteExternos(ClienteExternos cliente)throws Exception;
    public boolean clienteExiste(ClienteExternos cliente) throws Exception;
    public List<ClienteExternos>listarClienteExternos() throws Exception;
    public List<ClienteExternos>listadoClienteExternosSelectedOne() throws Exception;
    public List<ClienteExternos>listadoSucursales() throws Exception;
}
