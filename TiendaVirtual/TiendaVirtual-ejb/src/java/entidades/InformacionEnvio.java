/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Estudiante
 */
@Entity
public class InformacionEnvio {
    @Id
    private int id;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccion;
}
