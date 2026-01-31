<!DOCTYPE html>
<html>
console.log("Entered process-order.jsp");
<%

    int id=Integer.parseInt(request.getParameter("id"));
    String itemName=request.getParameter("itemName");
    int quantity=Integer.parseInt(request.getParameter("quantity"));

    com.fbp.objects.Order order = new com.fbp.objects.Order(id, itemName, quantity);

    // Call the LambdaClient from here
    com.fbp.lambdaclient.LambdaClient client = new com.fbp.lambdaclient.LambdaClient();


    request.setAttribute("Success",  "New Order Object Created: " + order.toString());
    RequestDispatcher dispatcher=request.getRequestDispatcher("signup-complete-lambda.jsp");
    dispatcher.forward(request, response);
%>

console.log("Leaving process-order.jsp");
</html>
