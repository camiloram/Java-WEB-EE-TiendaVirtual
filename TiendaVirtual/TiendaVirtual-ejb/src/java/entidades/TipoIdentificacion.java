/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Estudiante
 */

@Entity
@Table(name = "TIPO_IDENTIFICACION")
public class TipoIdentificacion {
    
    @Id
    @Column(length = 2)
    private String id;
    @Column(nullable = false, length = 30)
    private String descripcion;
}
