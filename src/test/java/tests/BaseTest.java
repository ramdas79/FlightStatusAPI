package tests;

import steps.FlightStatusSteps;
import java.time.LocalDate;

public class BaseTest {

    FlightStatusSteps fltSteps = new FlightStatusSteps();
    String currentDay = (LocalDate.now()).toString();
    String nextDay = (LocalDate.now().plusDays(1)).toString();
    String previousDay = (LocalDate.now().minusDays(1)).toString();
    String previousDayForError = (LocalDate.now().minusDays(9)).toString();
    String origin = "CGN";
    String destination = "BER";
    String invalidDestination = "DXB";
}