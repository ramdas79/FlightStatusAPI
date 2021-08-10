package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.response.ErrorResponse;
import dto.response.FlightStatusResponse;
import provider.request.FlightStatusPostRequest;
import tests.FlightStatusByRoute;

public class BaseSteps {
    FlightStatusPostRequest postReq = new FlightStatusPostRequest();
    FlightStatusResponse response = new FlightStatusResponse();
    ErrorResponse errorResponse = new ErrorResponse();
    ObjectMapper mapper = new ObjectMapper();
    String[] expectedStatus = {"ON_TIME","ARRIVED"};
}
