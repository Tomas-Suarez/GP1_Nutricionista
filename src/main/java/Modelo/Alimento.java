package Modelo;

import java.util.Objects;


public class Alimento {
    private int codComida;
    private String nombre;
    private String tipoComida;
    private int caloriasPor100g;
    private String detalle;
    private Boolean baja;

    public Alimento(int codComida, String nombre, String tipoComida, int caloriasPor100g, String detalle, Boolean baja) {
        this.codComida = codComida;
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }

    public Alimento(String nombre, String tipoComida, int caloriasPor100g, String detalle, Boolean baja) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }

    public Alimento() {
    }

    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int codComida) {
        this.codComida = codComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getCaloriasPor100g() {
        return caloriasPor100g;
    }

    public void setCaloriasPor100g(int caloriasPor100g) {
        this.caloriasPor100g = caloriasPor100g;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    @Override
    public String toString() {
        return "Alimento{" + "codComida=" + codComida + ", nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasPor100g=" + caloriasPor100g + ", detalle=" + detalle + ", baja=" + baja + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codComida;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.tipoComida);
        hash = 83 * hash + this.caloriasPor100g;
        hash = 83 * hash + Objects.hashCode(this.detalle);
        hash = 83 * hash + Objects.hashCode(this.baja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
    
    
    //public List<Alimento> filtrarxIngred(Alimento a){
        
    //}
    
    //public String filtrarNombre(Alimento a){
        
    //}
    
    //public int filtrarxCalorias100(Alimento a){
        
    //}
    
    public void modificarAlimento(Alimento alimento){
        
    }
    
    
}
