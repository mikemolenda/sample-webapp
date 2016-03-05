<div class="<%= request.getAttribute("size") %>">
  <div class="panel panel-primary">
    <div class="panel-heading"><%= request.getAttribute("heading") %></div>
    <div class="panel-body">
      <img 
          src="<%= request.getAttribute("imgSrc") %>" 
          class="img-responsive" 
          style="width:100%" 
          alt="<%= request.getAttribute("heading") %>">
    </div>
    <div class="panel-footer">
      <p><%= request.getAttribute("bodytext") %></p>
      <form action="<%= request.getAttribute("action") %>">
        <input 
          type="hidden" 
          name="category" 
          value="<%= request.getAttribute("param") %>">
        <input 
          type="submit" 
          class="btn btn-success btn-block" 
          value="<%= request.getAttribute("btntext") %>">
      </form>
    </div>
  </div>
</div>
