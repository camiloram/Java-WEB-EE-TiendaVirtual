/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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

public interface AdministracionPersistenciaLocal {
    
    public Producto consultarProducto(int Producto);
    
    public Integer createOrden(Orden orden);
    
    public Integer crearInformacionEnvio(InformacionEnvio ie);
    
    public Integer crearInformacionFactura(InformacionFactura infFac);
    
    public void modificarProductos(List<Producto> productos, Orden orden);
}
