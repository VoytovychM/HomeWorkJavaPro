package homework20240513;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м. Во сколько он прилетит?
// Написать метод, который мог бы совершать подобные вычисления.
public class Flight {
    public static void main(String[] args) {
        LocalDateTime departureTime = LocalDateTime.of(2024, 5, 17, 15, 5);
        ZoneId departureZoneId = ZoneId.of("America/Los_Angeles");
        ZoneId arrivalZoneId = ZoneId.of("CET");
        Duration flidhtDuration = Duration.ofHours(10).plusMinutes(50);


        LocalDateTime arrivalTime = calculateArrivalTime (departureTime, flidhtDuration, departureZoneId, arrivalZoneId);
        System.out.println(arrivalTime);
    }

    public static LocalDateTime calculateArrivalTime(LocalDateTime departureTime, Duration flidhtDuration, ZoneId departureZoneId, ZoneId arrivalZoneId) {
        return ZonedDateTime.of(departureTime, departureZoneId).plus(flidhtDuration).withZoneSameInstant(arrivalZoneId).toLocalDateTime();

    }
}
