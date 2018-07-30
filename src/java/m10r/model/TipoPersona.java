
package m10r.model;

/*
 * @author CSR
 */

public class TipoPersona {
    
    private int idTipoPersona;
    private String descripcionPersona;
    
    @Override
    public String toString() {
        return String.format("%s{idTipoPersona=%d}", getClass().getSimpleName(), getIdTipoPersona());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idTipoPersona;
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
        final TipoPersona other = (TipoPersona) obj;
        if (this.idTipoPersona != other.idTipoPersona) {
            return false;
        }
        return true;
    }
    
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getDescripcionPersona() {
        return descripcionPersona;
    }

    public void setDescripcionPersona(String descripcionPersona) {
        this.descripcionPersona = descripcionPersona;
    }
    
}