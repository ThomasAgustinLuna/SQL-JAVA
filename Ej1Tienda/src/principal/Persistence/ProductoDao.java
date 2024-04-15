/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import principal.entities.Producto;

/**
 *
 * @author Tomas
 */
public final class ProductoDao extends DAO {

    public void ingresarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO producto (nombre,precio,codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' ," + producto.getCodigoFabricante() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto prod) throws Exception {
        try {
            if (prod == null) {
                throw new Exception("Debe indicar el producto a modificar");
            }
            String sql = "UPDATE producto SET "
                    + " nombre = '" + prod.getNombre() + "' , precio = '" + prod.getPrecio() + "' , codigo_fabricante = " + prod.getCodigoFabricante()
                    + " WHERE codigo = '" + prod.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Producto prod = null;
            while (resultado.next()) {
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                prod.setCodigoFabricante(resultado.getInt(4));

            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> prods = new ArrayList();
            while (resultado.next()) {
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                prod.setCodigoFabricante(resultado.getInt(4));
                prods.add(prod);
            }
            desconectarBase();
            return prods;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarProductosXnombreYprecio() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto ";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> prods = new ArrayList();
            while (resultado.next()) {
                prod = new Producto();
                
                prod.setNombre(resultado.getString(1));
                prod.setPrecio(resultado.getDouble(2));
                
                prods.add(prod);
            }
            desconectarBase();
            return prods;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
        public Producto listarProductosXnombreYprecioMenor() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto ORDER BY precio ASC LIMIT 1";
            consultarBase(sql);
            Producto prod = null;
            //Collection<Producto> prods = new ArrayList();
            while (resultado.next()) {
                prod = new Producto();
                
                prod.setNombre(resultado.getString(1));
                prod.setPrecio(resultado.getDouble(2));
                
                //prods.add(prod);
            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductosPrecioEspecifico(Integer min,Integer max) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN "+min+" AND "+max+";";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> prods = new ArrayList();
            while (resultado.next()) {
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                prod.setCodigoFabricante(resultado.getInt(4));
                prods.add(prod);
            }
            desconectarBase();
            return prods;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosXPortatil() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%portatil%' ";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> prods = new ArrayList();
            while (resultado.next()) {
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                prod.setCodigoFabricante(resultado.getInt(4));
                prods.add(prod);
            }
            desconectarBase();
            return prods;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
