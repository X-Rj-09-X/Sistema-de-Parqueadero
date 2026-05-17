/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDateTime;


/**
 *
 * @author Ricardo J
 */
public class ControladorParqueadero {
    
    private Parqueadero parqueadero;
    private int contadorBicicletas;
    private final String USUARIO_ADMIN = "admin";
    private final String CONTRASENA_ADMIN = "123";
    
    
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
    
    public String pagarVehiculo(

        String id,
        boolean empleado,
        String codigoEmpleado,
        double valorCompras
    ){

        // BUSCAR VEHICULO
        Vehiculo v;

        v = parqueadero.buscarVehiculo(id);

        // VALIDAR EXISTENCIA
        if (v == null) {

            return "Vehículo no encontrado";
        }

        // BICICLETAS NO PAGAN
        if (v.getTipo().equals("BICICLETA")) {

            v.setPagado(true);

            return "Las bicicletas no pagan";
        }

        // VALIDAR EMPLEADO
        if (empleado) {

            if (codigoEmpleado.equals("123")) {

                v.setPagado(true);

                return "Pago realizado: EMPLEADO GRATIS";
            }
        }

        // CALCULAR TIEMPO
        LocalDateTime ahora;

        ahora = LocalDateTime.now();

        Duration duracion;

        duracion = Duration.between(
                v.getHoraEntrada(),
                ahora
        );

        long minutos;

        minutos = duracion.toMinutes();

        // CORTESIA 15 MINUTOS
        minutos = minutos - 15;

        if (minutos < 0) {

            minutos = 0;
        }

        // CALCULAR PAGO
        double total;

        total = v.calcularPago(minutos);

        // DESCUENTO 3 HORAS
        if (valorCompras >= 100000) {

            total = 0;
        }

        // DESCUENTO 25%
        else if (valorCompras >= 50000) {

            total = total * 0.75;
        }

        // MARCAR PAGADO
        v.setPagado(true);

        // ACUMULAR CONTABILIDAD
        parqueadero.setTotalDia(
                parqueadero.getTotalDia() + total
        );

        parqueadero.setTotalSemana(
                parqueadero.getTotalSemana() + total
        );

        parqueadero.setTotalMes(
                parqueadero.getTotalMes() + total
        );

        return "Pago realizado correctamente\n"
                + "Tiempo: " + minutos + " minutos\n"
                + "Valor pagado: $" + total;
    }
    
    
    public boolean validarAdmin(
        String usuario,
        String contrasena
    ) {

        return usuario.equals(USUARIO_ADMIN)
                &&
                contrasena.equals(CONTRASENA_ADMIN);
    }
    
    
    
    
}
