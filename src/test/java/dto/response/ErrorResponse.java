package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {
    @JsonProperty("errors")
    public List<Error> errors = null;
    @JsonProperty("success")
    public Boolean success;
}
