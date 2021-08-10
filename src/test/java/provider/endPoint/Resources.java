package provider.endPoint;

public enum Resources {
    FLIGHT_STATUS("/en/information/at-the-airport/flight-status/_jcr_content/main/flightstatus.search.flightRoute.nocache.html");

    public String getResources() {
        return resources;
    }

    private String resources;

    Resources(String resourceName) {
        this.resources = resourceName;
    }
}
