
package m10r.model;

import java.sql.Date;

/*
 * @author CSR
 */

public class Venta {

    private int idVenta;
    private Empleado empleado;
    private Persona persona;
    private TipoTransaccion tipoTransaccion;
    private float totalVenta;
    private float totalDescuentoVenta;
    ///private Date fechaVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public float getTotalDescuentoVenta() {
        return totalDescuentoVenta;
    }

    public void setTotalDescuentoVenta(float totalDescuentoVenta) {
        this.totalDescuentoVenta = totalDescuentoVenta;
    }

    /*public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }*/
}
