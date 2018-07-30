
package m10r.model;

/*
 * @author CSR
 */

public class UbicacionProducto {
    
    private int idUbicacionProducto;
    private String descripcionUbicacionPro;

    @Override
    public String toString() {
        return String.format("%s{idUbicacionProducto=%d}", getClass().getSimpleName(), getIdUbicacionProducto());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idUbicacionProducto;
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
        final UbicacionProducto other = (UbicacionProducto) obj;
        if (this.idUbicacionProducto != other.idUbicacionProducto) {
            return false;
        }
        return true;
    }
    
    public int getIdUbicacionProducto() {
        return idUbicacionProducto;
    }

    public void setIdUbicacionProducto(int idUbicacionProducto) {
        this.idUbicacionProducto = idUbicacionProducto;
    }

    public String getDescripcionUbicacionPro() {
        return descripcionUbicacionPro;
    }

    public void setDescripcionUbicacionPro(String descripcionUbicacionPro) {
        this.descripcionUbicacionPro = descripcionUbicacionPro;
    }
    
}