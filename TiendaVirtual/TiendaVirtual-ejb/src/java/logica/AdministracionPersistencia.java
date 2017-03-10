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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Estudiante
 */
@Stateless
public class AdministracionPersistencia implements AdministracionPersistenciaLocal {
    
    private Connection connection;
    @Resource(lookup = "jdbc/tiendaVirtualBD")
    DataSource ds; // inyeccion de dependencia
    
    @PostConstruct
    private void inicializar(){
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    @PreDestroy
    private void limpiar(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    @Override
    public Producto consultarProducto(int Producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer createOrden(Orden orden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarProductos(List<Producto> productos, Orden orden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
