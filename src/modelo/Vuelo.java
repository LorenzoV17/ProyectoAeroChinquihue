public class Vuelo {
    private String Destino;
    private double PrecioP;
    private double PrecioE;
    private Avion AvionAsig;

    public Vuelo(String Destino, double PrecioP, double PrecioE, Avion AvionAsig) {
        this.Destino = Destino;
        this.PrecioP = PrecioP;
        this.PrecioE = PrecioE;
        this.AvionAsig = AvionAsig;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public double getPrecioP() {
        return PrecioP;
    }

    public void setPrecioP(double PrecioP) {
        this.PrecioP = PrecioP;
    }

    public double getPrecioE() {
        return PrecioE;
    }

    public void setPrecioE(double PrecioE) {
        this.PrecioE = PrecioE;
    }

    public Avion getAvionAsig() {
        return AvionAsig;
    }

    public void setAvionAsig(Avion AvionAsig) {
        this.AvionAsig = AvionAsig;
    }
}
