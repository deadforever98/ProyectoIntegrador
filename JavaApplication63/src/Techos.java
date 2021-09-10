
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Techos extends Ladrillo{
private double espesor;
    public Techos(int marca,double espesor) {
        super(marca);
        this.espesor=espesor;
        
    }
    
    public Techos(){
        
    }

    public String[] lista() {
        String A[] = { "","hueco 20", "hueco 15","hueco 12","hueco 8"};
        return A;
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

    @Override
    public ImageIcon getImageLadrillo(String opcion) {
        
        final int ancho=170;
        final int alto=140;
                
        
        String urlpath="D:\\curso integrador\\proyecto\\ProyectoIntegrador\\JavaApplication63\\src\\imagenes\\";
        
        ImageIcon p=new ImageIcon(urlpath+"lad20huecos.png");
        String[] ladrillos=lista();
        if(opcion == ladrillos[1]){
            p=new ImageIcon(urlpath+"lad20huecos.png");
        }else if(opcion == ladrillos[2]){
            p=new ImageIcon(urlpath+"lad15Huecos.jpg");
        }else if(opcion == ladrillos[3]){
            p=new ImageIcon(urlpath+"lad12Huecos.jpg");
        }else if(opcion == ladrillos[4]){
            p=new ImageIcon(urlpath+"lad8Huecos.jpg");
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
        
        ImageIcon p=new ImageIcon(urlpath+"techo.png");
        
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
           ancho==null || ancho.isEmpty() || ancho.trim().isEmpty() ||
           espesor==null || espesor.isEmpty() || espesor.trim().isEmpty())
        {
            ans=false;
        }else{
            try{
               int altonum=Integer.parseInt(alto);
               int largonum=Integer.parseInt(ancho);
               int espesornum=Integer.parseInt(espesor);
               
               double altodob=Double.parseDouble(alto);
               double largodob=Double.parseDouble(ancho);
               double espesoredob=Double.parseDouble(espesor);
               
            } catch (Exception e) {
               ans=false; 
            }
        }
        return ans;
        
    }
}
