package Modelo;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Dieta {
    private int codDieta;
    private String nombre;
    private List<MenuDiario> Menus;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private float pesoInicial;
    private float pesoFinal;
    private float pesoObjetivo;
    private Boolean baja;
    private int TotalCalorias;
    private Paciente paciente;

    public Dieta(int codDieta, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, float pesoInicial, float pesoFinal, float pesoObjetivo, Boolean baja, int TotalCalorias, Paciente paciente) {
        this.codDieta = codDieta;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.pesoObjetivo = pesoObjetivo;
        this.baja = baja;
        this.TotalCalorias = TotalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombre, LocalDate fechaInicio, LocalDate fechaFinal, float pesoInicial, float pesoFinal, float pesoObjetivo, Boolean baja, int TotalCalorias, Paciente paciente) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.pesoObjetivo = pesoObjetivo;
        this.baja = baja;
        this.TotalCalorias = TotalCalorias;
        this.paciente = paciente;
    }


    public Dieta() {
    }

    public int getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(int codDieta) {
        this.codDieta = codDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public float getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(float pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public int getTotalCalorias() {
        return TotalCalorias;
    }

    public void setTotalCalorias(int TotalCalorias) {
        this.TotalCalorias = TotalCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public float getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(float pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public float getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(float pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.codDieta;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.Menus);
        hash = 79 * hash + Objects.hashCode(this.fechaInicio);
        hash = 79 * hash + Objects.hashCode(this.fechaFinal);
        hash = 79 * hash + Float.floatToIntBits(this.pesoInicial);
        hash = 79 * hash + Float.floatToIntBits(this.pesoFinal);
        hash = 79 * hash + Float.floatToIntBits(this.pesoObjetivo);
        hash = 79 * hash + Objects.hashCode(this.baja);
        hash = 79 * hash + this.TotalCalorias;
        hash = 79 * hash + Objects.hashCode(this.paciente);
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
        final Dieta other = (Dieta) obj;
        if (this.codDieta != other.codDieta) {
            return false;
        }
        if (Float.floatToIntBits(this.pesoInicial) != Float.floatToIntBits(other.pesoInicial)) {
            return false;
        }
        if (Float.floatToIntBits(this.pesoFinal) != Float.floatToIntBits(other.pesoFinal)) {
            return false;
        }
        if (Float.floatToIntBits(this.pesoObjetivo) != Float.floatToIntBits(other.pesoObjetivo)) {
            return false;
        }
        if (this.TotalCalorias != other.TotalCalorias) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.Menus, other.Menus)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinal, other.fechaFinal)) {
            return false;
        }
        if (!Objects.equals(this.baja, other.baja)) {
            return false;
        }
        return Objects.equals(this.paciente, other.paciente);
    }
    
    
    
    
    public void cargarPesoyFinalizar(float peso){
        
    }
    
    public void imprimirDieta(){
        
    }    
}
    