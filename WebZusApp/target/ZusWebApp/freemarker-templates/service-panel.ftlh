<#ftl encoding='UTF-8'>
<#include "header.ftlh">

<main>

    <div class="container-fluid" id="servicePanel">
        <div class="row no-gutters">

            <div class="col-sm-12"><h2>Witaj w panelu serwisanta</h2></div>
            <div class="container-fluid">
                <div class="row no-gutters">
                <div class="col-lg-2    col-md-3 col-sm-12" id="servicePanelManagment">
                    <h3>Panel</h3>
                    <ul>
                        <li>Zamówienia</li>
                        <li>Zadania</li>
                        <li>Wiadomości</li>
                    </ul>
                </div>
                <div class="col-lg-10 col-md-9 col-sm-12" id="serviceBigBox">
                    <div class="container-fluid">
                        <div class="row no-gutters">

                            <div class="col-md-2 col-sm-12" id="orderList">
                                <div><h3>Lista zamówień</h3><ul>
                                    <li>Zamowienie 1 : nr 010203</li>
                                    <li>Zamowienie 2 : nr 020203</li>
                                    <li>Zamowienie 3 : nr 030203</li>
                                    <li>Zamowienie 4 : nr 040203</li>
                                    <li>Zamowienie 5 : nr 050203</li>
                                    <li>Zamowienie 6 : nr 060203</li>
                                    <li>Zamowienie 7 : nr 070203</li>
                                    <li>Zamowienie 8 : nr 080203</li>
                                </ul></div>

                            </div>

                            <div class="col-md-10 col-sm-12" id="orderDetails">
                                <div><h3>Szczegóły zamówienia</h3>
                                    <div class="container-fluid">
                                        <div class="row no-gutters">
                                            <div class="col-sm-12">
                                                <h4>Zamowienie nr : <strong>numer zamówienia</strong></h4>
                                            </div>
                                            <div class="col-md-4 col-sm-12 orderDetailsCard"><h4>Dane zamawiającego</h4>
                                            <ul>
                                                <li>Nazwa użytkownika : </li>
                                                <li>Imię : </li>
                                                <li>Nazwisko : </li>
                                                <li>Adres : </li>
                                            </ul></div>
                                            <div class="col-md-4 col-sm-12 orderDetailsCard"><h4>Szczegóły pojazdu</h4>
                                            <ul>
                                                <li>Marka : </li>
                                                <li>Model : </li>
                                                <li>Rok produkcji : </li>
                                                <li>Wersja : </li>
                                            </ul></div>
                                            <div class="col-md-4 col-sm-12 orderDetailsCard"><h4>Szczegóły części</h4><ul>
                                                <li>Id: </li>
                                                <li>Numer : </li>
                                                <li>Nazwa : </li>
                                                <li>Producent : </li>
                                                <li>Właściwości : </li>
                                                <li>Dodatkowe informacje : </li>
                                            </ul></div>
                                            <div class="col-md-10 col-sm-12 orderDetailsCard"><h4>Uwagi : </h4></div>
                                            <div class="col-md-2 col-sm-12 orderDetailsCard"><h4>Status :</h4></div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
                </div>
            </div>

        </div>
    </div>

</main>

<#include "footer.ftlh">