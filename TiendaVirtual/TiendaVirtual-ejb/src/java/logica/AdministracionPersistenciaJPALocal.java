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
import javax.ejb.Local;

/**
 *
 * @author Estudiante
 */
@Local
public interface AdministracionPersistenciaJPALocal {
    
    public Producto consultarProducto(int idProducto);
    
    public Integer crearOrden(Orden orden) throws CreacionOrdenException;
    
    public Integer crearInformacionEnvio(InformacionEnvio ie);
    
    public Integer crearInformacionFactura(InformacionFactura infFac);
    
    public void modificarProductos(List<Producto> productos, Orden orden) throws ModificacionProductoException;
    
    public Comprador consultarComprador(String login);
    
    public List<Producto> consultarProductos();
    
    public Integer crearBitacora(Bitacora bitacora);
    
    public List<Comprador> consultarCompradores();
}
