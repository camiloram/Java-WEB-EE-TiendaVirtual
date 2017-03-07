/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
public class Producto {
    
    @Id
    private int id;
    private String nombre;
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private long precio;
    @ManyToOne(optional=false)
    private Vendedor vendedor;
    @ManyToMany
    private List<Categoria> categorias;
    @ManyToOne
    private Orden orden;
}
