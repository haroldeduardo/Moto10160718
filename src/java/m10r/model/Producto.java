
package m10r.model;

/*
 * @author CSR
 */

public class Producto {
    
    private int idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int stockProducto;
    private float valorCompraProducto;
    private float valorVentaProducto;
    private String IVA;
    private int idCategoria;
    private int idPresentacionProducto;
    private int idUbicacionProducto;

    @Override
    public String toString() {
        return String.format("%s{idProducto=%d}", getClass().getSimpleName(), getIdProducto());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idProducto;
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
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public float getValorCompraProducto() {
        return valorCompraProducto;
    }

    public void setValorCompraProducto(float valorCompraProducto) {
        this.valorCompraProducto = valorCompraProducto;
        
        if (valorCompraProducto<=0){
            valorCompraProducto=0;
        }
        
    }

    public float getValorVentaProducto() {
        return valorVentaProducto;
    }

    public void setValorVentaProducto(float valorVentaProducto) {
        this.valorVentaProducto = valorVentaProducto;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdPresentacionProducto() {
        return idPresentacionProducto;
    }

    public void setIdPresentacionProducto(int idPresentacionProducto) {
        this.idPresentacionProducto = idPresentacionProducto;
    }

    public int getIdUbicacionProducto() {
        return idUbicacionProducto;
    }

    public void setIdUbicacionProducto(int idUbicacionProducto) {
        this.idUbicacionProducto = idUbicacionProducto;
    }
    
}