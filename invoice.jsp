<%@ page import="model.EntityData" %>

<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 
    <h1>Invoice for <%= request.getAttribute("customerName") %></h1>

    <%-- Display status message for add/remove actions, if any --%>
    <jsp:include page="/InvoiceMessage" flush="true"/>

    <hr>

    <div class="row" id="row1">

      <table class="table table-hover text-left">
        <%-- Generate table based on customer's invoice data --%>
        <jsp:include page="/InvoiceTable" flush="true" />
      </table>

    </div><!-- end row 1 -->

    <hr>

    <div class="row" id="row2">

      <%-- Display action button for user, based on role --%> 
      <jsp:include page="/InvoiceAction" flush="true"/>

    </div><!-- end row 2 -->
  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>