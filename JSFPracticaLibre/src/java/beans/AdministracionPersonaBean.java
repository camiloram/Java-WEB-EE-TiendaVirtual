/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Andres
 */
@ManagedBean
@SessionScoped
public class AdministracionPersonaBean {

    private Persona persona = new Persona();
    private Persona personaBorrar = new Persona();
    private List<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Creates a new instance of AdministracionPersonaBean
     */
    public AdministracionPersonaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaBorrar() {
        return personaBorrar;
    }

    public void setPersonaBorrar(Persona personaBorrar) {
        this.personaBorrar = personaBorrar;
    }
    
    public void agregarPersona(){
        persona.setId(personas.size() + 1);
        personas.add(persona);
        persona = new Persona();
    }
    
    public void eliminarPersona(Persona persona){
        personas.remove(persona);
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Persona editada correctamente", ((Persona) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage("mensaje", msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada", ((Persona) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}