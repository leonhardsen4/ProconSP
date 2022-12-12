package br.gov.sp.procon.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Relogio {

    public static void main(String[] args){
        getDataHoraAtual();
    }

    public static void getDataHoraAtual() {

        Timer timer = new Timer();
        final long TEMPO = 1000;

        TimerTask tarefa = new TimerTask() {
            public void run () {
                LocalDateTime agora;
                String data;
                String hora;
                String diaDaSemana;
                DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                agora = LocalDateTime.now();
                diaDaSemana = agora.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-br")).toUpperCase();
                data = formatterData.format(agora);
                hora = formatterHora.format(agora);
                String dataHoraAtual = diaDaSemana + ", " + data + ", " + hora;
                System.out.println(dataHoraAtual);
            }
        };
        timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
    }

}