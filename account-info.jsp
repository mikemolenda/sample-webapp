<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
  
  <h1>Edit account info for <%= request.getAttribute("fullName") %></h1>

  <%-- Display status message for add/remove actions, if any --%>
  <jsp:include page="/AlertMessage" flush="true"/>

  <form action="Account" method="post">
    <div class="form-group">
      <label for="fName">First Name:</label>
      <input type="text"
             name="fName"
             class="form-control"
             value="<%= request.getAttribute("fName") %>"
             required>
    </div>

    <div class="form-group">
      <label for="lName">Last Name:</label>
      <input type="text"
             name="lName"
             class="form-control"
             value="<%= request.getAttribute("lName") %>"
             required>
    </div>

    <div class="form-group">
      <label for="email">Email Address:</label>
      <input type="email"
             name="email"
             class="form-control"
             value="<%= request.getAttribute("email") %>"
             required>
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password"
             name="password"
             class="form-control"
             value="<%= request.getAttribute("password") %>"
             required>
    </div>

    <div class="form-group">
      <label for="ccNo">Credit Card Number:</label>
      <input type="text"
             name="ccNo"
             class="form-control"
             value="<%= request.getAttribute("ccNo") %>"
             required>
    </div>

    <input type="hidden" 
           name="username" 
           value="<%= request.getAttribute("username") %>">

    <button type="submit" class="btn btn-success">Submit</button>

    <%-- Include "return to customer list" button if user admin or manager --%>
    <jsp:include page="/ListButton" flush="true"/>

  </form>

  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %> 