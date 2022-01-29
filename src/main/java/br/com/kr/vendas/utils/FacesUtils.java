package br.com.kr.vendas.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {

    public static void addErrorMessage(String key){
            addMessage(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
    }

    public static void addWarningMessage(String key){
        addMessage(FacesMessage.SEVERITY_WARN, getBundleValue(key));
    }

    public static void addSuccessMessage(String key){
        addMessage(FacesMessage.SEVERITY_INFO, getBundleValue(key));
    }

    public static FacesMessage addErrorMessageValidate(String key){
        return addMessageValidate(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
    }

    public static FacesMessage addWarningMessageValidate(String key){
        return addMessageValidate(FacesMessage.SEVERITY_WARN, getBundleValue(key));
    }

    public static FacesMessage addSuccessMessageValidate(String key){
        return addMessageValidate(FacesMessage.SEVERITY_INFO, getBundleValue(key));
    }

    private static void addMessage(FacesMessage.Severity severity, String msg){
        final FacesMessage facesMessage = new FacesMessage(severity, msg, "");
        facesMessage.rendered();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setRedirect(true);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    private static FacesMessage addMessageValidate(FacesMessage.Severity severity, String msg){
        final FacesMessage facesMessage = new FacesMessage(severity, msg, "");
        facesMessage.rendered();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setRedirect(true);
        return facesMessage;
    }

    private static String getBundleValue(String key){
        return FacesContext.getCurrentInstance().getApplication()
                .getResourceBundle(FacesContext.getCurrentInstance(), "m")
                .getString(key);
    }

}
