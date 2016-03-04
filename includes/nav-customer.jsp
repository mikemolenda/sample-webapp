<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="Home">Widecast Cable</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="ItemList?category=TV+Plan">TV</a></li>
        <li><a href="ItemList?category=Internet+Plan">Internet</a></li>
        <li><a href="ItemList?category=PPV+Live+Event">PPV Events</a></li>
        <li><a href="ItemList?category=PPV+Movie">PPV Movies</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Account">
          <span class="glyphicon glyphicon-user"></span> 
          <%= session.getAttribute("username") %>'s Account
        </a></li>
      </ul>
    </div>
  </div>
</nav>