
/**
 * Clase que representa accesos a un servidor con una fecha (yyyy-mm-dd) y hora(hh-mm).
 *
 * @author Didac Fernandez Fernandez
 * @version 2018-02-23
 */
public class Acceso
{
    // El ano del acceso
    private int ano;
    // El mes del acceso
    private int mes;
    // El dia del acceso
    private int dia;
    // La hora del acceso
    private int hora;
    // El minuto del acceso
    private int min;

    /**
     * Constructor para objetos de la clase Acceso
     * @param  ano  El ano en el que se realiza el acceso
     * @param  mes  El mes en el que se realiza el acceso
     * @param  dia  El dia en el que se realiza el acceso
     * @param  hora  La hora en el que se realiza el acceso
     * @param  min  El minuto en el que se realiza el acceso
     */
    public Acceso(int ano,int mes,int dia,int hora,int min)
    {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.min = min;
    }

    /**
     * @return    La hora del acceso
     */
    public int getHora()
    {
        return hora;
    }
}
