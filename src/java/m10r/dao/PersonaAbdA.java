
package m10r.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import m10r.model.Persona;

/*
 * @author CSR
 */

public class PersonaAbdA extends AbdA{
    
    public void ingresarPersona (Persona Per) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("INSERT INTO PERSONA (idTipoPersona, idTipoDocumento, identificacionPersona, nombresPersona, apellidosPersona, idDepartamento, idCiudad, direccionPersona, telefonoPersona, correoPersona) VALUES (?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, Per.getIdTipoPersona());
            st.setInt(2, Per.getIdTipoDocumento());
            st.setInt(3, Per.getIdentificacionPersona());
            st.setString(4, Per.getNombresPersona());
            st.setString(5, Per.getApellidosPersona());
            st.setInt(6, Per.getIdDepartamento());
            st.setInt(7, Per.getIdCiudad());
            st.setString(8, Per.getDireccionPersona());
            st.setString(9, Per.getTelefonoPersona());
            st.setString(10, Per.getCorreoPersona());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public Persona buscarPersona(Persona Per) throws Exception{
    
        Persona pers = null;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("SELECT idPersona, idTipoPersona, idTipoDocumento, identificacionPersona, nombresPersona, apellidosPersona, idDepartamento, idCiudad, direccionPersona, telefonoPersona, correoPersona FROM PERSONA WHERE idPersona = ?");
            st.setInt(1, Per.getIdPersona());
            rs = st.executeQuery();
            while(rs.next()){
                pers = new Persona();
                pers.setIdPersona(rs.getInt("idPersona"));
                pers.setIdTipoPersona(rs.getInt("idTipoPersona"));
                pers.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                pers.setIdentificacionPersona(rs.getInt("identificacionPersona"));
                pers.setNombresPersona(rs.getString("nombresPersona"));
                pers.setApellidosPersona(rs.getString("apellidosPersona"));
                pers.setIdDepartamento(rs.getInt("idDepartamento"));
                pers.setIdCiudad(rs.getInt("idCiudad"));
                pers.setDireccionPersona(rs.getString("direccionPersona"));
                pers.setTelefonoPersona(rs.getString("telefonoPersona"));
                pers.setCorreoPersona(rs.getString("correoPersona"));
            }
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
        return pers;
    }
    
    public void modificarPersona (Persona Per) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("UPDATE PERSONA SET idTipoPersona = ?, idTipoDocumento = ?, identificacionPersona = ?, nombresPersona = ?, apellidosPersona = ?, idDepartamento = ?, idCiudad = ?, direccionPersona = ?, telefonoPersona = ?, correoPersona = ? WHERE idPersona = ?");
            st.setInt(1, Per.getIdTipoPersona());
            st.setInt(2, Per.getIdTipoDocumento());
            st.setInt(3, Per.getIdentificacionPersona());
            st.setString(4, Per.getNombresPersona());
            st.setString(5, Per.getApellidosPersona());
            st.setInt(6, Per.getIdDepartamento());
            st.setInt(7, Per.getIdCiudad());
            st.setString(8, Per.getDireccionPersona());
            st.setString(9, Per.getTelefonoPersona());
            st.setString(10, Per.getCorreoPersona());
            st.setInt(11, Per.getIdPersona());
            st.executeUpdate();
        }
        
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public void eliminarPersona (Persona Per) throws Exception{
    
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareStatement("DELETE FROM PERSONA WHERE idPersona = ?");
            st.setInt(1, Per.getIdPersona());
            st.executeUpdate();
        }
        catch (Exception e){
            throw e;   
        }
        finally{
            this.Desconectar();
        }
    }
    
    public List<Persona> reportePersonas() throws Exception{
        
        List<Persona> reportesPersona;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCnt().prepareCall("SELECT idPersona, idTipoPersona, idTipoDocumento, identificacionPersona, nombresPersona, apellidosPersona, idDepartamento, idCiudad, direccionPersona, telefonoPersona, correoPersona FROM PERSONA");
            rs = st.executeQuery();
            reportesPersona = new ArrayList();
            while(rs.next()){
                Persona Per = new Persona();
                Per.setIdPersona(rs.getInt("idPersona"));
                Per.setIdTipoPersona(rs.getInt("idTipoPersona"));
                Per.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                Per.setIdentificacionPersona(rs.getInt("identificacionPersona"));
                Per.setNombresPersona(rs.getString("nombresPersona"));
                Per.setApellidosPersona(rs.getString("apellidosPersona"));
                Per.setIdDepartamento(rs.getInt("idDepartamento"));
                Per.setIdCiudad(rs.getInt("idCiudad"));
                Per.setDireccionPersona(rs.getString("direccionPersona"));
                Per.setTelefonoPersona(rs.getString("telefonoPersona"));
                Per.setCorreoPersona(rs.getString("correoPersona"));
                reportesPersona.add(Per);
            }
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.Desconectar();
        }
        return reportesPersona;
    }
    
}