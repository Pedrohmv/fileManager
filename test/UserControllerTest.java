import com.fasterxml.jackson.databind.JsonNode;

import models.User;
import org.junit.*;
import play.Application;
import play.GlobalSettings;
import play.test.*;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.*;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class UserControllerTest {

    Application fakeApp = Helpers.fakeApplication();

    @Before
    public void setup() {
        Helpers.start(fakeApp);
    }

    @After
    public void teardown() {
        Helpers.stop(fakeApp);
    }

    @Test
    public void postUserTest(){
        User userOk = new User("victor", "email@email.com", "123");
        User userBad1 = new User(null, null, null);
        User userBad2 = null;

        JsonNode payloadBad1 = Json.toJson(userBad1);
        JsonNode payloadBad2 = Json.toJson(userBad2);
        JsonNode payloadOk = Json.toJson(userOk);

        int codeOk = requestCode("POST", payloadOk, "/api/user");
        int codeBad1 = requestCode("POST", payloadBad1, "/api/user");
        int codeBad2 = requestCode("POST", payloadBad2, "/api/user");

        assertEquals(Status.OK, codeOk);
        assertEquals(Status.BAD_REQUEST, codeBad1);
        assertEquals(Status.BAD_REQUEST, codeBad2);
    }

    private int requestCode(String method, JsonNode payload, String uri){

        RequestBuilder request = new RequestBuilder().method(method)
                .bodyJson(payload)
                .uri(uri);

        Result result = route(request);
        return result.status();
    }


}

