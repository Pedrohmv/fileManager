import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.libs.Json;
import play.mvc.Http.RequestBuilder;
import play.mvc.Http.Status;
import play.mvc.Result;
import play.test.Helpers;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.route;

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

    //Post recebendo um objeto correto
    @Test
    public void postTest(){
        ObjectNode userOk = Json.newObject();
        userOk.put("username", "user");
        userOk.put("email", "email@email.com");
        userOk.put("password", "123");

        int codeRequest = requestCode("POST", userOk, "/api/user");

        assertEquals(Status.CREATED, codeRequest);
    }

    //Post recebendo um objeto Json vazio
    @Test
    public void postTest2(){
        ObjectNode userBad = Json.newObject();
        int codeRequest = requestCode("POST", userBad, "/api/user");
        assertEquals(Status.BAD_REQUEST, codeRequest);
    }

    //Post recebendo um parametro
    @Test
    public void postTest3(){
        ObjectNode userBad1 = Json.newObject();
        userBad1.put("username", "user");

        ObjectNode userBad2 = Json.newObject();
        userBad2.put("email", "email@email.com");

        ObjectNode userBad3 = Json.newObject();
        userBad3.put("password", "123");

        int codeRequest1 = requestCode("POST", userBad1, "/api/user");
        int codeRequest2 = requestCode("POST", userBad2, "/api/user");
        int codeRequest3 = requestCode("POST", userBad3, "/api/user");

        assertEquals(Status.BAD_REQUEST, codeRequest1);
        assertEquals(Status.BAD_REQUEST, codeRequest2);
        assertEquals(Status.BAD_REQUEST, codeRequest3);
    }

    //Post recebendo dois parametros
    @Test
    public void postTest4(){

        ObjectNode userBad1 = Json.newObject();
        userBad1.put("username", "user");
        userBad1.put("password", "123");

        ObjectNode userBad2 = Json.newObject();
        userBad2.put("username", "user");
        userBad2.put("email", "email@email.com");

        ObjectNode userBad3 = Json.newObject();
        userBad3.put("password", "123");
        userBad3.put("email", "email@email.com");

        int codeRequest1 = requestCode("POST", userBad1, "/api/user");
        int codeRequest2 = requestCode("POST", userBad2, "/api/user");
        int codeRequest3 = requestCode("POST", userBad3, "/api/user");

        assertEquals(Status.BAD_REQUEST, codeRequest1);
        assertEquals(Status.BAD_REQUEST, codeRequest2);
        assertEquals(Status.BAD_REQUEST, codeRequest3);
    }

    //Post com email fora do padrao
    @Test
    public void postTest5(){
        ObjectNode userBad1 = Json.newObject();
        userBad1.put("username", "user");
        userBad1.put("email", "emailemail.com");
        userBad1.put("password", "123");

        int codeRequest = requestCode("POST", userBad1, "/api/user");

        assertEquals(Status.BAD_REQUEST, codeRequest);

    }

    //Post com email ou username já cadastrado
    @Test
    public void postTest6(){
        ObjectNode user1 = Json.newObject();
        user1.put("username", "user1");
        user1.put("email", "email@gmail.com");
        user1.put("password", "123asd");

        ObjectNode user2 = Json.newObject();
        user2.put("username", "user2");
        user2.put("email", "email@gmail.com");
        user2.put("password", "123asd");

        ObjectNode user3 = Json.newObject();
        user3.put("username", "user1");
        user3.put("email", "email@hotmail.com");
        user3.put("password", "123asd");

        int codeRequest1 = requestCode("POST", user1, "/api/user");
        int codeRequest2 = requestCode("POST", user2, "/api/user");
        int codeRequest3 = requestCode("POST", user3, "/api/user");

        assertEquals(Status.CREATED, codeRequest1);
        assertEquals(Status.CONFLICT, codeRequest2);
        assertEquals(Status.CONFLICT, codeRequest3);

    }


    private int requestCode(String method, JsonNode payload, String uri){

        RequestBuilder request = new RequestBuilder().method(method)
                .bodyJson(payload)
                .uri(uri);

        Result result = route(request);
        return result.status();
    }


}

