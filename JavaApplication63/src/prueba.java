
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        
//        int x=4;
//        boolean rpta=true;
//        while(rpta){
//            switch(x){
//            case 1, 2 -> System.out.println("Correcto");
//            case 3 -> System.out.println("Correcto2");
//            case 4, 5 -> System.out.println("Operando");        }
//            rpta=scan.nextBoolean();
//            x=scan.nextInt();
//       //para eso integrsamos solo los indices para que realicen los calculos}
        MurosPortantes t1 = new MurosPortantes(1, 1, 1, 1);
        // se ingresa el t
        Techos t2=new Techos(2,0.5);
//        System.out.println("Sin desperdicio: " +t1.ladrillosxMetroCuadradoSinDesperdicio());
//        System.out.println(t1.formatoSinDesperdicio());
//        System.out.println("Con desperdicio:"+t1.ladrillosxMetroCuadradoConDesperdicio());
//        System.out.println(t1.formatoConDesperdicio());
        System.out.println(t1.getClass().getSimpleName());
        System.out.println("junta horizontal: " + t1.JuntaHorizontal());
        System.out.println("junta vertical: " + t1.JuntaVertical());
        System.out.println("dimension ladrillo alto:" + t1.dimensionLadrilloAlto());
        System.out.println("dimension ladrillo largo: " + t1.dimensionLadrilloLargo());
        System.out.println("dimension ladrillo ancho muro" + t1.dimensionLadrilloAncho());
        System.out.println("cantidad de ladrillos por m^2 Sin desperdicio: " + t1.ladrillosxMetroCuadradoSinDesperdicio());
        System.out.println("cantidad de ladrillos por m^2 Con desperdicio: " + t1.ladrillosxMetroCuadradoConDesperdicio());
        System.out.println("volumen del ladrillo m^3:" + t1.volumenLadrillo());
        System.out.println("volumen de mortero por m^2 de muro:" + t1.calculovolumenMorteroyConcreto());
        System.out.println("bolsas de cemento por m^2 de muro:" + t1.calculobolsascemento());
        System.out.println("m^3 de arena gruesa por m^2 de muro:" + t1.calculoArenaGruesa());
        System.out.println("***********");
//        double num=8.55;
//        System.out.println(Math.round(num));
        System.out.println(t2.getClass().getSimpleName());
        System.out.println("dimension ladrillo alto:" + t2.dimensionLadrilloAlto());
        System.out.println("dimension ladrillo largo: " + t2.dimensionLadrilloLargo());
        System.out.println("dimension ladrillo ancho muro" + t2.dimensionLadrilloAncho());
        System.out.println("cantidad de ladrillos por m^2 Sin desperdicio: " + t2.ladrillosxMetroCuadradoSinDesperdicio());
        System.out.println("cantidad de ladrillos por m^2 Con desperdicio: " + t2.ladrillosxMetroCuadradoConDesperdicio());
        System.out.println("volumen del ladrillo m^3:" + t2.volumenLadrillo());
        System.out.println("volumen de concreto por m^2 de techo:" + t2.calculovolumenMorteroyConcreto());
        System.out.println("bolsas de cemento por m^2 de techo:" + t2.calculobolsascemento());
        System.out.println("m^3 de arena gruesa por m^2 de techo:" + t2.calculoArenaGruesa());
        System.out.println("m^3 de piedra chancada por m^2 de techo:"+t2.calculoPiedraChancada());
        System.out.println("***********");

    }
}
