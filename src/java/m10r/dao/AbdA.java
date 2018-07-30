
package m10r.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * @author CSR
 */

public class AbdA {
    
    private Connection cnt;

    public Connection getCnt() {
        return cnt;
    }

    public void setCnt(Connection cnt) {
        this.cnt = cnt;
    }
    
    public void Conectar() throws Exception{
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/moto10racing?user=root&password=root");
        }
        catch (Exception e){
            throw e;
        }
    }
    
    public void Desconectar() throws Exception{
    
        try {
            if (cnt != null){
                if (cnt.isClosed() == false){
                    cnt.close();
                }
            }
        }
        catch (Exception e){
            throw e;
        }
    }
}