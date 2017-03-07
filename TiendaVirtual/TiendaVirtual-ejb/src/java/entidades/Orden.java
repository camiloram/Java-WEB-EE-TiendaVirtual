/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class Orden {
    
    private int id;
    private Date fecha;
    private List<Productos> productos;
    private Comprador comprador;
    private InformacionFactura informacionFactura;
    private InformacionEnvio informacionEnvio;
    
}
