package com.prueba.apificacion.noticia;

import com.google.gson.stream.JsonToken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoticiaUtils {
    public static String getFechaIso(String fechaNoticia){
        //Default
        String fechaISO ="";
        LocalDateTime localDateTime = null;
        //System.out.println("fecha java:"+fechaiSO);
        //tratar de manera diferente si no contiene fecha numerica
        if(fechaNoticia.contains("hace")){
            Pattern pattern = Pattern.compile(".+ [0-9]+ .+");
            Matcher matcher = pattern.matcher(fechaNoticia);
            if (fechaNoticia.contains("hora")){
                System.out.println("contiene palabra hora");
                if(matcher.matches()) {
                    System.out.println("matcheado correctamente");
                    int cantidadHoras = Integer.parseInt(fechaNoticia.replaceAll("[^0-9]", ""));
                    localDateTime = LocalDateTime.now().minusHours(cantidadHoras);
                    //System.out.println("fecha calculada:"+fechaiSO);
                }else{
                    //"una" hora en letras
                    localDateTime = LocalDateTime.now().minusHours(1);
                    //System.out.println("fecha calculada:"+fechaiSO);
                }
            }else if (fechaNoticia.contains("minuto")){
                System.out.println("contiene palabra minuto");
                if(matcher.matches()) {
                    int cantidadMinutos = Integer.parseInt(fechaNoticia.replaceAll("[^0-9]", ""));
                    localDateTime = LocalDateTime.now().minusMinutes(cantidadMinutos);
                    //System.out.println("fecha calculada:"+fechaiSO);
                }else {
                    localDateTime = LocalDateTime.now().minusMinutes(1);
                    //System.out.println("fecha calculada:"+fechaiSO);
                }

            }

        }else{
            //fechas con estilo  dd/MM/yyyy HH:mm:ss 10/5/2022 09:50
            //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");
            localDateTime = LocalDateTime.parse(fechaNoticia+":00", format);
            System.out.println(localDateTime.toString());
        }
        ZonedDateTime utcZoned = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        fechaISO = utcZoned.toString();
        System.out.println(fechaISO);
        if(fechaISO.length()==22){
            System.out.println("fecha previamente"+fechaISO);
            fechaISO = fechaISO.replace("Z[UTC]",":00Z");
            System.out.println("fecha en formato ISO: "+fechaISO);
        }else if(localDateTime.toString().length()>25){
            //System.out.println("fecha previamente"+fechaISO);
            fechaISO = fechaISO.substring(0,19);
            fechaISO = fechaISO + "Z";
            //System.out.println("fecha en formato ISO: "+fechaISO);
        }
        return fechaISO;

    }
}
