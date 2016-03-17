/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
//import piscifactoria.casilla;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Fernando
 */
public class mar {
    public int dimX;
    public int dimY;
    public int numNiv;
    public ArrayList vNiveles = new ArrayList <nivel>();
    public ArrayList vContadores = new ArrayList <Integer>();
    
    
   // public nivel [] vectorNiveles=new nivel[numNiv];
    
   public mar(int numNiv, int tamX, int tamY,int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT,int duracionEscenario, int tamChrono){
            this(numNiv,tamX,tamY);
             creaContadores(maxBug,lifeSpanT,lifeSpanP,breedT,breedP,feedT,porcentajeT,duracionEscenario,tamChrono);
   
   }
   public mar(int numNiv, int tamX, int tamY){
        this.numNiv=numNiv;
        this.dimX=tamX;
        this.dimY=tamY;
        creaNiveles();
       
   }
   
   public void creaContadores(int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT,int duracionEscenario,int tamChrono){
        this.vContadores.add(maxBug);//pos 0
        this.vContadores.add(lifeSpanT);//pos 1
        this.vContadores.add (lifeSpanP);//pos 2
        this.vContadores.add(breedT);//pos 3
        this.vContadores.add(breedP);//pos 4
        this.vContadores.add(feedT);//pos 5
        this.vContadores.add(porcentajeT);//pos 6
        this.vContadores.add(0);//pos 7 tiburones vivos
        this.vContadores.add(0);//pos 8 peces vivos
        this.vContadores.add(duracionEscenario);//pos 9 duracion Escenario
        this.vContadores.add(tamChrono);//pos 10 espera del refresco en segundos
        
        
   }
   public void actualizaContadores(){
       nivel cursor;
        int numTiburonesTodosNiveles,numPecesTodosNiveles;
        numTiburonesTodosNiveles=0;
        numPecesTodosNiveles=0;
         for (int i = 0; i < this.numNiv; i++) {//recorro los niveles
                 cursor=(nivel) this.vNiveles.get(i);
//                 nivelAct.mueveTiburonesEnNivel();
                 numTiburonesTodosNiveles=numTiburonesTodosNiveles + cursor.numTiburones;//sumamos los tiburones en cada nivel
                 numPecesTodosNiveles=numPecesTodosNiveles+cursor.numPeces;//sumamos los peces en cada nivel
                 this.vContadores.add(7,numTiburonesTodosNiveles);
                 this.vContadores.add(8,numPecesTodosNiveles);
                 
        }
        
   }
   public String[] pintaMarcador(){
       int resto,multiplicador,basePeces,baseTiburones,peces,tiburones,tasaDiv;
            String [] contadorPintado =new String [5];
            contadorPintado[0]="maximo Numero de animales: " + (int)this.vContadores.get(0);
            contadorPintado[0]=contadorPintado[0]+"####Relacion peces Tiburones: ";
             
            if ((int)this.vContadores.get(6) >= 101) {//en caso de que el numero de tiburones sea mas del doble que peces
//                resto=(int)this.vContadores.get(6)%100;//por debajo de 100
//                multiplicador=(int)this.vContadores.get(6)/100;//multiplos de 100
//                basePeces=100-resto;//si fuera porcentajes de 100 %
//                baseTiburones=basePeces*multiplicador;//multiplicamos los tiburones respecto a la tasa dada
//                tasaDiv=Mcd(basePeces,baseTiburones);//hallamos el minimo comun divisor para reducir la fraccion basePeces/baseTiburones
//                //contadorPintado[0]= " "+ Arrays.toString(contadorPintado)+ 100-resto+"/";
//                peces=basePeces/tasaDiv;//reducimos el denominador peces
//                tiburones=baseTiburones/tasaDiv;//reducimos el denominador Tiburones
                contadorPintado[0]= contadorPintado[0] + dameNumPeces() +"/"+dameNumTiburones(); 
            }else
                contadorPintado[0]= contadorPintado[0] + (100-(int)this.vContadores.get(6)) + "/"+(int)this.vContadores.get(6);
            contadorPintado[1]="            Tiburones vivos: "+this.vContadores.get(7);
            contadorPintado[1]=contadorPintado[1]+"####Peces vivos: "+this.vContadores.get(8);
            contadorPintado[2]="      tiempo vida tiburones: "+this.vContadores.get(1);
            contadorPintado[2]=contadorPintado[2]+"####tiempo vida peces: "+this.vContadores.get(2);
            contadorPintado[3]="   tiempo crianza tiburones: "+this.vContadores.get(3);
            contadorPintado[3]=contadorPintado[3]+"####tiempo crianza peces: "+this.vContadores.get(4);
            contadorPintado[4]="tiempo resistencia al hambre tiburones: "+this.vContadores.get(5); 
            contadorPintado[4]=contadorPintado[4]+"####duracion del escenario: "+this.vContadores.get(9);
            
            
           
            return contadorPintado;
        }
   
   public void creaNiveles(){
       for (int i=0; i<=this.numNiv; i++){
           nivel cursor= new nivel(this.dimX,this.dimY);
           this.vNiveles.add(cursor);
            //this.vectorNiveles [i]=(nivel)cursor;
       }
       
   }
   
   public String [] pintaMar(){
        String [] marPintado = new String [this.dimY];
        //int c = 0;
        if (this.numNiv > 1) {
            marPintado[0]="demasiados niveles, beta solo un nivel";    
       }else{
           nivel cursor; 
           cursor=(nivel)this.vNiveles.get(0);
           marPintado= cursor.pintaNivel();
            //for(String cursor: this.vNiveles.iterator().hasNext())
//            for(int i=0; i<= numNiv;i++)
//            {
//
//                    cursor=(String)this.vNiveles.get(0);
//                     marPintado[i]=cursor;
//            }
//            for(String cursor: this.vectorNiveles[0].pintaNivel()){
//            c++;
//            marPintado[c]=cursor;
//        }
        }
            
   return marPintado; 
   }
   
  
   public static int Mcd(int num1, int num2) {
       //pre:
       //post: devuelve el maximo coun divisor de los dos numeros
       //se usa para simplificar fracciones
        int mcd = 0;
        int numerador,denominador;
        numerador=Math.abs(num1);
        denominador=Math.abs(num2);
        int a = Math.max(numerador, denominador);
        int b = Math.min(numerador, denominador);
        do {
            mcd = b;
            b = a%b;
            a = mcd;
        } while(b!=0);
        return mcd;
    }
   
public void pueblaMar(){
   creaPeces();
   creaTiburones(false);
   
}

public void decrementaContadorGenerico(int i){
  //post: decrementa el contador indicado por i
 //         maxBug //pos 0
//         lifeSpanT //pos 1
//        lifeSpanP //pos 2
//         breedT //pos 3
//         breedP //pos 4
//         feedT //pos 5
//         porcentajeT //pos 6
//         //pos 7 tiburones vivos
//         //pos 8 peces vivos
//         duracionEscenario //pos 9 duracion Escenario
//         tamChrono //pos 10 espera del refresco en segundos
     Integer c;
     c=(Integer)this.vContadores.get(i);
           c--;
           this.vContadores.add(i,c);
}
 
public void incrementaContadorGenerico(int i){
     //post: decrementa el contador indicado por i
//         maxBug //pos 0
//         lifeSpanT //pos 1
//        lifeSpanP //pos 2
//         breedT //pos 3
//         breedP //pos 4
//         feedT //pos 5
//         porcentajeT //pos 6
//         //pos 7 tiburones vivos
//         //pos 8 peces vivos
//         duracionEscenario //pos 9 duracion Escenario
//         tamChrono //pos 10 espera del refresco en segundos
     Integer c;
     c=(Integer)this.vContadores.get(i);
           c++;
           this.vContadores.add(i,c);
 }

 public void incrementaContadorPeces(){
     Integer c;
     c=(Integer)this.vContadores.get(7);
           c++;
           this.vContadores.add(7,c);
 }
 
public void decrementaContadorPeces(){
     Integer c;
     c=(Integer)this.vContadores.get(8);
           c--;
           this.vContadores.add(8,c);
 
 }
 public void incrementaContadorTiburones(){
     Integer c;
     c=(Integer)this.vContadores.get(7);
           c++;
           this.vContadores.add(7,c);
 }

public void decrementaContadorTiburones(){
     Integer c;
     c=(Integer)this.vContadores.get(8);
           c--;
           this.vContadores.add(8,c);
 
 }
public void pongoEnMar(casilla cas){
    nivel nivelAct;
        nivelAct=(nivel) this.vNiveles.get(cas.getNivel());
        nivelAct.ponEnNivel(cas);
}
public void creaPeces(){
    
   int numPeces=dameNumPeces();
   do{
       casilla cuna=dameCasillaAleatoria();//elijo casilla aleatoria
       if (esCasillaVacia(cuna)) {//si esta vacia
           cuna.setHayPez(true);
           Pez pezActual=new Pez();//creo pez
            pezActual.nace(cuna);//le indico donde esta
            pongoEnMar(cuna);//lo pongo en el mar
           incrementaContadorPeces();
            numPeces--;
       }
      
   }while (numPeces >0);

}
public void creaTiburones(boolean test){
    //boolean test=true;
        int numTiburones=dameNumTiburones();
do{
       casilla cuna=dameCasillaAleatoria();//elijo casilla aleatoria
       if (esCasillaVacia(cuna)) {//si esta vacia
           if (test)
           System.out.print(cuna.getPosicionX()+":"+cuna.getPosicionY()+"|");
            cuna.setHayTiburon(true);
           Tiburon TibActual=new Tiburon();//creo Tiburon
            TibActual.nace(cuna);//le indico donde esta
            pongoEnMar(cuna);//lo pongo en el mar
           incrementaContadorTiburones();
            numTiburones--;
       }
      
   }while (numTiburones >0);
}
public casilla dameCasillaAleatoria(){
    double rand;
   // casilla casActual=new casilla();
    Random rnd =new Random();
      int nivelElecto,xElect,yElect;
      //(int) (rnd.nextDouble() * cantidad_números_rango + término_inicial_rango)
      rand=rnd.nextDouble();
      nivelElecto=(int)(rnd.nextDouble() * this.numNiv + 0);
      xElect=(int)(rnd.nextDouble() * this.dimX + 0);
      yElect=(int)(rnd.nextDouble() * this.dimY + 0);
     // this.vNiveles.get(nivelElecto).vNivel.get(xElect).get(yElect);
      
      nivel cursor =new nivel();
      cursor=(nivel)this.vNiveles.get(nivelElecto);
      casilla casActual=new casilla();
      casActual= (casilla)cursor.casillero1.get(yElect).get(xElect);
              
      return casActual;
}
    public boolean esCasillaVacia(casilla cas){
      return(! cas.isHayPez()) && (!cas.isHayTiburon());
    }
    
    public int dameNumTiburones(){
    //post: devuelve el numero de peces proporcional al numero de peces
        int nTiburones;
        int resto,multiplicador,basePeces,baseTiburones;
        int porT=(int)this.vContadores.get(6);
        if (porT==100) {//no hay peces
            return 1;
        }else if(porT>=101){
                resto=(int)this.vContadores.get(6)%100;//por debajo de 100
                multiplicador=(int)this.vContadores.get(6)/100;//multiplos de 100
                basePeces=100-resto;//si fuera porcentajes de 100 %
                baseTiburones=basePeces*multiplicador;//multiplicamos los tiburones respecto a la tasa dada
                return baseTiburones/Mcd(basePeces,baseTiburones);
        }else{
            nTiburones=porT/Mcd(porT,100-porT);
            return nTiburones;
                    
                }
    }
    public int dameNumPeces(){
    //numero de peces proporcional a 1 tiburon
        int nPeces;
        int porcentajeT=(int)this.vContadores.get(6);
        if (porcentajeT==100) {//100% tiburones no hay peces
            return 0;
        }else if(porcentajeT ==0){//no hay tiburones
            return 1;
        }
        else if (porcentajeT>=101)
        {//el doble de tiburones que de peces
        return 1;
        }else//porcentaje entre 1 y 99%
            //si 98% tiburones devuelvo 1 pez y serian 49 tiburones
            //si 2% tiburones devuelvo 49 peces y seria un solo tiburon
            
                   nPeces=(100-porcentajeT)/ Mcd(porcentajeT,100-porcentajeT); 
        return nPeces;
   
    }   
    
    public void resuelveEscenario() throws InterruptedException{
            decrementaContadorGenerico(9);//reduzco la duracion del escenario en uno
            quitaMarcaActualizado();
            //resuelveCaza()
            mueveTiburones();
            //muevePeces()
            actualizaContadores();
            
    }
    
    public void mueveTiburones(){
   //pre:
   //post: 
        nivel nivelAct;
//        int numTiburonesTodosNiveles,numPecesTodosNiveles;
//        numTiburonesTodosNiveles=0;
        for (int i = 0; i < this.numNiv; i++) {//recorro los niveles
                 nivelAct=(nivel) this.vNiveles.get(i);
                 nivelAct.mueveTiburonesEnNivel();
//                 numTiburonesTodosNiveles=numTiburonesTodosNiveles + nivelAct.numTiburones;//sumamos los tiburones en cada nivel
        }
        
    }
    public void quitaMarcaActualizado(){
    //pre:
   //post:pone todas las casilla del mar a no actualizado
         nivel nivelAct;
        for (int i = 0; i < this.numNiv; i++) {
                nivelAct=(nivel) this.vNiveles.get(i);
                nivelAct.quitaMarcaActualizadoEnNivel();
        }
    }
}

  

