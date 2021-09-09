
public class diamante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a=7;
       for(int i=1;i<=a;i++){//fila
           
           for( int j=a-i;j>=1;j--){//columna
               System.out.print(" ");
           }
           for( int j=1;j<=i;j++){//columna
               System.out.print(" *");
           }
           System.out.println("");
       }
       for(int i=a-1;i>=1;i--){//fila
           for( int j=a-i;j>=1;j--){//columna
               System.out.print(" ");
           }
           for( int j=1;j<=i;j++){//columna
               System.out.print(" *");
           }
           System.out.println("");
       }
       
    }
    
}
