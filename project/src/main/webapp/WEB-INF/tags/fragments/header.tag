<%@ tag body-content="empty" pageEncoding="UTF-8" %>

<%@ attribute name="url" required="false" %>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Cooking Miam Miam</a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class=${url=="/recettes"?'active':''}><a href="/recettes">Toutes les recettes</a></li>
                    <li class=${url=="/recette-du-moment"?'active':''}><a href="/recette-du-moment">Recette du moment</a></li>
                </ul>
            </div>
        </div>
    </nav>