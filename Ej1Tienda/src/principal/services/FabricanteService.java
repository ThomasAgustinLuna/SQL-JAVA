/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.services;

import java.util.Collection;
import principal.Persistence.FabricanteDao;
import principal.entities.Fabricante;
/**
 *
 * @author Tomas
 */
public class FabricanteService {
    private  FabricanteDao dao;

    public FabricanteService() {
        this.dao = new FabricanteDao();
    }

    public void crearFabricante(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            
            if (dao.buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe un fabricante con este nombre " + nombre);
            }

            //Creamos el usuario
            Fabricante fab = new Fabricante();
            fab.setNombre(nombre);
            
            dao.guardarFabricante(fab);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(String nombre, Integer codigo, String nuevoFab) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el Fabricante");
            }

            

            if (nuevoFab == null || nuevoFab.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo fabricante");
            }

            //Buscamos
            Fabricante fab = dao.buscarFabricantePorNombre(nombre);

            //Validamos
            if (!fab.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("El nombre no esta en la lista de fabricantes");
            }

            //Modificamos
            fab.setNombre(nombre);

            dao.modificarFabricante(fab);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            dao.eliminarFabricante(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Fabricante fab = dao.buscarFabricantePorNombre(nombre);

            return fab;
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo");
            }

            Fabricante fab = dao.buscarFabricanteCodigo(codigo);

            return fab;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {

        try {

            Collection<Fabricante> fabs = dao.listarFabricantes();

            return fabs;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricante() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Fabricante> fabs = listarFabricantes();

            //Imprimimos los usuarios
            if (fabs.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante u : fabs) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
