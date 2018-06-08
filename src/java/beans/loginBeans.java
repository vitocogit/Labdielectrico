/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import modelo.Usuario;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Victor
 */
@ManagedBean
@SessionScoped
public class loginBeans {

    /**
     * Creates a new instance of loginBeans
     */
private static final long serialVersionUID = -2152389656664659476L;
private String email;
private String clave;
private Usuario usuario;
private boolean logeado = false;
 
    public loginBeans() {
        
    }
    
    public boolean Logeado() {
    return logeado;
    } 

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public String getClave() {
    return clave; 
    }
    
    public void setClave(String clave) {
    this.clave = clave;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }
    
    

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    

        public String login() throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;       
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        if (usuarioDao.buscarPorUsuario(usuario)) {
            logeado = true;
            FacesContext.getCurrentInstance().addMessage("menu", new FacesMessage("Bienvenido", this.getUsuario().getNombres()));
            return "index?faces-redirect=true";
        } else 
           
        {
            FacesContext.getCurrentInstance().addMessage("FormLogin", new FacesMessage("Credenciales Incorrectas"));
            logeado = false;
            //msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
            return "login?faces-redirect=false";
            }
    }

        public String logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext(); 
        final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        context.getExternalContext().redirect("/dielectrico/faces/login.xhtml");
        request.getSession(false).invalidate(); 
        logeado=false;
        return null;
  }
        
        public String paginaexpirada()
       {
        return "/login?faces-redirect=true";
       }

    
    
}

