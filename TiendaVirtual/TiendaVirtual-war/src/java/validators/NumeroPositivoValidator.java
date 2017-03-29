/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Estudiante
 */
@FacesValidator("numeroPositivoValidator")
public class NumeroPositivoValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            HtmlInputText htmlInputText = (HtmlInputText) component;
            if (value != null && value.toString().trim().equals("")) {
                try {
                    if(Integer.parseInt(value.toString()) > 0){
                        FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + ": no es un número positivo.");
                        throw new ValidatorException(facesMessage);
                    }
                } catch (NumberFormatException numberFormatException) {
                    FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + ": no es un número.");
                    throw new ValidatorException(facesMessage);
                }
            }
        }
    }