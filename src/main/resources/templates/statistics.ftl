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
                        <th>#{totalR} Rents</th>
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
                <#list rents?sort_by("promisedDate") as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getPriceRate()}</td>
                        <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
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

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 600px;">
                <h4>Most Popular Equipment: <#if popularE != 'Equipment'>${popularE}<#else>None</#if></h4>
                <br>
                <h4>Most Popular Family: <#if popularF != 'Family'>${popularF}<#else>None</#if></h4>
                <br>
                <h4>Most Popular Sub-Family: <#if popularSF != 'SubFamily'>${popularSF}<#else>None</#if></h4>
            </div>

            <br><br>

                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                    <tr>
                        <th>#{totalT} Transactions</th>
                    </tr>
                    <tr>
                        <th>Transaction Id</th>
                        <th>Date</th>
                        <th>Total Price</th>
                        <th>Borrower Id</th>
                        <th>Borrower Name</th>
                        <th>Equipment Id</th>
                        <th>Equipment Name</th>
                    </tr>
                <#list receipts?sort_by("transactionDate") as receipt>
                    <tr>
                        <th>${receipt.getTransactionId()}</th>
                        <td>${receipt.getTransactionDate()}</td>
                        <td>${receipt.getTotalPrice()}</td>
                        <td>${receipt.getBorrower().getIdentificationNumber()}</td>
                        <td>${receipt.getBorrower().getFirstName()} ${receipt.getBorrower().getLastName()}</td>
                        <td>${receipt.getEquipment().getEquipmentId()}</td>
                        <td>${receipt.getEquipment().getEquipmentName()}</td>
                    </tr>
                </#list>
                </table>

            <br><br>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <div id="familyGraph" style=" min-width: 33%"></div>
            </div>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <div id="subFamilyGraph" style=" min-width: 33%"></div>
            </div>

            <script type="text/javascript">
                google.charts.load('current', {'packages':['geochart','corechart','line',"calendar"]});
                google.charts.setOnLoadCallback(drawFamilyChart);
                google.charts.setOnLoadCallback(drawSubFamilyChart);

                function drawFamilyChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['Family', 'Average'],
                    <#list fAve as family>
                        <#if family?is_last>
                                [${family}]
                        <#else>
                                [${family}],
                        </#if>
                    </#list>
                    ]);
                    var options = {
                        title: 'Average Days Rented Per Family',
                        'width':300,
                        'height':300,
                        legend: 'none'
                    };
                    var chart = new google.visualization.PieChart(document.getElementById('familyGraph'));
                    chart.draw(data, options);
                }

                function drawSubFamilyChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['SubFamily', 'Average'],
                    <#list sAve as subFamily>
                        <#if subFamily?is_last>
                                [${subFamily}]
                        <#else>
                                [${subFamily}],
                        </#if>
                    </#list>
                    ]);
                    var options = {
                        title: 'Average Days Rented Per SubFamily',
                        'width':300,
                        'height':300,
                        legend: 'none'
                    };
                    var chart = new google.visualization.PieChart(document.getElementById('subFamilyGraph'));
                    chart.draw(data, options);
                }
            </script>

        </div>
    </main>
</div>


</body>