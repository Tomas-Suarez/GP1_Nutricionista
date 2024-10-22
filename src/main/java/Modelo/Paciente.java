package Modelo;

import java.util.Objects;


public class Paciente {
    private int nroPaciente;
    private String nombre;
    private int edad;
    private float altura;
    private float pesoBuscado;
    private boolean baja;

    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoBuscado, boolean baja) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoBuscado = pesoBuscado;
        this.baja = baja;
    }

    public Paciente(String nombre, int edad, float altura, float pesoBuscado, boolean baja) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoBuscado = pesoBuscado;
        this.baja = baja;
    }

    public Paciente() {
    }

    

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

    public float getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(float pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
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
        hash = 53 * hash + this.nroPaciente;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + this.edad;
        hash = 53 * hash + Float.floatToIntBits(this.altura);
        hash = 53 * hash + Float.floatToIntBits(this.pesoBuscado);
        hash = 53 * hash + (this.baja ? 1 : 0);
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
        if (Float.floatToIntBits(this.pesoBuscado) != Float.floatToIntBits(other.pesoBuscado)) {
            return false;
        }
        if (this.baja != other.baja) {
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
