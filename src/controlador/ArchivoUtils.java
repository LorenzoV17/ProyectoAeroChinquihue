package controlador;

import java.io.*;
import java.util.List;

public class ArchivoUtils {

    public static void guardarDatos(String archivo, List<String> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String dato : datos) {
                bw.write(dato);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatos(String archivo, List<String> datos) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}