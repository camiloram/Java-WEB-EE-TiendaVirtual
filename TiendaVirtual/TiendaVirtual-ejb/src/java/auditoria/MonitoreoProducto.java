/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import entidades.Producto;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

/**
 *
 * @author Estudiante
 */
public class MonitoreoProducto {
    
    @PreUpdate
    public void preActualizacionProducto(Producto producto){
        System.out.println("El producto " + producto.getId() + 
            " va a ser agregado a la orden de compra " + producto.getOrden().getId());
    }
    
    @PostUpdate
    public void postActualizacionProducto(Producto producto){
        System.out.println("El producto " + producto.getId() + 
            " fue asignado a la orden de compra " + producto.getOrden().getId());
    }
}
