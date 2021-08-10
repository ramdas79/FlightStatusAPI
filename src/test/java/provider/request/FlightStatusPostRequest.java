package provider.request;

import dto.response.FlightStatusResponse;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import provider.builder.FltStatusReqBuilder;
import provider.endPoint.BaseURI;
import provider.endPoint.Resources;

import static io.restassured.RestAssured.given;

public class FlightStatusPostRequest extends BaseRequest{

    public String postRequest(String date, String origin , String  destination) {

        return given().headers(headers).spec(BaseURI.baseURL())
                      .body(fltStatReqBuilder.reqBuilder(date,origin,destination)).log().all()
                      .when().log().all()
                      .post(Resources.FLIGHT_STATUS.getResources()).asString();
    }
}
