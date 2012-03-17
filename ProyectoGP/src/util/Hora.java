package util;

import java.util.Calendar;
import java.util.Date;

public class Hora {

    String horaActual;
    
    @SuppressWarnings("deprecation")
    public String obtenerHora() {
	
        Calendar calendario = Calendar.getInstance();
        Date time = calendario.getTime();
        int hora = time.getHours();
        int minutos = time.getMinutes();
        String tanda;
        if(hora >= 12)
        {
            hora -= 12;
            tanda = " PM ";
        } else
        {
            tanda = " AM ";
        }
        return horaActual = (new StringBuilder(String.valueOf(hora))).append(":").append(minutos).append(tanda).toString();
    }
}
