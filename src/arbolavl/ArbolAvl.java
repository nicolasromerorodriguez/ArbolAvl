/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author nicol
 */
public class ArbolAvl <T extends Comparable<T>> implements Arbol<T>{

    private Nodo<T> raiz;
    
    @Override
    public Arbol<T> insertar(T data){
        raiz =  insertar(data, raiz);
        return this;
    }
    
    
    private Nodo<T> insertar(T data, Nodo<T> nodo) {
        if (nodo == null){
            return new Nodo<>(data);
        }
        
        if(data.compareTo(nodo.getData()) < 0 ){
            nodo.setHijoIq(insertar(data, nodo.getHijoIq()));
        } else if (data.compareTo(nodo.getData()) >0){
            nodo.setHijoDer(insertar(data, nodo.getHijoDer()));
        } else {
            return nodo;
        }
        
        actualizarAltura(nodo);
        return aplicarRotacion(nodo);
        
  
    }

    @Override
    public void borrar(T data) {
        raiz = borrar(data, raiz);
    }
    
    private Nodo<T> borrar(T data, Nodo<T> nodo){
        if (nodo == null){
            return null;
        }
        
        if(data.compareTo(nodo.getData()) < 0 ){
            nodo.setHijoIq(borrar(data, nodo. getHijoIq()));
        } else if (data.compareTo(nodo.getData()) > 0 ){
            nodo.setHijoDer(borrar(data, nodo. getHijoDer()));
        } else //Un solo hijo o ningun hijo
        {if (nodo.getHijoIq() == null){
            return nodo.getHijoDer();
            
        } else if (nodo.getHijoDer() == null){
            return nodo.getHijoIq();
        }
        
        //2 hijos
        //nodo.setData(getMax(nodo.getHijoIq()));
        nodo.setHijoIq(borrar(nodo.getData(), nodo.getHijoIq()));
            
    }
        actualizarAltura(nodo);
        return aplicarRotacion(nodo);
    }
    @Override
    public void recorrer() {
        recorrerOrdenado(raiz);
    }
    
    private void recorrerOrdenado(Nodo<T> nodo){
        if(nodo != null){
            recorrerOrdenado(nodo.getHijoIq());
            System.out.println(nodo);
            recorrerOrdenado(nodo.getHijoDer());
        }
    }

    @Override
    public T getMax(){
        if (isEmpty()){
            return null;
        }
        return getMax(raiz);
    }
    
    private T getMax(Nodo <T> nodo) {
        if (nodo.getHijoDer() != null){
            return getMax(nodo.getHijoDer());
        }
        return nodo.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(raiz);
    }
    
    private T getMin(Nodo <T> nodo) {
        if (nodo.getHijoIq() != null){
            return getMin(nodo.getHijoIq());
        }
        return nodo.getData();
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }
    
    
     private Nodo<T> aplicarRotacion(Nodo<T> nodo) {
        int balance = balance(nodo);
        if (balance > 1) {
            if (balance(nodo.getHijoIq()) < 0) {
                nodo.setHijoIq(rotarIzquierda(nodo.getHijoIq()));
            }
            return rotarDerecha(nodo);
        }
        if (balance < -1) {
            if (balance(nodo.getHijoDer()) > 0) {
                nodo.setHijoDer(rotarDerecha(nodo.getHijoDer()));
            }
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

    private Nodo<T> rotarDerecha(Nodo<T> nodo) {
        Nodo<T> nodoIzquierdo = nodo.getHijoIq();
        Nodo<T> centerNode = nodoIzquierdo.getHijoDer();
        nodoIzquierdo.setHijoDer(nodo);
        nodo.setHijoIq(centerNode);
        actualizarAltura(nodo);
        actualizarAltura(nodoIzquierdo);
        return nodoIzquierdo;
    }

    private Nodo<T> rotarIzquierda(Nodo<T> nodo) {
        Nodo<T> nodoDerecho = nodo.getHijoDer();
        Nodo<T> centerNode = nodoDerecho.getHijoIq();
        nodoDerecho.setHijoIq(nodo);
        nodo.setHijoDer(centerNode);
        actualizarAltura(nodo);
        actualizarAltura(nodoDerecho);
        return nodoDerecho;
    }

    private void actualizarAltura(Nodo<T> nodo) {
        int alturaMax = Math.max(
                altura(nodo.getHijoIq()),
                altura(nodo.getHijoDer())
        );
        nodo.setAltura(alturaMax + 1);
    }

    private int balance(Nodo<T> nodo) {
        return nodo != null ? altura(nodo.getHijoIq()) - altura(nodo.getHijoDer()) : 0;
    }

    private int altura(Nodo<T> nodo) {
        return nodo != null ? nodo.getAltura(): 0;
    }
    
    
    
}
