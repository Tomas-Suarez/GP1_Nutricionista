package Modelo;

import java.util.Objects;

public class RenglonDeMenu {

    private int codRenglon;
    private float cantidadGrs;
    private int subTotalCalorias;
    private Alimento alimento;
    private MenuDiario menu;
    private String horario; //Desayuno, almuerzo, merienda, cena

    public RenglonDeMenu(int codRenglon, float cantidadGrs, int subTotalCalorias, Alimento alimento, MenuDiario menu, String horario) {
        this.codRenglon = codRenglon;
        this.cantidadGrs = cantidadGrs;
        this.subTotalCalorias = subTotalCalorias;
        this.alimento = alimento;
        this.menu = menu;
        this.horario = horario;
    }

    public RenglonDeMenu(float cantidadGrs, int subTotalCalorias, Alimento alimento, MenuDiario menu, String horario) {
        this.cantidadGrs = cantidadGrs;
        this.subTotalCalorias = subTotalCalorias;
        this.alimento = alimento;
        this.menu = menu;
        this.horario = horario;
    }


    public RenglonDeMenu() {
    }

    public int getCodRenglon() {
        return codRenglon;
    }

    public void setCodRenglon(int codRenglon) {
        this.codRenglon = codRenglon;
    }

    public float getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(float cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public int getSubTotalCalorias() {
        return subTotalCalorias;
    }

    public void setSubTotalCalorias(int subTotalCalorias) {
        this.subTotalCalorias = subTotalCalorias;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public MenuDiario getMenu() {
        return menu;
    }

    public void setMenu(MenuDiario menu) {
        this.menu = menu;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codRenglon;
        hash = 37 * hash + Float.floatToIntBits(this.cantidadGrs);
        hash = 37 * hash + this.subTotalCalorias;
        hash = 37 * hash + Objects.hashCode(this.alimento);
        hash = 37 * hash + Objects.hashCode(this.menu);
        hash = 37 * hash + Objects.hashCode(this.horario);
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
        final RenglonDeMenu other = (RenglonDeMenu) obj;
        if (this.codRenglon != other.codRenglon) {
            return false;
        }
        if (Float.floatToIntBits(this.cantidadGrs) != Float.floatToIntBits(other.cantidadGrs)) {
            return false;
        }
        if (this.subTotalCalorias != other.subTotalCalorias) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.alimento, other.alimento)) {
            return false;
        }
        return Objects.equals(this.menu, other.menu);
    }



    public void modificarRenglon() {

    }

    public void imprimirRenglon() {

    }

    public void addAlimento(Alimento alimento) {

    }

}
