
package tienda.compadores;
import java.util.Comparator;
import tienda.entidades.Producto;
public class ComparadorPrecio implements Comparator<Producto> {

    @Override
    public int compare(Producto t, Producto t1) {
      return  t.getPrecio().compareTo(t1.getPrecio());
    }
    
}
