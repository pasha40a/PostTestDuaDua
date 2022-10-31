package com.juaracoding.posttestduadua;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestCRUD {

    @Test (priority = 1)
    public void testGetList(){
        JSONObject request = new JSONObject();
        given()

                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .accept(ContentType.JSON)
                .when()
                .get("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test (priority = 2)
    public void testGetSingle(){
        JSONObject request = new JSONObject();
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .accept(ContentType.JSON)
                .when()
                .get("https://mern-backend-8881.herokuapp.com/products/635f625183203fa2978a5c24")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test (priority = 3)
    public void testPut(){
        JSONObject request = new JSONObject();
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .accept(ContentType.JSON)
                .when()
                .put("https://mern-backend-8881.herokuapp.com/products/635f625183203fa2978a5c24")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test (priority = 4)
    public void testPatch(){
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp 8");
        request.put("category", "katalon dan uipath");
        request.put("price", 2400);
        System.out.println(request.toJSONString());
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .accept(ContentType.JSON)
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/635f625183203fa2978a5c24")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test
    public void testDelete() {

        when()
                .delete("https://mern-backend-8881.herokuapp.com/products/635f625183203fa2978a5c24")
                .then()
                .statusCode(204)
                .log().all();

    }
}
