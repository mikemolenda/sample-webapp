<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 

  <h1>Modify Order for <%= request.getAttribute("customerName") %></h1>

    <form action="ModifyOrder" method="post">

      <input 
        type="hidden" 
        name="orderId" 
        value="<%= request.getAttribute("orderId") %>">

      <div class="alert alert-info">
        <strong>Current item:</strong>&nbsp;<%= request.getAttribute("itemName") %>
      </div>

      <div class="form-group">
        <jsp:include page="SelectItem"/>
      </div>

      <button type="submit" class="btn btn-success">Submit</button>&nbsp;

      <a href="ViewOrders" class="btn btn-info">Return to Order List</a>

    </form>

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>