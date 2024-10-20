package Modelo;


import java.util.List;


public class MenuDiario {
    private int codMenu;
    private int dia;
    private List<RenglonDeMenu> comidas;
    private boolean bajar;
    private int caloriasDelMenu;
    private Dieta dieta;

    public MenuDiario(int codMenu, int dia, List<RenglonDeMenu> comidas, boolean bajar, int caloriasDelMenu, Dieta dieta) {
        this.codMenu = codMenu;
        this.dia = dia;
        this.comidas = comidas;
        this.bajar = bajar;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario(int dia, List<RenglonDeMenu> comidas, boolean bajar, int caloriasDelMenu, Dieta dieta) {
        this.dia = dia;
        this.comidas = comidas;
        this.bajar = bajar;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario() {
    }

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List<RenglonDeMenu> getComidas() {
        return comidas;
    }

    public void setComidas(List<RenglonDeMenu> comidas) {
        this.comidas = comidas;
    }

    public boolean isBajar() {
        return bajar;
    }

    public void setBajar(boolean bajar) {
        this.bajar = bajar;
    }

    public int getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(int caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    
    public void alterarMenuDiaria(){
        
    }
    
   // public MenuDiario generarMenuDiario(){
        
    //}
    
    //public MenuDiario armarMenuDiaria(){
        
    //}
    
    //public MenuDiario armarMenuDiario(){
        
    //}
    
    public void addRenglon(RenglonDeMenu menu){
        
    }
}
