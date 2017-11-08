<#include "header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "navbar.ftl">
<#include "sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">


        <!--LOGIN BOX-->
        <div class="mdl-grid demo-content">
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <form action="/addNewUserAccount" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Register User Account #${accounts}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="username" name="username">
                                <label class="mdl-textfield__label" >Username</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="first" name="first">
                                <label class="mdl-textfield__label" >First Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="last" name="last">
                                <label class="mdl-textfield__label" >Last Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="password" id="pass" name="pass">
                                <label class="mdl-textfield__label">Password</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Register">
                        </div>

                    </form>
                </div>
            </div>


                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px">
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric">Username</th>
                        <th class="mdl-data-table__cell--non-numeric">First Name</th>
                        <th class="mdl-data-table__cell--non-numeric">Last Name</th>
                        <th class="mdl-data-table__cell--non-numeric">Permission</th>
                    </tr>
                <#list users?sort_by("username") as user>
                    <tr>
                        <td class="mdl-data-table__cell--non-numeric">${user.getUsername()}</td>
                        <td class="mdl-data-table__cell--non-numeric">${user.getFirstName()}</td>
                        <td class="mdl-data-table__cell--non-numeric">${user.getLastName()}</td>
                        <#if user.getRole() == 'ADMIN'>
                            <td class="mdl-data-table__cell--non-numeric">Admin</td>
                        <#else>
                            <td class="mdl-data-table__cell--non-numeric">User</td>
                        </#if>
                    </tr>
                </#list>
                </table>
        </div>
        <!--END LOGIN BOX-->


    </main>
</div>


</body>