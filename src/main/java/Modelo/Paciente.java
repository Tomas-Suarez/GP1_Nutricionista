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

    public Paciente(int nroPaciente, String nombre, int dni, int edad, float altura, float pesoActual, boolean baja) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.baja = baja;
    }

    public Paciente(String nombre, int dni, int edad, float altura, float pesoActual, boolean baja) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.nroPaciente;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + this.dni;
        hash = 67 * hash + this.edad;
        hash = 67 * hash + Float.floatToIntBits(this.altura);
        hash = 67 * hash + Float.floatToIntBits(this.pesoActual);
        hash = 67 * hash + (this.baja ? 1 : 0);
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
        if (this.dni != other.dni) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (Float.floatToIntBits(this.altura) != Float.floatToIntBits(other.altura)) {
            return false;
        }
        if (Float.floatToIntBits(this.pesoActual) != Float.floatToIntBits(other.pesoActual)) {
            return false;
        }
        if (this.baja != other.baja) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Paciente{" + "nroPaciente=" + nroPaciente + ", nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", altura=" + altura + ", pesoActual=" + pesoActual + ", baja=" + baja + '}';
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
