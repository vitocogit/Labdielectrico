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
public class TipoEpp implements java.io.Serializable {
    
  private Integer id_tipo_epp;
  private String descripcion_corta;
  private String descripcion_completa;
  private String marca;
  private String largo_tipo;
  private Integer clase;
  private Integer claseTensionClases;
  private String claseTensionEnsayo;

    public TipoEpp(Integer id_tipo_epp, String descripcion_corta, String descripcion_completa, String marca, String largo_tipo, Integer clase, Integer claseTensionClases, String claseTensionEnsayo) {
        this.id_tipo_epp = id_tipo_epp;
        this.descripcion_corta = descripcion_corta;
        this.descripcion_completa = descripcion_completa;
        this.marca = marca;
        this.largo_tipo = largo_tipo;
        this.clase = clase;
        this.claseTensionClases = claseTensionClases;
        this.claseTensionEnsayo = claseTensionEnsayo;
    }

    

    public TipoEpp() {
    }

    public Integer getId_tipo_epp() {
        return id_tipo_epp;
    }

    public void setId_tipo_epp(Integer id_tipo_epp) {
        this.id_tipo_epp = id_tipo_epp;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getDescripcion_completa() {
        return descripcion_completa;
    }

    public void setDescripcion_completa(String descripcion_completa) {
        this.descripcion_completa = descripcion_completa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLargo_tipo() {
        return largo_tipo;
    }

    public void setLargo_tipo(String largo_tipo) {
        this.largo_tipo = largo_tipo;
    }

    public Integer getClase() {
        return clase;
    }

    public void setClase(Integer clase) {
        this.clase = clase;
    }

    public Integer getClaseTensionClases() {
        return claseTensionClases;
    }

    public void setClaseTensionClases(Integer claseTensionClases) {
        this.claseTensionClases = claseTensionClases;
    }

    public String getClaseTensionEnsayo() {
        return claseTensionEnsayo;
    }

    public void setClaseTensionEnsayo(String claseTensionEnsayo) {
        this.claseTensionEnsayo = claseTensionEnsayo;
    }
  
    
  
    
}
