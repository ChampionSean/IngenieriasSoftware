/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pTitulo;

//import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import dao.LoginDao;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dragon
 */
//@Named(value = "logControlador")
//@Dependent
@ManagedBean(name = "loginControlador")
@RequestScoped
public class LoginControlador {

    private String usuario;
    private String contrasenia;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage mensaje;
    private LoginDao intermediario;

    /**
     * Creates a new instance of LogControlador
     */
    public LoginControlador() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        intermediario = new LoginDao();
    }

    public String loginEstudiante() {
        Estudiante login;
        try {
            login = intermediario.getLoginEstudiante(Integer.parseInt(usuario));
            System.out.println(login);
            if (contrasenia.equals(login.getPassword())) {
                httpServletRequest.getSession().setAttribute("sessionEstudiante", usuario);
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                faceContext.addMessage(null, mensaje);
                return "BuscarProyectoIH";
            }
        } catch (NullPointerException npe) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estudiante Inválido", null);
            faceContext.addMessage(null, mensaje);
            return "InicioEstudianteIH";
        }catch (NumberFormatException e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estudiante Inválido", null);
            faceContext.addMessage(null, mensaje);
            return "InicioEstudianteIH";
        }
        mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta", null);
        faceContext.addMessage(null, mensaje);
        return "InicioEstudianteIH";
    }

    public String loginProfesor() {
        Profesor login;
        try {
            login = intermediario.getLoginProfesor(Integer.parseInt(usuario));
            System.out.println(login);
            if (contrasenia.equals(login.getPassword())) {
                httpServletRequest.getSession().setAttribute("sessionProfesor", usuario);
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                faceContext.addMessage(null, mensaje);
                return "PublicarProyectoIH";
            }
        } catch (NullPointerException npe) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Profesor Inválido", null);
            faceContext.addMessage(null, mensaje);
            return "InicioProfesorIH";
        }catch (NumberFormatException e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Profesor Inválido", null);
            faceContext.addMessage(null, mensaje);
            return "InicioProfesorIH";
        }
        mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta", null);
        faceContext.addMessage(null, mensaje);
        return "InicioProfesorIH";
    }

    public String loginAdmin() {
        Admin login;
        try {
            login = intermediario.getLoginAdmin(Integer.parseInt(usuario));
            if (contrasenia.equals(login.getPassword())) {
                httpServletRequest.getSession().setAttribute("sessionAdmin", usuario);
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                faceContext.addMessage(null, mensaje);
                return "RegistroEstudiante";
            }
        } catch (NullPointerException npe) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Admin Inválido", null);
            System.out.println("Hola");
            faceContext.addMessage(null, mensaje);
            return "InicioAdminIH";
        }catch (NumberFormatException e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Admin Inválido", null);
            faceContext.addMessage(null, mensaje);
            return "InicioAdminIH";
        }
        mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta", null);
        faceContext.addMessage(null, mensaje);
        return "InicioAdminIH";
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
