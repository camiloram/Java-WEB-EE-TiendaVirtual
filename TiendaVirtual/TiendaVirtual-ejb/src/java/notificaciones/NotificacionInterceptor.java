/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificaciones;

import entidades.Orden;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;

/**
 *
 * @author Estudiante
 */
public class NotificacionInterceptor {
    
    @Inject
    @JMSConnectionFactory("jms/CreacionOrdenTopicFactory")
    private JMSContext context;
    
    @Resource(name="jms/CreacionOrdenTopic")
    private Destination destination;
    
    @AroundInvoke
    public Object notificarCreacionOrden(InvocationContext ic) throws Exception{
        Object[] object = ic.getParameters();
        Orden orden = (Orden) object[0];
        
        ObjectMessage message = context.createObjectMessage();
        message.setObject(orden);
        
        JMSProducer producer = context.createProducer();
        producer.send(destination, message);
        
        return ic.proceed();
    }
}
