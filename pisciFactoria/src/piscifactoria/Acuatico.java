package piscifactoria;

/**
 *
 * @author Fernando
 */
public abstract class Acuatico implements serVivo {
    protected casilla posicionInicial;
    protected boolean vivo;
    protected boolean enCelo;
    protected int profundidad;
    protected String idBicho;
    protected String idBichoBreve;

    public casilla getPosicionInicial() {
        return posicionInicial;
    }

    public String getIdBichoBreve() {
        return idBichoBreve;
    }
    protected int vida;
    protected int celo;
    
    Acuatico(){
    this.vivo=false;
    this.enCelo=false;
    
    }
  
    public boolean isEnCelo() {
        return enCelo;
    }

    public void setEnCelo(boolean enCelo) {
        this.enCelo = enCelo;
    }
    

    public int getCelo() {
        return celo;
    }

    public void setCelo(int celo) {
        this.celo = celo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

  
    
    

    public String getIdBicho() {
        return idBicho;
    }

    public void setIdBicho(String idBicho) {
        this.idBicho = idBicho;
    }
    
    
    @Override
    public void nace(casilla cuna){
            this.profundidad=cuna.getNivel();
            this.posicionInicial=cuna;
            this.vivo=true;
    }
    public void nace(casilla cuna,String id){
            this.profundidad=cuna.getNivel();
            this.posicionInicial=cuna;
            this.vivo=true;
            this.idBicho=id;    
            String [] piezas;
            piezas = this.idBicho.split("#");
            this.idBichoBreve=piezas[2]+"#"+piezas[2]+"#"+piezas[3];
    }
    @Override
    public void muere(casilla tumba){
        this.profundidad=tumba.getNivel();
        this.posicionInicial=tumba;
        this.vivo=false;   
    }
    
      
//    public void nace(casilla cuna){
//        this.profundidad=cuna.getNivel();
//        this.posicion=cuna;
//        this.vivo=true;
//    }
    public casilla getPosicion() {
        return posicionInicial;
    }

    public void setPosicion(casilla posicion) {
        this.posicionInicial = posicion;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public void reduceVida(){
        this.vida--;
    }
    public void reduceCelo(){
        this.celo--;
    }
}
