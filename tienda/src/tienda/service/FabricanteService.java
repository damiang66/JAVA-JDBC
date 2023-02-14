
package tienda.service;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDao;

public class FabricanteService {
    FabricanteDao dao = new FabricanteDao();
     Scanner leer = new Scanner(System.in).useDelimiter("\n");
     public void crear() throws Exception{
         Fabricante f=null;
        f = new Fabricante();
         System.out.println("Ingrese el nombre del fabricante");
         f.setNombre(leer.next());
         try {
             System.out.println(f.getNombre());
              dao.guardar(f);
         } catch (Exception e) {
         }
        
     }
    
}
