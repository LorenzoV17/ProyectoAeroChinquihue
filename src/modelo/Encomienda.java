public class Encomienda {
    private Cliente Cliente;
    private Vuelo Vuelo;
    private double Peso;

    public Encomienda(Cliente Cliente, Vuelo Vuelo, double Peso) {
        this.Cliente = Cliente;
        this.Vuelo = Vuelo;
        this.Peso = Peso;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Vuelo getVuelo() {
        return Vuelo;
    }

    public void setVuelo(Vuelo Vuelo) {
        this.Vuelo = Vuelo;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double calcularCosto() {
        return Peso * Vuelo.getPrecioE(); //Aqui se calcula el costo con base en el peso y precio por kg.
    }
}
