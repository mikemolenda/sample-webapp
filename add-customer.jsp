<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
  
  <h1>Edit account info for <%= request.getAttribute("fullName") %></h1>

  <%-- Display status message for add/remove actions, if any --%>
  <jsp:include page="/AlertMessage" flush="true"/>

  <form action="NewCustomer" method="post">
    <div class="form-group">
      <label for="fName">First Name:</label>
      <input type="text" name="fName" class="form-control" required>
    </div>

    <div class="form-group">
      <label for="lName">Last Name:</label>
      <input type="text" name="lName" class="form-control" required>
    </div>

    <div class="form-group">
      <label for="email">Email Address:</label>
      <input type="email" name="email" class="form-control" required>
    </div>

    <div class="form-group">
      <label for="ccNo">Desired Username:</label>
      <input type="text" name="username" class="form-control" required>
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" name="password" class="form-control" required>
    </div>

    <div class="form-group">
      <label for="ccNo">Credit Card Number:</label>
      <input type="text" name="ccNo" class="form-control" required>
    </div>

    <button type="submit" class="btn btn-default">Submit</button>

  </form>

  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %> 

