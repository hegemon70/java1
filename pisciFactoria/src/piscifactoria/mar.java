/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
//import piscifactoria.casilla;
import java.util.ArrayList;
/**
 *
 * @author Fernando
 */
public class mar {
    public int dimX;
    public int dimY;
    public int numNiv;
    public ArrayList vNiveles = new ArrayList <nivel>();
   // public nivel [] vectorNiveles=new nivel[numNiv];
    
   
   public mar(int numNiv, int tamX, int tamY){
        this.numNiv=numNiv;
        this.dimX=tamX;
        this.dimY=tamY;
        creaNiveles();
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
        int c = 0;
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
public void pueblaMar(){}
   
}
