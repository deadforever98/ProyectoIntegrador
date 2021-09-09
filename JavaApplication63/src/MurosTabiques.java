
public class MurosTabiques extends Ladrillo{
    
    public MurosTabiques(){
        
    }
    public MurosTabiques(int  juntavertical, int juntahorizontal, int marca, int tipo) {
        super(juntavertical, juntahorizontal, marca, tipo);
    }
    
    
    @Override
    public String marcaLadrillo() {
        String A[] = {"", "pandereta", "tabicón"};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloAlto() {
        double A[]={0,0.09,0.08};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloLargo() {
        double A[]={0,0.23,0.25};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloAncho() {
        double A[]={0,0.11,0.15};
        return A[getMarca()];
    }


    @Override
    public double ladrillosxMetroCuadradoSinDesperdicio() {
        return  (1 / ((this.JuntaHorizontal() + this.largosegunmarcas()) * (this.JuntaVertical() + this.dimensionLadrilloAlto())));
    }

    @Override
    public double ladrillosxMetroCuadradoConDesperdicio() {
        return (1.05 * this.ladrillosxMetroCuadradoSinDesperdicio());
    }

    @Override
    public double calculovolumenMorteroyConcreto() {
        return (1*this.dimensionLadrilloAncho()-(this.ladrillosxMetroCuadradoSinDesperdicio()*this.volumenLadrillo()));
    }

    @Override
    public double calculobolsascemento() {
         return 7.5*this.calculovolumenMorteroyConcreto();
    }

    @Override
    public double calculoArenaGruesa() {
        return 1.05*this.calculovolumenMorteroyConcreto();
    }
    
    
    
}
