package piscifactoria;

/**
 *
 * @author Fernando
 */
public abstract class Acuatico implements serVivo {
    protected casilla posicion;
    protected boolean vivo;
    protected int profundidad;
    protected String idBicho;
    
    
    Acuatico(){
    this.vivo=false;
    
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
            this.posicion=cuna;
            this.vivo=true;
    }
    public void nace(casilla cuna,String id){
            this.profundidad=cuna.getNivel();
            this.posicion=cuna;
            this.vivo=true;
            this.idBicho=id;
    }
    @Override
    public void muere(casilla tumba){
        this.profundidad=tumba.getNivel();
        this.posicion=tumba;
        this.vivo=false;   
    }
    
      
//    public void nace(casilla cuna){
//        this.profundidad=cuna.getNivel();
//        this.posicion=cuna;
//        this.vivo=true;
//    }
    public casilla getPosicion() {
        return posicion;
    }

    public void setPosicion(casilla posicion) {
        this.posicion = posicion;
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


    
}
