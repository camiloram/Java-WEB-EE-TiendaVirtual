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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.AdministracionOrdenLocal;
import logica.AdministracionPersistenciaJPALocal;
import logica.AdministracionPersistenciaLocal;

/**
 *
 * @author Estudiante
 */
public class ClienteEJB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    AdministracionPersistenciaLocal administracionPersistencia;
    @EJB
    AdministracionOrdenLocal administracionOrden;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteEJB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteEJB at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            /*Producto producto = administracionPersistencia.consultarProducto(1);
            administracionOrden.adicionarProducto(producto);
            producto = new Producto();
            producto = administracionPersistencia.consultarProducto(2);
            administracionOrden.adicionarProducto(producto);

            Comprador comprador = new Comprador();
            comprador.setLogin("maria");
            administracionOrden.adicionarComprador(comprador);

            InformacionEnvio informacionEnvio = new InformacionEnvio();
            informacionEnvio.setCiudad("BOGOTA");
            informacionEnvio.setDepartamento("CUNDINAMARCA");
            informacionEnvio.setPais("COLOMBIA");
            informacionEnvio.setDireccion("CR50 N30-22");
            administracionOrden.adicionarInformacionEnvio(informacionEnvio);

            InformacionFactura informacionFactura = new InformacionFactura();
            informacionFactura.setCodigoTarjeta("0001");
            informacionFactura.setFechaExpiracion(new Date());
            informacionFactura.setNumeroTarjeta("123456789");
            administracionOrden.adicionarInformacionFactura(informacionFactura);

            administracionOrden.crearOrdenCompra();*/
            
            Producto producto = administracionPersistencia.consultarProducto(1);
            administracionOrden.adicionarProducto(producto);
            producto = new Producto();
            producto = administracionPersistencia.consultarProducto(2);
            administracionOrden.adicionarProducto(producto);

            Comprador comprador = administracionPersistencia.consultarComprador("maria");
            administracionOrden.adicionarComprador(comprador);

            InformacionEnvio informacionEnvio = new InformacionEnvio();
            informacionEnvio.setCiudad("BOGOTA");
            informacionEnvio.setDepartamento("CUNDINAMARCA");
            informacionEnvio.setPais("COLOMBIA");
            informacionEnvio.setDireccion("CR50 N30-22");
            administracionOrden.adicionarInformacionEnvio(informacionEnvio);

            InformacionFactura informacionFactura = new InformacionFactura();
            informacionFactura.setCodigoTarjeta("0001");
            informacionFactura.setFechaExpiracion(new Date());
            informacionFactura.setNumeroTarjeta("123456789");
            administracionOrden.adicionarInformacionFactura(informacionFactura);

            try {
                administracionOrden.crearOrdenCompra();
            } catch (CreacionOrdenException ex) {
                System.out.println("Ocurrió un error al crear la orden de compra.");
            } catch (ModificacionProductoException ex) {
                System.out.println("Ocurrió un error al modificar los productos de la orden de compra.");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
