/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import entidades.Producto;

/**
 *
 * @author Estudiante
 */
public class MonitoreoProducto {
    public void preActualizacionProducto(Producto producto) {
        System.out.println("El producto " + producto.getId() + " va a ser asignado a la orden de compra " + producto.getOrden().getId());
    }
    
    public void posActualizacionProducto(Producto producto) {
        System.out.println("El producto " + producto.getId() + " fue asignado a la orden de compra " + producto.getOrden().getId());
    }
}
