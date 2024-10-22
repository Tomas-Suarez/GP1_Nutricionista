package Modelo;

import java.util.Objects;


public class Paciente {
    private int nroPaciente;
    private String nombre;
    private int dni;
    private int edad;
    private float altura;
    private float pesoActual;
    private boolean baja;



    

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.nroPaciente;
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + this.edad;
        hash = 19 * hash + Float.floatToIntBits(this.altura);
        hash = 19 * hash + (this.baja ? 1 : 0);
        hash = 19 * hash + this.dni;
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
        final Paciente other = (Paciente) obj;
        if (this.nroPaciente != other.nroPaciente) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (Float.floatToIntBits(this.altura) != Float.floatToIntBits(other.altura)) {
            return false;
        }
        if (this.baja != other.baja) {
            return false;
        }
        if (this.dni != other.dni) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }


    
    
    public void cambiarPeso(){
        
    }
    
    public void actualizarPesoAct(){
        
    }
    
    //public boolean seAcercaAlPeso(Dieta dieta){
        
        
    //}
    
    //public List<Paciente> listarLosQueLlegaron(){
        
    //}
    
}
