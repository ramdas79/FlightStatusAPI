package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightStatus {
    @JsonProperty("statusCode")
    public String statusCode;
    @JsonProperty("label")
    public String label;
}
