<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="/">GRODNO_CINEMA<br>by dim4es_Uchiha</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Films</a>
            </li>

            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">UserList</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addFilms">Add film</a>
            </li>
            </#if>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/user-myFilms/${currentUserId}">My films</a>
            </li>
             </#if>
        </ul>

        <div class="navbar-text mr-5">${name}</div>
        <@l.logout />
    </div>
</nav>