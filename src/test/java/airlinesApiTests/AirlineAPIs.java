package airlinesApiTests;

import RestUtils.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAline(Map<String, Object> createAirlinePayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndPoint");
        return RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
    }

    public Response getAirline() {
        String endPoint = "https://api.instantwebtools.net/v1/airlines/28321851-bfd1-4f46-bf5a-c0a3e099ff8e";
        return RestUtils.performGet(endPoint, new HashMap<>());
    }
}
