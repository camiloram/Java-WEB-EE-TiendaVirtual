/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import entidades.Comprador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import logica.AdministracionOrdenLocal;
import logica.AdministracionPersisitenciaJPALocal;

/**
 *
 * @author Estudiante
 */
@Named(value = "ordenCompraBean")
@SessionScoped
public class OrdenCompraBean implements Serializable {

    @EJB
    AdministracionPersisitenciaJPALocal administracionPersisitencia;
    @EJB
    AdministracionOrdenLocal administracionOrden;
    
    /**
     * Creates a new instance of OrdenCompraBean
     */
    public OrdenCompraBean() {
    }
    
    public List<Comprador> getCompradores(){
        return administracionPersisitencia.consultarCompradores();
    }
    
    //public SelectItem[] getCompradores(){}
    
    public void compradoresListener(ValueChangeEvent vce){
        String login = vce.getNewValue().toString();
        if (!login.equals("-1")) {
            Comprador comprador = administracionPersisitencia.consultarCompradores(login);
            administracionOrden.adicionarComprador(comprador);
        }
    }
    
}
