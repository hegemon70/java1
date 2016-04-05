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
                System.out.println("");
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
    
 
    
    public static boolean AnyKeyToCancel_EnterToContinue(String peticion){
           String mensaje;
        
        java.util.Scanner sc =new Scanner(System.in);
        System.out.println(peticion);
        mensaje=sc.nextLine();
                
         
        if (mensaje.isEmpty()) {
            return true;
        }
       
    return false;
    }
            public static void refrescaPantalla(mar Oceano,boolean test){
                aclara(2);//antes era 5
                     for (String cursor:  Oceano.pintaMarcador() ){
                        System.out.println(cursor);
                    }
                     aclara(0);//antes era 2
                    for (String cursor:  Oceano.pintaMar(test) ){
                        System.out.println(cursor);
                    }
                    aclara(2);//antes era 5
            
            }
            
            public static void muestraSupervivientes(mar Oceano,boolean test){
             aclara(1);
             if(test)System.out.println("listado de supervivientes");
                for (String cursor: Oceano.pintaSupervientes(test)) {
                    System.out.println(cursor);
                }
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
        System.out.println("");
        return Integer.parseInt(mensaje);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        String mensaje;
        int nNiveles,tamX,tamY,maxBug,numberT,numberP,lifeSpanT,lifeSpanP,breedP,breedT,feedT,feedP,porcentajeT,duracionEscenario,tamChrono;
        boolean test;
                nNiveles=1;
                tamX=33;
                tamY=22;
                maxBug=255;
                lifeSpanT=30;
                lifeSpanP=10;
                breedT=10;
                breedP=5;
                feedT=6;
                porcentajeT=50;
                duracionEscenario=28;
                tamChrono=5;
                test=false;
        System.out.println("vamos a crear una pecera");
        if (!AnyKeyToCancel_EnterToContinue("pulsa enter para valores por defecto o cualquier otra tecla para  ajustarlos manualmente")){
    
        if (!AnyKeyToCancel_EnterToContinue("pulsa enter para continuar sin testeo o cualquier otra tecla para que salgan mensajes de testeo"))
        {
            test=true;
        }
                    //nNiveles=pideDatoNumerico("dime el numero de Niveles","dame un numero valido de niveles");
                nNiveles=pideDatoNumericoConDefault("dime el numero de Niveles ["+nNiveles+"]","dame un numero valido de niveles",Integer.toString(nNiveles),Integer.toString(nNiveles)+" nivel elegido ...");
                //tamX=pideDatoNumerico("dime el X del nivel","dame un X valido");
                tamX=pideDatoNumericoConDefault("dime el X del nivel ["+tamX+"]","dame un X valido",Integer.toString(tamX),Integer.toString(tamX)+" X elegido ...");
                tamY=pideDatoNumericoConDefault("dime el Y del nivel ["+tamY+"]","dame un Y valido",Integer.toString(tamY),Integer.toString(tamY)+" Y elegido ...");
                maxBug=pideDatoNumericoConDefault("dime el numero maximo de Bichos["+maxBug+"]","dame un numero de Bichos Valido",Integer.toString(maxBug),Integer.toString(maxBug)+" Bichos elegido...");
                lifeSpanT=pideDatoNumericoConDefault("dime el max de tiempo de vida de los Tiburones ["+lifeSpanT+"]","dame un numero valido",Integer.toString(lifeSpanT),Integer.toString(lifeSpanT)+" elegido ...");
                lifeSpanP=pideDatoNumericoConDefault("dime el max de tiempo de vida de los peces ["+lifeSpanP+"]","dame un numero valido",Integer.toString(lifeSpanP),Integer.toString(lifeSpanP)+" elegido ...");
                breedT=pideDatoNumericoConDefault("dime cada cuanto crian los Tiburones ["+breedT+"]","dame un numero valido",Integer.toString(breedT),Integer.toString(breedT)+" elegido ...");
                breedP=pideDatoNumericoConDefault("dime cada cuanto crian los peces ["+breedP+"]","dame un numero valido",Integer.toString(breedP),Integer.toString(breedP)+" elegido ...");
                feedT=pideDatoNumericoConDefault("dime cuanto aguantan los tiburones sin comer ["+feedT+"]","dame un numero valido",Integer.toString(feedT),Integer.toString(feedT)+" elegido ...");
                porcentajeT=pideDatoNumericoConDefault("dime el porcentaje de tiburones respecto de peces["+porcentajeT+"]","dame un numero valido",Integer.toString(porcentajeT),Integer.toString(porcentajeT)+"% elegido");
                duracionEscenario=pideDatoNumericoConDefault("dime el tiempo de duracion del escenario["+duracionEscenario+"]","dame un numero valido",Integer.toString(duracionEscenario),Integer.toString(duracionEscenario)+" refrescos de pantalla elegido");
                tamChrono=pideDatoNumericoConDefault("dame el tiempo de refresco pantalla en segundos["+tamChrono+"]","dame un numero valido",Integer.toString(tamChrono),Integer.toString(tamChrono)+" segundos elegido");
                
        }
        
        //pideEnter("dame un enter para continuar");
        if ( AnyKeyToCancel_EnterToContinue("enter to continue or anykey to cancel")) {
            
            
             System.out.println("pintando....");

                    aclara(1);
                    mar Oceano = new mar(nNiveles,tamX,tamY,maxBug,lifeSpanT,lifeSpanP,breedT,breedP,feedT,porcentajeT,duracionEscenario,tamChrono);
                    Oceano.pueblaMar(test);
                    refrescaPantalla(Oceano,test);
                    //int numNiv, int tamX, int tamY,int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT
                  while((int)Oceano.vContadores.get(9)>0){
                       Thread.sleep(tamChrono*1000);
               
                     Oceano.resuelveEscenario(test);
                     refrescaPantalla(Oceano,test);
               
                  }
                  muestraSupervivientes(Oceano,test);
                          
        }else
            System.out.println("adios");

        
        
    }

  
    
}
