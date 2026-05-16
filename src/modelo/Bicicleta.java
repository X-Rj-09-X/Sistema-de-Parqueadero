/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ricardo J
 */
public class Bicicleta extends Vehiculo{
    
    public Bicicleta(String id, boolean discapacitado){
        super(id, "BICI", discapacitado);
    }
    
    
    @Override
    public double calcularPago(long minutos){
        return minutos * 0;
    }
}
