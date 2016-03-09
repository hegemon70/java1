/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
import piscifactoria.casilla;
/**
 *
 * @author Fernando
 */
public class mar {
    public int dimX;
    public int dimY;
    public int numNiv;
    public nivel [] vectorNiveles=new nivel[numNiv];
    
   
   public mar(int numNiv, int tamX, int tamY){
        this.numNiv=numNiv;
        this.dimX=tamX;
        this.dimY=tamY;
        creaNiveles();
   }
   
   public void creaNiveles(){
       for (int i=0; i<=this.numNiv; i++){
           nivel cursor= new nivel(this.dimX,this.dimY);
           this.vectorNiveles [i]=cursor;
       }
       
   }
   
   public String [] pintaMar(){
        String [] marPintado = new String [this.dimY];
        int c = 0;
        if (this.numNiv > 1) {
            marPintado[0]="demasiados niveles, beta solo un nivel";    
          
       }else{
        for(String cursor: this.vectorNiveles[0].pintaNivel()){
            c++;
            marPintado[c]=cursor;
        }
        }
            
   return marPintado; 
   }
 
   
}
