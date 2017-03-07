/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
public class Persona {
    @Id
    private String login;
    @ManyToOne(optional=false)
    private TipoIdentificacion tipoId;
    private String numeroIdentificacion;
    private String nombre1;
    private String nombre2 ;
    private String apellido1;
    private String apellido2;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento ;
    
}
