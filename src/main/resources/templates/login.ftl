<#include "header.ftl">

<body>
<style>
    .mdl-layout {
        align-items: center;
        justify-content: center;
    }
    .mdl-layout__content {
        padding: 24px;
        flex: none;
    }
</style>
<div class="loader"></div>
<div class="mdl-layout mdl-js-layout mdl-color--grey-100">
    <main class="mdl-layout__content">
        <div class="mdl-card mdl-shadow--6dp">
            <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                <h2 class="mdl-card__title-text">Practica 11</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <form role="form" action="/login" method="post">
                    <#if (_csrf)??>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <#else>
                        <input type="hidden"/></h2>
                    </#if>

                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" name="username" id="username" />
                        <label class="mdl-textfield__label" for="username">Username</label>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="password" name="password" id="password" />
                        <label class="mdl-textfield__label" for="password">Password</label>
                    </div>
                    <div>
                        <label for="remember-me">Recordar...</label>
                        <input type="checkbox" name="remember-me" id="remember-me">
                    </div>
                    <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">Sign in</button>
                </form>
            <#if error.isPresent()>
                <p>Error de login, intente nuevamente</p>
            </#if>

            </div>
        </div>
    </main>
</div>
</body>