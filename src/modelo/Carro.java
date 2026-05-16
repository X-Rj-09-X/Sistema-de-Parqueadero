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

    public Carro(String placa, boolean discapacitado){
        
        super(placa, "CARRO", discapacitado);
        
    }
    
    @Override
    public double calcularPago(long minutos){
        return minutos * 50;
    }
    
  
    
}
