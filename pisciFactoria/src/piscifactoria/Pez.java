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
public class Pez extends Acuatico {
    

   
    
    Pez(int MaxVida){//constructor
        this.vida=MaxVida;
    }
    Pez(int MaxVida,int MaxCelo){//constructor
        this.vida=MaxVida;
        this.celo=MaxCelo;
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
