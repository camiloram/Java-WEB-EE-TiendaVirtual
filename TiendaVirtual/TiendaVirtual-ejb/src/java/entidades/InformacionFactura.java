/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
public class InformacionFactura {
    @Id
    private String id;
    private String numeroTarjeta;
    private String codigoTarjeta;
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;
}
