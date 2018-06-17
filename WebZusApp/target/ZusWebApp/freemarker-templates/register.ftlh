<#include "header.ftlh">

<main>

    <div class="pageContent container-fluid">


        <div class="center_box row">


            <div class="col_content col-sm-12">

                <div class="login_form container">

                    <form>

                        <img src="/image/man.png">
                        <input type="text" placeholder="Wprowadź imię" name="userName" required>
                        <input type="text" placeholder="Wprowadź nazwisko" name="userSurname" required>
                        <input type="password" name="password" placeholder="Wprowadź hasło" required>
                        <input type="password" name="password" placeholder="Powtórz hasło" required>
                        <input type="email" name="email" placeholder="Wprowadź email" required>
                        <input type="tel" name="phoneNumber" placeholder="Wprowadź numer teleonu">
                        <input type="date" name="dateOfBirth" placeholder="Wybierz datę urodzenia" required>
                        <input type="text" placeholder="Kraj" name="adressCountry" required>
                        <input type="text" name="adressCity" placeholder="Nazwa miejscowości" required>
                        <input type="text" name="adressStreet" placeholder="Nazwa ulicy" required>

                    <button type="button">Zarejestreuj</button>
                    <button type="button">Kontynuuj bez rejestracji</button>
                    </form>


                </div>

            </div>

        </div>

    </div>

</main>
<#include  "footer.ftlh">