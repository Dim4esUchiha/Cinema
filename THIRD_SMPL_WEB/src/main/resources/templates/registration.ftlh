<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
Registration form
${messages_to_page!""}
<@l.login "/registration" true />
</@c.page>