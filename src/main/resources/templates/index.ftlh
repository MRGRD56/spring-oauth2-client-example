<#import "/spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#if model.userInfo??>
    You are logged in via ${model.userInfo.registration}
    <div>
        <a href="<@spring.url '/logout'/>">Log out</a>
    </div>

    <div>
        <a href="<@spring.url '/private'/>">View my access token</a>
    </div>

    <table>
        <tr>
            <td>Id</td>
            <td>${model.userInfo.id!}</td>
        </tr>
        <tr>
            <td>Login</td>
            <td>${model.userInfo.login!}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${model.userInfo.email!}</td>
        </tr>
        <tr>
            <td>Avatar</td>
            <td><img src="${model.userInfo.avatarUrl!}" alt="Avatar" height="50" width="50"></td>
        </tr>
    </table>

    <div>
        <code>
            ${model.userInfo.raw!}
        </code>
    </div>
<#else>
    You are not logged in
    <div>
        <a href="<@spring.url '/login'/>">Sign in</a>
    </div>
</#if>
</body>
</html>