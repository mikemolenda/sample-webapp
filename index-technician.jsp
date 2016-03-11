<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>WideCast Technician Dashboard</h1>

    <img class="img-responsive img-center" src="img/main-tech.jpg" alt="WideCast Cable">

    <h3>Technician: <%= session.getAttribute("fullname") %></h3>

    <hr>

    <div class="row" id="row1">
      <div class="col-sm-3">
        <a href="ViewTickets?status=open" class="btn btn-info btn-block">View Open Tickets</a>
      </div>
      <div class="col-sm-3">
        <a href="ViewTickets?status=closed" class="btn btn-info btn-block">View Completed Tickets</a>
      </div>
      <div class="col-sm-3">
        <a href="AddTicket" class="btn btn-success btn-block">Add a New Ticket</a>
      </div>
      <div class="col-sm-3">
        <a href="Logout" class="btn btn-danger btn-block">Logout</a>
      </div>
    </div><!-- end row 1 -->

    <hr>

  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %> 