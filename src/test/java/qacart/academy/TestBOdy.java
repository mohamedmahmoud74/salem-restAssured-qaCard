package qacart.academy;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import testData.loginData;

import javax.management.DescriptorKey;
import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestBOdy {

    @DescriptorKey("")
    @Test
    public void TestLogin()
    {
        loginData bodyData =new loginData();
        bodyData.setEmail("mohamedm.salem19972020@gmail.com");
        bodyData.setPassword("baba010644210522020");
    //    HashMap <String, String> Body =new HashMap<>();
        /*String body = "{\n" +
                "    \"email\":\"mohamedm.salem19972020@gmail.com\",\n" +
                "    \"password\":\"baba010644210522020\"\n" +
                "}";*/
        //*********************************
     //   File bodyfile =new File("src/test/resources/loginData.json");

       /* Body.put("email","mohamedm.salem19972020@gmail.com");
        Body.put("password","baba010644210522020");*/

        given()
                .baseUri("https://todo.qacart.com")
                .log().all()
                .body(bodyData)
              //  .header("Authorization","e126566589cdvff5d35653568532")
               // .auth().oauth("tocken")

               // .headers("Content-Type","application/json")
               // .body(bodyfile)

                .contentType(ContentType.JSON)
         .when()
                .post("/api/v1/students/login")
         .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
