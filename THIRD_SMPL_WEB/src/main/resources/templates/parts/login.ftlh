<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Username</label>
        <div class="col-sm-5">
            <input type="text"  name="username" class="form-control" placeholder="username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password"  name="password" class="form-control" placeholder="password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm>
        <a href="/registration">Register new user</a>
    </#if>
    <button type="submit" class="btn btn-primary">
        <#if isRegisterForm>Register<#else>Sign in</#if>
    </button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <button type="submit" class="btn btn-primary">Log out</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
</#macro>