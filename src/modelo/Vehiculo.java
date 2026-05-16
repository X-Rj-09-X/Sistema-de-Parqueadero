/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDateTime;

/**
 *
 * @author Ricardo J
 */
public abstract class Vehiculo {
    
    private String id;
    private String tipo;
    private boolean discapacitado;
    private boolean pagado;
    private int fila;
    private int columna; 
    private LocalDateTime horaEntrada;

    public Vehiculo(String id, String tipo, boolean discapacitado) {
        this.id = id;
        this.tipo = tipo;
        this.discapacitado = discapacitado;
        this.pagado = false;
        this.horaEntrada = LocalDateTime.now();
        
    }
    
    public abstract double calcularPago(long minutos);
    
    
    

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public boolean isPagado() {
        return pagado;
    }
    
    public void setPagado(boolean pagado){
        this.pagado = pagado;
        
    }

    public int getFila() {
        return fila;
    }
    
    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public void setColumna(int columna){
        this.columna = columna;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
    
    
    
    
   
    
    
}
