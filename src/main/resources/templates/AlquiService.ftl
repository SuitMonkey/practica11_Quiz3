<#include "header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "navbar.ftl">
<#include "sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
            <div style="width: 49%;">
                    <table class="mdl-data-table mdl-js-data-table  mdl-shadow--2dp" style="width: 49%;">
                        <tr>
                            <th>Equipment Legend (Total: ${totalE})</th>
                        </tr>
                        <tr>
                            <th>Key</th>
                            <th>Name</th>
                            <th>SubFamily</th>
                            <th>Quantity</th>
                        </tr>
                    <#list equipments?sort_by("equipmentName") as equipment>
                        <tr>
                            <td>${equipment.getEquipmentId()}</td>
                            <td>${equipment.getEquipmentName()}</td>
                            <td>${equipment.getSubFamily().getSubFamilyName()}</td>
                            <#if equipment.getStock() gt 0 >
                                <td>${equipment.getStock()}</td>
                            <#else>
                                <td>OUT OF STOCK</td>
                            </#if>
                        </tr>
                    </#list>
                    </table>
            </div>
            <div style="width: 49%;">
                    <table class="mdl-data-table mdl-js-data-table  mdl-shadow--2dp" style="width: 90%; margin: 2%;">
                        <tr>
                            <th>#{totalC} Clients</th>
                        </tr>
                        <tr>
                            <th>Id Number</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                    <#list clients?sort_by("lastName") as client>
                        <tr>
                            <td>${client.getIdentificationNumber()}</td>
                            <td>${client.getFirstName()}</td>
                            <td>${client.getLastName()}</td>
                        </tr>
                    </#list>
                    </table>
            </div>

            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <form action="/lend" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Rent an Equipment</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="equipment" name="equipment">
                                <label class="mdl-textfield__label" >Equipment</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="return" name="return">
                                <label class="mdl-textfield__label" >Return Date(DD-MM-YYYY)</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="rate" name="rate">
                                <label class="mdl-textfield__label" >Rate</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="client" name="client">
                                <label class="mdl-textfield__label" >Client ID</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Register">
                        </div>

                    </form>
                </div>
            </div>

            <br><br>

                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                    <tr>
                        <th>#{totalR} Rented Equipments</th>
                    </tr>
                    <tr>
                        <th>Rent Id</th>
                        <th>Equipment</th>
                        <th>Start Date</th>
                        <th>Promised Date</th>
                        <th>Borrower</th>
                        <th>Status</th>
                        <th>Days Out</th>
                    </tr>
                <#list rents?sort_by("daysOut")?reverse as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
                        <#if rent.getPromisedDate() lt today>
                            <td>LATE</td>
                        <#else>
                            <td>OK</td>
                        </#if>
                        <td>${rent.getDaysOut()}</td>
                    </tr>
                </#list>
                </table>

            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <form action="/return" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Return an Equipment</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="equip" name="equipment">
                                <label class="mdl-textfield__label" >Equipment</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="rent" name="id">
                                <label class="mdl-textfield__label" >Rent id</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Register">
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </main>
</div>


</body>