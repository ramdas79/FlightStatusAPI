package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {
    @JsonProperty("departureTime")
    public String departureTime;
    @JsonProperty("arrivalTime")
    public String arrivalTime;
    @JsonProperty("departureTLC")
    public String departureTLC;
    @JsonProperty("destinationTLC")
    public String destinationTLC;
    @JsonProperty("airlineCode")
    public String airlineCode;
    @JsonProperty("gateNumber")
    public String gateNumber;
    @JsonProperty("flightNumber")
    public String flightNumber;
    @JsonProperty("flightStatus")
    public FlightStatus flightStatus;
}
