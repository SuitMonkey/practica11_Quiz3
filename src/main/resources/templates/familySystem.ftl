<#include "header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "navbar.ftl">
<#include "sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">


        <!--LOGIN BOX-->
        <div class="mdl-grid demo-content">
            <div class="mdl-cell mdl-cell--4-col" style="display: inline-block;">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin: auto; width: 600px; display: inline-block;">
                    <form action="/addNewFamily" METHOD="POST" >
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Add Family #${fcount}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="id" name="name">
                                <label class="mdl-textfield__label" >Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                                   type="submit" value="Register">
                        </div>

                    </form>
                </div>
            </div>


                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                    <tr>
                        <th>Key</th>
                        <th>Name</th>
                    </tr>
                <#list families?sort_by("familyName") as family>
                    <tr>
                        <td>${family.getFamilyKey()}</td>
                        <td>${family.getFamilyName()}</td>
                    </tr>
                </#list>
                </table>


            <br><br>

            <div class="mdl-grid demo-content">
                <div class="mdl-cell mdl-cell--4-col" style="display: inline-block;">
                    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin: auto; width: 600px; display: inline-block;">
                        <form action="/addNewSubFamily" METHOD="POST" >
                            <div class="mdl-card__title">
                                <h2 class="mdl-card__title-text">Add Sub-Family #${scount}</h2>
                            </div>
                            <div class="mdl-card__supporting-text">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="sname" name="name">
                                    <label class="mdl-textfield__label" >Name</label>
                                </div>
                            </div>
                            <div class="mdl-card__supporting-text">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="family" name="family">
                                    <label class="mdl-textfield__label" >Familly</label>
                                </div>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                                       type="submit" value="Register">
                            </div>

                        </form>
                    </div>
                </div>


                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                        <tr>
                            <th>Key</th>
                            <th>Name</th>
                            <th>Family</th>
                        </tr>
                    <#list subfamilies?sort_by("family") as subfamily>
                        <tr>
                            <td>${subfamily.getSubFamilyKey()}</td>
                            <td>${subfamily.getSubFamilyName()}</td>
                            <td>${subfamily.getFamily().getFamilyName()}</td>
                        </tr>
                    </#list>
                    </table>

        <!--END LOGIN BOX-->


    </main>
</div>


</body>