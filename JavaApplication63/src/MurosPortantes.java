
public class MurosPortantes extends Ladrillo {

    public MurosPortantes(int juntavertical, int juntahorizontal, int marca, int tipo) {
        super(juntavertical, juntahorizontal, marca, tipo);
    }

    public MurosPortantes() {
    }

    public String[] lista() {
        String A[] = {"","king kong 18", "king kong 30"};
        return A;
    }

    @Override
    public String marcaLadrillo() {
        String A[] = {"","king kong 18", "king kong 30"};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloAlto() {
        double A[] = {0,0.09, 0.09};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloLargo() {
        double A[] = {0,0.23, 0.24};
        return A[getMarca()];
    }

    @Override
    public Double dimensionLadrilloAncho() {
        double A[] = {0,0.125, 0.14};
        return A[getMarca()];
    }

    @Override
    public double ladrillosxMetroCuadradoSinDesperdicio() {

        return Math.round((1 / ((this.JuntaHorizontal() + this.largosegunmarcas()) * (this.JuntaVertical() + this.dimensionLadrilloAlto()))));
    }

    @Override
    public double ladrillosxMetroCuadradoConDesperdicio() {
        return Math.round((1.05 * this.ladrillosxMetroCuadradoSinDesperdicio()));

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
