/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Estudiante
 */
@Entity
public class Comprador extends Persona{
    
    // en relaciones bidimeccionales, debemos definir el dueño de la relacion y esta va a ser el de lado muchos definido de la siguiente manera
    @OneToMany(mappedBy = "comprador") // siendo "comprador" de la Clase Orden
    private List<Orden> ordenes;
    private int cantidadCompras;
}
