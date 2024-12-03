public class Avion {
    private String Modelo;
    private int CapacidadP;
    private double CapacidadC;

    public Avion(String Modelo, int CapacidadP, double CapacidadC) {
        this.Modelo = Modelo;
        this.CapacidadP = CapacidadP;
        this.CapacidadC = CapacidadC;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getCapacidadP() {
        return CapacidadP;
    }

    public void setCapacidadP(int CapacidadP) {
        this.CapacidadP = CapacidadP;
    }

    public double getCapacidadC() {
        return CapacidadC;
    }

    public void setCapacidadC(double CapacidadC) {
        this.CapacidadC = CapacidadC;
    }
}
