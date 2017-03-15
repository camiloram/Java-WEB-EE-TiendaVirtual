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
import javax.ejb.Local;

/**
 *
 * @author Estudiante
 */
@Local
public interface AdministracionPersisitenciaJPALocal {
    
    public Producto consultarProducto(int idProducto);
    
    public Integer crearOrden(Orden orden);
    
    public Integer crearInformacionEnvio(InformacionEnvio ie);
    
    public Integer crearInformacionFactura(InformacionFactura infFac);
    
    public void modificarProductos(List<Producto> productos, Orden orden);
    
    public Comprador cosultarComprador(String login);
    
    public List<Producto> consultarProductos();
    
    public Integer crearBitacora(Bitacora bitacora);
    
    public List<Comprador> consultarCompradores();

    public Comprador consultarCompradores(String maria);

    public Comprador consultarCompradores(String maria);
}
