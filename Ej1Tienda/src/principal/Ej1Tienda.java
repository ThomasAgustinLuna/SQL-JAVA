/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Collection;
import java.util.Scanner;
import principal.entities.Producto;
import principal.services.FabricanteService;
import principal.services.ProductoService;

/**
 *
 * @author Tomas
 */
public class Ej1Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");

        FabricanteService fs = new FabricanteService();
        ProductoService ps = new ProductoService();
        
        String str = "s";
        try {
            do {
                System.out.println("Ingrese una opción: (s para salir)\n"
                        + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                        + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                        + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                        + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                        + "e) Listar el nombre y el precio del producto más barato.\n"
                        + "f) Ingresar un producto a la base de datos.\n"
                        + "g) Ingresar un fabricante a la base de datos\n"
                        + "h) Editar un producto con datos a elección.");
                str = read.next().toLowerCase();
                switch (str) {
                    case "a"://a) Lista el nombre de todos los productos que hay en la tabla producto.
                        Collection<String> lista = ps.listarNombreDeProductos();
                        System.out.println(lista);
                        break;
                    case "b"://b) Lista los nombres y los precios de todos los productos de la tabla producto.                        
                        //Collection<Producto> prods = ps.listarProductosXnombreYprecio();
                        //System.out.println(prods);
                        ps.imprimirProductosXnombreYprecio();
                        break;
                    case "c"://c) Listar aquellos productos que su precio esté entre 120 y 202.
                        //ps.listarProductosPrecioEspecifico(120,202);
                        ps.imprimirProductosPrecioEspecifico(102, 202);
                        break;
                    case "d"://d) Buscar y listar todos los Portátiles de la tabla producto.
                        ps.imprimirProductosXPortatil();
                        break;
                    case "e"://e) Listar el nombre y el precio del producto más barato.
                        ps.imprimirProductosXnombreYprecioMenor();
                        break;
                    case "f"://f) Ingresar un producto a la base de datos.
                        System.out.println("Ingrese el nombre, precio y código de fabricante del producto");
                        ps.crearProducto(read.next(), read.nextDouble(), read.nextInt());
                        break;
                    case "g"://g) Ingresar un fabricante a la base de datos
                        System.out.println("Ingrese el nombre del fabricante");
                        fs.crearFabricante(read.next());
                        break;
                    case "h"://h) Editar un producto con datos a elección.
                        System.out.println("Ingrese el código del producto a modificar");
                        Integer codigop = read.nextInt();
                        System.out.println("Ingrese el nombre, precio y código de fabricante del producto");
                        ps.modificarProducto(codigop, read.next(), read.nextDouble(), read.nextInt());
                        break;
                    case "s":
                        break;
                    default:
                        System.out.println("Código incorrecto");
                }

            } while (str != "s");

        } catch (Exception e) {
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
    }
}
