
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import m10r.model.Empleado;

/*
 * @author CSR
 */

public class IngresoAbdA extends AbdA{
    
    public Empleado buscarEmpleado(Empleado Cat) throws Exception{
    
        Empleado cats = null;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("SELECT idEmpleado, userEmp, passEmp FROM EMPLEADO WHERE idEmpleado = ?");
            st.setInt(1, Cat.getIdEmpleado());
            rs = st.executeQuery();
            while(rs.next()){
                cats = new Empleado();
                cats.setIdEmpleado(rs.getInt("idEmpleado"));
///                cats.setNombreEmpleado(rs.getString("nombreEmpleado"));
            }
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
        return cats;
    }

}