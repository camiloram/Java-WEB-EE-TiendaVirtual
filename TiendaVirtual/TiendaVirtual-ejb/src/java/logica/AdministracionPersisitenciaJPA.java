/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Bitacora;
import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Orden;
import entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Estudiante
 */
@Stateless
public class AdministracionPersisitenciaJPA implements AdministracionPersisitenciaJPALocal {
    
    // maneja la conexion a base de datos.
    // si esta no se define toma por defecto la que exista en caso que sea unica.
    @PersistenceContext
    private EntityManager em;

    @Override
    public Producto consultarProducto(int idProducto) {
        return em.find(Producto.class, idProducto); 
        // find es para consultas con llave primaria.
        // carga las dependencias unicas o uno a uno que tenga relacionadas en 
        // este caso Ej: vendenor no la lista de categorias.
        // definiendo en el @ManyToOne(fetch = FetchType.LAZY) para que no cargue y EAGER para que si.
        // @Basic(fetch = FetchType.LAZY) para datos(columnas) que no estan en relaciones.
    }

    @Override
    public Integer crearOrden(Orden orden) {
        em.persist(orden);
        return orden.getId();
    }

    @Override
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        em.persist(ie);
        return ie.getId();
    }

    @Override
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        em.persist(infFac);
        return infFac.getId();
    }

    @Override
    public void modificarProductos(List<Producto> productos, Orden orden) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            producto.setOrden(orden);
            em.merge(producto);
        }
    }
    
    // em.remove(categoria);
    // ademas para ser borrado debe ser administrado por el EM osea buscar y borrar
    // o se podria usar em.remove(em.merge(categoria)); para convertirlo en administrado y borrar.

    @Override
    public Comprador cosultarComprador(String login) {
        return em.find(Comprador.class, login);
    }

    @Override
    public List<Producto> consultarProductos() {
        Query query = em.createNamedQuery("findAllProducts");
        List<Producto> productos = query.getResultList();
        return productos;
    }

    @Override
    public Integer crearBitacora(Bitacora bitacora) {
        em.persist(bitacora);
        return bitacora.getId();
    }

    @Override
    public List<Comprador> consultarCompradores() {
        Query query = em.createNamedQuery("findAllCompradores");
        List<Comprador> compradores = query.getResultList();
        return compradores;
    }
}
