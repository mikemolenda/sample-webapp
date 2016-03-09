<%@ include file="includes/header.jsp" %>

<div class="container-fluid" onload="init()">    
  <div class="col-sm-12 text-center">

    <h1>Search</h1>

    <div class="autocomplete-container">
      <form action="AutoComplete">
        <input 
          type="text" 
          class="form-control" 
          id="complete-field"
          onkeyup="doCompletion()">
      </form>

    <hr>

    <table class="table table-hover" id="complete-table"></table>

    </div>

  </div>

<script src="js/autocomplete.js"></script>

<%@ include file="includes/footer.jsp" %>