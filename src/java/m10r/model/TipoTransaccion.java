
package m10r.model;

/*
 * @author CSR
 */

public class TipoTransaccion {

    private int idTipoTransaccion;
    private String descripcionTransaccion;

    @Override
    public String toString() {
        return String.format("%s{idTipoTransaccion=%d}", getClass().getSimpleName(), getIdTipoTransaccion());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idTipoTransaccion;
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
        final TipoTransaccion other = (TipoTransaccion) obj;
        if (this.idTipoTransaccion != other.idTipoTransaccion) {
            return false;
        }
        return true;
    }
    
    public int getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getDescripcionTransaccion() {
        return descripcionTransaccion;
    }

    public void setDescripcionTransaccion(String descripcionTransaccion) {
        this.descripcionTransaccion = descripcionTransaccion;
    }
    
}