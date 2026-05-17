/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import modelo.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Ricardo J
 */
public class ArchivoCSV {

    // GUARDAR
    public static void guardarVehiculos(
            ArrayList<Vehiculo> lista
    ) {

        try {

            FileWriter archivo;

            archivo = new FileWriter(
                    "vehiculos.csv"
            );

            PrintWriter escritor;

            escritor = new PrintWriter(archivo);

            for (Vehiculo v : lista) {

                escritor.println(

                        v.getTipo()
                        + ","

                        + v.getId()
                        + ","

                        + v.getFila()
                        + ","

                        + v.getColumna()
                        + ","

                        + v.isPagado()
                );
            }

            escritor.close();

        }

        catch (Exception e) {

            System.out.println(
                    "Error guardando CSV"
            );
        }
    }

    // CARGAR
    public static ArrayList<Vehiculo>
    cargarVehiculos() {

        ArrayList<Vehiculo> lista;

        lista = new ArrayList<>();

        try {

            BufferedReader lector;

            lector = new BufferedReader(
                    new FileReader("vehiculos.csv")
            );

            String linea;

            while ((linea = lector.readLine())
                    != null) {

                String[] datos;

                datos = linea.split(",");

                String tipo;
                String id;

                int fila;
                int columna;

                boolean pagado;

                tipo = datos[0];

                id = datos[1];

                fila = Integer.parseInt(datos[2]);

                columna = Integer.parseInt(datos[3]);

                pagado = Boolean.parseBoolean(
                        datos[4]
                );

                Vehiculo v;

                // CREAR OBJETOS
                if (tipo.equals("CARRO")) {

                    v = new Carro(
                            id,
                            fila,
                            columna,
                            false
                    );
                }

                else if (tipo.equals("MOTO")) {

                    v = new Moto(
                            id,
                            fila,
                            columna,
                            false
                    );
                }

                else {

                    v = new Bicicleta(
                            id,
                            fila,
                            columna
                    );
                }

                v.setPagado(pagado);

                lista.add(v);
            }

            lector.close();
        }

        catch (Exception e) {

            System.out.println(
                    "No existe archivo CSV"
            );
        }

        return lista;
    }
}
