
package beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
 
@ManagedBean
public class MenuView {
     
    private MenuModel model;
    private String vista;
    private String modulo;
 
    @PostConstruct
    public void init() {
        
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        model.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
        
    }
 
    public MenuModel getModel(){
       return model;
    }
    
    public String getModulo(){
       return modulo;
    }
     
    public String getOpenPage(){
       return "ensayos.xhtml";
    } 
    
    public void ensayos() {
        
      addMessage("Success", "Data ensayos");
      
      this.vista = "ensayos.xhtml"; 
      
    }
     
    public void uno() {
      addMessage("uno", "Data uno");
    }
     
    public void dos() {
      addMessage("dos", "Data dos");
    }
    
    public void tres() {
      addMessage("tres", "Data tres");
    }
    
    public void cuatro() {
      addMessage("cuatro", "Data cuatro");
    }
    
    public void cinco() {
      addMessage("cinco", "Data cinco");
    }
    
    public void seis() {
      addMessage("seis", "Data seis");
    }
    
    public void siete() {
      addMessage("siete", "Data siete");
    }
    
    public void ocho() {
      addMessage("ocho", "Data ocho");
    }
    
    public void nueve() {
      addMessage("nueve", "Data nueve");
    }
    
    public void dies() {
      addMessage("dies", "Data dies");  
    }
    
    public void addMessage(String summary, String detail) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
      FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
