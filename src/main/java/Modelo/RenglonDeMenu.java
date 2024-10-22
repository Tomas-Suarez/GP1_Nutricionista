package Modelo;

public class RenglonDeMenu {

    private int codRenglon;
    private double cantidadGrs;
    private int subTotalCalorias;
    private Alimento alimento;
    private MenuDiario menu;

    public RenglonDeMenu(int codRenglon, double cantidadGrs, int subTotalCalorias, Alimento alimento, MenuDiario menu) {
        this.codRenglon = codRenglon;
        this.cantidadGrs = cantidadGrs;
        this.subTotalCalorias = subTotalCalorias;
        this.alimento = alimento;
        this.menu = menu;
    }

    public RenglonDeMenu(double cantidadGrs, int subTotalCalorias, Alimento alimento) {
        this.cantidadGrs = cantidadGrs;
        this.subTotalCalorias = subTotalCalorias;
        this.alimento = alimento;
    }

    public RenglonDeMenu() {
    }

    public int getCodRenglon() {
        return codRenglon;
    }

    public void setCodRenglon(int codRenglon) {
        this.codRenglon = codRenglon;
    }

    public double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(double cantidadGrs) {
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

    public void modificarRenglon() {

    }

    public void imprimirRenglon() {

    }

    public void addAlimento(Alimento alimento) {

    }

}
