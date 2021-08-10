package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightStatusResponse {
    @JsonProperty("resultData")
    public ResultData resultData;
    @JsonProperty("success")
    public Boolean success;
}
