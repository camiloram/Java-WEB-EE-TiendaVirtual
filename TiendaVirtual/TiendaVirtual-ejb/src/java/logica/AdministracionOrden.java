/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Orden;
import entidades.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Estudiante
 */
@Stateful
public class AdministracionOrden implements AdministracionOrdenLocal {
    
    @EJB
    AdministracionPersisitenciaJPALocal administracionPersisitencia;
    
    private List<Producto> productos;
    private Comprador comprador;
    private InformacionFactura informacionFactura;
    private InformacionEnvio informacionEnvio;
    
    // Se Inyectaa la dependencia
    @EJB
    AdministracionPersistenciaLocal administracionPersistencia;

    // Se crea en el momento que es llamado este constructor
    public AdministracionOrden() {
        productos = new ArrayList<Producto>();
    }
    
    @Override
    public void adicionarComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public void adicionarInformacionFactura(InformacionFactura informacionFactura) {
        this.informacionFactura = informacionFactura;
    }

    @Override
    public void adicionarInformacionEnvio(InformacionEnvio informacionEnvio) {
        this.informacionEnvio = informacionEnvio;
    }

    @Override
    @Remove // se muere apenas termina la ejecución
    public Integer crearOrdenCompra() {
        
        administracionPersistencia.crearInformacionEnvio(informacionEnvio);
        administracionPersistencia.crearInformacionFactura(informacionFactura);
        
        //informacionEnvio.setId(administracionPersistencia.crearInformacionEnvio(informacionEnvio));
        //informacionFactura.setId(administracionPersistencia.crearInformacionFactura(informacionFactura));
        
        Orden orden = new Orden();
        orden.setComprador(comprador);
        orden.setFecha(new Date());
        orden.setInformacionEnvio(informacionEnvio);
        orden.setInformacionFactura(informacionFactura);
        
        administracionPersisitencia.crearOrden(orden);
        //orden.setId(administracionPersistencia.crearOrden(orden));

        administracionPersistencia.modificarProductos(productos, orden);
        return orden.getId();

    }

    @Override
    @Remove // se muere apenas termina la ejecución
    public void cancelarOrdenCompra() {
    }

    @Override
    public void adicionarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Comprador getComprador() {
        return comprador;
    }

    @Override
    public List ConsultarCarroCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
