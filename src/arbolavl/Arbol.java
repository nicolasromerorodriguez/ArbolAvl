/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arbolavl;

/**
 *
 * @author nicol
 */


public interface Arbol <T extends Comparable<T>> {
    
    Arbol<T> insertar(T data);
    
    void borrar(T data);
    
    
    //Pendiente de implementar
    void recorrer();
    
    T getMax();
    
    T getMin();
    
    boolean isEmpty();
    
}
