
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

public abstract class Ladrillo {

    protected int juntavertical;
    protected int juntahorizontal;
    private int marca;
    private int tipo;

    public Ladrillo() {
    }

    public Ladrillo(int marca) {
        this.marca = marca;
    }
    // insertamos el indice 
    public Ladrillo(int juntavertical, int juntahorizontal, int marca, int tipo) {
        this.juntavertical = juntavertical;
        this.juntahorizontal = juntahorizontal;
        this.marca = marca;
        this.tipo = tipo;
    }

    public int getJuntavertical() {
        return juntavertical;
    }

    public void setJuntavertical(int juntavertical) {
        this.juntavertical = juntavertical;
    }

    public int getJuntahorizontal() {
        return juntahorizontal;
    }

    public void setJuntahorizontal(int juntahorizontal) {
        this.juntahorizontal = juntahorizontal;
    }

    public Double largosegunmarcas() {
        double resultado = 0;

        switch (this.segunCabezaoSoga()) {
            case "cabeza":
                resultado = this.dimensionLadrilloAncho();
                break;

            case "soga":
                resultado = this.dimensionLadrilloLargo();
                break;

        }
        return resultado;
    }

    public String segunCabezaoSoga() {
        String B[] = { "cabeza", "soga"};
        return B[tipo];
    }

    public double JuntaHorizontal() {
        double A[] = {0,0.01, 0.015};
        return A[this.getJuntahorizontal()];
    }

    public double JuntaVertical() {
        double A[] = {0,0.01, 0.015};
        return A[this.getJuntavertical()];
    }
    public double volumenLadrillo(){
        return this.dimensionLadrilloAlto()*this.dimensionLadrilloAncho()*this.dimensionLadrilloLargo();
    }
    public abstract String marcaLadrillo();

    public abstract Double dimensionLadrilloAlto();

    public abstract Double dimensionLadrilloLargo();

    public abstract Double dimensionLadrilloAncho();

//    public abstract Double largosegunmarca();
    public abstract double ladrillosxMetroCuadradoSinDesperdicio();

    public abstract double ladrillosxMetroCuadradoConDesperdicio();

    public String formatoSinDesperdicio() {
        DecimalFormat dt = new DecimalFormat("#.00");
        return dt.format(this.ladrillosxMetroCuadradoSinDesperdicio());
    }

    public String formatoConDesperdicio() {
        DecimalFormat dt = new DecimalFormat("#.00");
        return dt.format(this.ladrillosxMetroCuadradoConDesperdicio());
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    //calculo del volumen de mortero y de concreto por metro cuadrado de muro m3/m2
    public abstract double calculovolumenMorteroyConcreto();
      
    
    //calcul de volsas de cemento por metro cuadrado de muro bolsas/m2
    public  abstract double calculobolsascemento();
       
    
    //calculo de m^3 de arena gruesa por m^2 de muro
    public abstract double calculoArenaGruesa();
        
    public abstract ImageIcon getImageLadrillo(String opcion);
    public abstract ImageIcon getImageResponsive(double alto, double ancho,int opcion);
    public abstract boolean validarCampos(String alto, String ancho,String espesor);
}
