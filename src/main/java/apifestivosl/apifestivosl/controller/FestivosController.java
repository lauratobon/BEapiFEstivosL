package apifestivosl.apifestivosl.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apifestivosl.apifestivosl.interfaces.IFestivoServicio;
import apifestivosl.apifestivosl.entities.Festivo;

@RestController
@RequestMapping("/diafestivo")
public class FestivosController {

    @Autowired
    private IFestivoServicio servicio;

    @GetMapping(value = "/validarf/{año}/{mes}/{dia}")
    public String validarfestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        System.out.println("año " + año + " mes " + mes + " dia " + dia);
        boolean validacion = servicio
                .esFechaValida(String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia));
        System.out.println(validacion);
        if (validacion) {

            Date fecha = new Date(año - 1900, mes - 1, dia);
            System.out.println(fecha);
            String resultado = servicio.esFestivo(fecha) ? "Día festivo" : "Día NO festivo";
            return resultado;

        } else {
            return "fecha NO válida, intente nuevamente";
        }
    }

    @GetMapping(value = "/listar/{año}")
    public List<Festivo> listar(@PathVariable int año) {
        return servicio.obtenerFestivos(año);

    }
}
