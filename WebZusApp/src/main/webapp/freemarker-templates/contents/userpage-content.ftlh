<#ftl encoding='UTF-8'>
<main>
    <div class="container-fluid">
        <div class="row userTab">
            <div class="col-sm-2">
                <i class="fas fa-user-circle"></i><span>Jan Kowalski</span>
            </div>
            <div class="col-sm-10 userMenu">
                <ul>
                    <li id="infoPanel">Info</li>
                    <li id="userPanel">Konto</li>
                    <li id="carPanel">Pojazd</li>
                    <li id="orderPanel">Zamówienia</li>
                    <li><form method="post"><button type="submit" class="btn btn-primary" id="orderButton">Zamów części</button></form></li>
                    <li><button class="btn btn-danger" id="logoutButton">Wyloguj</button></li>

                </ul>
            </div>
        </div>
        <h3>Witaj w panelu użytkownika</h3>
        <div class="panels">
        <div class="container-fluid infoPanel">
            <div class="row">
                <h4>Panel informacyjny</h4>
                <div class="col-sm-4">
                    <h5>Moudł wyboru pojazdu</h5>
                    <p>
                        W module wybierania pojazdu możesz wybrać pojazd
                        który cię interesuje, masz do wyboru kilkadziesiąt marek
                        pojazdów oraz dopasowanych do nich modeli. Po wybraniu modelu
                        zostaniesz poproszony o wybranie wersji modelu oraz roku produkcji.
                        Twój wyboru w momencie zalogowania będzie przechowywany na twoim koncie
                        w zakładce <strong>POJAZD</strong>, możesz przechowywać więcej niż jeden
                        pojazd. Przehowywanie pojazdu ułatwia kolejne wyszukiwanie potrzebnych części
                    </p>
                </div>
                <div class="col-sm-4">
                    <h5>Moduł wyboru części</h5>
                    <p>
                        Po wybraniu pojazdu możesz przejść do modułu wybierania części, do każdego modelu
                        możesz wybrać odpowiednie części po wcześniejszym wyborze kategorii. Zapisanie wcześniej wybranego
                        samochodu w swoich pojazdach ułatwia późniejsze wybranie kolejnych części. Po wybraniu jednej części
                        możesz pozostać w module wybierania części i wybrać kolejne. Po zaakcepotwaniu wyboru twoje zamówienie
                        trafia do systemu ze statusem "Oczekujące", podczas procesowania zamówienia przez naszego pracownika
                        status twojego zamówienia ulega zmianie, o kązdej będziesz poinformowany.
                    </p>
                </div>
                <div class="col-sm-4">
                    <h5>Realizacja zamówień</h5>
                    <p>
                        Złożone przez Ciebie zamówienie trafia na koniec kolejki i czeka na przyjęcie przez
                        naszego pracownika, po przyjęciu zamówienia przez naszego pracownika status zostaje zmieniony
                        na "W realizacji". Nasz pracownik sprawdza zamówione produkty, dostępność, stan magazynowy,
                        potwierdza cenę. Jesli wszystkie produkty z twojego zamówinia są dostępne status twojego zamówienia
                        ponownie ulega zmianie na "Prygotowanie do wydania". Zamówienie możesz odberać osobiście w naszej placówce
                        lub poprosić o wysłanie kurierem. W zależności od wybranej przez Ciebie opcji zamówienie zmienia status
                        na "Czeka na odbiór" lub "W wysyłce".Jeśli zamówienie trafiło do wysyłki zostaniesz o tym powiadomiony.
                    </p>
                </div>
            </div>
        </div>
        <div class="container-fluid userPanel">
            <div class="row">
                <h4>Panel użytkownika</h4>
                <div class="col-sm-12">
                    <h5>Dane personalne</h5>
                    <div class="container-fluid">
                        <div class="row no-gutters">
                            <div class="col-sm-2">
                                <img src="../../image/user_photo.png">
                                <button class="btn">Dodaj zdjęcie</button>
                            </div>
                            <div class="col-sm-10 userDetails">
                                <h6>Dane użytkownika</h6>
                                <div>
                                    <span class="headerTab">Imię</span>
                                    <span class="headerTab">Nazwisko</span>
                                    <span class="headerTab">Mail</span>
                                </div>
                                <div>
                                    <span class="userDetailInfo">Jan</span>
                                    <span class="userDetailInfo">Kowalski</span>
                                    <span class="userDetailInfo">jankowalski@poczta.pl</span>
                                </div>
                                <h6>Dane adresowe</h6>
                                <div>
                                   <div>
                                       <span class="headerTab">Kraj</span>
                                       <span class="headerTab">Miasto</span>
                                       <span class="headerTab">Ulica</span>
                                   </div>
                                    <div>
                                        <span class="userDetailInfo">Polska</span>
                                        <span class="userDetailInfo">Warszawa</span>
                                        <span class="userDetailInfo">Puławska 2/67</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid carPanel">
            <div class="row carInfo">
                <h4>Panel pojazdu</h4>
                <div class="col-sm-2 carList">
                    <h5>Twoje pojazdy</h5>
                </div>
                <div class="col-sm-10 carDetails">
                    <h5>Szczegóły pojazdu</h5>
                </div>
            </div>
        </div>
        <div class="container-fluid orderPanel">
            <div class="row">
                <h4>Panel zamówień</h4>
                <div class="col-sm-2 orderList">
                    <h5>Lista zamówień</h5>
                </div>
                <div class="col-sm-10 orderDetails">
                    <h5>Szczegóły zamówienia</h5>
                </div>
            </div>
        </div>
        </div>
</main>