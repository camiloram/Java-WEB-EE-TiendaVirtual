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
import excepciones.CreacionOrdenException;
import excepciones.ModificacionProductoException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import notificaciones.NotificacionInterceptor;

/**
 *
 * @author Estudiante
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class AdministracionPersistenciaJPA implements AdministracionPersistenciaJPALocal {
    
    // maneja la conexion a base de datos.
    // si esta no se define toma por defecto la que exista en caso que sea unica.
    @PersistenceContext
    EntityManager em;
    
    @Resource
    private TimerService timerService;
    
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
    @Interceptors(NotificacionInterceptor.class)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearOrden(Orden orden) throws CreacionOrdenException {
        try {
            em.persist(orden);
            timerService.createTimer(15000, orden);
        } catch (Exception ex) {
           throw new CreacionOrdenException();
        }
        return orden.getId();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        em.persist(ie);
        em.flush();
        return ie.getId();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        em.persist(infFac);
        em.flush();
        return infFac.getId();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarProductos(List<Producto> productos, Orden orden) throws ModificacionProductoException {
        try {    
            for (Producto producto: productos) {
                producto.setOrden(orden);
                em.merge(producto);
            }
            //throw new ModificacionProductoException();//Se realiza la excepcion para probar rollback
        } catch (Exception ex) {
           throw new ModificacionProductoException();
        }
    }

    @Override
    public Comprador consultarComprador(String login) {
        return em.find(Comprador.class, login);
    }

    @Override
    public List<Producto> consultarProductos() {
        Query query = em.createNamedQuery("findAllProducts");
        List<Producto> productos = query.getResultList();
        return productos;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
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

    @Timeout
    private void timerCrearOrden(Timer timer){
        Orden orden = (Orden) timer.getInfo();
        System.out.println("Se ha enviado la orden a la dirección "
        + orden.getInformacionEnvio().getDireccion());
    }
}
