
import java.awt.Image;
import javax.swing.ImageIcon;


public class MurosTabiques extends Ladrillo{
    
    public MurosTabiques(){
        
    }
    public MurosTabiques(int  juntavertical, int juntahorizontal, int marca, int tipo) {
        super(juntavertical, juntahorizontal, marca, tipo);
    }
    
    public String[] lista() {
        String A[] = {"", "pandereta", "tabicón"};
        return A;
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

    @Override
    public ImageIcon getImageLadrillo(String opcion) {
        final int ancho=170;
        final int alto=140;
                
        //ImageIcon p=new ImageIcon("D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\ladKingKong13.jpg");
        ImageIcon p=new ImageIcon("D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\ladPandereta.jpg");
        String[] ladrillos=lista();
        if(opcion == ladrillos[1]){
            p=new ImageIcon("D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\ladPandereta.jpg");
        }else if(opcion == ladrillos[2]){
            p=new ImageIcon("D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\ladTabicon.png");
        }
        
        Image imgg=p.getImage().getScaledInstance(
                ancho, 
                alto, 
                Image.SCALE_SMOOTH);
        p = new ImageIcon(imgg,p.getDescription());
        
        return p;
    }

    @Override
    public ImageIcon getImageResponsive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
