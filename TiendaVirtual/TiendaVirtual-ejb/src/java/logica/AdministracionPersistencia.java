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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    @Resource(lookup = "jdbc/tiendaVirtualDB")
    DataSource ds;
    
    @Override
    public Producto consultarProducto(int idProducto) {
        Producto producto = null;
        try {
            String sql = "SELECT ID, NOMBRE FROM PRODUCTO WHERE ID = " + idProducto;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //si la consulta produce resultados se crea objeto producto
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("ID"));
                producto.setNombre(rs.getString("NOMBRE"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return producto;

    }

    @Override
    public Integer crearOrden(Orden orden) {
        Integer idOrden = null;
        try {
            //inserta registro en la tabla ORDEN
            String sql = "INSERT INTO ORDEN (FECHA, ID_INF_ENVIO, ID_INF_FACTURA, ID_COMPRADOR) "
                    + "VALUES(CURRENT_TIMESTAMP, " + orden.getInformacionEnvio().getId()
                    + ", " + orden.getInformacionFactura().getId()
                    + ", '" + orden.getComprador().getLogin() + "')";
            Statement st = connection.createStatement();
            st.executeUpdate(sql);

            //se consulta el ID del registro insertado
            sql = "SELECT MAX(ID) AS ID FROM ORDEN";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idOrden = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("Error crearOrden " + ex.toString());
        }
        return idOrden;
    }

    @Override
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        Integer idInformacionEnvio = null;
        try {
            //inserta registro en la tabla INFORMACION_ENVIO
            String sql = "INSERT INTO INFORMACION_ENVIO (DIRECCION, CIUDAD, PAIS, DEPARTAMENTO) "
                    + "VALUES ('" + ie.getDireccion() + "', '" + ie.getCiudad() + "', "
                    + "'" + ie.getPais() + "', '" + ie.getDepartamento() + "')";
            Statement st = connection.createStatement();
            st.executeUpdate(sql);

            //se consulta el ID del registro insertado
            sql = "SELECT MAX(ID) AS ID FROM INFORMACION_ENVIO";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idInformacionEnvio = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("Error crearInformacionEnvio " + ex.toString());
        }
        return idInformacionEnvio;
    }

    @Override
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        Integer idInformacionFactura = null;
        try {
            //inserta registro en la tabla INFORMACION_FACTURA
            String sql = "INSERT INTO INFORMACION_FACTURA " +
                    "(CODIGO_TARJETA, NUMERO_TARJETA, FECHA_EXPIRACION) "
                    + "VALUES ('" + infFac.getCodigoTarjeta() + "', '" + infFac.getNumeroTarjeta() + "', "
                    + "CURRENT_DATE)";
            Statement st = connection.createStatement();
            st.executeUpdate(sql);

            //se consulta el ID del registro insertado
            sql = "SELECT MAX(ID) AS ID FROM INFORMACION_FACTURA";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idInformacionFactura = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("Error crearInformacionFactura " + ex.toString());
        }
        return idInformacionFactura;
    }

    @Override
    public void modificarProductos(List<Producto> productos, Orden orden) {
        try {
            //asigna número de orden a los productos comprados
            String sql;
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                sql = "UPDATE PRODUCTO SET ID_ORDEN = " + orden.getId()
                        + " WHERE ID = " + producto.getId();
                Statement st = connection.createStatement();
                st.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            System.out.println("Error modificarProductos " + ex.toString());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PostConstruct
    private void inicializar(){
        try{
            connection = ds.getConnection();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    @PreDestroy
    private void limpiar(){
        try{
            connection.close();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

    @Override
    public Comprador consultarComprador(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> consultarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer crearBitacora(Bitacora bitacora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comprador> consultarCompradores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}