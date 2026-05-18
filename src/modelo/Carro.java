/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ricardo J
 */
public class Carro extends Vehiculo {

    public Carro(String id, boolean discapacitado){
        
        super(id, "CARRO", discapacitado);
        
    }
    
    public Carro(
            String id,
            int fila,
            int columna,
            boolean discapacitado
    ) {

        super(id, "CARRO", fila, columna, discapacitado);
        
    }
    
    @Override
    public double calcularPago(long minutos){
        return minutos * 50;
    }
    
  
    
}
