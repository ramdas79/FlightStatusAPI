package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("errorType")
    public String errorType;
    @JsonProperty("errorMessage")
    public String errorMessage;

}
