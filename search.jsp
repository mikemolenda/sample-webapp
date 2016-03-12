<%@ include file="includes/header-search.jsp" %>

<div class="container-fluid">    
  <div class="col-sm-12 text-center">

    <h1>Search</h1>

    <div class="row" id="searchbar-row">

      <form action="AutoComplete">
        <input 
          type="text" 
          class="form-control" 
          id="complete-field"
          onkeyup="doCompletion()">
      </form>

    </div><!-- end searchbar row -->

    <hr>

    <div class="row" id="results-row">

      <table class="table table-hover">
        <thead>
          <th class="text-center">Results</th>
        </thead>
        <tbody id="complete-table"></tbody>
      </table>

    </div><!-- end results row -->

    <hr>

  </div>
</div><!-- end container -->

<script src="js/autocomplete.js"></script>

<%@ include file="includes/footer.jsp" %>