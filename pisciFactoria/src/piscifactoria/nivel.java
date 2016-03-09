/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class nivel {
   public int dimensionX;
   public int dimensionY;
    public int[][] vNivel = new int[dimensionX][dimensionY];
    public ArrayList casillero = new ArrayList <casilla>();
    public ArrayList<ArrayList<casilla>> casillero1 = new ArrayList<ArrayList<casilla>>();
   
   nivel(){}
   
   nivel(int tamX,int tamY){
        this.dimensionX=tamX;
        this.dimensionY=tamY;
     
        creaColumnas();
        creaCasillas();
    }
   
   private void creaColumnas(){
        for(int i=0;i<=this.dimensionY;i++){//filas Y
            this.casillero1.add(new ArrayList <casilla>());
        }
   }
   
   private void creaCasillas(){
      
       for(int i=0;i<=this.dimensionY;i++){//filas Y
           for (int j=0;j<=this.dimensionX;j++){//columnas X
               casilla cursor=new casilla(j,i);//creo una casilla
               this.casillero1.get(i).add(j,cursor);//con i saco la linea
               
         
           }
       }
   }
   public String [] pintaNivel(){
      String [] dibNivel =new String[this.dimensionY+1];//creo un array de string del tamñano de tamY+1 para devolverlo
      String fila,shift,tapaSup;
      int contaShift,contFila;
      fila="";
      shift=" ";
      tapaSup="__ ";
      //casilla cursor =new casilla();
      //public cursor <casilla> =new iterator();
      int indice=0;
      
     for (int i=0;i>=this.dimensionX;i++){//    creamos la linea superior de cierre
         tapaSup=tapaSup+tapaSup;
     }
      contaShift=this.dimensionX;
       //ponemos la colocamos la tapa superior de cierre desplazada
                   
       while (contaShift>=0) {
           shift=shift+shift;//concatena un espacio
           contaShift--;
       }
       contaShift=this.dimensionX;
       tapaSup=shift+tapaSup;
      //ponemos la colocamos la tapa superior de cierre desplazada
       dibNivel[0]=tapaSup;
       contFila=0;//inicializo indice de fila (en el bucle se incrementa antes de usarlo)
       
    for(int y=this.dimensionY-1; y>=0;y--){//bucle de filas desde arriba
        try{
        shift.substring(0,contaShift);//reduzco el desplazamiento
        }catch(Exception e){
            System.out.println( e.getMessage()+"79 nivel");

        }
        contaShift--;//reduzco el contador del despalzamiento
        contFila++;//indice de fila
        fila=shift+fila;//añado el desplazamiento a la fila
        for (int x=0; x<=this.dimensionX-1;x++){//bucle de casillas
            fila=fila+this.casillero1.get(y).get(x).pintaCasilla(x, y,this.dimensionX,this.dimensionX, true, true);
            //indice=this.vNivel[x][y];
            //casilla cursor=(casilla) this.casillero.get(indice);
                   //fila=fila+cursor.pintaCasilla(x,y,this.dimensionX,this.dimensionX,false,false);
            //fila=fila+this.vNivel[x][y].pintaCasilla(x, y, this.dimensionX, this.dimensionY, false, false);
        }
        dibNivel[contFila]=fila;//añado la fila completa
    }
   return dibNivel;
   }
   
   
}
