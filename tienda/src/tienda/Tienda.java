package tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tienda.entidades.Producto;
import tienda.service.FabricanteService;
import tienda.service.ProductoService;

public class Tienda {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        FabricanteService fabricanteService = new FabricanteService();
        ProductoService productoService = new ProductoService();
        // productoService.crear();
        List<Producto> productos = new ArrayList<>();
      //1  productos = productoService.listar();
        productoService.menu();
        int opcion = 0;
        while (opcion != 9) {

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    productoService.listarNombre();
                    break;
                case 2:
                    productoService.listarPrecioYNombre();
                    break;
                case 3:
                    productoService.precioMayor();
                    break;
                case 4:
                    productoService.listarPortatiles();
                    break;
                case 5:
                    productoService.productoMasBarato();
                    break;
                case 6:
                    productoService.crear();
                    break;
                case 7:
                    fabricanteService.crear();
                    break;
                case 8:
                    System.out.println("Ingrese el id del Producto a moficicar");
                    Integer id = leer.nextInt();
                    System.out.println("Ingrese el nombre que desea ingresar");
                    productoService.modificar(id, leer.next());
                    break;
                case 9:
                    System.out.println("SISTEMA TERMINADO");
                    opcion = 9;
                    break;
                default:
                    System.out.println("Ingreso una opcion no valida");

            }
            if(!(opcion!=9)){
            } else {
                productoService.menu();
            }
           
        }

        // fabricanteService.crear();
        /*
        System.out.println("Ingrese el id del Producto a moficicar");
        Integer id = leer.nextInt();
        System.out.println("Ingrese el nombre que desea ingresar");
        productoService.modificar(id, leer.next());
         */
    }

}
