
package m10r.model;

/*
 *@author CSR
 */

public class TipoDocumento {
    
    private int idTipoDocumento;
    private String descripcionDocumento;
    
    @Override
    public String toString() {
        return String.format("%s{idTipoDocumento=%d}", getClass().getSimpleName(), getIdTipoDocumento());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idTipoDocumento;
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
        final TipoDocumento other = (TipoDocumento) obj;
        if (this.idTipoDocumento != other.idTipoDocumento) {
            return false;
        }
        return true;
    }
    
    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }
    
}