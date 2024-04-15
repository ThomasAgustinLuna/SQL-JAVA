/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Persistence;

import principal.entities.Fabricante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Tomas
 */
public final class FabricanteDao extends DAO{
    
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            String sql = "INSERT INTO Fabricante (nombre)"
                    + "VALUES ( '" + fabricante.getNombre() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }

            String sql = "UPDATE Fabricante SET "
                    + "codigo = '" + fabricante.getCodigo() + "' WHERE nombre = '" + fabricante.getNombre() + "';";//sino funciona probamos sin el punto y coma

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public void eliminarFabricante(String nombre) throws Exception {
        try {
           
            String sql = "DELETE FROM Fabricante WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Fabricante fab = null;
            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString("nombre"));    
            }
            desconectarBase();
            return fab;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    public Fabricante buscarFabricanteCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Fabricante fab = null;
            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString("nombre"));    
            }
            desconectarBase();
            return fab;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {

            String sql = "SELECT codigo,nombre FROM Fabricante ";

            consultarBase(sql);

            Fabricante fab = null;
            Collection<Fabricante> af=new ArrayList();
            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString("nombre"));  
                af.add(fab);
            }
            desconectarBase();
            return af;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
        
    }
    
    

    
    
    
}
