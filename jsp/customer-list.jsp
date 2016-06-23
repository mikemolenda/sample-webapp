<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>Active Customers</h1>

    <%-- Display status message for add/remove actions, if any --%>
    <jsp:include page="/AlertMessage" flush="true"/>

    <hr>

    <div class="row" id="row1">

      <table class="table table-hover text-left">
        <%-- Generate table based on ticket data --%>
        <jsp:include page="/CustomerTable" flush="true" />
      </table>

    </div><!-- end row 1 -->

    <hr>

    <div class="row" id="row2">

      <a href="NewCustomer" class="btn btn-info btn-block">Add New Customer</a>

    </div><!-- end row 2 -->
  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>