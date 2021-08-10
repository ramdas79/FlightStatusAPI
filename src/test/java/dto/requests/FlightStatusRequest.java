package dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightStatusRequest {
    @JsonProperty("departureDate")
    public String departureDate;
    @JsonProperty("originTlc")
    public String originTlc;
    @JsonProperty("destinationTlc")
    public String destinationTlc;
}
