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
public interface serVivo {

    /**
     *
     * @param cuna
     * @param tumba
     */
    void nace(casilla cuna);
    casilla mueve(casilla origen);
    casilla reproduce(casilla cuna);
    void muere(casilla tumba);
}
