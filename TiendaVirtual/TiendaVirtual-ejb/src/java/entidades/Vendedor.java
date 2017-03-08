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
public class Vendedor extends Persona{
    @OneToMany(mappedBy = "vendedor")
    private List<Producto> productos;
    private int calificacion;
}
