<#import "parts/common.ftlh" as c>


<@c.page>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseBtnSearch" role="button" aria-expanded="false" aria-controls="collapseExample">
    Search
</a>
<div class="collapse" id="collapseBtnSearch">
    <div class="form-group col-md-5">
        <!--filter-->
        <form method="get" action="/main">
            <div class="col-auto my-1">
                <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="genreFilter">
                    <option selected>Choose...</option>
                    <option value="Ужасы">Ужасы</option>
                    <option value="Триллер">Триллер</option>
                    <option value="Фантастика">Фантастика</option>
                </select>
            </div>
            <div class="col-auto my-2">
                <input type="text" name="nameFilter" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Поиск</button>
        </form>
    </div>
</div>


<div class="mt-3">Список фильмов</div>
<#list films_to_page as film>
<div class="card mt-3">
    <div class="card-body">
        <h5 class="card-title">${film.filmName}</h5>
        <p class="card-text">${film.filmDescription}</p>
        <a href="/user/infoAboutFilm/${film.filmName}/${film.filmGenre}" class="btn btn-primary">Buy a ticket</a>
    </div>
    <div class="card-footer text-muted">
        <i>${film.filmGenre}</i>
    </div>
</div>
<#else>
No films
</#list>
</@c.page>