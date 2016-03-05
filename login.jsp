<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>Welcome to WideCast!</h1>
    <p>"The cable company that <em>isn't</em> evil."</p>
    <img class="img-responsive img-center" src="img/main.jpg" alt="WideCast Cable">

    <hr>

    <%-- Warn user if login invalid --%>
    <% if (session.getAttribute("login").equals("invalid")) { %> 
    <div class="alert alert-danger">
      <strong>Error:</strong> Invalid username or password
    </div>
    <% } %>

    <div class="panel panel-default" id="login">
      <div class="panel-heading">
        <h4>Please log in to continue</h4>
      </div>
      <div class="panel-body">
        <form action="Login" method="post" class="form-horizontal">
          <div class="form-group">
            <label class="control-label col-sm-4" for="username">Username: </label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="username" name="username">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4" for="password">Password: </label>
            <div class="col-sm-4">
              <input type="password" class="form-control" id="password" name="password">
            </div>
          </div>
          <button type="submit" class="btn btn-default">Login</button>
        </form>
      </div>
    </div><!-- end login panel -->

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %> 