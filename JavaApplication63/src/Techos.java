
import java.util.ArrayList;


public class Techos extends Ladrillo{
private double espesor;
    public Techos(int marca,double espesor) {
        super(marca);
        this.espesor=espesor;
        
    }
    
    public Techos(){
        
    }

    
    
    @Override
    public String marcaLadrillo() {
        String A[] = { "","hueco 20", "hueco 15","hueco 12","hueco 8"};
        return A[getMarca()];
    }
    
   
    @Override
    public Double dimensionLadrilloAlto() {
        double A[] = {0,0.20,0.15,0.12,0.08};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloLargo() {
       double A[] = {0,0.3,0.3,0.3,0.3};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloAncho() {
        double A[] = {0,0.3,0.3,0.3,0.3};
        return A[getMarca()];
    }
    
    @Override
    public  double ladrillosxMetroCuadradoSinDesperdicio(){
        return (1/((this.dimensionLadrilloAncho()+0.1)*this.dimensionLadrilloLargo()));
    }
    @Override
    public  double ladrillosxMetroCuadradoConDesperdicio(){
        return (1.05*this.ladrillosxMetroCuadradoSinDesperdicio());
    }

    public double getEspesor() {
        return espesor;
    }

    public void setEspesor(double espesor) {
        this.espesor = espesor;
    }
    //calculo de volumen concreto por m2 de techo->m3/m2
    public double calculoConcreto(){
         return (1*(this.getEspesor()+this.dimensionLadrilloAlto())-(this.ladrillosxMetroCuadradoSinDesperdicio()*this.volumenLadrillo()));
    }

    @Override
    public double calculovolumenMorteroyConcreto() {
       return (1*this.getEspesor()-(this.ladrillosxMetroCuadradoSinDesperdicio()*this.volumenLadrillo()));
    }

    @Override
    public double calculobolsascemento() {
        return 8.5*this.calculovolumenMorteroyConcreto();
    }

    @Override
    public double calculoArenaGruesa() {
        return 0.6*this.calculovolumenMorteroyConcreto();
    }
    
    public double calculoPiedraChancada(){
        return 0.6*this.calculovolumenMorteroyConcreto();
    }
}
