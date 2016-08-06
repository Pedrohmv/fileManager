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
    ObjectNode userGETOk;
    ObjectNode userPOSTOk;
    ObjectNode userPOSTBad1;
    ObjectNode userPOSTBad2;
    ObjectNode userPOSTBad3;
    ObjectNode userPOSTBad4;
    ObjectNode userPOSTBad5;
    ObjectNode userPOSTBad6;
    ObjectNode userPOSTBad7;
    ObjectNode userPOSTBad8;
    ObjectNode userPOSTConflict1;
    ObjectNode userPOSTConflict2;
    ObjectNode userPOSTConflict3;
    @Before
    public void setup() {
        userGETOk = Json.newObject();
        userGETOk.put("username", "userGet");
        userGETOk.put("email", "email@get.com");
        userGETOk.put("password", "123");

        userPOSTOk = Json.newObject();
        userPOSTOk.put("username", "userPost");
        userPOSTOk.put("email", "email@post.com");
        userPOSTOk.put("password", "123");

        userPOSTBad1 = Json.newObject();

        userPOSTBad2 = Json.newObject();
        userPOSTBad2.put("username", "userPost");

        userPOSTBad3 = Json.newObject();
        userPOSTBad3.put("email", "email@post.com");

        userPOSTBad4 = Json.newObject();
        userPOSTBad4.put("password", "123");

        userPOSTBad5 = Json.newObject();
        userPOSTBad5.put("username", "user");
        userPOSTBad5.put("password", "123");

        userPOSTBad6 = Json.newObject();
        userPOSTBad6.put("username", "user");
        userPOSTBad6.put("email", "email@email.com");

        userPOSTBad7 = Json.newObject();
        userPOSTBad7.put("password", "123");
        userPOSTBad7.put("email", "email@email.com");

        userPOSTBad8 = Json.newObject();
        userPOSTBad8.put("username", "user");
        userPOSTBad8.put("email", "emailemail.com");
        userPOSTBad8.put("password", "123");

        userPOSTConflict1 = Json.newObject();
        userPOSTConflict1.put("username", "user1");
        userPOSTConflict1.put("email", "email@gmail.com");
        userPOSTConflict1.put("password", "123asd");

        userPOSTConflict2 = Json.newObject();
        userPOSTConflict2.put("username", "user2");
        userPOSTConflict2.put("email", "email@gmail.com");
        userPOSTConflict2.put("password", "123asd");

        userPOSTConflict3 = Json.newObject();
        userPOSTConflict3.put("username", "user1");
        userPOSTConflict3.put("email", "email@hotmail.com");
        userPOSTConflict3.put("password", "123asd");

        Helpers.start(fakeApp);
    }

    @After
    public void teardown() {
        Helpers.stop(fakeApp);
    }

    @Test
    public  void test1Get1(){
        int codeRequest1 = requestCode("GET", null, "/api/users/user");
        assertEquals(Status.NOT_FOUND, codeRequest1);
    }

    @Test
    public  void test1Get2(){
        requestCode("POST", userGETOk, "/api/user");
        int codeRequest1 = requestCode("GET", null, "/api/users/userGet");
        assertEquals(Status.OK, codeRequest1);
    }

    //Post recebendo um objeto correto
    @Test
    public void test2Post1(){
        int codeRequest = requestCode("POST", userPOSTOk, "/api/user");
        assertEquals(Status.CREATED, codeRequest);
    }

    //Post recebendo um objeto Json vazio
    @Test
    public void test2Post2(){
        int codeRequest = requestCode("POST", userPOSTBad1, "/api/user");
        assertEquals(Status.BAD_REQUEST, codeRequest);
    }

    //Post recebendo um parametro
    @Test
    public void test2Post3(){
        incompleteBadRequest(userPOSTBad2,userPOSTBad3,userPOSTBad4);
        incompleteBadRequest(userPOSTBad5,userPOSTBad6,userPOSTBad7);
    }

    private void incompleteBadRequest(ObjectNode user1, ObjectNode user2, ObjectNode user3){
        int codeRequest1 = requestCode("POST", user1, "/api/user");
        int codeRequest2 = requestCode("POST", user2, "/api/user");
        int codeRequest3 = requestCode("POST", user3, "/api/user");

        assertEquals(Status.BAD_REQUEST, codeRequest1);
        assertEquals(Status.BAD_REQUEST, codeRequest2);
        assertEquals(Status.BAD_REQUEST, codeRequest3);
    }
    //Post com email fora do padrao
    @Test
    public void test2Post4(){
        int codeRequest = requestCode("POST", userPOSTBad8, "/api/user");
        assertEquals(Status.BAD_REQUEST, codeRequest);
    }

    //Post com email ou username já cadastrado
    @Test
    public void test2Post5(){
        int codeRequest1 = requestCode("POST", userPOSTConflict1, "/api/user");
        int codeRequest2 = requestCode("POST", userPOSTConflict2, "/api/user");
        int codeRequest3 = requestCode("POST", userPOSTConflict3, "/api/user");

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

