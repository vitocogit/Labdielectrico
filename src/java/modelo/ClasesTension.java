/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pgcardenasg
 */
public class ClasesTension implements java.io.Serializable {
    
  private Integer id_clase_tension;
  private Integer clases;
  private String tension_ensayo;

    public ClasesTension(Integer id_clase_tension, Integer clases, String tension_ensayo) {
        this.id_clase_tension = id_clase_tension;
        this.clases = clases;
        this.tension_ensayo = tension_ensayo;
    }

    public ClasesTension() {
    }

    public Integer getId_clase_tension() {
        return id_clase_tension;
    }

    public void setId_clase_tension(Integer id_clase_tension) {
        this.id_clase_tension = id_clase_tension;
    }

    public Integer getClases() {
        return clases;
    }

    public void setClases(Integer clases) {
        this.clases = clases;
    }

    public String getTension_ensayo() {
        return tension_ensayo;
    }

    public void setTension_ensayo(String tension_ensayo) {
        this.tension_ensayo = tension_ensayo;
    }
  
  
          
    
}
