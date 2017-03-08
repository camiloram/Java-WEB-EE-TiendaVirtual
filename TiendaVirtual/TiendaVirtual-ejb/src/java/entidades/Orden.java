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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
public class Orden {
    @Id
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "orden")
    private List<Producto> productos;
    @ManyToOne(optional=false)
    private Comprador comprador;
    @OneToOne(optional=false)
    private InformacionFactura informacionFactura;
    @OneToOne(optional=false)
    private InformacionEnvio informacionEnvio;
    
}
