<#include "header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "navbar.ftl">
<#include "sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <div class="mdl-grid demo-content">

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 600px;">
                <h4>Client Information</h4>
                <h5>Identification Number: ${client.getIdentificationNumber()}</h5>
                <br>
                <h5>Name: ${client.getFirstName()} ${client.getLastName()}</h5>
                <br>
                <h5>Telephone Number: ${client.getTelephone()}</h5>
                <h5>Address: ${client.getAddress()}</h5>
            </div>

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 800px">
                <table>
                    <tr>
                        <th>History: ${totalR} Rents</th>
                    </tr>
                    <tr>
                        <th>Rent Id</th>
                        <th>Equipment</th>
                        <th>Start Date</th>
                        <th>Promised Date</th>
                        <th>Price Rate</th>
                        <th>Status</th>
                        <th>Days Out</th>
                    </tr>
                <#list rents?sort_by("promisedDate") as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getPriceRate()}</td>
                        <#if rent.isActive()>
                            <td>ACTIVE</td>
                            <td>${rent.getDaysOut()}</td>
                        <#else>
                            <td>COMPLETED</td>
                            <td>N/A</td>
                        </#if>
                    </tr>
                </#list>
                </table>
            </div>
        </div>
    </main>
</div>


</body>