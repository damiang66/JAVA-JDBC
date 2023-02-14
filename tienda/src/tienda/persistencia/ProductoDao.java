
package tienda.persistencia;

import java.util.ArrayList;

import java.util.List;
import tienda.entidades.Producto;




public class ProductoDao extends DAO {
    public void guardar(Producto p) throws Exception{
       // System.out.println(p.getNombre() + "desde la clase dao");
        try {
            if(p==null){
                throw new Exception("Debe indicar un Producto");
            }
         String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) "
                    + "VALUES ( '" + p.getNombre() + "' , '" + p.getPrecio()+ "' ," + p.getCodigoFabricante() + " );";
          this.insertarModificarEliminar(sql);
       //     System.out.println("guarde");
        } catch (Exception e) {
           throw e;
          
        }finally{
            desconectarBase();
        }
        
    }
    public List<Producto> listar() throws Exception {
        try {
            String sql = "SELECT *FROM producto ";

            consultarBase(sql);

            Producto p = null;
           List<Producto> productos = new ArrayList();
            while (resultado.next()) {
                p = new Producto();
                  p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                productos.add(p);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
     public void modificarUsuario(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "nombre = '" + producto.getNombre()+ "' WHERE codigo = '" + producto.getCodigo()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     public Producto buscarPorId(Integer id) throws Exception{
       try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE codigo= '" + id + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        
}
}
}