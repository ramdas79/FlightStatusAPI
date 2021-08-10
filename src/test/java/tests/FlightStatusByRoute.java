package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class FlightStatusByRoute extends BaseTest {

    @ParameterizedTest
    @MethodSource("flightRoutes")
    @DisplayName("Verify Flight status of flights for multiple routes for the current day by parameterizing the routes")
    public void flightStatusRouteCurrentDay(String origin , String destination) throws JsonProcessingException {

        fltSteps.thenISearchForFlightStatus(currentDay,origin,destination);
        fltSteps.VerifyTheFlightStatus(origin,destination);
    }

    @Test
    @DisplayName("Flight Status of Nextday flight for the route CGN-BER")
    public void flightStatusRouteNextDay() throws JsonProcessingException {

        fltSteps.thenISearchForFlightStatus(nextDay,origin,destination);
        fltSteps.VerifyTheFlightStatus(origin,destination);
    }

    @Test
    @DisplayName("Flight Status of previous day flight for the route CGN-BER")
    public void flightStatusRoutePrevDay() throws JsonProcessingException {

        fltSteps.thenISearchForFlightStatus(previousDay,origin,destination);
        fltSteps.VerifyTheFlightStatus(origin,destination);
    }

    @Test
    @DisplayName("Error scenario for a search leass than seven days")
    public void flightStatusForErrorWhenFlightDateLessThanSevenDays() throws JsonProcessingException {

        fltSteps.thenISearchForFlightForError(previousDayForError,origin,destination);
        fltSteps.verifyErrorStatus();
    }

    @Test
    @DisplayName("Error scenario for a search with invalid routes")
    public void flightStatusErrorForInvalidRoutes() throws JsonProcessingException {

        fltSteps.thenISearchForFlightForErrorInvalidRoute(currentDay,origin,invalidDestination);
        fltSteps.verifyErrorStatusInvalidRoutes();
    }

    public static Object[][] flightRoutes() {
        return new Object[][] {{"CGN","BER"},{"BER","CGN"},{"CGN","VIE"},{"CGN","MUC"}};
    }

}