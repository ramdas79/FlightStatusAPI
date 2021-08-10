package provider.builder;

import dto.requests.FlightStatusRequest;

public class FltStatusReqBuilder extends BaseBuilder {

    public FlightStatusRequest reqBuilder(String date, String origin, String destination) {
        fltStatReq.originTlc = origin;
        fltStatReq.destinationTlc = destination;
        fltStatReq.departureDate = date;
        return fltStatReq;

    }
}
