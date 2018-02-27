import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Clase que representa objetos capaces de leer, analizar y procesar datos de registros de acceso a
 * un servidor.
 *
 * @author Didac Fernandez Fernandez
 * @version 2018-02-23
 */
public class AnalizadorAccesosAServidor
{    
    HashMap<Integer,ArrayList<Acceso>> mapaHoras;

    /**
     * Constructor de objetos de la clase AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor(){
        mapaHoras = new HashMap<>();
    }

    /**
     * Metodo que lee y analiza un archivo de log indicado por parametro. El 
     * archivo debe estar almacenado en el directorio del proyecto.
     * @param log El nombre del archivo
     */
    public void analizarArchivoDeLog(String log){
        mapaHoras.clear();  // vacia el mapa para poder almacenar los datos del siguiente archivo

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
                    ArrayList<Acceso> listaAccesos = new ArrayList<>();
                    mapaHoras.put(Integer.parseInt(datosAcceso[3]),listaAccesos);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que devuelve y muestra por pantalla la hora a la que se producen mas accesos al
     * servidor. En caso de empate devuelve la hora mas alta.
     *
     * @return    La hora con mas accesos. Si no hay datos en el registro devuelve -1
     */
    public int obtenerHoraMasAccesos()
    {
        int aDevolver = -1;
        int totalAccesos = 0;

        if(!mapaHoras.isEmpty()){
            for(ArrayList<Acceso> listaAccesos : mapaHoras.values()){       // Recorre todos los valores del mapa, y al ser listas de accesos
                if(listaAccesos.get(0).getHora() > aDevolver && listaAccesos.size() >= totalAccesos){   // puede acceder a las horas evitando utilizar un conjunto para almacenar las claves,
                    totalAccesos = listaAccesos.size();     // el uso de un bucle para la busqueda de mayor numero de accesos
                    aDevolver = listaAccesos.get(0).getHora();      // y otro para la hora mas alta con ese numero de accesos
                }
            }            
            System.out.println("La hora con mas accesos al servidor es: " + aDevolver);
        }
        else{
            System.out.println("No existen datos de acceso al servidor");
        }

        return aDevolver;
    }
}
