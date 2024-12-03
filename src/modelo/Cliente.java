public class Cliente {
    private String Nombre;
    private int numV;
    private boolean esClienteF;

    public Cliente(String Nombre, int numV) {
        this.Nombre = Nombre;
        this.numV = numV;
        this.esClienteF = numV > 10; //Este apartado determina si es cliente frecuente.
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public boolean isEsClienteF() {
        return esClienteF;
    }

    public void setEsClienteF(boolean esClienteF) {
        this.esClienteF = esClienteF;
    }
}
