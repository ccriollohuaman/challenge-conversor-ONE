package proyecto.codigo;

public class Pares {
    private String nombre;
    private double cambioMedida;
    private String pasarDe;
    private String pasarPara;

    public Pares(String nombre, double cambioMedida, String pasarDe, String pasarPara) {
        this.nombre = nombre;
        this.cambioMedida = cambioMedida;
        this.pasarDe = pasarDe;
        this.pasarPara = pasarPara;
    }

    public Pares(String nombre, String pasarDe, String pasarPara) {
        this.nombre = nombre;
        this.pasarDe = pasarDe;
        this.pasarPara = pasarPara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCambioMedida() {
        return cambioMedida;
    }

    public void setCambioMedida(double cambioMedida) {
        this.cambioMedida = cambioMedida;
    }

    public String getPasarDe() {
        return pasarDe;
    }

    public void setPasarDe(String pasarDe) {
        this.pasarDe = pasarDe;
    }

    public String getPasarPara() {
        return pasarPara;
    }

    public void setPasarPara(String pasarPara) {
        this.pasarPara = pasarPara;
    }
}
