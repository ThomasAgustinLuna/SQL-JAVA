/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.services;

import java.util.Collection;
import principal.Persistence.ProductoDao;
import principal.entities.Producto;

/**
 *
 * @author Tomas
 */
public class ProductoService {

    private ProductoDao dao;

    public ProductoService() {
        this.dao = new ProductoDao();
    }

    public void crearProducto(String nombre, Double precio, Integer codfab) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            if (precio == null) {
                throw new Exception("Debe indicar un precio");
            }

            if (codfab == null) {
                throw new Exception("Debe indicar un codigo de fabricante");
            }

            //Creamos el producto
            Producto prod = new Producto();
            prod.setNombre(nombre);
            prod.setPrecio(precio);
            prod.setCodigoFabricante(codfab);

            dao.ingresarProducto(prod);

        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<String> listarNombreDeProductos() throws Exception {
        return dao.listarNombreproductos();
    }

    public void modificarProducto(Integer codigo, String nombre, Double precio, Integer codfab) throws Exception {

        try {

            //Validamos
            if (codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio == null) {
                throw new Exception("Debe indicar el precio");
            }

            if (codfab <= 0) {
                throw new Exception("Debe indicar el codigo de fabricante");
            }

            //Buscamos
            Producto prod = dao.buscarProductoPorCodigo(codigo);

            dao.modificarProducto(prod);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(Integer codigo) throws Exception {

        try {

            //Validamos 
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto prod = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (prod == null) {
                throw new Exception("No se econtró producto para el codigo indicado");
            }

            return prod;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> prods = dao.listarProductos();

            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosXnombreYprecio() throws Exception {

        try {

            Collection<Producto> prods = dao.listarProductosXnombreYprecio();

            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto listarProductosXnombreYprecioMenor() throws Exception {

        try {

            Producto prod = dao.listarProductosXnombreYprecioMenor();

            return prod;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosXnombreYprecioMenor() throws Exception {
        try {
            //Listamos los productos
            Producto prod = listarProductosXnombreYprecioMenor();

            //Imprimimos los productos
            if (prod == null) {
                throw new Exception("No se encontró el producto");
            }
            System.out.println("Nombre: " + prod.getNombre() + prod.getPrecio());

        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> prods = listarProductos();

            //Imprimimos los productos
            if (prods.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : prods) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosXnombreYprecio() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> prods = listarProductosXnombreYprecio();

            //Imprimimos los productos
            if (prods.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : prods) {
                    System.out.println(u.toString());
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosPrecioEspecifico(Integer min, Integer max) throws Exception {

        try {

            Collection<Producto> prods = dao.listarProductosPrecioEspecifico(min, max);

            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosPrecioEspecifico(Integer min, Integer max) throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> prods = listarProductosPrecioEspecifico(min, max);

            //Imprimimos los productos
            if (prods.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : prods) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosXPortatil() throws Exception {

        try {

            Collection<Producto> prods = dao.listarProductosXPortatil();//.listarProductos();

            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosXPortatil() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> prods = listarProductosXPortatil();//listarProductos();

            //Imprimimos los productos
            if (prods.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : prods) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
