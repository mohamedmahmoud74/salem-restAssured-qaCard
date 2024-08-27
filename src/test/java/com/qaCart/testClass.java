package com.qaCart;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static    org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.management.DescriptorKey;


public class testClass {
@DescriptorKey("test assertion ")
    @Test
            void test(){
        given().baseUri("https://66c46859b026f3cc6cef3932.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
              //  .assertThat().body("[0].name",is(equalTo("Carolyn Roob")))
               //.assertThat().body("[0].country",equalTo("Aruba"),"name",hasItem("Edgar Block"))
               //.assertThat().body("name",hasItems("Edgar Block","Carolyn Roob","Hattie Gottlieb"))
              //.assertThat().body("name",not(hasItem("salem")))
                //.assertThat().body("name",contains(""))
               //.assertThat().body("name",containsInAnyOrder(""))
               //.assertThat().body("name",empty())
              //.assertThat().body("name",not(empty()))
             //.assertThat().body("name",hasSize())
              //.assertThat().body("createdAt",everyItem(startsWith("2024")))
                .assertThat().body("[0]",hasKey("createdAt"))
                .assertThat().body("[0]",hasValue("Carolyn Roob"))
                .assertThat().body("[0]",hasEntry("name","Carolyn Roob"))

        ;


    }
    @DescriptorKey("extract response ")
    @Test
    void test2(){
     Response res= given().baseUri("https://66c46859b026f3cc6cef3932.mockapi.io/api/v1")
                .when().get("users")
                .then().extract().response();
       String Name= given().baseUri("https://66c46859b026f3cc6cef3932.mockapi.io/api/v1")
                .when().get("users")
                .then().extract().response().path("[1].name");
        // System.out.println(res.asString());
        //**************************************************
       String name =res.path("[0].name");
       //*********************************************************
        String name1 = JsonPath.from(res.asString()).getString("[0].name");
        //***********************************************************
        JsonPath path=new JsonPath(res.asString());
        String name2= path.getString("[0].name");
        //*****************************************************************
        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(Name);

    }
    @DescriptorKey("LOGGING REQUEST ")
    @Test
    void test3(){
      given().baseUri("https://66c46859b026f3cc6cef3932.mockapi.io/api/v1")
                .when().get("users")
                .then().log().ifValidationFails()
              .assertThat().statusCode(20);


    }

}
