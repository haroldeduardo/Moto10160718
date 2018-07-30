
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import m10r.dao.EmpleadoAbdA;
import m10r.model.Empleado;
import m10r.model.Departamento;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class EmpleadoBean {
    
    private Empleado empleado = new Empleado();
    private List<Empleado> lstEmpleados;
    private String accionBotonEmpleado;

    public String getAccionBotonEmpleado() {
        return accionBotonEmpleado;
    }

    public void setAccionBotonEmpleado(String accionBotonEmpleado) {
        this.cleanEmpleado();
        this.accionBotonEmpleado = accionBotonEmpleado;
    }
    
    public List<Empleado> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<Empleado> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    private boolean isPostBack() {

        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void ingresarEmpleado() throws Exception {
        
        EmpleadoAbdA Dao;
        
        try{
            Dao = new EmpleadoAbdA();
            Dao.ingresarEmpleado(empleado);
            this.reporteEmpleados("V");
        }
        catch (Exception e){
        throw e;
        }
    }
    
    public void buscarEmpleado(Empleado Pro) throws Exception{
        
        EmpleadoAbdA Dao;
        Empleado temp;
        
        try{
            Dao = new EmpleadoAbdA();
            temp = Dao.buscarEmpleado(Pro);
            
            if (temp != null){
                this.empleado = temp;
                this.accionBotonEmpleado = "Modificar";
            }
        }
        catch (Exception e){
        throw e;
        }
    }
    
    public void modificarEmpleado() throws Exception {
        
        EmpleadoAbdA Dao;
        
        try{
            Dao = new EmpleadoAbdA();
            Dao.modificarEmpleado(empleado);
            this.reporteEmpleados("V");
        }
        catch (Exception e){
        throw e;
        }
    }
    
    public void eliminarEmpleado(Empleado Pro) throws Exception {
        
        EmpleadoAbdA Dao;
        
        try{
            Dao = new EmpleadoAbdA();
            Dao.eliminarEmpleado(Pro);
            this.reporteEmpleados("V");
        }
        catch (Exception e){
        throw e;
        }
    }
    
    public void reporteEmpleados(String Valor) throws Exception {

        EmpleadoAbdA Dao;

        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    Dao = new EmpleadoAbdA();
                    lstEmpleados = Dao.reporteEmpleados();
                }

            } else {
                Dao = new EmpleadoAbdA();
                lstEmpleados = Dao.reporteEmpleados();
            }

        }
        catch (Exception e) {
        throw e;
        }
    }
    
    public void operarAccionBotonEmpleado() throws Exception{
    
        switch (accionBotonEmpleado){
        
            case "Guardar":
                this.ingresarEmpleado();
                this.cleanEmpleado();
                break;
            case "Modificar":
                this.modificarEmpleado();
                this.cleanEmpleado();
                break;
        }
    }
    
    public void cleanEmpleado(){
        
        Departamento dep = new Departamento();
        
        this.empleado.setIdEmpleado(0);
        this.empleado.setIdentificacionEmpleado(0);
        this.empleado.setNombresEmpleado("");
        this.empleado.setApellidosEmpleado("");
        dep.setIdDepartamento(0);
        this.empleado.setIdCiudad(0);
        this.empleado.setDireccionEmpleado("");
        this.empleado.setTelefonoEmpleado("");
        this.empleado.setCorreoEmpleado("");
        this.empleado.setUserEmp("");
        this.empleado.setPassEmp("");
    }
    
}