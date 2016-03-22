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
public class Tiburon extends Acuatico {
    protected int energia;
   
    
    Tiburon(int MaxVida,int maxHambre){
        this.vida=MaxVida;
        this.energia=maxHambre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

   

    
    
    
    @Override
    public casilla mueve(casilla origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public casilla reproduce(casilla cuna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    

 
    
   
}
