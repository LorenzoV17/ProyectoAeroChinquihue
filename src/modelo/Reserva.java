public class Reserva {
    private Cliente Cliente;
    private Vuelo Vuelo;
    private String fechaR;
    private boolean DescuentoAp;

    public Reserva(Cliente Cliente, Vuelo Vuelo, String fechaR) {
        this.Cliente = Cliente;
        this.Vuelo = Vuelo;
        this.fechaR = fechaR;
        this.DescuentoAp = Cliente.isEsClienteF(); //aplica descuento si es cliente frecuente.
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

    public String getFechaR() {
        return fechaR;
    }

    public void setFechaR(String fechaR) {
        this.fechaR = fechaR;
    }

    public boolean isDescuentoAp() {
        return DescuentoAp;
    }
}
