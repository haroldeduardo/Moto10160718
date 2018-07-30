
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Departamento;

/*
 * @author CSR
 */

public class DepartamentoAbdA extends AbdA{
    
    public List<Departamento> reporteDepartamentos() throws Exception{
        
        List<Departamento> reportesDepartamento;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idDepartamento, nombreDepartamento FROM DEPARTAMENTO");
            rs = st.executeQuery();
            reportesDepartamento = new ArrayList();
            while(rs.next()){
                Departamento Dep = new Departamento();
                Dep.setIdDepartamento(rs.getInt("idDepartamento"));
                Dep.setNombreDepartamento(rs.getString("nombreDepartamento"));
                reportesDepartamento.add(Dep);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesDepartamento;
    }
    
}