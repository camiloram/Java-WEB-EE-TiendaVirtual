/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// paso 3 //

/**
 *
 * @author Estudiante
 */
@Named(value = "administracionPersonaBean")
@SessionScoped
public class AdministracionPersonaBean implements Serializable {

    // paso 4 //
    
    List<Persona> personaList = new ArrayList<Persona>();
    Persona persona = new Persona();
     
    
    /**
     * Creates a new instance of AdministracionPersonaBean
     */
    public AdministracionPersonaBean() {
        persona.setNombre("Camilo");
        persona.setSexo("Masculino");
        persona.setEdad("30");
        persona.setFechaNacimiento(new Date());
        
        personaList.add(persona);
    }
    
        public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}    
}
