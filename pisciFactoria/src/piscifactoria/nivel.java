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
    //public int[][] vNivel = new int[dimensionX][dimensionY];
    //public ArrayList casillero = new ArrayList <casilla>();
    public ArrayList<ArrayList<casilla>> casillero1 = new ArrayList<ArrayList<casilla>>();
   
   nivel(){}
   
   nivel(int tamX,int tamY){
        this.dimensionX=tamX;
        this.dimensionY=tamY;
     
        creaColumnas();
        creaCasillas();
    }
   public void ponEnNivel(casilla cas){
       this.casillero1.add(cas.getPosicionX(),this.casillero1.get(cas.getPosicionY()));
       
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
      String [] dibNivel =new String[this.dimensionY+2];//creo un array de string del tamñano de tamY+2 para devolverc con tapa sup e inf
      String fila,shift,tapaSup,shiftT;
      int contaShift,contFila;
      fila="";
      shift=" ";
      shiftT="";
      tapaSup="__ ";
      
      dibNivel[0]=PonTapa();
    
      contaShift=this.dimensionX;
    
       fila="";//inicializo fila para usar mas tarde
       contFila=0;//inicializo indice de fila (en el bucle se incrementa antes de usarlo)
       
         while (contaShift>=0) {//recreo el espacio de desplazamiento en shiftT
           shiftT=shift+shiftT;//concatena un espacio
           contaShift--;
       }
         contaShift=this.dimensionX;//recupero contaShift
    for(int y=this.dimensionY; y>0;y--){//bucle de filas desde arriba
        try{
        shiftT=shiftT.substring(0,contaShift);//reduzco el desplazamiento
        }catch(Exception e){
            System.out.println( e.getMessage()+"#79 nivel");

        }
        contaShift--;//reduzco el contador del desplazamiento
        contFila++;//indice de fila
        fila=shiftT+fila;//añado el desplazamiento a la fila
        for (int x=0; x<=this.dimensionX-1;x++){//bucle de casillas
            fila=fila+this.casillero1.get(y).get(x).pintaCasilla(x, y,this.dimensionX,this.dimensionY, this.casillero1.get(y).get(x).isHayPez(), this.casillero1.get(y).get(x).isHayTiburon());
        }
        dibNivel[contFila]=fila;//añado la fila completa
        fila="";
        
    }
     dibNivel[this.dimensionY+1]=PonPie(shiftT);
   return dibNivel;
   }
   

   public String PonTapa() {
     
      String fila,shift,tapaSup,shiftT;
      int contaShift;
      fila="";
      shift=" ";
      tapaSup="__ ";
      shiftT="";
        
     for (int i=0;i<=this.dimensionX-1;i++){//    creamos la linea superior de cierre
         fila=fila+tapaSup;
     }
      contaShift=this.dimensionX;
       //ponemos la colocamos la tapa superior de cierre desplazada
       while (contaShift>=0) {
           shiftT=shift+shiftT;//concatena un espacio
           contaShift--;
      }
       fila=shiftT+fila;  
//       tapaSup=shift+tapaSup;
  
       return fila;
   }
    public String PonPie(String shift) {
        String fila,tapaInf;
        fila="";
        tapaInf="__|";
        
      fila="|";
      for (int i=0;i<=this.dimensionX-2;i++){//    creamos la linea superior de cierre
         fila=fila+tapaInf;
      }
        //fila=shift+fila;
        fila=fila+"__|/";//la ultima casilla
        fila=shift+fila;//el desplazamiento inicial

        
        return fila;
    }
}


