
package m10r.model;

/*
 * @author CSR
 */

public class Departamento {
    
    private int idDepartamento;
    private String nombreDepartamento;
    
    @Override
    public String toString() {
        return String.format("%s{idDepartamento=%d}", getClass().getSimpleName(), getIdDepartamento());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idDepartamento;
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
        final Departamento other = (Departamento) obj;
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
}