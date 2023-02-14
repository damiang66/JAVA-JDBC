
package tienda.persistencia;

import tienda.entidades.Fabricante;


public class FabricanteDao extends DAO {
    public void guardar(Fabricante fabricante) throws Exception{
        System.out.println(fabricante.getNombre() + "desde la clase dao");
        try {
            if(fabricante==null){
                throw new Exception("Debe indicar un Fabricante");
            }
          String sql = "INSERT INTO Fabricante (nombre) "
                    + "VALUES ( '" + fabricante.getNombre()+ "')";
          this.insertarModificarEliminar(sql);
            System.out.println("guarde");
        } catch (Exception e) {
           throw e;
          
        }finally{
            desconectarBase();
        }
        
    }
 
    
}
