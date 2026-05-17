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
    private double totalDia;
    private double totalSemana;
    private double totalMes;
    private int contadorBicicletas;
    
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
    
    public boolean agregarVehiculo(Vehiculo v){
        
        //filas para usar
        int filaInicio = 0;
        int filaFin = 0;
        
        //discapacitados
        if(v.isDiscapacitado()){
            
            filaInicio = 0;
            filaFin = 0;
            
        }
        
        //bicicletas
        else if (v.getTipo().equals("BICICLETA")){
            
            filaInicio = 1;
            filaFin = 1;
            
        }
        
        //motos
        else if(v.getTipo().equals("MOTO")){
            
            filaInicio = 2;
            filaFin = 3;
            
        }
        
        //carro
        else{
            
            filaInicio = 4;
            filaFin = 5;
            
        }
        
        //buscar cupo
        for(int i = filaInicio; i <= filaFin; i++){
            
            for(int j = 0; j < 5; j++){
                
                //cupo libre
                if(matriz[i][j] == null){
                    
                    //guardar en la matriz
                    matriz[i][j] = v;
                    
                    //guardar posicion
                    v.setFila(i);
                    v.setColumna(j);
                    
                    //agregar a la lista
                    listaVehiculos.add(v);
                    
                    return true;
                }
            }
        }
        
        //no hay cupo
        return false;
    }
    
    public Vehiculo buscarVehiculo(String id){
        
        for(Vehiculo v : listaVehiculos){
            
            if(v.getId().equalsIgnoreCase(id)){
                return v;
                
            }
            
        }
        
        return null;
    }
    
    
    public double getTotalDia() {
        return totalDia;
        
    }   

    public void setTotalDia(double totalDia) {
        
        this.totalDia = totalDia;
    }

    public double getTotalSemana() {
        
        return totalSemana;
    }

    public void setTotalSemana(double totalSemana) {
        
        this.totalSemana = totalSemana;
    }

    public double getTotalMes() {
        
        return totalMes;
    }

    public void setTotalMes(double totalMes) {
        
        this.totalMes = totalMes;
    }
    
    public int getContadorBicicletas() {

    return contadorBicicletas;
    }

    public void setContadorBicicletas(
            int contadorBicicletas
    ) {

        this.contadorBicicletas =
                contadorBicicletas;
    }
    
}
