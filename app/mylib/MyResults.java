package mylib;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Result;
import play.mvc.Results;

import static play.mvc.Http.Status.*;


public class MyResults extends Results {

    public static Result conflict(String content) {
        return status(CONFLICT, content);
    }

    public static Result conflict(JsonNode content) {
        return status(CONFLICT, content);
    }
}
