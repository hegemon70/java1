/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
//import piscifactoria.casilla;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fernando
 */
public class mar {
    public int dimX;
    public int dimY;
    public int numNiv;
    public ArrayList <nivel> vNiveles;
    public ArrayList <Integer> vContadores; 
    public ArrayList <Pez> vPeces;
    public ArrayList <Tiburon> vTiburones; 
//    public ArrayList vPeces = new ArrayList <Pez>();
//    public ArrayList vTiburones =new ArrayList <Tiburon>();
    
    
    
   // public nivel [] vectorNiveles=new nivel[numNiv];
    
   public mar(int numNiv, int tamX, int tamY,int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT,int duracionEscenario, int tamChrono){
            this(numNiv,tamX,tamY);
           
            
            creaContadores(maxBug,lifeSpanT,lifeSpanP,breedT,breedP,feedT,porcentajeT,duracionEscenario,tamChrono);
   
   }
   public mar(int numNiv, int tamX, int tamY){
        this.numNiv=numNiv;
        this.dimX=tamX;
        this.dimY=tamY;
        this.vNiveles= new ArrayList();
        this.vContadores=new ArrayList();
        this.vPeces=new ArrayList();
        this.vTiburones=new ArrayList();
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
       //int cont;
       //ESTA PARTE CUANDO HAYA MAS NIVELES
//       nivel cursor;
//        int numTiburonesTodosNiveles,numPecesTodosNiveles;
//        numTiburonesTodosNiveles=0;
//        numPecesTodosNiveles=0;
//         for (int i = 0; i < this.numNiv; i++) {//recorro los niveles
//                 cursor=(nivel) this.vNiveles.get(i);
////                 nivelAct.mueveTiburonesEnNivel();
//                 numTiburonesTodosNiveles=numTiburonesTodosNiveles + cursor.numTiburones;//sumamos los tiburones en cada nivel
//                 numPecesTodosNiveles=numPecesTodosNiveles+cursor.numPeces;//sumamos los peces en cada nivel
//                 this.vContadores.add(7,numTiburonesTodosNiveles);
//                 this.vContadores.add(8,numPecesTodosNiveles);
//                 
//        }
       if (this.numNiv==1){
           //cont=this.vNiveles.get(0).numPeces;
           this.cambiaContadorPeces(this.vNiveles.get(0).numPeces);//recupera el num peces del nivel unico
           this.cambiaContadorTiburones(this.vNiveles.get(0).numTiburones);//recupera el num Tiburon del nivel unico
           
       }
       
        
   }
public static String padRight(String s, int n) {
     return String.format("%1$-" + n + "s", s);  
}

public static String padLeft(String s, int n) {
    return String.format("%1$" + n + "s", s);  
}
   public String[] pintaMarcador(){
//       int resto,multiplicador,basePeces,baseTiburones,peces,tiburones,tasaDiv;
//       int formateadorI;
//       String formateadorS1col="%40s";
            String col=console.getStringInColor(console.ANSI_RED,"");
            String reset=console.getStringInColor(console.ANSI_BLACK,"");
            String [] contadorPintado =new String [5];
//            formateadorS="maximo Numero de animales: ";
//            formateadorS=String.format("%40s",formateadorS);
            
            //contadorPintado[0]="maximo Numero de animales: " + (int)this.vContadores.get(0);
            contadorPintado[0]=padLeft("maximo Numero de animales: ",40) + String.format("%-4d",(int)this.vContadores.get(0));
            //contadorPintado[0]=contadorPintado[0]+"####Relacion peces Tiburones: ";
            contadorPintado[0]=contadorPintado[0]+padRight("####Relacion peces Tiburones: ",30);
            contadorPintado[0]= contadorPintado[0] + String.format("%4d",dameNumPeces());//calculo num peces segun porcentaje
            contadorPintado[0]= contadorPintado[0] +"/"+ String.format("%-4d",dameNumTiburones());//calculo num tiburones segun porcentaje
            //contadorPintado[0]= contadorPintado[0] + (100-(int)this.vContadores.get(6)) + "/"+(int)this.vContadores.get(6);
            contadorPintado[1]=padLeft("Tiburones vivos: ",40)+String.format("%-4d",this.vContadores.get(7));
            //contadorPintado[1]="            Tiburones vivos: "+this.vContadores.get(7);
            contadorPintado[1]=contadorPintado[1]+padRight("####Peces vivos: ",32);
             contadorPintado[1]=contadorPintado[1]+String.format("%-4d",this.vContadores.get(8));
            //contadorPintado[1]=contadorPintado[1]+"####Peces vivos: "+this.vContadores.get(8);
            contadorPintado[2]=padLeft("tiempo vida tiburones: ",40);
            contadorPintado[2]=contadorPintado[2]+String.format("%-4d",this.vContadores.get(1));
            //contadorPintado[2]="      tiempo vida tiburones: "+this.vContadores.get(1);
            contadorPintado[2]=contadorPintado[2]+padRight("####tiempo vida peces: ",32);
            contadorPintado[2]=contadorPintado[2]+String.format("%-4d",this.vContadores.get(2));
            //contadorPintado[2]=contadorPintado[2]+"####tiempo vida peces: "+this.vContadores.get(2);
            contadorPintado[3]=padLeft("tiempo crianza tiburones: ",40);
            contadorPintado[3]=contadorPintado[3]+String.format("%-4d",this.vContadores.get(3));
            //contadorPintado[3]="   tiempo crianza tiburones: "+this.vContadores.get(3);
            contadorPintado[3]=contadorPintado[3]+padRight("####tiempo crianza peces: ",32);
            contadorPintado[3]=contadorPintado[3]+String.format("%-4d",this.vContadores.get(4));
            //contadorPintado[3]=contadorPintado[3]+"####tiempo crianza peces: "+this.vContadores.get(4);
            //contadorPintado[4]="tiempo resistencia al hambre tiburones: "+this.vContadores.get(5); 
            contadorPintado[4]=padLeft("tiempo resistencia al hambre tiburones: " ,40);
            contadorPintado[4]=contadorPintado[4]+String.format("%-4d",this.vContadores.get(5));
            //contadorPintado[4]=contadorPintado[4]+"####duracion del escenario: "+this.vContadores.get(9);
            contadorPintado[4]=contadorPintado[4]+padRight("####duracion del escenario: ",32)+reset;
            contadorPintado[4]=contadorPintado[4]+col+String.format("%-4d",this.vContadores.get(9))+reset;
            
            
            
            
           
            return contadorPintado;
        }
   
    public String [] pintaSupervientes(boolean test){
        
        if(test){
        int c=0;
        String [] pincel=new String [this.vPeces.size()+this.vTiburones.size()];
            for (Pez cursor: vPeces) {
                pincel[c] ="pez: "+cursor.getIdBicho();
                c++;
            }
            c=0;
            for (Tiburon cursor: vTiburones){
                pincel[c]="tiburon: "+cursor.getIdBicho();
            }
        return pincel;
        }else {String [] pincel=new String[1];
        pincel[0]="";
        return pincel;}
    }
       
   public void creaNiveles(){
       for (int i=0; i<=this.numNiv; i++){
           nivel cursor= new nivel(this.dimX,this.dimY);
           this.vNiveles.add(cursor);
            //this.vectorNiveles [i]=(nivel)cursor;
       }
       
   }
   
   public String [] pintaMar(boolean test){
        String [] marPintado = new String [this.dimY+1];
        //int c = 0;
        if (this.numNiv > 1) {
            marPintado[0]="demasiados niveles, beta solo un nivel";    
       }else{
           nivel cursor; 
           cursor=(nivel)this.vNiveles.get(0);
           marPintado= cursor.pintaNivel(test);
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
   
public void pueblaMar(boolean test){
   creaPeces(test);
   creaTiburones(test);
   
}
public void cambiaContadorTiburones(int cantidad){
        int i=7; //pos 7 tiburones vivos
        cambiaContadorGenerico(i,cantidad);
}
public void cambiaContadorPeces(int cantidad){
        int i=8; //pos 8 peces vivos
        cambiaContadorGenerico(i,cantidad);
}
public void cambiaContadorGenerico(int i,int cantidad){
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
     this.vContadores.remove(i);//quito el elemento de la posicion indicada por i
     this.vContadores.add(i,cantidad);//inserto el nuevo valor en la pasicion indicada por i
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
     c=this.vContadores.get(i);
           c--;
           this.vContadores.remove(i);//quito el elemento de la posicion indicada por i
           this.vContadores.add(i,c);//inserto el nuevo valor en la pasicion indicada por i
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
     c=this.vContadores.get(i);
           c++;
           this.vContadores.remove(i);//quito el elemento de la posicion indicada por i
           this.vContadores.add(i,c);//inserto el nuevo valor en la pasicion indicada por i
 }

 public void incrementaContadorPeces(){
     incrementaContadorGenerico(8);
 }
 
public void decrementaContadorPeces(){
     decrementaContadorGenerico(8);
 
 }
 public void incrementaContadorTiburones(){
     incrementaContadorGenerico(7);
 }

public void decrementaContadorTiburones(){
     decrementaContadorGenerico(7);
 
 }
public void pongoEnMar(casilla cas,Acuatico bicho){
    nivel nivelAct;
        nivelAct=(nivel) this.vNiveles.get(cas.getNivel());
        nivelAct.ponEnNivel(cas,bicho);
}

public  String creaIdBicho(casilla cas,String idPadre){
    //pre:IdPadre es un idBicho formateado o un String vacio
    //post: devuelve un String que combina el contador de escenario
    //concatenado con un #
    //indice del nivel en el que ha nacido
    //concatenado con un #
    //x de la casilla
    //concatenado con un #
    //y de la casilla
    //concatenado con un #
    //id del del padre
    //en caso de que sea el primero -1#-1#-1#-1
    //ejemplo 15#00#25#19#-1#-1#-1#-1
    //ejemplo bicho nacido del anterior  10#00#20#10#15#00#25#19
   String idBicho,formateador;
   int len;
    len=this.dameTamañoDelEnteroMayor(dimX, dimY, (int)this.vContadores.get(9), numNiv);
    formateador="%0"+len+"d";//rellenare con ceros
    idBicho=String.format(formateador,this.vContadores.get(9));//duracionEscenario
    idBicho=idBicho+"#";
    idBicho=idBicho+String.format(formateador,cas.getNivel());//nivel
    idBicho=idBicho+"#";
    idBicho=idBicho+String.format(formateador,cas.getPosicionX());//x
    idBicho=idBicho+"#";
    idBicho=idBicho+String.format(formateador,cas.getPosicionY());//y
    if (idPadre.length() < 1){
        idBicho=idBicho+"#-1#-1#-1#-1";   
    }else
        idBicho=idBicho+"#"+idPadre;
        
    
    //this.vNiveles.size();
    
   
return idBicho;
}


public int dameTamañoDelEnteroMayor(int a,int b,int c,int d){
    //pre:
    //post: devuelve el tamaño del numero mayor de los cuatro pasado por parametro
    String numero;
    int len;
    int mayor;
   mayor=Math.max(a,b);
   mayor=Math.max(c,mayor);
   mayor=Math.max(d, mayor);
   numero=String.valueOf(mayor);
   len=numero.length();
    return len;
}
public void creaPeces(boolean test){
    String avisoPeces="creado pez:";
    String idP;
   int numPeces=dameNumPeces();
   do{
       casilla cuna=dameCasillaAleatoria();//elijo casilla aleatoria
       if (esCasillaVacia(cuna)) {//si esta vacia
           cuna.setHayPez(true);
           Pez pezActual=new Pez();//creo pez
           idP=creaIdBicho(cuna,"");
            pezActual.nace(cuna,idP);//le indico donde esta y le meto un id unico
            pongoEnMar(cuna,pezActual);//lo pongo en el mar
            this.vPeces.add(pezActual);//lo añado al vector de peces
           
           incrementaContadorPeces();
            numPeces--;
             if (test) {
                System.out.print(String.format("%15s",avisoPeces)+String.format("%3d", numPeces));
//                System.out.print(" en:"+String.format("%3d",cuna.getPosicionX()));
//                System.out.println("|"+String.format("%3d",cuna.getPosicionY()));
                 System.out.println(" "+idP);
           }
       }
       
      
   }while (numPeces >0);

}
public void creaTiburones(boolean test){
    //boolean test=true;
        String idT;
        int numTiburones=dameNumTiburones();
do{
       casilla cuna=dameCasillaAleatoria();//elijo casilla aleatoria
       if (esCasillaVacia(cuna)) {//si esta vacia
           
            cuna.setHayTiburon(true);
           Tiburon tibActual=new Tiburon();//creo Tiburon
           idT=creaIdBicho(cuna,"");
            tibActual.nace(cuna,idT);
            pongoEnMar(cuna,tibActual);//lo pongo en el mar
           this.vTiburones.add(tibActual);//lo añado al vector de peces
           incrementaContadorTiburones();
           if (test){
                //System.out.print(cuna.getPosicionX()+":"+cuna.getPosicionY()+"|");
                System.out.print("creado tiburon:"+String.format("%3d", numTiburones));
//                System.out.print(" en:"+String.format("%3d",cuna.getPosicionX()));
//                System.out.println("|"+String.format("%3d",cuna.getPosicionY()));
                System.out.println(" "+ idT);
           }
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
      
      nivel cursor; //=new nivel();
      cursor=(nivel)this.vNiveles.get(nivelElecto);
      casilla casActual;//=new casilla();
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
    
    public void resuelveEscenario(boolean test) throws InterruptedException{
            decrementaContadorGenerico(9);//reduzco la duracion del escenario en uno
            
            devoraPeces(test);
            quitaMarcaActualizado();
            //muerenBichos(); //por inamicion
            //reproduceBichos;
            //muevePeces();
            mueveTiburones(test);
            actualizaContadores();
            
    }
    public void devoraPeces(boolean test){
    //pre:
   //post: recorre todos los niveles devorando los peces que esten en casilla de tiburon
        nivel nivelAct;
        for (int i = 0; i < this.numNiv; i++) {
            nivelAct=(nivel) this.vNiveles.get(i);
            nivelAct.devoraPezEnNivel(this.vPeces,test);
            
            
        }
    }
    public void mueveTiburones(boolean test){
   //pre:
   //post: recorre todos los niveles moviendo los tiburones
        nivel nivelAct;
//        int numTiburonesTodosNiveles,numPecesTodosNiveles;
//        numTiburonesTodosNiveles=0;
        for (int i = 0; i < this.numNiv; i++) {//recorro los niveles
                 nivelAct=(nivel) this.vNiveles.get(i);
                 nivelAct.mueveTiburonesEnNivel(test);
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

  

