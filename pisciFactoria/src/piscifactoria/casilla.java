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
    //public int nivel;
    private boolean hayPez;
    private boolean hayTiburon;
    
     public casilla(){
     }
    
    public casilla(int x,int y){//, int nivel){
        this.posicionX=x;
        this.posicionY=y;
        this.hayPez=false;
        this.hayTiburon=false;
        //this.nivel=nivel;
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
    
    
    
    public String pintaCasilla(int x,int y,int tamX, int tamY,boolean T,boolean P){
        
        String trazo="";
       if (T||P){ //HAY BICHO
           if(T&&P){ //BREED tiburon come pez
                if(x==0 && y!=tamY-1){//casillas del lateral izquierdo
                    trazo="/_X/";
                }
                else if(x==tamX && y==0){//casilla del inferior derecha
                    trazo="_X|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_X/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_X/|";
                }else trazo="_X/";//casilla normal
           }else if(T){//Hay tiburon
                if(x==0 && y!=tamY-1){//casillas del lateral izquierdo
                    trazo="/_T/";
                }
                else if(x==tamX && y==0){//casilla del inferior derecha
                    trazo="_T|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_T/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_T/|";
                }else trazo="_T/";//casilla normal
           }else{//hay pez
               if(x==0 && y!=tamY-1){//casillas del lateral izquierdo
                    trazo="/_P/";
                }
                else if(x==tamX && y==0){//casilla del inferior derecha
                    trazo="_P|/";
                }
                else if((x==tamX-1) && (y!=tamY-1)){ //casillas del lateral derecho
                    trazo="_P/|/";
                }else if ((x==tamX-1)&& y==tamY-1){ //casilla superior derecha
                    trazo="_P/|";
                }else trazo="_P/";//casilla normal
               
               
           }
           
           
           
       }else{ //casilla vacia
           
            if(x==0 && y!=tamY-1){//casillas del lateral izquierdo
                trazo="/__/";
            }
            else if(x==tamX && y==0){//casilla del inferior derecha
                trazo="__|/";
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
