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
                <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width: 600px;">
                    <form action="/addNewClient" METHOD="POST" >
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Add Client #${position}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="id" name="id">
                                <label class="mdl-textfield__label" >Cedula</label>
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
                                <input class="mdl-textfield__input" type="text" id="tel" name="tel">
                                <label class="mdl-textfield__label">Telephone</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="add" name="add">
                                <label class="mdl-textfield__label">Address</label>
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
                    <h3>Clients</h3>
                    <tr>
                        <th>Id Number</th>
                        <th>Name</th>
                        <th>Telephone</th>
                        <th>Address</th>
                    </tr>
                <#list clients?sort_by("lastName") as client>
                    <tr>
                        <td>${client.getIdentificationNumber()}</td>
                        <td><a href="/Client?id=${client.getIdentificationNumber()}">${client.getFirstName()} ${client.getLastName()}</a></td>
                        <td>${client.getTelephone()}</td>
                        <td>${client.getAddress()}</td>
                    </tr>
                </#list>
                </table>

        </div>
        <!--END LOGIN BOX-->


    </main>
</div>


</body>