package Modelo;


import java.util.List;
import java.util.Objects;


public class MenuDiario {
    private int codMenu;
    private int dia;
    private List<RenglonDeMenu> comidas;
    private boolean baja;
    private int caloriasDelMenu;
    private Dieta dieta;

    public MenuDiario(int codMenu, int dia, List<RenglonDeMenu> comidas, boolean bajar, int caloriasDelMenu, Dieta dieta) {
        this.codMenu = codMenu;
        this.dia = dia;
        this.comidas = comidas;
        this.baja = bajar;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario(int dia, List<RenglonDeMenu> comidas, boolean bajar, int caloriasDelMenu, Dieta dieta) {
        this.dia = dia;
        this.comidas = comidas;
        this.baja = bajar;
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

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean bajar) {
        this.baja = bajar;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final MenuDiario other = (MenuDiario) obj;
        if (this.codMenu != other.codMenu) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.baja != other.baja) {
            return false;
        }
        if (this.caloriasDelMenu != other.caloriasDelMenu) {
            return false;
        }
        if (!Objects.equals(this.comidas, other.comidas)) {
            return false;
        }
        return Objects.equals(this.dieta, other.dieta);
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
