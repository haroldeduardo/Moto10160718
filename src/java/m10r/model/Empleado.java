
package m10r.model;

/*
 * @author CSR
 */

public class Empleado {
    
    private int idEmpleado;
    private int identificacionEmpleado;
    private String nombresEmpleado;
    private String apellidosEmpleado;
    private Departamento departamento;
    private int idCiudad;
    private String direccionEmpleado;
    private String telefonoEmpleado;
    private String correoEmpleado;
    private String userEmp;
    private String passEmp;

    @Override
    public String toString() {
        return String.format("%s{idEmpleado=%d}", getClass().getSimpleName(), getIdEmpleado());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        return true;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(int identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public String getNombresEmpleado() {
        return nombresEmpleado;
    }

    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    /*public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }*/

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getUserEmp() {
        return userEmp;
    }

    public void setUserEmp(String userEmp) {
        this.userEmp = userEmp;
    }

    public String getPassEmp() {
        return passEmp;
    }

    public void setPassEmp(String passEmp) {
        this.passEmp = passEmp;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
}

