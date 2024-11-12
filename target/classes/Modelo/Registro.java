
package Modelo;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idRegistro;
        hash = 79 * hash + Objects.hashCode(this.dieta);
        hash = 79 * hash + Float.floatToIntBits(this.peso);
        hash = 79 * hash + Objects.hashCode(this.FechaRegistro);
        hash = 79 * hash + Objects.hashCode(this.detalle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registro other = (Registro) obj;
        if (this.idRegistro != other.idRegistro) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        if (!Objects.equals(this.dieta, other.dieta)) {
            return false;
        }
        return Objects.equals(this.FechaRegistro, other.FechaRegistro);
    }

    @Override
    public String toString() {
        return ""+FechaRegistro;
    }
    
    
    
}
