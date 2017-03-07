/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Estudiante
 */
@Entity
public class Categoria {
    @Id
    private int id;
    private String descripcion;
    @ManyToMany(mappedBy = "categorias") // como en la clase Producto
    private List<Producto> productos;
}
