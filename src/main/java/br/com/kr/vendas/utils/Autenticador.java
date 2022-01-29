package br.com.kr.vendas.utils;

import br.com.kr.vendas.model.Usuario;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autenticador implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext context = phaseEvent.getFacesContext();
        String page = context.getViewRoot().getViewId();

        System.out.println(page);

        if("/login.xhtml".equals(page))
            return;

        Usuario usuarioLogado = (Usuario)context.getExternalContext().getSessionMap().get("usuarioLogado");
        if(usuarioLogado != null){
            return;
        }

        NavigationHandler handler = context.getApplication().getNavigationHandler();
        handler.handleNavigation(context, null, "/login?faces-redirect=true");
        context.renderResponse();
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
