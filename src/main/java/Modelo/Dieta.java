package Modelo;


import java.time.LocalDate;
import java.util.List;


public class Dieta {
    private int codDieta;
    private String nombre;
    private List<MenuDiario> Menus;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private float pesoInicial;
    private float pesoFinal;
    private Boolean baja;
    private int TotalCalorias;
    private Paciente paciente;

    public Dieta(int codDieta, String nombre, List<MenuDiario> Menus, LocalDate fechaInicio, LocalDate fechaFinal, float pesoInicial, float pesoFinal, Boolean baja, int TotalCalorias, Paciente paciente) {
        this.codDieta = codDieta;
        this.nombre = nombre;
        this.Menus = Menus;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.baja = baja;
        this.TotalCalorias = TotalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombre, List<MenuDiario> Menus, LocalDate fechaInicio, LocalDate fechaFinal, float pesoInicial, float pesoFinal, Boolean baja, int TotalCalorias, Paciente paciente) {
        this.nombre = nombre;
        this.Menus = Menus;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
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

    public List<MenuDiario> getMenus() {
        return Menus;
    }

    public void setMenus(List<MenuDiario> Menus) {
        this.Menus = Menus;
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
    
    
    
    public void cargarPesoyFinalizar(float peso){
        
    }
    
    public void imprimirDieta(){
        
    }    
}
    