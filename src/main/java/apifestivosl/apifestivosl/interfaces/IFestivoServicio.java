package apifestivosl.apifestivosl.interfaces;

import java.util.Date;
import java.util.List;

import apifestivosl.apifestivosl.entities.Festivo;

public interface IFestivoServicio {

    public List<Festivo> obtenerFestivos(int año);

    public boolean esFechaValida(String strFecha);

    public boolean esFestivo(Date Fecha);

}
