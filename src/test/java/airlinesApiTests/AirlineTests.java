package airlinesApiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import RestUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests extends AirlineAPIs {
/*    static AllureRestAssured allureFilter = new AllureRestAssured()
            .setRequestTemplate("my-http-request.ftl")
            .setResponseTemplate("my-http-response.ftl");*/
    // TODO: Implement Airline tests here
    @Test
    public void createAirLineTest() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";

        String payLoad = Payloads.getAirlinePayloadViaString("252d3bca-d9bb-476c-9a97-562d685e235c", "10Pearls Airways", "Pakistan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Pakistan", "Karachi, Pakistan", "http://10pearls.com", "2004");
        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirLineTestWithMap() {
        Map<String, Object> payLoad = Payloads.getAirlinePayloadByMap("252d3bca-d9bb-476c-9a97-562d685e235c", "10Pearls Airways", "Pakistan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Pakistan", "Karachi, Pakistan", "http://10pearls.com", "2004");
        Response response = createAline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getAirlinesByID() {
        Response response = getAirline();
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200.");
        String actualId = response.jsonPath().getString("_id");
        Assert.assertEquals(actualId, "28321851-bfd1-4f46-bf5a-c0a3e099ff8e", "The AirlineID cannot be found!");
    }
}
