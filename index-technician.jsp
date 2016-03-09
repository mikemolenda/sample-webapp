<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>Welcome to WideCast!</h1>
    <h2>Technician Dashboard</h2>
    <img class="img-responsive img-center" src="img/main.jpg" alt="WideCast Cable">

    <hr>

    <div class="row" id="row1">
      <div class="col-sm-4">
        <a href="ViewTickets" class="btn btn-danger btn-block">View Open Tickets</a>
      </div>
      <div class="col-sm-4">
        <a href="Account" class="btn btn-danger btn-block">Manage My Account</a>
      </div>
      <div class="col-sm-4">
        <a href="Logout" class="btn btn-danger btn-block">Logout</a>
      </div>
    </div><!-- end row 1 -->

    <hr>

    <div class="row" id="row2">

      <%-- Generate UI panels used for app navigation --%>
      <jsp:include page="/CustomerUIPanels" flush="true" />

    </div><!--end row 2 -->
  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %> 