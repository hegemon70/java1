/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
//import piscifactoria.casilla;
import java.util.ArrayList;
import java.util.Arrays;
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
    
   public mar(int numNiv, int tamX, int tamY,int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT){
            this(numNiv,tamX,tamY);
             actualizaContadores(maxBug,lifeSpanT,lifeSpanP,breedT,breedP,feedT,porcentajeT);
   
   }
   public mar(int numNiv, int tamX, int tamY){
        this.numNiv=numNiv;
        this.dimX=tamX;
        this.dimY=tamY;
        creaNiveles();
       
   }
   
   public void actualizaContadores(int maxBug,int lifeSpanT,int lifeSpanP,int breedT,int breedP,int feedT,int porcentajeT){
        this.vContadores.add(maxBug);//pos 0
        this.vContadores.add(lifeSpanT);//pos 1
        this.vContadores.add (lifeSpanP);//pos 2
        this.vContadores.add(breedT);//pos 3
        this.vContadores.add(breedP);//pos 4
        this.vContadores.add(feedT);//pos 5
        this.vContadores.add(porcentajeT);//pos 6
        this.vContadores.add(0);//pos 7 tiburones vivos
        this.vContadores.add(0);//pos 8 peces vivos
        
        
   }
   public String[] pintaMarcador(){
       int resto,multiplicador,basePeces,baseTiburones,peces,tiburones,tasaDiv;
            String [] contadorPintado =new String [5];
            contadorPintado[0]="maximo Numero de animales: " + (int)this.vContadores.get(0);
            contadorPintado[0]=contadorPintado[0]+"####Relacion peces Tiburones: ";
             
            if ((int)this.vContadores.get(6) >= 101) {//en caso de que el numero de tiburones sea mayor que los peces
                resto=(int)this.vContadores.get(6)%100;//por debajo de 100
                multiplicador=(int)this.vContadores.get(6)/100;//multiplos de 100
                basePeces=100-resto;//si fuera porcentajes de 100 %
                baseTiburones=basePeces*multiplicador;//multiplicamos los tiburones respecto a la tasa dada
                tasaDiv=mcd(basePeces,baseTiburones);//hallamos el minimo comun divisor para reducir la fraccion basePeces/baseTiburones
                //contadorPintado[0]= " "+ Arrays.toString(contadorPintado)+ 100-resto+"/";
                peces=basePeces/tasaDiv;//reducimos el denominador peces
                tiburones=baseTiburones/tasaDiv;//reducimos el denominador Tiburones
                contadorPintado[0]= contadorPintado[0] + peces +"/"+tiburones; 
            }else
                contadorPintado[0]= contadorPintado[0] + (100-(int)this.vContadores.get(6)) + "/"+(int)this.vContadores.get(6);
            contadorPintado[1]="            Tiburones vivos: "+this.vContadores.get(7);
            contadorPintado[1]=contadorPintado[1]+"####Peces vivos: "+this.vContadores.get(8);
            contadorPintado[2]="      tiempo vida tiburones: "+this.vContadores.get(1);
            contadorPintado[2]=contadorPintado[2]+"####tiempo vida peces: "+this.vContadores.get(2);
            contadorPintado[3]="   tiempo crianza tiburones: "+this.vContadores.get(3);
            contadorPintado[3]=contadorPintado[3]+"####tiempo crianza peces: "+this.vContadores.get(4);
            contadorPintado[4]="tiempo resistencia al hambre tiburones: "+this.vContadores.get(5);            
            
            
           
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
   
  
   public static int mcd(int num1, int num2) {
        int mcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        do {
            mcd = b;
            b = a%b;
            a = mcd;
        } while(b!=0);
        return mcd;
    }
   
public void pueblaMar(){}
   
}
