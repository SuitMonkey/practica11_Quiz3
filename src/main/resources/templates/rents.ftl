<#include "header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "navbar.ftl">
<#include "sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">

            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                <tr>
                    <th>#{totalA} Active Rents</th>
                </tr>
                <tr>
                    <th>Rent Id</th>
                    <th>Equipment</th>
                    <th>Start Date</th>
                    <th>Promised Date</th>
                    <th>Price Rate</th>
                    <th>Borrower</th>
                    <th>Status</th>
                    <th>Days Out</th>
                </tr>
            <#list actives?sort_by("daysOut")?reverse as rent>
                <tr>
                    <th>${rent.getRentId()}</th>
                    <td>${rent.getEquipment().getEquipmentName()}</td>
                    <td>${rent.getStartDate()}</td>
                    <td>${rent.getPromisedDate()}</td>
                    <td>${rent.getPriceRate()}</td>
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


            <br><br>

            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                <tr>
                    <th>#{totalI} Equipment Returns</th>
                </tr>
                <tr>
                    <th>Rent Id</th>
                    <th>Equipment</th>
                    <th>Start Date</th>
                    <th>Promised Date</th>
                    <th>Borrower</th>
                </tr>
            <#list inactives?sort_by("startDate") as rent>
                <tr>
                    <th>${rent.getRentId()}</th>
                    <td>${rent.getEquipment().getEquipmentName()}</td>
                    <td>${rent.getStartDate()}</td>
                    <td>${rent.getPromisedDate()}</td>
                    <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
                </tr>
            </#list>
            </table>
        </div>
    </main>
</div>


</body>