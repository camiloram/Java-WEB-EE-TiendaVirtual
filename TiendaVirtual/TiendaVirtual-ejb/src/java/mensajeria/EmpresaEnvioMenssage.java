/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import entidades.Orden;
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
    //@ActivationConfigProperty(propertyName="messageSelector", propertyValue = "Fragile is TRUE")
})
public class EmpresaEnvioMenssage implements MessageListener {
    
    public EmpresaEnvioMenssage() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage) message;
            Orden orden = (Orden) objectMessage.getObject();
            System.out.println("Empresa de envío: se ha recibido la notificacion para " +
                    "que los productos sean enviados a la dirección " +
                    orden.getInformacionEnvio().getDireccion());
        }catch(JMSException ex){
            System.out.println("Error EmpresaEnvioMessage: " + ex);
        }
    }
    
}
