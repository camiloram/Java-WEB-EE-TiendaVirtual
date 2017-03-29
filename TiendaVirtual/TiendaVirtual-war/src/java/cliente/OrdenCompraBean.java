/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Producto;
import excepciones.CreacionOrdenException;
import excepciones.ModificacionProductoException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import logica.AdministracionOrdenLocal;
import logica.AdministracionPersistenciaJPALocal;

/**
 *
 * @author Estudiante
 */
@Named(value = "ordenCompraBean")
@SessionScoped
public class OrdenCompraBean implements Serializable {

    @EJB
    AdministracionPersistenciaJPALocal administracionPersistencia;
    
    @EJB
    AdministracionOrdenLocal administracionOrden;
    
    private InformacionEnvio informacionEnvio;
    
    private InformacionFactura informacionFactura;
    
    /**
     * Creates a new instance of OrdenCompraBean
     */
    public OrdenCompraBean() {
        informacionEnvio = new InformacionEnvio();
        informacionFactura = new InformacionFactura();
    }
    
    public List<Comprador> getCompradores(){
        return administracionPersistencia.consultarCompradores();
    }
    
    //public SelectItem[] getCompradores(){}
    
    public void compradoresListener(ValueChangeEvent vce){
        String login = vce.getNewValue().toString();
        if(!login.equals("-1")){
            Comprador comprador = administracionPersistencia.consultarComprador(login);
            administracionOrden.adicionarComprador(comprador);
        }
    }
    
    public List getProductos() {
        return administracionPersistencia.consultarProductos();
    }
    
    public void adicionarProducto(String id){
        Producto producto = administracionPersistencia.consultarProducto(Integer.parseInt(id));
        administracionOrden.adicionarProducto(producto);
    }
    
    public List getCarroCompras(){
       return administracionOrden.consultarCarroCompras();
    }
    
    public String adicionarInformacionEnvio(){
        administracionOrden.adicionarInformacionEnvio(informacionEnvio);
        return "informacion_factura";
    }
    
    public void crearOrdenCompra(){
        administracionOrden.adicionarInformacionFactura(informacionFactura);
        try{
            administracionOrden.crearOrdenCompra();
        } catch (CreacionOrdenException ex) {
            System.out.println("Error en creación de orden");
        } catch (ModificacionProductoException ex) {
            System.out.println("Error en modificación de productos");
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("OrdenCompraBean");
    }

    public InformacionFactura getInformacionFactura() {
        return informacionFactura;
    }

    public void setInformacionFactura(InformacionFactura informacionFactura) {
        this.informacionFactura = informacionFactura;
    }

    public AdministracionPersistenciaJPALocal getAdministracionPersisitencia() {
        return administracionPersistencia;
    }

    public void setAdministracionPersisitencia(AdministracionPersistenciaJPALocal administracionPersisitencia) {
        this.administracionPersistencia = administracionPersisitencia;
    }

    public AdministracionOrdenLocal getAdministracionOrden() {
        return administracionOrden;
    }

    public void setAdministracionOrden(AdministracionOrdenLocal administracionOrden) {
        this.administracionOrden = administracionOrden;
    }

    public InformacionEnvio getInformacionEnvio() {
        return informacionEnvio;
    }

    public void setInformacionEnvio(InformacionEnvio informacionEnvio) {
        this.informacionEnvio = informacionEnvio;
    }
}
