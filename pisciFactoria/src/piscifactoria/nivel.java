/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fernando
 */
public class nivel {
   public int dimensionX;
   public int dimensionY;
   public int numPeces,numTiburones;
    //public int[][] vNivel = new int[dimensionX][dimensionY];
    //public ArrayList casillero = new ArrayList <casilla>();
    public ArrayList<ArrayList<casilla>> casillero1 = new ArrayList<ArrayList<casilla>>();
    //public ArrayList vCazas =new ArrayList <casilla>();
   
   nivel(){}
   
   nivel(int tamX,int tamY){
        this.dimensionX=tamX;
        this.dimensionY=tamY;
        this.numPeces=0;
        this.numTiburones=0;
        creaColumnas();
        creaCasillas();
    }
   public void ponEnNivel(casilla cas){
       int indexY,indexX;
       indexX=cas.getPosicionX();
       indexY=cas.getPosicionY();
       try { 
           this.casillero1.get(indexY).get(indexX).setNivel((int)cas.getNivel());
       }catch(Exception e){
           
           System.out.println(""+e.getMessage()+" excepcion con indices X:"+indexX+" Y:"+indexY+"" );
           //System.exit(indexX);
       };
       if (cas.isHayPez()) {//si es pez incremento el contado de peces en el nivel
           this.numPeces++;
       }
       if (cas.isHayTiburon()) {//si es tiburon incremento el contado de tiburones en el nivel
           this.numTiburones++;
       }

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
   public String [] pintaNivel(boolean test){
      String [] dibNivel =new String[this.dimensionY+3];//creo un array de string del tamñano de tamY+3 para devolverc con tapa sup e inf y linea testeo
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
            fila=fila+this.casillero1.get(y).get(x).pintaCasilla(x, y,this.dimensionX,this.dimensionY, this.casillero1.get(y).get(x).isHayPez(), this.casillero1.get(y).get(x).isHayTiburon(),test);
        }
        if (test){
            fila=fila+String.format("%3d",y);
            //fila=fila+String.format("%3d",(int)this.dimensionY-y);
        }
        dibNivel[contFila]=fila;//añado la fila completa
        fila="";
        
    }
     dibNivel[this.dimensionY+1]=PonPie(shiftT);
     if (test){
        dibNivel[this.dimensionY+2]=PonPieNumerico(shiftT);
     }else
         dibNivel[this.dimensionY+2]="";
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
    public String PonPieNumerico(String shift){
        String fila="";int n=3;
        String m;
    for (int i=0;i<=this.dimensionX-1;i++){// incluimos la ultima casilla por que enn este caso es igual que las demas
        m=String.valueOf(i);
        //fila=fila+String.format("%1$" + n, (int)i);
        //fila=fila+String.format("%1$" + n, m);
       fila=fila+String.format("%3d", i);
         
      }
        fila=shift+fila;//el desplazamiento inicial
       return fila;
    }
    
    public static String padRight(String s, int n) {
     return String.format("%1$-" + n + "s", s);  
}

public static String padLeft(String s, int n) {
    return String.format("%1$" + n + "s", s);  
}

//...
//
//public static void main(String args[]) throws Exception {
// System.out.println(padRight("Howto", 20) + "*");
// System.out.println(padLeft("Howto", 20) + "*");
//}
///*
//  output :
//     Howto               *
//                    Howto*
//*/
    public void quitaMarcaActualizadoEnNivel(){
    //pre:
   //post:
        for (int y = 0; y < this.dimensionY; y++) {
            for (int x = 0; x < this.dimensionX; x++) {
                this.casillero1.get(y).get(x).setActualizado(false);
            }
        }
                
        
    }
    
    public void mueveTiburonesEnNivel(boolean test){
        casilla cursor;
        for (int y = 0; y < this.dimensionY; y++) {
            for (int x = 0; x < this.dimensionX; x++) {
                cursor=this.casillero1.get(y).get(x);
                if (! cursor.isActualizado()){//si no ha sido antes actualizado
                       if (cursor.isHayTiburon()) {//si hay tiburon
                        if(!cursor.isHayPez()){//si no hay caza
                            decideMovimientoTiburonEnNivel(cursor,test);
                        }
                    }
                }
            }
        }
    }
    public void colocaEnDestino(casilla origen,casilla destino,boolean hayCaza){
        if (hayCaza){//no muevo el tiburon y se come al pez
            
            this.casillero1.get(destino.getPosicionY()).get(origen.getPosicionX()).setHayPez(false);//quito el pez destino
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
          
            
        }else{
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setHayTiburon(false);//quito el tiburon en el origen
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setHayTiburon(true);//pongo el tiburon en el destino
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
            this.casillero1.get(destino.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
        }
    }
    
    public boolean esCasillaVacia(casilla cas){
        return (!cas.isHayPez())&&(!cas.isHayTiburon());
    }
    public void decideMovimientoTiburonEnNivel(casilla origen,boolean test){
        casilla destino=dameCasillaAleatoriaContigua(origen,test);
        if(esCasillaVacia(destino)){
            colocaEnDestino(origen,destino,false);//no haycaza
        }
        else{//hay bicho
            if (destino.isHayPez()) {//movemos y tiburon come
                colocaEnDestino(origen,destino,true);//haycaza
            }//si es un tiburon no hacemos nada  
            
        }
            

            
       
    }
    
    public casilla dameCasillaAleatoriaContigua(casilla origen,boolean test){
    double rand;
    casilla casDestino=new casilla();
    Random rnd =new Random();
      int xElect,yElect,rumbo;
      //(int) (rnd.nextDouble() * cantidad_números_rango + término_inicial_rango)
      rand=rnd.nextDouble();
      rumbo=(int)(rnd.nextDouble() * 8 + 0);
             casDestino=dameCasillaDestino(rumbo,origen,test);
      return casDestino;
}
    public boolean estaEnBorde(casilla cas){
        return (cas.getPosicionX()==0)||(cas.getPosicionY()==0)||(cas.getPosicionX()==this.dimensionX-1)||(cas.getPosicionX()==this.dimensionY);
    }
    
    public String dimeQueRumboEs(int numRumbo){
        String rumbo="";
        switch (numRumbo) {
            case 0:
                rumbo="N";                
            break;
             case 1:
                rumbo="NE";
            break;
             case 2:
                rumbo="E";
            break;
             case 3:
                rumbo="SE";
            break;
             case 4:
                rumbo="S";
            break;
             case 5:
                rumbo="SO";
            break;
             case 6:
                rumbo="O";
            break;
             case 7:
                rumbo="NO";
            break;
            
            default:
                throw new AssertionError();
        }
        return rumbo;
    }
    public void testeaCasillaOrigen(int x,int y, boolean test,int rumbo){
        if(test){
        String dir="se mueve al ";
                dir=dimeQueRumboEs(rumbo);
                System.out.print("origen"+" [X:"+x+" Y:"+y+"]#"+dir);
        }
    }
    public void testeaCasillaDestino(int x,int y, boolean test,int rumbo){
	  if (test){
                            System.out.println(" destino"+" [X:"+x+" Y:"+y+"]"); 
                        }
	
	}
     public casilla dameCasillaDestino(int rumbo,casilla origen,boolean test ){
         //pre:
         //post:movimientos cartesianos el origen  de coordenadas x=0 y Y=0 esta al SO;
         //rumbo 0://N y++; rumbo 1://NE x++; y++; rumbo 2://E x++; rumbo 3://SE x++; y--; 
         //rumbo 4://S y--; rumbo 5://SO x--; y--; rumbo 6://O x--; rumbo 7://NO x--; y++;
        casilla casDestino=new casilla();
        int x=origen.getPosicionX();
        int y=origen.getPosicionY();
        if(estaEnBorde(origen)){
            //estan mal las posiciones del los bordes                     
            if((x==0)&&(y==0)){//esquina NO
                switch (rumbo) {
                    case 0://se mueve al norte y sale al sur
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                      
                    break;
                    case 1://se mueve al NE y sale al sur con deriva este
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=this.dimensionY-1;
                        x++;
                        testeaCasillaDestino(x,y,test,rumbo);
                      
                    break;
                    case 2://se mueve al este
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 3://se mueve al SE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x++;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 4://se mueve al Sur
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 5://se mueve al SO y sale al Este con deriva sur
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                        
                    break;
                    case 6://se mueve al oeste y sale al este
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 7://se mueve al NO y sale por la esquina SE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    default:
                        throw new AssertionError();
                }
            }else if((x==this.dimensionX-1)||(y==this.dimensionY-1)){//esquina SE
                switch (rumbo) {
                    case 0://se mueve N 
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 1://se mueve NE y sale al O con deriva N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 2://se mueve E y sale por el O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 3://se mueve SE y sale por la esquina NO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 4://se mueve S y sale por el N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 5://se mueve SO y sale por el N con deriva O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=0;
                        x--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 6://se mueve O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 7://se mueve NO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    
                    default:
                        throw new AssertionError();
                }
            }
            else if((x==0)&&(y==this.dimensionY-1)){//esquina SO
                    switch (rumbo) {
                    case 0://se mueve al N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 1://se mueve al NE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y--;
                        x++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 2://se mueve al E
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 3://se mueve al SE y sale al N con deriva E
                        testeaCasillaOrigen(x,y,test,rumbo);
                         y=0;
                         x++;
                         testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 4://se mueve al S y sale al N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 5://se mueve al SO y sale en la esquina NE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 6://se mueve al O y sale al E
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 7://se mueve al NO y sale al E con deriva N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    
                    default:
                        throw new AssertionError();
                }
            }
            else if ((y==0)&&(x==this.dimensionX-1)){//esquina NE
                switch (rumbo) {
                    case 0://se mueve al N y sale por la esquina SE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 1://se mueve al NE y se  poe la esquina SO
                        testeaCasillaOrigen(x,y,test,rumbo);
                         x=0;
                         y=this.dimensionY;
                         testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 2://se mueve al E y salgo por la esquina NO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 3://se mueve al SE sale al Oeste con deriva S
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 4://se mueve al S
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 5://se mueve al SO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 6://se mueve al O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 7://se mueve al NO y sale por el Sur con deriva O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    
                    default:
                        throw new AssertionError();
                }
            }
            else if(x==0){//borde Oeste
                switch (rumbo) {
                    case 0://N
                        testeaCasillaOrigen(x,y,test,rumbo);
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO y sale al E con deriva S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O y sale al E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO y sale al E con deriva N
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                    
                    default:
                        throw new AssertionError();
                }
            
            }else if(y==0){//borde Norte
                switch (rumbo) {
                     case 0://N y sale por el S
                         testeaCasillaOrigen(x,y,test,rumbo);
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE y sale por el S con deriva E
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO y sale por el S con deriva O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                    default:
                        throw new AssertionError();
                }
                
            }else if (x==this.dimensionX-1){//borde Este
                switch (rumbo) {
                 case 0://N
                     testeaCasillaOrigen(x,y,test,rumbo);
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE y sale al O con deriva N
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E y sale al O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE y sale al O con deriva S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                    default:
                        throw new AssertionError();
                }
            }else{//y==this.dimensionY //borde Sur
                switch (rumbo) {
                    
                    case 0://N
                        testeaCasillaOrigen(x,y,test,rumbo);
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE y sale por el N con deriva E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S y sale por el N
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO y sale por el N con deriva O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                    default:
                        throw new AssertionError();
                }
            }
                
        }else{//no esta al borde
            switch (rumbo) {
                case 0://N
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                default:
                    throw new AssertionError();
            }
    }
        try{
        casDestino=this.casillero1.get(y).get(x);
        }catch (Exception e){
            System.out.println(""+ e.getMessage()+"en dameCasillaDestino" +" valor de X:" + x +" Y:" + y+" y el ultimo rumbo es: " );
        }
    return casDestino;
    }
}


