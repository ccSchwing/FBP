<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fbp.httpclient.*" %>
<!DOCTYPE html>
<html>
console.log("Entered process-order.jsp");
<%

    int id=Integer.parseInt(request.getParameter("id"));
    String itemName=request.getParameter("itemName");
    int quantity=Integer.parseInt(request.getParameter("quantity"));

    com.fbp.objects.Order order = new com.fbp.objects.Order(id, itemName, quantity);

    // Call the LambdaClient from here
    HttpLambdaClient  client = new HttpLambdaClient();

    //
    // Convert order to a JSON string
    //
    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new 
        com.fasterxml.jackson.databind.ObjectMapper();
    String orderJson=objectMapper.writeValueAsString(order);
    String otherURL="https://nei4gucoye.execute-api.us-east-1.amazonaws.com/Dev/createOrder";
    String url="https://7g6jdv933c.execute-api.us-east-1.amazonaws.com/Prod/create-order";

    //client.runWithPayload("us-east-1", "scratch-HelloWorldFunction-Hus0ilr43Lxs", orderJson);
    client.makePostRequest(otherURL, orderJson);


    request.setAttribute("Success",  "New Order Object Created: " + order.toString());
    RequestDispatcher dispatcher=request.getRequestDispatcher("signup-complete-lambda.jsp");
    dispatcher.forward(request, response);
%>

console.log("Leaving process-order.jsp");
</html>
