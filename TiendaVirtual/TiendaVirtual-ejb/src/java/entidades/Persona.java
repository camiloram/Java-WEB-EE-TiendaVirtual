/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TIPO_PERSONA", discriminatorType = DiscriminatorType.STRING, length = 1)
public class Persona {
    @Id
    @Column(length = 12)
    private String login;
    @ManyToOne(optional=false)
    @JoinColumn(name = "TIPO_ID")
    private TipoIdentificacion tipoId;
    @Column(length = 15, nullable = false, name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;
    @Column(length = 40, nullable = false)
    private String nombre1;
    @Column(length = 40)
    private String nombre2 ;
    @Column(length = 40, nullable = false)
    private String apellido1;
    @Column(length = 40)
    private String apellido2;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento ;
    
}
