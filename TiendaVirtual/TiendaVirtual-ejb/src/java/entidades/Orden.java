/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Orden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) -  oracle
    //@GeneratedValue(strategy = GenerationType.TABLE) - crea tabla con el control de secuencia de cada tabla
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "orden")
    private List<Producto> productos;
    @ManyToOne(optional=false)
    private Comprador comprador;
    @OneToOne(optional=false)
    @JoinColumn(name = "ID_INF_FACTURA")
    private InformacionFactura informacionFactura;
    @OneToOne(optional=false)
    @JoinColumn(name = "ID_INF_ENVIO")
    private InformacionEnvio informacionEnvio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public InformacionFactura getInformacionFactura() {
        return informacionFactura;
    }

    public void setInformacionFactura(InformacionFactura informacionFactura) {
        this.informacionFactura = informacionFactura;
    }

    public InformacionEnvio getInformacionEnvio() {
        return informacionEnvio;
    }

    public void setInformacionEnvio(InformacionEnvio informacionEnvio) {
        this.informacionEnvio = informacionEnvio;
    }
    
}
