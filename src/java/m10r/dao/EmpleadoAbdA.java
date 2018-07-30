
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Empleado;
import m10r.model.Departamento;

/*
 * @author CSR
 */

public class EmpleadoAbdA extends AbdA{
    
    public void ingresarEmpleado (Empleado Emp) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("INSERT INTO EMPLEADO (identificacionEmpleado, nombresEmpleado, apellidosEmpleado, idDepartamento, idCiudad, direccionEmpleado, telefonoEmpleado, correoEmpleado, userEmp, passEmp) VALUES (?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, Emp.getIdentificacionEmpleado());
            st.setString(2, Emp.getNombresEmpleado());
            st.setString(3, Emp.getApellidosEmpleado());
            st.setInt(4, Emp.getDepartamento().getIdDepartamento());
            st.setInt(5, Emp.getIdCiudad());
            st.setString(6, Emp.getDireccionEmpleado());
            st.setString(7, Emp.getTelefonoEmpleado());
            st.setString(8, Emp.getCorreoEmpleado());
            st.setString(9, Emp.getUserEmp());
            st.setString(10, Emp.getPassEmp());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public Empleado buscarEmpleado(Empleado Emp) throws Exception{
    
        Empleado emps = null;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("SELECT idEmpleado, identificacionEmpleado, nombresEmpleado, apellidosEmpleado, idDepartamento, idCiudad, direccionEmpleado, telefonoEmpleado, correoEmpleado, userEmp, passEmp FROM EMPLEADO WHERE idEmpleado = ?");
            st.setInt(1, Emp.getIdEmpleado());
            rs = st.executeQuery();
            Departamento dep = new Departamento();
            while(rs.next()){
                emps = new Empleado();
                emps.setIdEmpleado(rs.getInt("idEmpleado"));
                emps.setIdentificacionEmpleado(rs.getInt("identificacionEmpleado"));
                emps.setNombresEmpleado(rs.getString("nombresEmpleado"));
                emps.setApellidosEmpleado(rs.getString("apellidosEmpleado"));
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                emps.setIdCiudad(rs.getInt("idCiudad"));
                emps.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                emps.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
                emps.setCorreoEmpleado(rs.getString("correoEmpleado"));
                emps.setUserEmp(rs.getString("userEmp"));
                emps.setPassEmp(rs.getString("passEmp"));
            }
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
        return emps;
    }
    
    public void modificarEmpleado (Empleado Emp) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("UPDATE EMPLEADO SET identificacionEmpleado = ?, nombresEmpleado = ?, apellidosEmpleado = ?, idDepartamento = ?, idCiudad = ?, direccionEmpleado = ?, telefonoEmpleado = ?, correoEmpleado = ?, userEmp = ?, passEmp = ? WHERE idEmpleado = ?");
            st.setInt(1, Emp.getIdentificacionEmpleado());
            st.setString(2, Emp.getNombresEmpleado());
            st.setString(3, Emp.getApellidosEmpleado());
            st.setInt(4, Emp.getDepartamento().getIdDepartamento());
            st.setInt(5, Emp.getIdCiudad());
            st.setString(6, Emp.getDireccionEmpleado());
            st.setString(7, Emp.getTelefonoEmpleado());
            st.setString(8, Emp.getCorreoEmpleado());
            st.setString(9, Emp.getUserEmp());
            st.setString(10, Emp.getPassEmp());
            st.setInt(11, Emp.getIdEmpleado());
            st.executeUpdate();
        }
        
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public void eliminarEmpleado (Empleado Emp) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("DELETE FROM EMPLEADO WHERE idEmpleado = ?");
            st.setInt(1, Emp.getIdEmpleado());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public List<Empleado> reporteEmpleados() throws Exception{
        
        List<Empleado> reportesEmpleado;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idEmpleado, identificacionEmpleado, nombresEmpleado, apellidosEmpleado, idDepartamento, idCiudad, direccionEmpleado, telefonoEmpleado, correoEmpleado, userEmp, passEmp FROM EMPLEADO");
            rs = st.executeQuery();
            Departamento dep = new Departamento();
            reportesEmpleado = new ArrayList();
            while(rs.next()){
                Empleado Emp = new Empleado();
                Emp.setIdEmpleado(rs.getInt("idEmpleado"));
                Emp.setIdentificacionEmpleado(rs.getInt("identificacionEmpleado"));
                Emp.setNombresEmpleado(rs.getString("nombresEmpleado"));
                Emp.setApellidosEmpleado(rs.getString("apellidosEmpleado"));
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                Emp.setIdCiudad(rs.getInt("idCiudad"));
                Emp.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                Emp.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
                Emp.setCorreoEmpleado(rs.getString("correoEmpleado"));
                Emp.setUserEmp(rs.getString("userEmp"));
                Emp.setPassEmp(rs.getString("passEmp"));
                reportesEmpleado.add(Emp);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesEmpleado;
    }
    
}