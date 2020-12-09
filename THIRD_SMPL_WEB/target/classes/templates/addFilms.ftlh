<#import "parts/common.ftlh" as c>

<@c.page>
<!-- Add new film to db-->
<a class="btn btn-primary" data-toggle="collapse" href="#collapseBtn" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new film
</a>
<div class="collapse" id="collapseBtn">
    <div class="form-group mt-3">
        <form method="post" action="/addFilms">

            <div class="form-group mt-3">
                <input class="form-control" type="text" name="filmName" placeholder="Введите название фильма">
            </div>

            <div id="Жанр" class="form-group mt-3">
                <select name="filmGenre">
                    <option>Ужасы</option>
                    <option>Триллер</option>
                    <option>Детектив</option>
                </select>
            </div>


            <div class="form-group mt-3">
                <input class="form-control" type="text" name="filmDescription" placeholder="Описание фильма">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>
</div>

</@c.page>
