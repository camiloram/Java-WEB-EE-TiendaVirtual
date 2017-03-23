/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import entidades.Orden;
import entidades.Producto;
import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Estudiante
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/CreacionOrdenTopic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/CreacionOrdenTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/CreacionOrdenTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class EmpresaFabricanteMessage implements MessageListener {
    
    public EmpresaFabricanteMessage() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage) message;
            Orden orden = (Orden) objectMessage.getObject();
            List<Producto> productos = orden.getProductos();
            String nombreProductos = "";
            Boolean bandera = false;
            for (Producto producto : productos) {
                if (!bandera)
                    nombreProductos = nombreProductos + producto.getDescripcion();
                else
                    nombreProductos = nombreProductos + ", " + producto.getDescripcion();
                bandera = true;
            }
            System.out.println("Empresa de fábrica: se ha recibido la notificacion de " +
                    "venta de los productos: " + nombreProductos);
        }catch(JMSException ex){
            System.out.println("Error EmpresaEnvioMessage: " + ex);
        }
    }
    
}
