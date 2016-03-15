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
     */
    void nace(casilla cuna);
    casilla mueve();
    casilla reproduce();
    casilla muere();
}
