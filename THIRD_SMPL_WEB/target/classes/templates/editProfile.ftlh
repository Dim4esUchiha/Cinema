<#import "parts/common.ftlh" as c>

<@c.page>
<h5>${username}</h5>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseBtnEdit" role="button" aria-expanded="false" aria-controls="collapseExample">
Edit
</a>
<div class="collapse" id="collapseBtnEdit">
    <form method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Username</label>
            <div class="col-sm-5">
                <input type="text"  name="username" class="form-control" placeholder="username" value="${username}"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input type="text"  name="password" class="form-control" placeholder="password" value="${password}"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Save changes</button>
    </form>
</div>
</@c.page>