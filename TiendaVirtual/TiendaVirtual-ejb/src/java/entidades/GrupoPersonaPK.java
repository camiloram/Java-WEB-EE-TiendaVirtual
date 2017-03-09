/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Estudiante
 */

@Embeddable
public class GrupoPersonaPK implements Serializable {  // para crear la llave compuesta con los 2 campos
                                // esta llave compuesta se encapsula por rela de JPA
    
    @Column(nullable = false, length = 12)
    private String login;

    public String getGrupoPersona() {
        return grupoPersona;
    }

    public void setGrupoPersona(String grupoPersona) {
        this.grupoPersona = grupoPersona;
    }
    
    @Column(nullable = false, length = 12, name = "GRUPO_PERSONA")
    private String grupoPersona;
}
