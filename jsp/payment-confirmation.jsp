<%@ page import="model.EntityData" %>

<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 

  <h1>Payment Successful</h1>

  <p><strong>$<%= request.getAttribute("total") %></strong> was charged to credit card ending in <strong><%= request.getAttribute("ccLast4") %></strong>.</p>

  <hr>

  <a href="Home" class="btn btn-success btn-block">Click here to return Home</a>

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>