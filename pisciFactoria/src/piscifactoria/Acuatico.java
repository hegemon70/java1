package piscifactoria;

/**
 *
 * @author Fernando
 */
public abstract class Acuatico implements serVivo {
    protected casilla posicion;
    protected boolean vivo;
    protected nivel profundidad;
    
    
    Acuatico(){
    this.vivo=false;
    
    }
    
    
    @Override
    public casilla nace(){
        casilla casIni =new casilla();
      return   casIni;
    }
    
      
    public casilla nace(casilla cuna){
      
      return   cuna;
    }
  

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

    public nivel getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(nivel profundidad) {
        this.profundidad = profundidad;
    }


    
}
