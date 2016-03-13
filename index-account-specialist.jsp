<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>WideCast Account Specialist Dashboard</h1>

    <img class="img-responsive img-center" src="img/main-admin.jpg" alt="WideCast Cable">

    <h3>Account Specialist: <%= session.getAttribute("fullname") %></h3>

    <hr>

    <div class="row" id="row1">
      <div class="col-sm-3">
        <a href="NewCustomer" class="btn btn-info btn-block">Add New Customer</a>
      </div>
      <div class="col-sm-3">
        <a href="UpdateCustomer" class="btn btn-info btn-block">Update Customer</a>
      </div>
      <div class="col-sm-3">
        <a href="AddTicket" class="btn btn-info btn-block">Add Support Ticket</a>
      </div>
      <div class="col-sm-3">
        <a href="AddOrder" class="btn btn-info btn-block">Add PPV Order</a>
      </div>

    </div><!-- end row 1 -->

    <hr>

    <div class="row" id="row2">

      <div class="col-sm-3"></div>
      <div class="col-sm-6">
        <a href="Logout" class="btn btn-danger btn-block">Logout</a>
      </div>
      <div class="col-sm-3"></div>

    </div><!-- end row 2 -->

    <hr>

  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %>