<%@ page import="model.EntityData" %>

<%@ include file="includes/header.jsp" %>

<%@ include file="includes/nav-customer.jsp" %>

<% String category = request.getParameter("category"); %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1><%= category %>s</h1>
    <img class="img-responsive img-center" src="img/<%= request.getAttribute("imgSplash") %>.jpg">

    <hr>

    <div class="row" id="row1">

      <jsp:include page="/ItemOrderTable" flush="true" />

    </div><!-- end row 1 -->

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>