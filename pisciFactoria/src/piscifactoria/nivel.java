/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Iterator;
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
    public ArrayList<ArrayList<casilla>> casillero1;
    //public ArrayList vCazas =new ArrayList <casilla>();
    //this.vPeces.add(pezActual);//lo añado al vector de peces
   
   nivel(){}
   
   nivel(int tamX,int tamY){
        this.dimensionX=tamX;
        this.dimensionY=tamY;
        this.numPeces=0;
        this.numTiburones=0;
        this.casillero1= new ArrayList();
//        this.vPeces = new ArrayList();
//        this.vTiburones = new ArrayList();
        creaColumnas();
        creaCasillas();
    }
   public void ponEnNivel(casilla cas,Acuatico bicho){
       int indexY,indexX;
       indexX=cas.getPosicionX();
       indexY=cas.getPosicionY();
       try { 
           this.casillero1.get(indexY).get(indexX).setNivel((int)cas.getNivel());
       }catch(Exception e){
           
           System.out.println(""+e.getMessage()+" excepcion con indices X:"+indexX+" Y:"+indexY+"" );
           //System.exit(indexX);
       }
       
       if (cas.isHayPez()) {//si es pez incremento el contado de peces en el nivel
           this.casillero1.get(indexY).get(indexX).setIdBicho(bicho.getIdBicho());//pongo en la casilla el id del Pez
           //this.vPeces.add((Pez)bicho);//lo añado al vector de peces
           //cas.setIndiceBicho((this.vPeces.size()-1));//meto en casilla el indice de vPeces
           this.numPeces++;
       }
       if (cas.isHayTiburon()) {//si es tiburon incremento el contado de tiburones en el nivel
           this.casillero1.get(indexY).get(indexX).setIdBicho(bicho.getIdBicho());//pongo en la casilla el id del
           //this.vTiburones.add((Tiburon)bicho);//lo añado al vector de tiburones
          // cas.setIndiceBicho((this.vTiburones.size()-1));//meto en casilla el indice de vTiburones
           this.numTiburones++;
       }

   }
   private void creaColumnas(){
       // for(int i=0;i<=this.dimensionY;i++){//filas Y
       for(int i=0;i<this.dimensionY;i++){//filas Y
            this.casillero1.add(new ArrayList <casilla>());
        }
   }
   
   private void creaCasillas(){
        //for(int i=0;i<=this.dimensionY;i++){//filas Y
       for(int y=0;y<this.dimensionY;y++){//filas Y
           //for (int j=0;j<=this.dimensionX;j++){//columnas X
           for (int x=0;x<this.dimensionX;x++){//columnas X
               casilla cursor=new casilla(x,y);//creo una casilla
               this.casillero1.get(y).add(x,cursor);//con i saco la linea
               
         
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
    
       
       contFila=0;//inicializo indice de fila (en el bucle se incrementa antes de usarlo)
       
         while (contaShift>=0) {//recreo el espacio de desplazamiento en shiftT
           shiftT=shift+shiftT;//concatena un espacio
           contaShift--;
       }
         contaShift=this.dimensionX;//recupero contaShift
         //for(int y=this.dimensionY-1; y>0;y--){//bucle de filas desde arriba
    for(int y=this.dimensionY-1; y>=0;y--){//bucle de filas desde arriba
        try{
        shiftT=shiftT.substring(0,contaShift);//reduzco el desplazamiento
        }catch(Exception e){
            System.out.println( e.getMessage()+"#97 error en pintaNivel nivel");
        }
        contaShift--;//reduzco el contador del desplazamiento
        contFila++;//indice de fila
        fila=shiftT+fila;//añado el desplazamiento a la fila
        //for (int x=0; x<=this.dimensionX-1;x++){//bucle de casillas
        for (int x=0; x<this.dimensionX;x++){//bucle de casillas
        //for (int x=this.dimensionX; x>0 ;x--){//bucle de casillas
           
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
     //dibNivel[this.dimensionY]=PonPie(shiftT); //pisa la ultima fila la Y=0
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
        tapaInf="__|";
        
      fila="|";
      for (int i=0;i<this.dimensionX-1;i++){//    creamos la linea superior de cierre con el ultimo sin mostrar
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
    for (int i=0;i<this.dimensionX;i++){// incluimos la ultima casilla por que en este caso es igual que las demas
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
    
    
    public String dameIdBicho(casilla cas){
        return cas.getIdBicho();
    }
    public void devoraPezEnNivel(ArrayList vPeces,boolean test){
        casilla cursor;
        String idPez;
        for (int y = 0; y < this.dimensionY; y++) {//recorre el casillero desde el NO
            for (int x = 0; x < this.dimensionX; x++) {
                cursor=this.casillero1.get(y).get(x);
                if ((cursor.isHayTiburon())&&(cursor.isHayPez())){
                    if(test){
                        System.out.println("tiburon devora pez en casilla:"+x+"#"+y);
                    }
                    idPez=cursor.getIdBicho2();
                    cursor.setIdBicho2("");//Quitamos la referencia al id del pez
                    cursor.setHayPez(false);//borramos al pez de la casilla
                    eliminaPez(idPez,vPeces);//eliminamos pez de vPeces
                    numPeces--;
                }
            }
        }
    
    }
    public void eliminaPez(String idPez,ArrayList vPeces){
   
    Iterator <Pez> cursor =vPeces.iterator();
        while (cursor.hasNext()) {            
            if (cursor.next().getIdBicho().equals(idPez)) {
                cursor.remove();
            }
        }
//            Iterator<String> nombreIterator = nombreArrayList.iterator();
//while(nombreIterator.hasNext()){
//	String elemento = nombreIterator.next();
//	System.out.print(elemento+" / ");}
}
    
   
    public void eliminaTiburones(String idTib,ArrayList vTiburones){
    Iterator <Tiburon> cursor =vTiburones.iterator();
        while (cursor.hasNext()) {            
            if (cursor.next().getIdBicho().equals(idTib)) {
                cursor.remove();
            }
        }
    }
    
    public void mueveTiburonesEnNivel(boolean test){
        casilla cursor;
        for (int y = 0; y < this.dimensionY; y++) {//recorre el casillero desde el NO
            for (int x = 0; x < this.dimensionX; x++) {
                cursor=this.casillero1.get(y).get(x);
              //  if (! cursor.isActualizado()){//si no ha sido antes actualizado
                       if (cursor.isHayTiburon()) {//si hay tiburon
                           if(test){System.out.print("el tiburon "+cursor.getIdBicho()+" ");}
                        if(!cursor.isHayPez()){//si no hay caza
                            
                            decideMovimientoTiburonEnNivel(cursor,test);
                        }
//                        else //hay una pez pendiente de comer
//                            {
//                                devoraPez(cursor,test);
//                            }
                    }
               // }
            }
        }
    }
    public void colocaEnDestinoT(casilla origen,casilla destino,boolean hayCaza){
       
        
        if (hayCaza){//no muevo el tiburon y se come al pez
//            if (this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).isActualizado()==false){//ha pasado un ciclo completo con pez y tiburon en casilla
//                this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setHayPez(false);//quito el pez destino
//                this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
//          
            String idPez=dameIdBicho(destino);//cojo el incide del pez que esta en la casilla destino
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setIdBicho2(idPez);//paso el indice al iindiceBicho2
        }
       // else{//muevo el tiburon
             String idTib=dameIdBicho(origen);
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setHayTiburon(false);//quito el tiburon en el origen
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setIdBicho("");//quito el indice de bicho en la casilla origen
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setHayTiburon(true);//pongo el tiburon en el destino
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setIdBicho(idTib);//pongo el indice de  bicho en la casilla destino
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setActualizado(true);//casilla actualizada
       // }
    }
      public void decideMovimientoTiburonEnNivel(casilla origen,boolean test){
        casilla destino=dameCasillaAleatoriaContigua(origen,test);
        if(esCasillaVacia(destino)){
            //if(test){System.out.print("el tiburon "+origen.getIdBicho()+"se mueve ");}
            colocaEnDestinoT(origen,destino,false);//no haycaza
             
        }
        else{//hay bicho
            
            if (destino.isHayPez()) {//movemos y tiburon come
              //  if(test){System.out.print("el tiburon "+origen.getIdBicho()+"come en  ");}
                colocaEnDestinoT(origen,destino,true);//haycaza
            }//si es un tiburon no hacemos nada    
        } 
       
    }
      
    public boolean esCasillaVacia(casilla cas){
        return (!cas.isHayPez())&&(!cas.isHayTiburon());
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
        return (cas.getPosicionX()==0)||(cas.getPosicionY()==0)||(cas.getPosicionX()==this.dimensionX-1)||(cas.getPosicionY()==this.dimensionY-1);
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
            if((x==0)&&(y==0)){//esquina SO
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
                case 3://SE  se sale y aparece en borde norte con deriva este
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y=this.dimensionY-1;
                    //y--;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S se sale y aparece en esquina NO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    //y--;
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO se sale y aparece en la esquina NE
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 6://O se sale y aparece en la esquina SE 
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 7://NO se sale y aparece en borde este con deriva norte
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=this.dimensionX-1;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;

                    default:
                        throw new AssertionError();
                }
            }else if((x==this.dimensionX-1)&&(y==this.dimensionY-1)){//esquina NE
                switch (rumbo) {
                 case 0://N se sale y aparece en esquina SE
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE se sale y aparece en la esquina SO
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E se sale y aparece en la esquina NO
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE se sale y aparece en borde O con deriva S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
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
                case 7://NO se sale y aparece en el S con deriva O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;

                    
                    default:
                        throw new AssertionError();
                }
            }
            else if((x==0)&&(y==this.dimensionY-1)){//esquina NO
                    switch (rumbo) {
                         case 0://N se sale y aparece en esquina SO
                            testeaCasillaOrigen(x,y,test,rumbo);
                            y=0;
                            testeaCasillaDestino(x,y,test,rumbo);
                            break;
                         case 1://NE se sale y aparece en borde S con deriva E
                             testeaCasillaOrigen(x,y,test,rumbo);
                            x++;
                            y=0;
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
                        case 5://SO se sale y aparece en borde E y con deriva S
                            testeaCasillaOrigen(x,y,test,rumbo);
                            x=this.dimensionX-1;
                            y--;
                            testeaCasillaDestino(x,y,test,rumbo);
                            break;
                        case 6://O se sale y aparece en Esquina NE
                            testeaCasillaOrigen(x,y,test,rumbo);
                            x=this.dimensionX-1;
                            testeaCasillaDestino(x,y,test,rumbo);
                        break;
                        case 7://NO se sale y aparece en esquina SE
                            testeaCasillaOrigen(x,y,test,rumbo);
                            x=this.dimensionX-1;
                            y=0;
                            testeaCasillaDestino(x,y,test,rumbo);
                        break;

                    
                    default:
                        throw new AssertionError();
                }
            }
            else if ((y==0)&&(x==this.dimensionX-1)){//esquina SE
                switch (rumbo) {
                     case 0://N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                        break;
                     case 1://NE se sale y aparece en borde O con deriva Norte
                         testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                        break;
                    case 2://E se sale y aparece en Esquina SO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        testeaCasillaDestino(x,y,test,rumbo);
                        break;
                    case 3://SE se sale y aparece en Esquina NO
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=0;
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                        break;
                    case 4://S se sale y aparece en Esquina NE
                        testeaCasillaOrigen(x,y,test,rumbo);
                        y=this.dimensionY-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 5://SO se sale y aparece en borde N con deriva O
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x--;
                        y=this.dimensionY-1;
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
            else if(x==0){//borde Oeste
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
                    case 5://SO se sale y aparece en borde E con deriva S
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y--;
                        testeaCasillaDestino(x,y,test,rumbo);
                        break;
                    case 6://O se sale y aparece en borde E
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;
                    case 7://NO se sale y aparece en borde E con deriva N
                        testeaCasillaOrigen(x,y,test,rumbo);
                        x=this.dimensionX-1;
                        y++;
                        testeaCasillaDestino(x,y,test,rumbo);
                    break;

                    
                    default:
                        throw new AssertionError();
                }
            
            }else if(y==0){//borde Sur
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
                case 3://SE se sale y aparece en borde Norte con deriva E
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 4://S se sale y aparece en borde Norte
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y=this.dimensionY-1;
                    testeaCasillaDestino(x,y,test,rumbo);
                break;
                case 5://SO se sale y aparece en borde N con deriva O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y=this.dimensionY-1;
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
                
            }else if (x==this.dimensionX-1){//borde Este
                switch (rumbo) {
                 case 0://N
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE se sale y aparece en borde O con deriva N
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    y++;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 2://E se sale y aparece en borde O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                case 3://SE se sale y aparece en borde O con deriva S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x=0;
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
                
            }else{//(y==this.dimensionY-1){//borde Norte
                switch (rumbo) {
                 case 0://N se sale y aparece en borde S
                    testeaCasillaOrigen(x,y,test,rumbo);
                    y=0;
                    testeaCasillaDestino(x,y,test,rumbo);
                    break;
                 case 1://NE se sale y aparece en borde S con deriva E
                     testeaCasillaOrigen(x,y,test,rumbo);
                    x++;
                    y=0;
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
                case 7://NO se sale y aparece en borde S con deriva O
                    testeaCasillaOrigen(x,y,test,rumbo);
                    x--;
                    y=0;
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


