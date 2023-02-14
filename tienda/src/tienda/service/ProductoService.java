
package tienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tienda.compadores.ComparadorPrecio;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDao;


public class ProductoService {
    ProductoDao dao = new ProductoDao();
   Scanner leer = new Scanner(System.in).useDelimiter("\n");
   List<Producto>productos = new ArrayList<>();
   public void crear() throws Exception{
       Producto p = new Producto();
       System.out.println("Ingrese el nombre del producto");
       p.setNombre(leer.next());
       System.out.println("Ingrese el precio del Producto");
       p.setPrecio(leer.nextDouble());
       System.out.println("Ingrese el codigo del fabricante");
       p.setCodigoFabricante(leer.nextInt());
      dao.guardar(p);
   }
   public void listarTodo() throws Exception{
       listar();
       productos.forEach(p->{
           System.out.println("codigo: " + p.getCodigo() + " Nombre: " + p.getNombre()+ " Precio: "+ p.getPrecio());
       });
   }
   public void listar() throws Exception{
             productos = dao.listar();
       
   }
   public void modificar(Integer id,String nombre) throws Exception{
    
       
       if(nombre.isEmpty() || nombre==null){
            throw new Exception("Debe ingresar un nombre valido");
       }
       Producto p = dao.buscarPorId(id);
       if (p==null){
           throw new Exception("Error no se encontro el producto");
           
       }
       p.setNombre(nombre);
       dao.modificarUsuario(p);
   }
   public void listarNombre() throws Exception{
       listar();
        System.out.println("----------------------------------");
        System.out.println("Lista los nombres de los productos de la tabla producto ");
        System.out.println("");
        productos.forEach(p -> {
            System.out.println(p.getNombre());
        });
   }
   public void listarPrecioYNombre() throws Exception{
       listar();
        System.out.println("-------------------------------");
        System.out.println("Lista los nombres y los precios de todos los productos de la tabla producto..");
        System.out.println("");
        productos.forEach(p -> {
            System.out.println("Nombre Producto " + p.getNombre() + " Precio Producto: " + p.getPrecio());
        });
   }
   public void precioMayor() throws Exception{
        listar();
       System.out.println("-----------------------------------");
        System.out.println(" Listar aquellos productos que su precio esté entre 120 y 202.");
        productos.forEach(p -> {
            if (p.getPrecio() >= 120 && p.getPrecio() <= 202) {
                System.out.println("Nombre Producto " + p.getNombre() + " Precio Producto: " + p.getPrecio());
            }
        });
   }
   public void listarPortatiles() throws Exception{
        listar();
        System.out.println("-------------------------------------");
        System.out.println("Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("");
        productos.forEach(p->{
            if(p.getNombre().contains("Portátil")){
                System.out.println("Nombre Producto " + p.getNombre() + " Precio Producto: " + p.getPrecio());
            }
        });
   }
   public void productoMasBarato() throws Exception{
        listar();
        System.out.println("-------------------------------------");
        System.out.println(" Listar el nombre y el precio del producto más barato.");
        System.out.println("");
        productos.sort(new ComparadorPrecio());
        System.out.println(productos.get(0).getNombre());
   }
   public void menu(){
        System.out.println("Ingrese una opcion a realizar\n"
                + "1- Listar nombre\n"
                + "2- Listar Nombre y Precio\n"
                + "3- Listar Productos que su precio este entre 120 y 202\n"
                + "4- Buscar y listar todos los Portátiles de la tabla producto\n"
                + "5- Listar el nombre y el precio del producto más barato\n"
                + "6- Ingresar un nuevo Producto\n"
                + "7- Ingresar un nuevo Fabricante\n"
                + "8- Modificar un Producto \n"
                + "9- salir");
   }
}