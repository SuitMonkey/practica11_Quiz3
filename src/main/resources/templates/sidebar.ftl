<div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
    <header class="demo-drawer-header">
        <img src="https://getmdl.io/templates/dashboard/images/user.jpg" class="demo-avatar">
        <#--<div class="demo-avatar-dropdown">-->
            <#--<span>user@example.com</span>-->
            <#--<div class="mdl-layout-spacer"></div>-->
            <#--<button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">-->
                <#--<i class="material-icons" role="presentation">arrow_drop_down</i>-->
                <#--<span class="visuallyhidden">Accounts</span>-->
            <#--</button>-->
            <#--<ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">-->
                <#--<li class="mdl-menu__item">user@example.com</li>-->
                <#--<li class="mdl-menu__item">info@example.com</li>-->
                <#--<li class="mdl-menu__item"><i class="material-icons">add</i>Add another account...</li>-->
            <#--</ul>-->
        <#--</div>-->
    </header>
    <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">

        <#--<a class="mdl-navigation__link" href="/"><i class="mdl-color-text--blue-grey-400 material-icons"-->
                                                    <#--role="presentation">home</i><@spring.message "home" /></a>-->

        <a class="mdl-navigation__link" href="/login"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                         role="presentation">people</i><@spring.message "login" /></a>



        <a class="mdl-navigation__link" href="/Users"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                     role="presentation">person_add</i><@spring.message "user_management" /></a>



        <a class="mdl-navigation__link" href="/Clients"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                         role="presentation">assignment_ind</i><@spring.message "clients" /></a>



        <a class="mdl-navigation__link" href="/Equipments"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                           role="presentation">list</i><@spring.message "equipments" /></a>



        <a class="mdl-navigation__link" href="/families_subfamilies"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                       role="presentation">developer_board</i><@spring.message "fams" /></a>

        <a class="mdl-navigation__link" href="/AlquiService"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                        role="presentation">developer_board</i><@spring.message "alq_serv" /></a>

        <a class="mdl-navigation__link" href="/Rents"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                        role="presentation">developer_board</i><@spring.message "rents" /></a>




        <div class="mdl-layout-spacer"></div>

    </nav>
</div>