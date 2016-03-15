package piscifactoria;

/**
 *
 * @author Fernando
 */
public abstract class Acuatico implements serVivo {
    protected casilla posicion;
    protected boolean vivo;
    protected int profundidad;
    
    
    Acuatico(){
    this.vivo=false;
    
    }
    
    
    @Override
    public void nace(casilla cuna){
            this.profundidad=cuna.getNivel();
            this.posicion=cuna;
            this.vivo=true;
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
