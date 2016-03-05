  <tr>
    <td><%= request.getAttribute("td1") %></td>
    <td><%= request.getAttribute("td2") %></td>
    <td><%= request.getAttribute("td3") %></td>
    <td>
      <form action="<%= request.getAttribute("action") %>">
        <input 
          type="hidden" 
          name="<%= request.getAttribute("paramType") %>" 
          value="<%= request.getAttribute("param") %>">
        <input 
          type="submit" 
          class="btn btn-success btn-sm" 
          value="<%= request.getAttribute("btntext") %>">
      </form>
    </td>
  </tr>
  