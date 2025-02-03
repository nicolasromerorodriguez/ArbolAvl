/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolavl;

/**
 *
 * @author nicol
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Arbol<Integer> arbolAvl = new ArbolAvl<>();
        arbolAvl.insertar(45).insertar(80).insertar(70).insertar(103).insertar(10).insertar(110);
        arbolAvl.borrar(45);
        arbolAvl.insertar(7).insertar(90).insertar(100).insertar(85).insertar(87).insertar(103).insertar(90).insertar(102).insertar(107).insertar(114).insertar(73);
        arbolAvl.borrar(100);
        arbolAvl.borrar(90);
        
        arbolAvl.recorrer();
        
        System.out.println("El maximo es: "+ arbolAvl.getMax());
        System.out.println("El minimo es: "+ arbolAvl.getMin());
        
     

       arbolAvl.recorrer();
        
    }
    
}
