<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 

  <h1>Add Order</h1>

    <form action="AddOrder" method="post">

      <%-- Generate dropdown of all existing customers --%>
      <div class="form-group">
        <jsp:include page="SelectCustomer"/>
      </div>

      <div class="form-group">
        <jsp:include page="SelectItem"/>
      </div>

      <button type="submit" class="btn btn-default">Submit</button>

    </form>

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>