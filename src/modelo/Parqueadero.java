/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author Ricardo J
 */
public class Parqueadero {
    
    private Vehiculo[][] matriz;
    private ArrayList<Vehiculo> listaVehiculos;
    
    public Parqueadero(){
        
        matriz = new Vehiculo[6][5];
        
        listaVehiculos = new ArrayList<>();
        
    }
    
    public Vehiculo[][] getMatriz(){
        return matriz;
    }
    
    public ArrayList<Vehiculo> getListaVehiculos(){
        return listaVehiculos;
    }
    
    public boolean existeVehiculo(String id){
        
        for(Vehiculo v : listaVehiculos){
            
            if(v.getId().equalsIgnoreCase(id)){
                return true;
                
            }
        }
        return false;
    }
    
}
