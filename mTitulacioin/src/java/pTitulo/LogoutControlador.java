/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pTitulo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dragon
 */
@ManagedBean(name = "logoutControlador")
@RequestScoped
@ViewScoped
public class LogoutControlador {

    private String usuario; 
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    /**
     * Creates a new instance of LogoutControlador
     */
    public LogoutControlador() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }
    
    public String cerrarSessionEstudiante() {
        if (httpServletRequest.getSession().getAttribute("sessionEstudiante") != null) {
            usuario = httpServletRequest.getSession().getAttribute("sessionEstudiante").toString();
        }
        httpServletRequest.getSession().removeAttribute("sessionEstudiante");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, message);
        return "InicioEstudianteIH";
    }

    public String cerrarSessionProfesor() {
        if (httpServletRequest.getSession().getAttribute("sessionProfesor") != null) {
            usuario = httpServletRequest.getSession().getAttribute("sessionProfesor").toString();
        }
        httpServletRequest.getSession().removeAttribute("sessionProfesor");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, message);
        return "InicioProfesorIH";
    }
    
    public String cerrarSessionAdmin() {
        if (httpServletRequest.getSession().getAttribute("sessionAdmin") != null) {
            usuario = httpServletRequest.getSession().getAttribute("sessionAdmin").toString();
        }
        httpServletRequest.getSession().removeAttribute("sessionAdmin");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, message);
        return "InicioAdminIH";
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
