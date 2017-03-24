/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientews;

/**
 *
 * @author Estudiante
 */
public class ClienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministracioPersistemciaJPAWS_Service service = new AdministracioPersistemciaJPAWS_Service();
        AdministracioPersistemciaJPAWS port = service.getAdministracioPersistemciaJPAWSPort();
        
        
        Orden orden = new Orden();
        Comprador comprador = port.consultarCompradores1("pedro");
        orden.setComprador(comprador);
        
        System.err.println(
            orden.getComprador()
        );
        
        
        port.crearOrden(orden);
        
        System.err.println(
            port.consultarProducto(1)
        );
        
        
    }
    
}
