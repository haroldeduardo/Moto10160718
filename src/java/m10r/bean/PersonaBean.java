
package m10r.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import m10r.dao.PersonaAbdA;
import m10r.model.Persona;

/*
 * @author CSR
 */

@ManagedBean

@ViewScoped

public class PersonaBean {

    private Persona persona = new Persona();
    private List<Persona> lstPersonas;
    private String accionBotonPersona;

    public String getAccionBotonPersona() {
        return accionBotonPersona;
    }

    public void setAccionBotonPersona(String accionBotonPersona) {
        this.cleanPersona();
        this.accionBotonPersona = accionBotonPersona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    private boolean isPostBack() {

        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void ingresarPersona() throws Exception {

        PersonaAbdA Dao;

        try {
            Dao = new PersonaAbdA();
            Dao.ingresarPersona(persona);
            this.reportePersonas("V");
        }
        catch (Exception e) {
        throw e;
        }
    }

    public void buscarPersona(Persona Pro) throws Exception {

        PersonaAbdA Dao;
        Persona temp;

        try {
            Dao = new PersonaAbdA();
            temp = Dao.buscarPersona(Pro);

            if (temp != null) {
                this.persona = temp;
                this.accionBotonPersona = "Modificar";
            }
        }
        catch (Exception e) {
        throw e;
        }
    }

    public void modificarPersona() throws Exception {
        
        PersonaAbdA Dao;

        try{
            Dao = new PersonaAbdA();
            Dao.modificarPersona(persona);
            this.reportePersonas("V");
        }
        catch (Exception e) {
        throw e;
        }
    }

    public void eliminarPersona(Persona Pro) throws Exception {

        PersonaAbdA Dao;

        try {
            Dao = new PersonaAbdA();
            Dao.eliminarPersona(Pro);
            this.reportePersonas("V");
        }
        catch (Exception e) {
        throw e;
        }
    }

    public void reportePersonas(String Valor) throws Exception {

        PersonaAbdA Dao;

        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    Dao = new PersonaAbdA();
                    lstPersonas = Dao.reportePersonas();
                }

            } else {
                Dao = new PersonaAbdA();
                lstPersonas = Dao.reportePersonas();
            }

        }
        catch (Exception e) {
        throw e;
        }
    }

    public void operarAccionBotonPersona() throws Exception {

        switch (accionBotonPersona) {

            case "Guardar":
                this.ingresarPersona();
                this.cleanPersona();
                break;
            case "Modificar":
                this.modificarPersona();
                this.cleanPersona();
                break;
        }
    }

    public void cleanPersona() {

        this.persona.setIdPersona(0);
        this.persona.setIdTipoPersona(0);
        this.persona.setIdTipoDocumento(0);
        this.persona.setIdentificacionPersona(0);
        this.persona.setNombresPersona("");
        this.persona.setApellidosPersona("");
        this.persona.setIdDepartamento(0);
        this.persona.setIdCiudad(0);
        this.persona.setDireccionPersona("");
        this.persona.setTelefonoPersona("");
        this.persona.setCorreoPersona("");
    }

}