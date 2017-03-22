/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import entidades.Bitacora;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import logica.AdministracionOrdenLocal;
import logica.AdministracionPersisitenciaJPALocal;

/**
 *
 * @author Estudiante
 */
public class CreacionOrdenInterceptor {
    
    @EJB
    AdministracionPersisitenciaJPALocal administracionPersisitencia;
    
    @AroundInvoke
    public Object creacionOrden(InvocationContext ic) throws Exception {
        Object object = ic.getTarget();
        
        AdministracionOrdenLocal administracionOrdenLocal = (AdministracionOrdenLocal) object;
        
        Bitacora bitacora = new Bitacora();
        
    }
}
