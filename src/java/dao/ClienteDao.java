/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Victor
 */
public interface ClienteDao {
    
    public boolean agregarCliente(Cliente cliente)throws Exception;
    public boolean eliminarCliente(Cliente cliente)throws Exception;
    public boolean actualizarCliente(Cliente cliente)throws Exception;
    public boolean clienteExiste(Cliente cliente) throws Exception;
    public List<Cliente>listarClientes() throws Exception;
    public List<Cliente> clienteDeshabilitado() throws Exception;
    public List<Cliente>ListadoClientesSelectedOne() throws Exception;
    public int findbycodcliente()throws Exception; //busca el cliente por el id
}
