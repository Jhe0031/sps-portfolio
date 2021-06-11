package com.google.sps.servlets;

import com.google.sps.data.GreetingList;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String enGreeting = "Hello world!";
    String spGreeting = "¡Hola Mundo!";
    String cnGreeting = "世界好！";
    String fraGreeting = "Bonjour le monde!";

    // Convert the greetings to JSON
    GreetingList greetings = new GreetingList(enGreeting, spGreeting, cnGreeting, fraGreeting);
    String json = convertToJson(greetings);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

/**
   * Converts a GreetingList instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(GreetingList greetings) {
    String json = "{";
    json += "\"english\": ";
    json += "\"" + greetings.getEn() + "\"";
    json += ", ";
    json += "\"spanish\": ";
    json += "\"" + greetings.getSp() + "\"";
    json += ", ";
    json += "\"chinese\": ";
    json += greetings.getCn();
    json += ", ";
    json += "\"french\": ";
    json += greetings.getFra();
    json += "}";
    return json;
  }

  /**
   * Converts a GreetingList instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(GreetingList greetings) {
    Gson gson = new Gson();
    String json = gson.toJson(greetings);
    return json;
  }
}
