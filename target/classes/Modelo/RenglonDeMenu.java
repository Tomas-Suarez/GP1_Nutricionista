package Modelo;

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
        return Math.round(alimento.getCaloriasPor100g() / 100f * getCantidadGrs());
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
    public String toString() {
        return alimento.getNombre();
    }



    public void modificarRenglon() {

    }

    public void imprimirRenglon() {

    }

    public void addAlimento(Alimento alimento) {

    }

}
