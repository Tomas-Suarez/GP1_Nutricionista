
package Modelo;

import java.time.LocalDate;

public class Registro {

    private int idRegistro;
    private Dieta dieta;
    private float peso;
    private LocalDate FechaRegistro;
    private String detalle;

    public Registro(int idRegistro, Dieta dieta, float peso, LocalDate FechaRegistro, String detalle) {
        this.idRegistro = idRegistro;
        this.dieta = dieta;
        this.peso = peso;
        this.FechaRegistro = FechaRegistro;
        this.detalle = detalle;
    }

    public Registro(Dieta dieta, float peso, LocalDate FechaRegistro, String detalle) {
        this.dieta = dieta;
        this.peso = peso;
        this.FechaRegistro = FechaRegistro;
        this.detalle = detalle;
    }

    public Registro() {
    }
    
    

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(LocalDate FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
}
