/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;

/**
 *
 * @author Fernando
 */
public class casilla {
    private int posicionX;
    private int posicionY;
    private int nivel;
    private boolean hayPez;
    private boolean hayTiburon;
    private boolean actualizado;
    private String idBicho;
    private String idBicho2;
    
    
       public casilla(){
     }
    
    public casilla(int x,int y){//, int nivel){
        this.posicionX=x;
        this.posicionY=y;
        this.hayPez=false;
        this.hayTiburon=false;
        this.actualizado=false;
        this.idBicho="";
        this.idBicho="";
        //this.nivel=nivel;
    }
    
    public void actualizada(){
        this.actualizado=true;
    }
    
    public void noActualizada(){
        this.actualizado=false;
    }
    
    public void borraTiburon(){
        this.hayTiburon=false;
        this.idBicho="";
    }
    public void borraPez(){
        this.hayPez=false;
        this.idBicho="";
    }
    
    public void PonTiburon(String idTib){
        if (this.hayPez) {//devorara al siguiente
            this.setIdBicho2(this.getIdBicho());//paso el id del pez cazado al indiceBicho2
        }
        this.setHayTiburon(true);//pongo el tiburon en el destino
        this.setIdBicho(idTib);//pongo el indice de  bicho en la casilla destino
        this.actualizada();
            
    }
    
    public boolean hayCaza(){
        return (this.isHayTiburon())&&(this.isHayPez());
    }
    
  
    public String  devoraPez(){
        //pre:
        //post: devolvemos el id del pez devorado y lo eliminamos de la casilla
        
        
                    String idPez=this.getIdBicho2();
                    this.setIdBicho2("");//Quitamos la referencia al id del pez
                    this.setHayPez(false);//borramos al pez de la casilla
                    return idPez;
    }

    public String getIdBicho() {
        return idBicho;
    }

    public void setIdBicho(String idBicho) {
        this.idBicho = idBicho;
    }

    public String getIdBicho2() {
        return idBicho2;
    }

    public void setIdBicho2(String idBicho2) {
        this.idBicho2 = idBicho2;
    }



    public boolean isActualizado() {
        return actualizado;
    }

    public void setActualizado(boolean actualizado) {
        this.actualizado = actualizado;
    }
    
   
    
  

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public boolean isHayPez() {
        return hayPez;
    }

    public boolean isHayTiburon() {
        return hayTiburon;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public void setHayPez(boolean hayPez) {
        this.hayPez = hayPez;
    }

    public void setHayTiburon(boolean hayTiburon) {
        this.hayTiburon = hayTiburon;
    }
    
     public String getIdBichoBreve(){
        String [] piezas=this.idBicho.split("#");
        
    return piezas[0]+"#"+piezas[2]+"#"+piezas[3];
    }
    
    
    public String pintaCasilla(int x,int y,int tamX, int tamY,boolean P,boolean T,boolean test){
      
  //String tib=console.getStringInColor(console.ANSI_PURPLE,"T");  
//        String pez=console.getStringInColor(console.ANSI_GREEN,"P");
//        String ira=console.getStringInColor(console.ANSI_RED,"X");
//        String cas=console.getStringInColor(console.ANSI_RESET,"");
//        String cas=console.getStringInColor(console.ANSI_BLUE,"");
        String reset=console.getStringInColor(console.ANSI_RESET,"");
        
        String tib="T"; 
        String pez="P";
        String ira="X";
        String cas="";
        //if (test){tib=console.getStringInColor(console.ANSI_RED,"T")+reset;}
        tib=console.getStringInColor(console.ANSI_RED,"T")+reset;
        String trazo=cas+"";
       if (T||P){ //HAY BICHO
           if(T&&P){ //BREED tiburon come pez
                 if(x==0 ){//casillas del lateral izquierdo
                trazo="/_"+ira+"/";
                }
                else if(x==tamX-1 && y==0){//casilla del inferior derecha
                   // trazo="_"+ira+"|/";
                    trazo="_"+ira+"/|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_"+ira+"/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_"+ira+"/|";
                }else trazo="_"+ira+"/";
           }else if(T){//Hay tiburon
                if(x==0 ){//casillas del lateral izquierdo
                trazo="/_"+tib+"/";
                }
                else if(x==tamX-1 && y==0){//casilla del inferior derecha
                   // trazo="_"+tib+"|/";
                    trazo="_"+tib+"/|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_"+tib+"/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_"+tib+"/|";
                }else trazo="_"+tib+"/";
           }else{//hay pez
                if(x==0 ){//casillas del lateral izquierdo
                trazo="/"+pez+"_/";
                }
                else if(x==tamX-1 && y==0){//casilla del inferior derecha
                   // trazo="_"+pez+"|/";
                    trazo="_"+pez+"/|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_"+pez+"/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_"+pez+"/|";
                }else trazo="_"+pez+"/";

           }
           
           
           
       }else{ //casilla vacia
           
            if(x==0){//casillas del lateral izquierdo
                trazo="/__/";
            }
            else if(x==tamX-1 && y==0){//casilla del inferior derecha
                //trazo="__|/";
                 trazo="__/|/";
            }
            else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                trazo="__/|/";
            }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                trazo="__/|";
            }else trazo="__/";
       }
            
    return trazo;
    }
    

}
