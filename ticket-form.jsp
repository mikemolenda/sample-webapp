<%@ include file="includes/header.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center"> 

  <h1>Add Support Ticket</h1>

    <form action="AddTicket" method="post">

      <%-- Include either technician select or technicianId hidden field, depending on whether user is admin or technician --%>
      <div class="form-group">
        <jsp:include page="SelectTechnician"/>
      </div>

      <%-- Generate dropdown of all existing customers --%>
      <div class="form-group">
        <jsp:include page="SelectCustomer"/>
      </div>

      <div class="form-group">
        <label for="ticketMsg">Ticket details (limit 150 characters):</label>
        <textarea name="ticketMsg" class="form-control" rows="4" maxlength="150"></textarea>
      </div>

      <button type="submit" class="btn btn-default">Submit</button>

    </form>

  </div>
</div><!-- end container -->

<%@ include file="includes/footer.jsp" %>