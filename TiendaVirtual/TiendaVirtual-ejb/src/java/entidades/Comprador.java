/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Estudiante
 */
@Entity
@DiscriminatorValue(value = "C")
@NamedQueries({
    @NamedQuery(name = "findAllCompradores", query = "SELECT c FROM Comprador c")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Comprador extends Persona{
    
    @XmlTransient
    // en relaciones bidimeccionales, debemos definir el dueño de la relacion y esta va a ser el de lado muchos definido de la siguiente manera
    @OneToMany(mappedBy = "comprador") // siendo "comprador" de la Clase Orden
    private List<Orden> ordenes;
    private int cantidadCompras;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }
}
