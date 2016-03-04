<%@ include file="includes/header.jsp" %>

<%@ include file="includes/nav-customer.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>Welcome to WideCast!</h1>
    <p>"The cable company that <em>isn't</em> evil."</p>
    <img class="img-responsive img-center" src="img/main.jpg" alt="WideCast Cable">

    <hr>

    <div class="row" id="row1">
      <div class="col-sm-2"></div>
      <div class="col-sm-4">
        <a href="Account" class="btn btn-danger btn-block">Manage My Account</a>
      </div>
      <div class="col-sm-4">
        <a href="Logout" class="btn btn-danger btn-block">Logout</a>
      </div>
      <div class="col-sm-2"></div>
    </div><!-- end row 1 -->

    <hr>

    <jsp:include page="/CustomerUIPanels" flush="true" />

  </div>
</div><!-- end container -->    

<%@ include file="includes/footer.jsp" %> 