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
    
    public Bicicleta(String id){
        super(id, "BICI", false);
    }
    
    public Bicicleta(
            String id,
            int fila,
            int columna
    ) {

        super(
                id,
                "BICI",
                fila,
                columna,
                false
        );
    }
    
    
    @Override
    public double calcularPago(long minutos){
        return 0;
    }
}
