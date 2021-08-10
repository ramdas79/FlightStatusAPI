package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ResultData {
    @JsonProperty("flights")
    public List<Flight> flights = null;
}
