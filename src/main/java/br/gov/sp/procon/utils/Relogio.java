package br.gov.sp.procon.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Relogio{

    public static void main(String[] args){
        RelogioThread thread = new RelogioThread();
        thread.start();
    }

}

class RelogioThread extends Thread{

    public void run() {

        LocalDateTime agora;
        String data;
        String hora;
        String dataHora;
        String diaDaSemana;
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {
            try {
                agora = LocalDateTime.now();
                diaDaSemana = String.valueOf(agora.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-br")).toUpperCase());
                data = formatterData.format(agora);
                hora = formatterHora.format(agora);
                dataHora = diaDaSemana + ", " + data + ", " + hora;
                System.out.println(dataHora);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}