/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;

import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class PisciFactoria {
    //
//Se considera los siguientes puntos:
//
//      Un tablero con dimensión de 30 * 30.
//
//      La cantidad de Vegetales (V) la ingresa el Usuario.
//
//      La cantidad de Tiburones (T) la ingresa el Usuario.
//
//      La cantidad de Peces (P) la ingresa el Usuario.
//
//      Cada ciclo implica: decremento de energía si no come.
//
//      Los V aumentan en uno por cada ciclo.
//
//     Si T come P y llega a su energía máxima, entonces se multiplica.
//
//     Si P como V y llega a su energía máxima entonces se multiplica.
//
//     Si T o P llegan a su nivel de energía mínima, entonces muere.
//
//     Tanto T como P miran a su casilla próxima para comer o desplazarse.
//
//     El programa procesa al azar el ciclo de la casilla que se procesara.
    
    
    public static boolean  isNumeric(String mensaje){
        try{
            Integer.parseInt(mensaje);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
        
    }
    public static void aclara(int numLineas){
        for (int i=0; i<=numLineas;i++){
            System.out.println("");
        }
        
    }
   
    
    public static int pideDatoNumerico(String peticion,String peticionSiFallo){
         //pre: peticion es el mensaje de la primera peticion, peticion si fallo las sucesivos mensajes de peticion
         //post: pide un valor numerico hasta que se lo de el usuario, devolviendo un entero
        String mensaje; 
        java.util.Scanner sc =new Scanner(System.in);
        System.out.println(peticion);
         mensaje=sc.next();
                while ( ! isNumeric(mensaje) ) {            
            System.out.println(peticionSiFallo);
            mensaje=sc.next();
        }
        return Integer.parseInt(mensaje);
    }
    
    public static void pideEnter(String peticion){
     String mensaje; 
        java.util.Scanner sc =new Scanner(System.in);
        System.out.println(peticion);
         mensaje=sc.nextLine();
       
                while ( ! mensaje.isEmpty() ) {
                   // System.out.println(peticion);
                }
                  
    }
    
    public static boolean IntroOEsc(){
         KeyEvent e;
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
    {
    System.out.println("enter the name or number of month: ");
    int monthNumber=input.nextInt();
    }
    else if (Keyboard.getEventKey()==Keyboard.KEY_ESCAPE)
    {
        System.out.println("GoodBye");
    }
    return false;
    }
     public static int pideDatoNumericoConDefault(String peticion,String peticionSiFallo,String vDefecto,String avisoXDefect){
        //pre: peticion es el mensaje de la primera peticion, peticion si fallo las sucesivos mensajes de peticion         
        // el valor por defecto ha de ser el valor de un entero valido
         //avisoXDefect es el aviso de que se ha elegidola opcion por defecto
         //post: pide un valor numerico hasta que se lo de el usuario, devolviendo un entero
         //en caso de dar intro vacio devuelve el entero que indica el valor por defecto
         
        String mensaje; 
        java.util.Scanner sc =new Scanner(System.in);
        System.out.println(peticion);
         mensaje=sc.nextLine();
       
                while ( ! isNumeric(mensaje) ) {
                    if (mensaje.isEmpty()){
                        mensaje=vDefecto;
                        System.out.println(avisoXDefect);
                    break;
                    }
            System.out.println(peticionSiFallo);
            mensaje=sc.next();
        }
        return Integer.parseInt(mensaje);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mensaje;
        int nNiveles,tamX,tamY,maxBug,numberT,numberP,lifeSpanT,lifeSpanP,breedP,breedT,feedT,feedP;
        System.out.println("vamos a crea una piscifactoria");
        //nNiveles=pideDatoNumerico("dime el numero de Niveles","dame un numero valido de niveles");
        nNiveles=pideDatoNumericoConDefault("dime el numero de Niveles [1]","dame un numero valido de niveles","1","1 nivel elegido ...");
        //tamX=pideDatoNumerico("dime el X del nivel","dame un X valido");
        tamX=pideDatoNumericoConDefault("dime el X del nivel [33]","dame un X valido","33","33 X elegido ...");
        tamY=pideDatoNumericoConDefault("dime el Y del nivel [22]","dame un Y valido","22","22 Y elegido ...");
        maxBug=pideDatoNumericoConDefault("dime el numero maximo de Bichos[255]","dame un numero de Bichos Valido","255","255 Bichos elegido...");
        lifeSpanT=pideDatoNumericoConDefault("dime el max de tiempo de vida de los Tiburones [25]","dame un numero valido","25","25 elegido ...");
        lifeSpanP=pideDatoNumericoConDefault("dime el max de tiempo de vida de los peces [25]","dame un numero valido","25","25 elegido ...");
        breedT=pideDatoNumericoConDefault("dime cada cuanto crian los Tiburones [10]","dame un numero valido","10","10 elegido ...");
        breedP=pideDatoNumericoConDefault("dime cada cuanto crian los peces [3]","dame un numero valido","3","3 elegido ...");
        feedT=pideDatoNumericoConDefault("dime cuanto aguantan los tiburones sin comer [6]","dame un numero valido","6","6 elegido ...");
        pideEnter("dame un enter para continuar");
        System.out.println("pintando....");
        
        aclara(25);
        mar Oceano = new mar(nNiveles,tamX,tamY);
        String [] lienzo = new String [tamY+1];
     
        for (String cursor:  Oceano.pintaMar() ){
            System.out.println(cursor);
        }
        aclara(5);
            //int numNiv, int tamX, int tamY
        
//        java.util.Scanner sc =new Scanner(System.in);
//        System.out.println("dime el numero de niveles");
//        mensaje=sc.next();
//        while ( ! isNumeric(mensaje) ) {            
//            System.out.println("dame un numero valido de niveles");
//            mensaje=sc.next();
//        }
        //        while ( ! isNumeric(mensaje) ) {            
//            System.out.println("dame un numero valido de ancho");
//            mensaje=sc.next();
//        }
//        ntamX=Integer.parseInt(mensaje);
        
        
    }

  
    
}
