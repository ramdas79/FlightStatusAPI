package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.response.ErrorResponse;
import dto.response.FlightStatusResponse;
import org.junit.Assert;

public class FlightStatusSteps extends BaseSteps {
    public void thenISearchForFlightStatus(String date, String origin, String destination) throws JsonProcessingException {

        String res = postReq.postRequest(date, origin, destination);
        response = mapper.readValue(res, FlightStatusResponse.class);
    }

    public void VerifyTheFlightStatus(String origin, String destination) {
        for (int i = 0; i < response.resultData.flights.size(); i++) {

            String fltStat = response.resultData.flights.get(i).flightStatus.statusCode;
            if (fltStat.equals("ON_TIME")) {

                Assert.assertEquals("The flight status is", "ON_TIME", response.resultData.flights.get(i).flightStatus.statusCode);
                Assert.assertFalse("Departure time is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("Arrival time is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertEquals("The departure airport code ", response.resultData.flights.get(i).departureTLC, origin);
                Assert.assertEquals("The departure airport code ", response.resultData.flights.get(i).destinationTLC, destination);
                Assert.assertFalse("The airline code is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("The gate number is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("The flight number is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertTrue("The flight status response is successful", response.success);

            } else if (fltStat.equals("ARRIVED")) {

                Assert.assertEquals("The flight status is", "ARRIVED", response.resultData.flights.get(i).flightStatus.statusCode);
                Assert.assertFalse("Departure time is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("Arrival time is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertEquals("The departure airport code ", response.resultData.flights.get(i).departureTLC, origin);
                Assert.assertEquals("The departure airport code ", response.resultData.flights.get(i).destinationTLC, destination);
                Assert.assertFalse("The airline code is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("The gate number is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertFalse("The flight number is not empty", (response.resultData.flights.get(i).departureTime).isEmpty());
                Assert.assertTrue("The flight status response is successful", response.success);

            } else if (fltStat.equals("CANCELLED")) {

                Assert.assertEquals("The flight status is", "CANCELLED", response.resultData.flights.get(i).flightStatus.statusCode);
                Assert.assertTrue("The flight status response is successful", response.success);

            } else {
                Assert.assertEquals("The status is not found", response.success, "false");
            }
        }
    }

    public void thenISearchForFlightForError(String date, String origin, String destination) throws JsonProcessingException {
        String errorRes = postReq.postRequest(date, origin, destination);
        errorResponse = mapper.readValue(errorRes, ErrorResponse.class);
    }

    public void thenISearchForFlightForErrorInvalidRoute(String date, String origin, String invalidDestination) throws JsonProcessingException {
        String errorRes = postReq.postRequest(date, origin, invalidDestination);
        errorResponse = mapper.readValue(errorRes, ErrorResponse.class);
    }

    public void verifyErrorStatus() {
        Assert.assertEquals("Error message is displayed", "SearchDate may be at most 7 days in the past.", errorResponse.errors.get(0).errorMessage);
        Assert.assertEquals("Error type is displayed", "INVALID_REQUEST", errorResponse.errors.get(0).errorType);
    }

    public void verifyErrorStatusInvalidRoutes() {
        Assert.assertEquals("Error message is displayed", "Invalid route queried.", errorResponse.errors.get(0).errorMessage);
        Assert.assertEquals("Error type is displayed", "INVALID_REQUEST", errorResponse.errors.get(0).errorType);
    }
}