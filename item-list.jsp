<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1><%= request.getParameter("category") %>s</h1>
    <img class="img-responsive img-center" src="img/<%= request.getAttribute("imgSplash") %>.jpg">

    <hr>

    <div class="row" id="row1">
      <table class="table table-hover text-left">
        <%-- Generate table of all items matching category --%>
        <jsp:include page="/ItemOrderTable" flush="true" />
      </table>
    </div><!-- end row 1 -->

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>