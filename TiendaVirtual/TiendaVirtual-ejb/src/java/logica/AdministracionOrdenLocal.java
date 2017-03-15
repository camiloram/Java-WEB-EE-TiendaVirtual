/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Producto;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author Estudiante
 */
@Local
public interface AdministracionOrdenLocal {

    public void adicionarComprador(Comprador comprador);
    public void adicionarInformacionFactura(InformacionFactura informacionFactura);
    public void adicionarInformacionEnvio(InformacionEnvio informacionEnvio);
    public Integer crearOrdenCompra();
    public void cancelarOrdenCompra();
    public void adicionarProducto(Producto producto);
    public Comprador getComprador();
    public List ConsultarCarroCompras();
    
}
