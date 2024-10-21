package Modelo;


import java.util.List;
import java.util.Objects;


public class MenuDiario {
    private int codMenu;
    private int dia;
    private List<RenglonDeMenu> comidas;
    private boolean baja;
    private int caloriasDelMenu;
    private String tipo;

    public MenuDiario(int codMenu, int dia, List<RenglonDeMenu> comidas, boolean baja, int caloriasDelMenu, String tipo) {
        this.codMenu = codMenu;
        this.dia = dia;
        this.comidas = comidas;
        this.baja = baja;
        this.caloriasDelMenu = caloriasDelMenu;
        this.tipo = tipo;
    }

    public MenuDiario(int dia, List<RenglonDeMenu> comidas, boolean baja, int caloriasDelMenu, String tipo) {
        this.dia = dia;
        this.comidas = comidas;
        this.baja = baja;
        this.caloriasDelMenu = caloriasDelMenu;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codMenu;
        hash = 89 * hash + this.dia;
        hash = 89 * hash + Objects.hashCode(this.comidas);
        hash = 89 * hash + (this.baja ? 1 : 0);
        hash = 89 * hash + this.caloriasDelMenu;
        hash = 89 * hash + Objects.hashCode(this.tipo);
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
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.comidas, other.comidas);
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
