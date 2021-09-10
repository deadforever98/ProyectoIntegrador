
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
                
        
        String urlpath="D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\";
        
        ImageIcon p=new ImageIcon(urlpath+"ladPandereta.jpg");
        String[] ladrillos=lista();
        if(opcion == ladrillos[1]){
            p=new ImageIcon(urlpath+"ladPandereta.jpg");
        }else if(opcion == ladrillos[2]){
            p=new ImageIcon(urlpath+"ladTabicon.png");
        }
        
        Image imgg=p.getImage().getScaledInstance(
                ancho, 
                alto, 
                Image.SCALE_SMOOTH);
        p = new ImageIcon(imgg,p.getDescription());
        
        return p;
    }

    @Override
    public ImageIcon getImageResponsive(double alto, double ancho,int opcion) {
        
        //medida metro ancho y alto maximo:10
        final double ANCHOMAX=310;
        final double ALTOMAX=155;
        double anchoCalc=ancho*34;
        double altoCalc=alto*17;
        
        if(anchoCalc>ANCHOMAX){
            ancho=ANCHOMAX;
        }else{
            ancho=anchoCalc;
        }
        if(altoCalc>ALTOMAX){
            alto=ALTOMAX;         
        }else{
            alto=altoCalc;
        }
        
        String urlpath="D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\";
        
        ImageIcon p=new ImageIcon(urlpath+"pared_soga.jpg");
        
        String imagen;
        if(opcion==1){
            p=new ImageIcon(urlpath+"pared_soga.jpg");
        }else{
            p=new ImageIcon(urlpath+"pared_cabeza.png");
        }
        Image imgg=p.getImage().getScaledInstance(
                (int) ancho, 
                (int) alto, 
                Image.SCALE_SMOOTH);
        p = new ImageIcon(imgg,p.getDescription());
        return p;
        
    }

    @Override
    public boolean validarCampos(String alto, String ancho,String espesor) {
        
        boolean ans=true;
        if(alto==null || alto.isEmpty() || alto.trim().isEmpty() || 
           ancho==null || ancho.isEmpty() || ancho.trim().isEmpty())
        {
            ans=false;
        }else{
            try{
               int altonum=Integer.parseInt(alto);
               int largonum=Integer.parseInt(ancho);
               
               double altodob=Double.parseDouble(alto);
               double largodob=Double.parseDouble(ancho);
               
            } catch (Exception e) {
               ans=false; 
            }
        }
        return ans;
        
    }
    
    
    
}
