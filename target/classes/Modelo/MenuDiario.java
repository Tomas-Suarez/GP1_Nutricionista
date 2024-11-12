package Modelo;


import java.util.List;
import java.util.Objects;


public class MenuDiario {
    private int codMenu;
    private int dia;
    private List<RenglonDeMenu> comidas;
    private boolean baja;
    private int caloriasDelMenu;
    private Dieta dieta; //Para el codigo

    public MenuDiario(int codMenu, int dia, boolean baja, int caloriasDelMenu, Dieta dieta) {
        this.codMenu = codMenu;
        this.dia = dia;
        this.baja = baja;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario(int dia, boolean baja, int caloriasDelMenu, Dieta dieta) {
        this.dia = dia;
        this.baja = baja;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario() {
    }

    @Override
    public String toString() {
        return switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            default -> "Domingo";
        };
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
        int hash = 7;
        hash = 79 * hash + this.codMenu;
        hash = 79 * hash + this.dia;
        hash = 79 * hash + Objects.hashCode(this.comidas);
        hash = 79 * hash + (this.baja ? 1 : 0);
        hash = 79 * hash + this.caloriasDelMenu;
        hash = 79 * hash + Objects.hashCode(this.dieta);
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
