package com.ClassLPU;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class DTDemo {

    public static void main(String[] args) {
       /* LocalDateTime dt = LocalDateTime.now();         //immutable object
        System.out.println(dt);

        LocalDateTime dt2 = LocalDateTime.of(2021, Month.APRIL,6,15,10);
        System.out.println(dt2);

        System.out.println(dt.withYear(2020));
        System.out.println(dt.getMonth());
        System.out.println(dt2.getDayOfMonth());
        if(dt.isAfter(dt2))
            System.out.println("True");*/

//        pInstant();
//        pPeriodDuration();
//        pTimeZone();
        pDateTimeFormat();

    }

    public static void pInstant(){
        Instant it = Instant.now();
        System.out.println(it);

//        Instant it2 = Instant.ofEpochSecond(50000); //50000 seconds from 1/1/1970
//        System.out.println(it2);

        System.out.println(it.getEpochSecond());  // get 1617616832

        Instant itCur = Instant.ofEpochSecond(10000000);
        System.out.println(itCur);

        System.out.println(itCur.until(it, ChronoUnit.DAYS));

    }

    public static void pPeriodDuration(){

        Period p = Period.ofDays(50).plusMonths(18).plusYears(100);
        System.out.println(p);

        Period p2 = Period.of(5,10,90);
        System.out.println(p2);

        Period p3 = Period.between(LocalDate.now(), LocalDate.parse("2018-12-31"));
        System.out.println(p3);


        Duration d = Duration.ofDays(5).plusSeconds(100).plusMinutes(10).plusHours(2);
        System.out.println(d);

        Duration d2 = Duration.between(LocalTime.parse("15:00"), LocalTime.now());
        System.out.println(d2);

//        Duration diffIndiaRussia = Duration.between(LocalTime.now(), LocalTime.

    }

    public static void pTimeZone(){
        ZoneId.getAvailableZoneIds().stream().filter((a)-> a.contains("Moscow")).forEach(System.out::println);

        ZonedDateTime zd = ZonedDateTime.now();
        System.out.println(zd);

        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println(odt);

        ZonedDateTime zd2 = odt.toZonedDateTime();
        System.out.println(zd2);

        OffsetDateTime od2 = zd.toOffsetDateTime();
        System.out.println(od2);

    }

    public static void pDateTimeFormat() {
// Using Constants
        DateTimeFormatter dtf = DateTimeFormatter.ISO_ORDINAL_DATE;
//        LocalDateTime dt = LocalDateTime.now();
        ZonedDateTime dt = ZonedDateTime.now();

        System.out.println(dtf.format(dt));
        System.out.println(dt.format(dtf));
// Using Systems predefined formats
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        System.out.println(dt);
        System.out.println(dt.format(dtf1));
// Using Pattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("EEEE MMM dd, YYYY HH:mm:ss a VV");
        System.out.println(dtf2.format(dt));
    }

}
