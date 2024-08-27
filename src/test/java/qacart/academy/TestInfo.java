package qacart.academy;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import javax.management.DescriptorKey;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class TestInfo {

    @DescriptorKey("دي الطرق المختلفه اللي بقدر اناديي بيها ال headers عندي ف الريكويست بتاعي ")
    @Test
    public void TestGetCourses()
    {
        HashMap<String,String> HeadersUsed =new HashMap<>();

        HeadersUsed.put("type","MANUAL");
        HeadersUsed.put("language","NONE");

      /*  Header TypeHeader =new Header("type","MANUAL");
        Header LanguageHeader =new Header("language","NONE");

        Headers infoHeaders =new Headers(TypeHeader,LanguageHeader);*/
        given()
                .baseUri("https://todo.qacart.com")
                .log().all()
                .headers(HeadersUsed)
              //  .headers(infoHeaders)
               /* .header(TypeHeader)
                .header(LanguageHeader)*/
               /* .headers("language","NONE","type","MANUAL","name","ISTQB Foundation Level")
                .header("language","NONE")
                .header("type","MANUAL")
                .header("name","ISTQB Foundation Level")*/
       .when()
                .get("/api/v1/info/courses")
       .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @DescriptorKey("دي الطرق المختلفه اللي بقدر اناديي بيها ال QuaryParamters عندي ف الريكويست بتاعي اللي ببعته ")
    @Test
    public void TestGetLectures()
    {
        HashMap<String,String> QuarysUsed =new HashMap<>();

        QuarysUsed.put("type","PAID");
        QuarysUsed.put("mode","VIDEO");

            given()
                    .baseUri("https://todo.qacart.com")
                    .log().all()
                    .queryParams(QuarysUsed)
                //    .queryParams("type","PAID","mode","VIDEO")
                /*    .queryParam("type","PAID")
                    .queryParam("mode","VIDEO")*/
                .when()
                .get("/api/v1/info/lectures")
         .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
