/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Ricardo J
 */
public class ControladorParqueadero {
    
    private Parqueadero parqueadero;
    private int contadorBicicletas;
    
    
    public ControladorParqueadero(){
        
        parqueadero = new Parqueadero();
        
        contadorBicicletas = 1;
        
    }
    
    public Parqueadero getParqueadero(){
        return parqueadero;
        
    }
    
    public String generarIdBicicleta(){
        
        String id = String.format("%03d", contadorBicicletas);
        
        contadorBicicletas++;
        
        return id;
    }
    
    public String ingresarVehiculo(
                int tipo,
                String id,
                boolean discapacitado
    
    ){
        Vehiculo v = null;
        
        //carro
        if (tipo == 0){
            
            v = new Carro(id, discapacitado);
            
        }
        
        //moto
        else if(tipo == 1){
            
            v = new Moto(id, discapacitado);
            
        }
        
        //bicicleta
        else if(tipo == 2){
            
            id = generarIdBicicleta();
            
            v = new Bicicleta(id);
            
        }
        
        //validar repetidos
        if(parqueadero.existeVehiculo(v.getId())){
            
            return "El vehiculo ya existe.";
        }
        
        //agregar vehiculo
        boolean agregado = parqueadero.agregarVehiculo(v);
        
        //validar espacio
        if(!agregado){
            
            return "Parqueadero lleno";
        }
        
        //generar el tiket
        return generarTicket(v);
    }
    
    public String generarTicket(Vehiculo v){
        
        DateTimeFormatter formato;
        
        formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        String ticket = "";
        
        ticket += "========== TICKET ==========\n";

        ticket += "ID: " + v.getId() + "\n";

        ticket += "Tipo: " + v.getTipo() + "\n";

        ticket += "Fila: " + (v.getFila() + 1) + "\n";

        ticket += "Columna: " + (v.getColumna() + 1) + "\n";

        ticket += "Hora Entrada: ";

        ticket += v.getHoraEntrada().format(formato) + "\n";

        ticket += "============================";

        return ticket;
        
    }
    
    public String salidaVehiculo(String id){
        
        //buscar vehiculo
        Vehiculo v;
        
        v = parqueadero.buscarVehiculo(id);
        
        //validar que existe
        if (v == null){
            
            return "Vehiculo no encontrado";
            
        }
        
        //validar pago
        if (!v.isPagado()){
            
            //biciciletas no pagan
            if(!v.getTipo().equals("BICI")){
                
                return "Debe realizar el pago";
            }
        }
        
        //liberar matriz
        parqueadero.getMatriz()[v.getFila()][v.getColumna()] = null;
        
        //eliminar del array
        parqueadero.getListaVehiculos().remove(v);
        
        return "Salida realizada correctamente";
    }
    
    
    
    
}
