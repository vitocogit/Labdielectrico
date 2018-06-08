/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Patron;

/**
 *
 * @author vvaldez
 */
public interface PatronDao {
    public boolean agregarPatron(Patron patron)throws Exception;
    public boolean eliminarPatron(Patron patron)throws Exception;
    public boolean actualizarPatron(Patron patron)throws Exception;
    public boolean patronDescripcionExiste(Patron patron) throws Exception;
    public boolean patronMarcaExiste(Patron patron) throws Exception;
    public boolean patronModeloExiste(Patron patron) throws Exception;
    public boolean patronNSerieExiste(Patron patron) throws Exception;
    public List<Patron>listarPatrones() throws Exception;
    public List<Patron>ListadoPatronSelectedOne() throws Exception;
}
