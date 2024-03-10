package com.example.demo9;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator(value = "isbnValidator")
public class IsBnValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
            String value=o.toString();
            pattern=Pattern.compile("(?=[-0-9xX]{13}$)");
            matcher=pattern.matcher(value);
            if(!matcher.find()){
                String message = MessageFormat.format("{0} is not a valide isbn",value);
                FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "le contenu doit etre compose de 13 caractere de 0 a 9 zvec des - et x");
                throw new ValidatorException(facesMessage);
            }

    }
}
