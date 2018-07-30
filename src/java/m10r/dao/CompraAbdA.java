
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import m10r.model.DetalleCompra;
import m10r.model.Compra;

/*
 * @author CSR
 */

public class CompraAbdA extends AbdA{
    
    public void ingresarCompra(Compra Com, List<DetalleCompra> listaDC) throws Exception {

        try {
            this.Conectar();
            this.getCnt().setAutoCommit(false);
            PreparedStatement st1 = this.getCnt().prepareStatement("INSERT INTO COMPRA (idEmpleado, idPersona, idTipoTransaccion, totalCompra) VALUES (?,?,?,?)");
            st1.setInt(1, Com.getEmpleado().getIdEmpleado());
            st1.setInt(2, Com.getPersona().getIdPersona());
            st1.setInt(3, Com.getTipoTransaccion().getIdTipoTransaccion());
            st1.setFloat(4, Com.getTotalCompra());
            ///st1.setDate(5, Com.getFechaCompra());
            st1.executeUpdate();
            st1.close();

            PreparedStatement st2 = this.getCnt().prepareStatement("SELECT idCompra FROM Compra ORDER BY idCompra DESC LIMIT 1");
            ResultSet rs;
            int idCompraLast = 0;
            rs = st2.executeQuery();

            while (rs.next()) {
                idCompraLast = rs.getInt(1);
            }
            rs.close();
            
            for (DetalleCompra detCom : listaDC) {

                PreparedStatement st3 = this.getCnt().prepareStatement("INSERT INTO DETALLECOMPRA (idCompra, idProducto, valorCompraProducto, valorVentaProducto, unidadesCompradas) VALUES (?,?,?,?,?)");
                st3.setInt(1, idCompraLast);
                st3.setInt(2, detCom.getProducto().getIdProducto());
                st3.setFloat(3, detCom.getProducto().getValorCompraProducto());
                st3.setFloat(4, detCom.getProducto().getValorVentaProducto());
                st3.setInt(5, detCom.getUnidadesCompradas());
                st3.executeUpdate();
                st3.close();
                
            }
            this.getCnt().commit();
        } catch (Exception e) {
            this.getCnt().rollback();
            throw e;
        } finally {
            this.Desconectar();
        }
    }
    
}
