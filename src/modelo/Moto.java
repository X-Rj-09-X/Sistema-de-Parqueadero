/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ricardo J
 */
public class Moto extends Vehiculo{
    
    public Moto(String id, boolean discapacitado){
        super(id, "MOTO", discapacitado);
        
    }
    
    public Moto(
            String id,
            int fila,
            int columna,
            boolean discapacitado
    ) {

        super(
                id,
                "MOTO",
                fila,
                columna,
                discapacitado
        );
    }
    
    @Override
    public double calcularPago(long minutos){
        return minutos * 35;
    }
    
    
}
