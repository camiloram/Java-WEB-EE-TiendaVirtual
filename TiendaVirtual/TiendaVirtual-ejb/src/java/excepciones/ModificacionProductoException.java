/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author Estudiante
 */
@ApplicationException(rollback=true)
public class ModificacionProductoException extends Exception {
    
}
