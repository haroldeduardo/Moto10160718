
package m10r.model;

/*
 * @author CSR
 */

public class Ciudad {
    
    private int idCiudad;
    private String nombreCiudad;
    
    @Override
    public String toString() {
        return String.format("%s{idCiudad=%d}", getClass().getSimpleName(), getIdCiudad());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idCiudad;
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
        final Ciudad other = (Ciudad) obj;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        return true;
    }
    
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
}