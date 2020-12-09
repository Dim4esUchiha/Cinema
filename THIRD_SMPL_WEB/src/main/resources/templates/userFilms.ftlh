<#import "parts/common.ftlh" as c>

<@c.page>
<div class="mt-3">Список моих фильмов</div>
<#list films_to_page as film>
<div class="card mt-3">
    <div class="card-body">
        <h5 class="card-title">${film.filmName}</h5>
        <p class="card-text">${film.filmDescription}</p>
        <a href="/user/user-myFilmsCancel/${film.filmName}" class="btn btn-primary">Cancel film</a>
    </div>
</div>
<#else>
No films
</#list>

</@c.page>