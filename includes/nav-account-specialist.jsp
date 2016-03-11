<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="Home">Widecast Cable</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="NewCustomer">New Customer</a></li>
        <li><a href="ModifyCustomer">Modify Customer</a></li>
        <li><a href="AddTicket">Add Ticket</a></li>
        <li><a href="AddPPV">Add PPV Order</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Logout">Logout <%= session.getAttribute("username") %>&nbsp;<span class="glyphicon glyphicon-log-out"></span>
        </a></li>
      </ul>
    </div>
  </div>
</nav>
