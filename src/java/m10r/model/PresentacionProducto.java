
package m10r.model;

/*
 * @author CSR
 */

public class PresentacionProducto {
    
    private int idPresentacionProducto;
    private String descripcionPresentacionPro;

    @Override
    public String toString() {
        return String.format("%s{idPresentacionProducto=%d}", getClass().getSimpleName(), getIdPresentacionProducto());
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idPresentacionProducto;
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
        final PresentacionProducto other = (PresentacionProducto) obj;
        if (this.idPresentacionProducto != other.idPresentacionProducto) {
            return false;
        }
        return true;
    }
    
    public int getIdPresentacionProducto() {
        return idPresentacionProducto;
    }

    public void setIdPresentacionProducto(int idPresentacionProducto) {
        this.idPresentacionProducto = idPresentacionProducto;
    }

    public String getDescripcionPresentacionPro() {
        return descripcionPresentacionPro;
    }

    public void setDescripcionPresentacionPro(String descripcionPresentacionPro) {
        this.descripcionPresentacionPro = descripcionPresentacionPro;
    }
    
}