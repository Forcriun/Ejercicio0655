import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class AnalizadorAccesoServidor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnalizadorAccesosAServidor
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor de objetos de la clase AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor(){    
    }

    /**
     * Metodo que lee y analiza un archivo de log indicado por parametro. El 
     * archivo debe estar almacenado en el directorio del proyecto.
     * @param log El nombre del archivo
     */
    public void analizarArchivoDeLog(String log){
        HashMap<Integer,ArrayList<Acceso>> mapaHoras = new HashMap<>();
        ArrayList<Acceso> listaAccesos = new ArrayList<>();

        try {
            File archivo = new File(log);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String[] datosAcceso = sc.nextLine().split(" ");
                if(mapaHoras.containsKey(Integer.parseInt(datosAcceso[3]))){
                    mapaHoras.get(Integer.parseInt(datosAcceso[3])).add(new Acceso(Integer.parseInt(datosAcceso[0]),
                            Integer.parseInt(datosAcceso[1]),Integer.parseInt(datosAcceso[2]),
                            Integer.parseInt(datosAcceso[3]),Integer.parseInt(datosAcceso[4])));
                }
                else{
                    mapaHoras.put(Integer.parseInt(datosAcceso[3]),listaAccesos);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
