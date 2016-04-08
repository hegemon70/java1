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
    public ArrayList<Pez> vPecesNiv;
    public ArrayList<Tiburon> vTiburonesNiv;
    public ArrayList<Pez> vTempPezNiv;
    public ArrayList<Tiburon> vTempTiburonNiv;
    //this.vPeces.add(pezActual);//lo añado al vector de peces
   
   nivel(){}
   
   nivel(int tamX,int tamY){
        this.dimensionX=tamX;
        this.dimensionY=tamY;
        this.numPeces=0;
        this.numTiburones=0;
        this.casillero1= new ArrayList();
        this.vPecesNiv = new ArrayList();
        this.vTiburonesNiv = new ArrayList();
        this.vTempTiburonNiv = new ArrayList();
        this.vTempPezNiv = new ArrayList();
        creaColumnas();
        creaCasillas();
    }
   
   public void ponEnNivel(casilla cas,Acuatico bicho,boolean test){
       //Pre: casilla es casilla vacia y valida, bicho es pez o tiburon
       //Post: coloca en la casilla el id del bicho y toda su filiacion, activa el booleano de status tib o pez
       //incrementa contador de pez o tib del nivel
       //añade el bicho al arrayList correspondiente
       int indexY,indexX;
       indexX=cas.getPosicionX();
       indexY=cas.getPosicionY();
       try { 
           this.casillero1.get(indexY).get(indexX).setNivel((int)cas.getNivel());
       }catch(Exception e){
           
           String rec = ""+e.getMessage()+" excepcion con indices X:"+indexX+" Y:"+indexY+" en PonEnNivel";
           System.out.println(rec);
           //System.exit(indexX);
       }
       this.casillero1.get(indexY).get(indexX).setIdBicho(bicho.getIdBicho());//pongo en la casilla el id del Pez

          if (esObjetoTiburon(bicho)){ //es Tiburon
            this.vTempTiburonNiv.add((Tiburon)bicho); //lo añado al vector de bebes tiburon
            this.casillero1.get(indexY).get(indexX).setHayTiburon(true);
            this.numTiburones++;
            if(test){
                String rec = "tiburon creado en "+indexX+"#"+indexY;
                System.out.println(rec);
                    }
          }else{//es pez
              this.vTempPezNiv.add((Pez)bicho);//lo añado al vector de bebesPez
              this.casillero1.get(indexY).get(indexX).setHayPez(true);
               this.numPeces++;
                if(test){
                String rec = "pez creado en "+indexX+"#"+indexY;
                    System.out.println(rec);
                    }
            }

   }
   
   public void marcaComoElimiminadoDeVector(casilla cas,Acuatico bicho,boolean test){
       //Pre: casilla es casilla llena y valida, bicho es pez o tiburon
       //Post: decrementa contador de pez o tib del nivel
       //añade el bicho al arrayList temporal de bichos a eliminar 
       int indexY,indexX;
          if (esObjetoTiburon(bicho)){ //es Tiburon
            this.vTempTiburonNiv.add((Tiburon)bicho); //lo añado al vector de tiburones eliminados
          //  this.casillero1.get(indexY).get(indexX).setHayTiburon(false);//borro el bit de tiburon POSIBLE REPETICION eliminaTiburondeNivel
            this.numTiburones--;
            if(test){
                indexX=cas.getPosicionX();
                indexY=cas.getPosicionY();
                String rec = "tiburon muerto en "+indexX+"#"+indexY;
                System.out.println(rec);
                    }
          }else{//es pez
              this.vTempPezNiv.add((Pez)bicho);//lo añado al vector de peces eliminados
            //  this.casillero1.get(indexY).get(indexX).setHayPez(false);
               this.numPeces--;
                if(test){
                        indexX=cas.getPosicionX();
                        indexY=cas.getPosicionY();
                        String rec = "pez muerto en "+indexX+"#"+indexY;
                        System.out.println(rec);
                    }
            }
// try { 
//           this.casillero1.get(indexY).get(indexX).setNivel((int)cas.getNivel());
//       }catch(Exception e){
//           
//           String rec = ""+e.getMessage()+" excepcion con indices X:"+indexX+" Y:"+indexY+" en PonEnNivel";
//           System.out.println(rec);
//           //System.exit(indexX);
//       }
       ///this.casillero1.get(indexY).get(indexX).setIdBicho("");//borro de la casilla el id del Bicho POSIBLE REPETICION eliminaTiburondeNivel
   }
   //Pre: casilla es casilla vacia y valida, bicho es pez o tiburon
       //Post: incrementa contador de pez o tib del nivel
       //añade el bicho al arrayList correspondiente

   private boolean esObjetoTiburon(Acuatico bicho){
       String s1 = bicho.getClass().getName();
       String s2=Tiburon.class.toString().substring(6,Tiburon.class.toString().length());     

       return  s1.equals(s2);
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
            String rec = e.getMessage()+"#97 error en pintaNivel nivel";
            System.out.println(rec);
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


    public void quitaMarcaActualizadoEnNivel(){
    //pre:
   //post:
        for (int y = 0; y < this.dimensionY; y++) {
            for (int x = 0; x < this.dimensionX; x++) {
                //this.casillero1.get(y).get(x).setActualizado(false);
                this.casillero1.get(y).get(x).noActualizada();
            }
        }
    }
    public void muereTiburonHambreEnNivel(Tiburon cursor,boolean test){
            this.eliminaTiburonEnNivel(cursor,test);
            //this.quitaDeNivel(null, cursor, test);
            
    }
     public void muerenTiburonesHambreEnNivel(boolean test){
    //pre:
    //post: comprueba la fuerza de los tiburones y los mata si llega a 0  
         String rec;
         if (this.vTiburonesNiv.size()>0) {//compruebo que queden tiburones
                for (Tiburon cursor: this.vTiburonesNiv){
                cursor.reduceFuerza();
              if (cursor.getEnergia()<=0){
                  if (test) {
                      rec =" muere de hambre el tiburon "+cursor.getIdBicho();
                      System.out.println(rec);
                  }
                  muereTiburonHambreEnNivel(cursor,test);
                  
              }

           }
          this.eliminaTiburonesDeVector(this.vTempTiburonNiv, test);
           this.vTempTiburonNiv.clear();//reseteo arrray temporal de tiburones
         }else {
                if (test) {
                 rec="no hay mas tiburones que mueran de hambre";
                 System.out.println(rec);  
                }

                 }
 
 }
      //pre:
    //post: comprueba la fuerza de los tiburones y los mata si llega a 0   
     
     public void muereTiburonAncianoEnNivel(Tiburon cursor,boolean test){
            this.eliminaTiburonEnNivel(cursor,test);
     }
     public void muerePezAncianoEnNivel(Pez cursor,boolean test){
            this.eliminaPezEnNivel(cursor,test);
     }
     public void muerenBichosAncianosEnNivel(boolean test){
    //pre:
    //post: comprueba la vida del los tiburones y los mata si llega a 0
     if(this.vTiburonesNiv.size()>0) {//compruebo que queden tiburones
        for (Tiburon cursor:  this.vTiburonesNiv) {
            cursor.reduceVida();
                 if (cursor.getVida()<=0) {
                    if(test){
                        String rec = "muere de viejo el tiburon"+cursor.getIdBicho();
                        System.out.println(rec);
                    }
                this.muereTiburonAncianoEnNivel(cursor,test);
                //eliminaTiburonEnNivel(cursor,test);
                }
        }
           this.eliminaTiburonesDeVector(this.vTempTiburonNiv, test);
           this.vTempTiburonNiv.clear();//reseteo array temporal de tiburones
            
         }else{
            if (test) {
             String rec="no hay mas tiburones que mueran de viejo";
             System.out.println(rec);  
            }
         }
     if (this.vPecesNiv.size()>0) {//compruebo que queden peces
        for (Pez cursor: this.vPecesNiv){
            cursor.reduceVida();
            if (cursor.getVida()<=0) {
               if(test){
                      String rec = "muere de viejo el pez"+cursor.getIdBicho();
                      System.out.println(rec);
               }
                 this.muerePezAncianoEnNivel(cursor,test);
                //eliminaPezEnNivel(cursor,test);
            }
        }
          this.eliminaPecesDeVector(this.vTempPezNiv, test);
          this.vTempPezNiv.clear();//reseteo array temporal de peces
         }else {
                if (test) {
                 String rec="no hay mas peces";
                 System.out.println(rec);  
                }
         }
        }
             
    //pre:
    //post: comprueba la vida del los tiburones y los mata si llega a 0  
    public String dameIdBicho(casilla cas){
        return cas.getIdBicho();
    }
    
    private void alimentaTiburon(String idTib,boolean test){
      int i= this.dameIndiceTiburon(idTib);
      this.vTiburonesNiv.get(i).recuperaFuerza();
      
    }
    public void devoraPecesEnNivel(boolean test){
        casilla cursor;
        String idPez,idTib;
        for (int y = 0; y < this.dimensionY; y++) {//recorre el casillero desde el NO
            for (int x = 0; x < this.dimensionX; x++) {
                cursor=this.casillero1.get(y).get(x);
                if ((cursor.isHayTiburon())&&(cursor.isHayPez())){
                    if(test){
                        String rec = "tiburon devora pez en casilla:"+x+"#"+y;
                        System.out.println(rec);
                    }
                    idPez=cursor.devoraPez();
                    idTib=cursor.getIdBicho();
                    alimentaTiburon(idTib,test);
//                    idPez=cursor.getIdBicho2();
//                    cursor.setIdBicho2("");//Quitamos la referencia al id del pez
//                    cursor.setHayPez(false);//borramos al pez de la casilla
                    eliminaPezDeVector(idPez,test);//eliminamos pez de vPeces
                    numPeces--;
                }
            }
        }
    
    }
    public void eliminaPezEnNivel(Pez P,boolean test){
        casilla cas;       
             cas=damePosicionBicho(P);
             cas.borraPez();
             this.marcaComoElimiminadoDeVector(cas, P, test);
//           String idPez;  
//           casilla cas;
//           int indexX,indexY;
//           indexX=P.getPosicion().getPosicionX();
//           indexY=P.getPosicion().getPosicionY();
//           idPez=P.getIdBicho();
//           this.casillero1.get(indexY).get(indexX).setIdBicho("");//Quitamos la referencia al id del pez
//           this.casillero1.get(indexY).get(indexX).setHayPez(false);//borramos al pez de la casilla
//           //this.eliminaPezDeVector(idPez,test);
//           cas=this.casillero1.get(indexY).get(indexX);
        
           
           
    }
    
    public casilla damePosicionBicho(Acuatico bicho){
        //pre:
        //post:recorre el casillero y devuelve la casilla donde esta el bicho
        //si no existe devuelve null
        casilla cas=null;
        String idActual;
        
        for (int y = 0; y < this.dimensionY; y++) {
            for (int x = 0; x < this.dimensionX; x++) {
                idActual=this.casillero1.get(y).get(x).getIdBicho();
                if (idActual.equals(bicho.getIdBicho())) {
                    return this.casillero1.get(y).get(x);
                }
            }
        }
    return cas;
    }
     public void eliminaTiburonEnNivel(Tiburon T,boolean test){
        //pre: 
        //post: busca el tiburon por casillero1 y 
         //coloca en la casilla el id del bicho y toda su filiacion, activa el booleano de status tib o pez
           
             casilla cas;       
             cas=damePosicionBicho(T);
             if (cas!=null){
                 cas.borraTiburon();
                 this.marcaComoElimiminadoDeVector(cas, T, test);
             }
//           int indexX,indexY;
//           indexX=T.getPosicion().getPosicionX();
//           indexY=T.getPosicion().getPosicionY();
//           idTiburon=T.getIdBicho();
//           this.casillero1.get(indexY).get(indexX).setIdBicho("");//Quitamos la referencia al id del tib
//           this.casillero1.get(indexY).get(indexX).setHayTiburon(false);//borramos al tib de la casilla
//           cas=this.casillero1.get(indexY).get(indexX);
           //this.eliminaTiburonesDeVector(idTiburon,test);
       
    }
    public void eliminaPezDeVector(String idPez,boolean test){
        String rec;
    if (this.vPecesNiv.size()>0) {
        Iterator <Pez> cursor =vPecesNiv.iterator();
        while (cursor.hasNext()) {            
            if (cursor.next().getIdBicho().equals(idPez)) {
                cursor.remove();
            }
        }
        if(test){
            System.out.println("");
            rec = "Pez: "+idPez+ " eliminado";
            System.out.println(rec);
        }
//            Iterator<String> nombreIterator = nombreArrayList.iterator();
//while(nombreIterator.hasNext()){
//	String elemento = nombreIterator.next();
//	System.out.print(elemento+" / ");}
    }else{ 
        System.out.println("");
        rec=" Intentando eliminar pero no hay mas Peces vivos ";
        System.out.println(rec);
    }
}
   public void  eliminaTiburonDeVector(String idTib,boolean test ){
   String rec;
        if (vTiburonesNiv.size()>0) {
                Iterator <Tiburon> cursor =vTiburonesNiv.iterator();
            while (cursor.hasNext()) {            
                if (cursor.next().getIdBicho().equals(idTib)) {
                    cursor.remove();
                }
            }
        }else { 
            if (test) {
                rec="  Tiburones extintos ";
            System.out.println(rec);
            }   
        }
   }
       public void eliminaPecesDeVector(ArrayList<Pez> vTempPecesMuertos, boolean test) {
        //pre:
        //post: recorre cada pez que hay en peceesMuertos y los elimina de vPecesNiv     
            String rec;
       if (this.vTempPezNiv.size()>0) {//hay tiburones para eliminar
            Iterator <Pez> cursor = vTempPecesMuertos.iterator();
            while(cursor.hasNext()){
                eliminaPezDeVector(cursor.next().idBicho,test);
            }

               if(test){
                            System.out.println("");
                            rec="num Pecees vivos: "+vPecesNiv.size();
                            System.out.println(rec);
                }
              // this.vTempTiburonNiv.clear();//reseteo el vector temporal

        }else {
           if (test) {
               //System.out.println("");
                rec=" no hay Peces muertos ";
                System.out.println(rec);
           }
       }
      
    }
       //pre:
        //post: recorre cada pez que hay en peceesMuertos y los elimina
        //de vPecesNiv
       
    public void eliminaTiburonesDeVector(ArrayList vTiburonesMuertos,boolean test){
        //pre:
        //post: recorre cada tiburon que hay en tiburonesMuertos y los elimina
        //de vTiburonesNiv
        String rec;
        
       if (this.vTempTiburonNiv.size()>0) {//hay tiburones para eliminar
        Iterator <Tiburon> cursor = vTiburonesMuertos.iterator();
        while(cursor.hasNext()){
            eliminaTiburonDeVector(cursor.next().idBicho,test);
        }

           if(test){
                        rec="num Tiburones vivos: "+vTiburonesNiv.size();
                        System.out.println(rec);
            }
          // this.vTempTiburonNiv.clear();//reseteo el vector temporal
    
        }else { 
           if (test) {
                rec=" no hay Tiburones muertos de hambre ";
                System.out.println(rec);
           }
            
       }
    }
        //pre:
        //post: recorre cada tiburon que hay en tiburonesMuertos y los elimina
        //de vTiburonesNiv
   
    public void muevePecesEnNivel(boolean test){
        casilla origen;
        
        this.vTempPezNiv.clear();
        for (int y=0; y < this.dimensionY; y++) {
            for (int x=0 ; x < this.dimensionX; x++) {
                origen=this.casillero1.get(y).get(x);
                if (!origen.isActualizado()){
                    if (origen.isHayPez()){
                        if (test) {
                            
                            String rec = " el pez "+origen.getIdBichoBreve()+" ";
                            System.out.print(rec);
                        }
                            decideMovimientoPezEnNivel(origen,test);
                    }
                }
            }
    
            
            //this.vTempPezNiv.add(pezActual);//añade el pez movido o no al vector temporal de peces   
        }
//             this.vPecesNiv.clear();
//               this.vPecesNiv.addAll(this.vTempPezNiv);
//               this.vTempPezNiv.clear();
        
    
    }
    public void mueveTiburonesEnNivel(boolean test){
        casilla cursor;
        for (int y = 0; y < this.dimensionY; y++) {//recorre el casillero desde el NO
            for (int x = 0; x < this.dimensionX; x++) {
                cursor=this.casillero1.get(y).get(x);
                    if (! cursor.isActualizado()){//si no ha sido antes actualizado
                       if (cursor.isHayTiburon()) {//si hay tiburon
                           if(test){System.out.print(" el tiburon "+cursor.getIdBichoBreve()+" ");}
                        if(!cursor.isHayPez()){//si no hay caza
                            decideMovimientoTiburonEnNivel(cursor,test);
                        }

                    }
               }
            }
      
           }
        
    }
    
    public void colocaEnDestinoP(casilla origen,casilla destino){
    String idPez=dameIdBicho(origen);
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setHayPez(false);//quito el pez en el origen
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setIdBicho("");//quito el indice de bicho en la casilla origen
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setHayPez(true);//pongo el pez en el destino
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setIdBicho(idPez);//pongo el indice de  bicho en la casilla destino
            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setActualizado(true);//casilla actualizada
    
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
    
    public boolean decideMovimientoPezEnNivel(casilla origen,boolean test){
        casilla destino=dameCasillaAleatoriaContigua(origen,test);
        if(esCasillaVacia(destino)){
//            if(test){
//                String rec = "el pez "+origen.getIdBicho()+"se mueve#### ";
//                System.out.print(rec);
//            }
            colocaEnDestinoP(origen,destino);
             return true;
        }else return false;
    }
      public void decideMovimientoTiburonEnNivel(casilla origen,boolean test){
        casilla destino=dameCasillaAleatoriaContigua(origen,test);
        destino.PonTiburon(origen.getIdBicho());
        origen.borraTiburon();
    }
      public boolean esCasillaVacia(casilla cas){
        return (!cas.isHayPez())&&(!cas.isHayTiburon());
    }
  public int dameRumboAleatorio(boolean test){
    //pre:
   //post:devuelve u numero aleatorio entre 0 y 7
      //movimientos cartesianos el origen  de coordenadas x=0 y Y=0 esta al SO;
         //rumbo 0://N y++; rumbo 1://NE x++; y++; rumbo 2://E x++; rumbo 3://SE x++; y--; 
         //rumbo 4://S y--; rumbo 5://SO x--; y--; rumbo 6://O x--; rumbo 7://NO x--; y++;
      double rand;
      int rumbo=0;
      Random rnd =new Random();
      
      //(int) (rnd.nextDouble() * cantidad_números_rango + término_inicial_rango)
      rand=rnd.nextDouble();
      rumbo=(int)(rnd.nextDouble() * 8 + 0);
  return rumbo;
  }
   //pre:
   //post:devuelve u numero aleatorio entre 0 y 7
      //movimientos cartesianos el origen  de coordenadas x=0 y Y=0 esta al SO;
         //rumbo 0://N y++; rumbo 1://NE x++; y++; rumbo 2://E x++; rumbo 3://SE x++; y--; 
         //rumbo 4://S y--; rumbo 5://SO x--; y--; rumbo 6://O x--; rumbo 7://NO x--; y++;
    
    public casilla dameCasillaAleatoriaContigua(casilla origen,boolean test){
   // double rand;
    casilla casDestino;//=new casilla();
    Random rnd =new Random();
    int rumbo;
                rumbo=dameRumboAleatorio(test);
             casDestino=dameCasillaDestino(rumbo,origen,test);
      return casDestino;
}
      public casilla decideLugarEnNivel(casilla origen,boolean test){
          //pre: dada una casilla valida
          //post: devuelve casilla vacia o null
         ArrayList <Integer> vBrujula=new ArrayList();
         Integer rumbo;
         String recogedor="";
         casilla destino;
         do {
             rumbo=(Integer)dameRumboAleatorio(test);
             if (!vBrujula.contains(rumbo)) {
                 vBrujula.add(rumbo);
             }
             destino=this.dameCasillaDestino(rumbo, origen, test);
              if(test){
                 if (vBrujula.size()==1)
                     recogedor="intentado "+dimeQueRumboEs((int)rumbo);
                 else{//vBrujula mas de 1
                     for (Integer cursor: vBrujula) {
                          recogedor=recogedor+dimeQueRumboEs(cursor)+"#";
                     }
                 }
                  System.out.println(recogedor);
                  recogedor="";
             }
         } while ((!esCasillaVacia(destino))&&(vBrujula.size()<8));//seguir mientras casilla nueva este llena  
                                                                    //y no hallamos probado todas las direcciones de la brujula
         
       // casilla destino=dameCasillaAleatoriaContigua(origen,test);
         vBrujula.clear();
        if(esCasillaVacia(destino)){
            return destino;
        }else 
        return null;
     }
       //pre: dada una casilla valida
       //post: devuelve casilla vacia o null
private String dameIdPadre(String idHijo){
       //pre: IdHIjo formateado (consultar creaIdBichoEnNivel)
       //post:devuelve solo la parte del padre
       String [] vRec;
       String rec="";
       vRec=idHijo.split("#");//divido en partes
       for (int i = 4; i < vRec.length; i++) {
           if (i==vRec.length-1) rec=rec+vRec[i];
           else rec=rec+vRec[i]+"#";
       }       
   return rec;
   }
       //pre: IdHIjo formateado (consultar creaIdBichoEnNivel)
       //post:devuelve solo la parte del padre
 public  String creaIdBichoEnNivel(casilla cas,ArrayList vContadores,String idPadre){
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
    len=this.dameTamañoDelEnteroMayor((int)vContadores.get(9),(int)vContadores.get(11),(int)vContadores.get(12),(int)vContadores.get(13));
//         duracionEscenario //pos 9 duracion Escenario
//          dimX pos 11 tamaño x de piscina
//          dimY pos 12 tamaño x de piscina
//          numNiv pos 13 num Niveles 
    formateador="%0"+len+"d";//rellenare con ceros
    idBicho=String.format(formateador,vContadores.get(9));//duracionEscenario
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

return idBicho;
}
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


 
 public boolean esMismoBicho(Acuatico a,Acuatico b){
    //return a.posicion.getPosicionX()==b.posicion.getPosicionX() && a.posicion.getPosicionY()==b.posicion.getPosicionY();
    return a.getIdBicho().equals(b.getIdBicho());//compara el getIdBicho
 }
 public boolean esMismoPez(Pez a,Pez b){
    return esMismoBicho(a,b);
 }
  public boolean esMismoTiburon(Tiburon a,Tiburon b){
    return esMismoBicho(a,b);
  }
 public int dameIndicePez(Pez objetivo){
    int indice=-1;
     for (int i = 0; i < this.vPecesNiv.size(); i++) {
         if (esMismoPez(objetivo,this.vPecesNiv.get(i))){
             return i;
         }
     }
 return indice;
 }
  public int dameIndicePez(String idObjetivo){
    int indice=-1;
     for (int i = 0; i < this.vPecesNiv.size(); i++) {
         if (idObjetivo.equals(this.vPecesNiv.get(i).getIdBicho())){//
             return i;
         }
     }
 return indice;
 }
  public int dameIndiceTiburon(Tiburon objetivo){
    int indice=-1;
     for (int i = 0; i < this.vPecesNiv.size(); i++) {
         if (esMismoTiburon(objetivo,this.vTiburonesNiv.get(i))){
             return i;
         }
     }
 return indice;
 }
   public int dameIndiceTiburon(String idObjetivo){
    int indice=-1;
     for (int i = 0; i < this.vTiburonesNiv.size(); i++) {
         if (idObjetivo.equals(this.vTiburonesNiv.get(i).getIdBicho())){
             return i;
         }
     }
 return indice;
 }
     public void partoPez(casilla cuna,Pez padre,ArrayList vContadores,boolean test){
     //pre:  en vContadores debe estar 
         //lifeSpanP //pos 2
        //breedP //pos 4
         //en casilla cuna debe haber una casilla valida vacia
        //post: creaPez en ella
        int  vidaMax=(int)vContadores.get(2); //lifeSpanP //pos 2
        int celoMax=(int)vContadores.get(4); //breedP //pos 4
        String idP,rec;
        Pez pezActual;
        pezActual= new Pez(vidaMax,celoMax);
        idP=creaIdBichoEnNivel(cuna,vContadores,padre.getIdBicho());
        pezActual.nace(cuna,idP);
        this.ponEnNivel(cuna, pezActual, test);
       // padre.setCelo(celoMax);
        
         if (test) {
             rec="nace pez:";
                rec=rec+" "+ pezActual.getIdBichoBreve();
                rec=rec+" del pez"+ this.dameIdPadre(idP);
                System.out.println(rec);
             
         }
     }
        //pre:  en vContadores debe estar 
         //lifeSpanP //pos 2
        //breedP //pos 4
         //en casilla cuna debe haber una casilla valida vacia
        //post: creaPez en ella
    public void partoTiburon(casilla cuna,Tiburon padre,ArrayList vContadores,boolean test){
//pre: en vContadores debe estar 
         //lifeSpanT //pos 1
         //breedT //pos 3
        //feedT //pos 5
//post: 
        int vidaMax=(int)vContadores.get(1); //lifeSpanT //pos 1
        int celoMax=(int)vContadores.get(3); //breedT //pos 3
        int feedT=(int)vContadores.get(5); //feedT //pos 5
        String idT,rec;
      //  cuna.setHayTiburon(true);
           Tiburon tibActual;
           tibActual = new Tiburon(vidaMax,celoMax,feedT);//lifeSpanT //pos 1 y  feedT //pos 5
           idT=creaIdBichoEnNivel(cuna,vContadores,padre.getIdBicho());
            tibActual.nace(cuna,idT);
            this.ponEnNivel(cuna,tibActual,test);
//            pongoEnMar(cuna,tibActual);//lo pongo en el mar
//           incrementaContadorTiburones();
           if (test){
                //System.out.print(cuna.getPosicionX()+":"+cuna.getPosicionY()+"|");
                rec="nace tiburon:";
                rec=rec+" "+ tibActual.getIdBichoBreve();
                rec=rec+" del tiburon"+ this.dameIdPadre(idT);
                System.out.println(rec);
           }
    }
    //pre: en vContadores debe estar 
         //lifeSpanT //pos 1
         //breedT //pos 3
        //feedT //pos 5
        //post: 

//      public void colocaEnDestinoPHijo(casilla origen,casilla destino,boolean test){
//      
//    }
//      public void colocaEnDestinoTHijo(casilla origen,casilla destino,boolean test){
//       
//
//             String idTib=dameIdBicho(origen);
//            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setHayTiburon(false);//quito el tiburon en el origen
//            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setIdBicho("");//quito el indice de bicho en la casilla origen
//            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setHayTiburon(true);//pongo el tiburon en el destino
//            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setIdBicho(idTib);//pongo el indice de  bicho en la casilla destino
//            this.casillero1.get(origen.getPosicionY()).get(origen.getPosicionX()).setActualizado(true);//casilla actualizada
//            this.casillero1.get(destino.getPosicionY()).get(destino.getPosicionX()).setActualizado(true);//casilla actualizada
//       
//    }
     
    public void reproduceTiburonEnNivel(Tiburon padre,ArrayList vContadores,boolean test){
         //Pre:
         //Post: decide una casilla destino y crea el tiburon en ella
        casilla destino;
//        int vidaMax=(int)vContadores.get(1);//lifeSpanT   
//        int celoMax=(int)vContadores.get(3);//breedT
//        int feedT=(int)vContadores.get(5);//  feedT 
        destino=decideLugarEnNivel(padre.getPosicion(),test);
        if (destino!=null){
            //creaIdBichoEnNivel(destino,vContadores, padre.getIdBicho());
            partoTiburon(destino,padre,vContadores,test);
        }
       
         
    }
     //Pre:
     //Post: decide una casilla destino y crea el tiburon en ella
     public void reproducePezEnNivel(Pez padre,ArrayList vContadores,boolean test){//,int vidaMax,int celoMax,boolean test){
         //Pre:
         //Post: decide una casilla destino y crea el pez en ella
         casilla destino;   
         destino=decideLugarEnNivel(padre.getPosicion(),test);
         if (destino!=null){
            //creaIdBichoEnNivel(destino,vContadores, padre.getIdBicho());
            partoPez(destino,padre,vContadores,test);
        }
    }
     //Pre:
     //Post: decide una casilla destino y crea el pez en ella
    public void reproduceTiburonesEnNivel(ArrayList vContadores,boolean test){
    //pre: en vContenedores lifeSpanT pos 1  breedT pos 3  feedT pos 5
    //post:reduce el celo de los Tiburones cuando llega el celo a 0 se intenta reproducir
        String rec;
        
        reduceCeloTiburonesEnNivel();
        poneEnCeloTiburonesEnNivel(); 
           for (Tiburon cursor: this.vTiburonesNiv){
                     //if (cursor.getCelo()<=0) {
                    if (cursor.isEnCelo()) {
                          if(test){
                              rec = "el tiburon"+cursor.getIdBichoBreve()+"intenta reproducirse";
                              //rec=rec + " numero tiburones antes de reproduccion :"+this.vTiburonesNiv.size();
                              System.out.println(rec);
                        }
                        reproduceTiburonEnNivel(cursor,vContadores,test);
                    }
               }

          if (this.vTempTiburonNiv.size()>0) {
               this.vTiburonesNiv.addAll(this.vTempTiburonNiv);
               this.vTempTiburonNiv.clear();
           }
          reanudaNoCeloTiburones(vContadores);
    }
    
    public void reduceCeloTiburonesEnNivel(){
    //pre:  
   //post:reduce el celo de todos los Tiburones
        Iterator <Tiburon> cursor=this.vTiburonesNiv.iterator();
           while (cursor.hasNext()){
               cursor.next().reduceCelo();
           }
    }
    //pre:  
   //post:reduce el celo de todos los Tiburones
    public void poneEnCeloTiburonesEnNivel(){
    //pre:  
   //post:pone en celo a los Tiburones si su nivel de celo es inferior a 0
        for (int i = 0; i < this.vTiburonesNiv.size(); i++) {
            if (this.vTiburonesNiv.get(i).getCelo() <= 0) {
                this.vTiburonesNiv.get(i).setEnCelo(true);
            }
 
        }
    } 
    //pre:  
   //post:pone en celo a los Tiburones si su nivel de celo es inferior a 0
    
    public void reduceCeloPecesEnNivel(){
    //pre:  
   //post:reduce el celo de los Peces 
     Iterator <Pez> cursor=this.vPecesNiv.iterator();
           while (cursor.hasNext()){
               cursor.next().reduceCelo();
           }
    }
       //pre:  
   //post:reduce el celo de los Peces 
    public void poneEnCeloPecesEnNivel(){
  //pre:  
   //post:pone en celo a los Peces si su nivel de celo es inferior a 0
        for (int i = 0; i < this.vPecesNiv.size(); i++) {
            if (this.vPecesNiv.get(i).getCelo() <= 0) {
                this.vPecesNiv.get(i).setEnCelo(true);
            }
 
        }
    
    }
     //pre:  
   //post:pone en celo a los Peces si su nivel de celo es inferior a 0
    
    public void reanudaNoCeloPeces(ArrayList vContadores){
 //pre:
 //post: si esta el boolean en celo lo resetea y pone el celo al maximo
     int maxCelo=(int) vContadores.get(4);//breed P pos4
     for (int i = 0; i < this.vPecesNiv.size(); i++) {
         if ( this.vPecesNiv.get(i).isEnCelo()) {
           this.vPecesNiv.get(i).setEnCelo(false);
           this.vPecesNiv.get(i).setCelo(maxCelo);           
         }
     }

 }
  //pre:
 //post: si esta el boolean en celo lo resetea y pone el celo al maximo
    
 public void reanudaNoCeloTiburones(ArrayList vContadores){
 //pre:
 //post: si esta el boolean en celo lo resetea y pone el celo al maximo
     int maxCelo=(int) vContadores.get(3);//breed T pos3
     for (int i = 0; i < this.vTiburonesNiv.size(); i++) {
         if ( this.vTiburonesNiv.get(i).isEnCelo()) {
           this.vTiburonesNiv.get(i).setEnCelo(false);
           this.vTiburonesNiv.get(i).setCelo(maxCelo);           
         }
     }

 }
  //pre:
 //post: si esta el boolean en celo lo resetea y pone el celo al maximo
        
 public void reproducePecesEnNivel(ArrayList vContadores,boolean test){
    //pre:  lifeSpanP pos 2  breedP pos 4
   //post:reduce el celo de los Peces cuando llega el celo a 0 se intenta reproducir
           String rec;
 //        int vidaMax =(int) vContadores.get(2);
 //        int celoMax =(int) vContadores.get(4);
         
//         if (this.vPecesNiv.size() > 0){
//             rec=""+vPecesNiv.size();
//             System.out.println(rec);
           reduceCeloPecesEnNivel();
           poneEnCeloPecesEnNivel();        
         
                for (Pez cursor: this.vPecesNiv){
                     //if (cursor.getCelo()<=0) {
                    if (cursor.isEnCelo()) {
                          if(test){
                              rec = "el pez"+cursor.getIdBichoBreve()+"intenta reproducirse";
                              rec=rec + " numero peces antes de reproduccion :"+this.vPecesNiv.size();
                              System.out.println(rec);
                        }
                        reproducePezEnNivel(cursor,vContadores,test);
                    }
               }
                               
         
           if (this.vTempPezNiv.size()>0) {
               this.vPecesNiv.addAll(this.vTempPezNiv);//añade los bebes Pez a el vector peces
               this.vTempPezNiv.clear();//vacio el vector de bebes
           }
           this.reanudaNoCeloPeces(vContadores);

//        }else {rec="vpecesNiv VACIOOOOOO";
//             System.out.println(rec);
         
                
    }
//pre:  lifeSpanP pos 2  breedP pos 4
   //post:reduce el celo de los Peces cuando llega el celo a 0 se intenta reproducir
 
 
    public int recuentoBichosEnCeloEnNivel(){
    //pre:
   //post:devuelve el numero de bichos que se intentara reproducir 
      return recuentoPecesEnCeloEnNivel()+recuentoTiburonesEnCeloEnNivel();
      
  } //pre:
   //post:devuelve el numero de bichos que se intentara reproducir 

    public int recuentoPecesEnCeloEnNivel(){
    //pre:
   //post:devuelve el numero de peces que se intentara reproducir 
    
     int numPecesEnCelo=0;
        for (Pez P: this.vPecesNiv) {
            if(P.getCelo()<=0){
                numPecesEnCelo++;
            }
        }
        return numPecesEnCelo;
    }
      //pre:
   //post:devuelve el numero de peces que se intentara reproducir 
   
    public int recuentoTiburonesEnCeloEnNivel(){
    //pre:
   //post:devuelve el numero de tiburones que se intentara reproducir 
        int numTiburonesEnCelo=0;
        for (Pez P: this.vPecesNiv) {
            if(P.getCelo()<=0){
                numTiburonesEnCelo++;
            }
        }
        return numTiburonesEnCelo;
    }
      //pre:
   //post:devuelve el numero de tiburones que se intentara reproducir 
    
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
    //pre: x e y deben estar entre tamX y tamY
    //post:muestra por pantalla el runbo y las coordenadas de la casilla Origen
        if(test){
        String dir="se mueve al ";
                dir=dir+dimeQueRumboEs(rumbo);
                System.out.print("origen"+" [X:"+x+" Y:"+y+"]#"+dir);
        }
    }    
    //pre: x e y deben estar entre tamX y tamY
    //post:muestra por pantalla el runbo y las coordenadas de la casilla Origen
    
    public void testeaCasillaDestino(int x,int y, boolean test,int rumbo){
     //pre: x e y deben estar entre tamX y tamY
    //post:muestra por pantalla el runbo y las coordenadas de la casilla Destino
	  if (test){
              String rec = " destino"+" [X:"+x+" Y:"+y+"]";
              System.out.println(rec);
                        }
	
	}
    //pre: x e y deben estar entre tamX y tamY
    //post:muestra por pantalla el runbo y las coordenadas de la casilla Destino
   
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
            String rec = ""+ e.getMessage()+"en dameCasillaDestino" +" valor de X:" + x +" Y:" + y+" y el ultimo rumbo es: ";
            System.out.println(rec);
        }
    return casDestino;
    }
}
     //pre:
         //post:movimientos cartesianos el origen  de coordenadas x=0 y Y=0 esta al SO;
         //rumbo 0://N y++; rumbo 1://NE x++; y++; rumbo 2://E x++; rumbo 3://SE x++; y--; 
         //rumbo 4://S y--; rumbo 5://SO x--; y--; rumbo 6://O x--; rumbo 7://NO x--; y++;
     
