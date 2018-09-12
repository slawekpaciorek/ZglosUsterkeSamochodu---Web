<#ftl encoding='UTF-8'>

<main>
<h3 class="title-bar">Wybierz swoje auto : </h3>
<div class="container-fluid">
    <form method="post" class="vehicle">
        <label>Wybór marki pojazdu</label>
        <select name="brands" id="brands">
            <#list brandList as brand>
                <option value="${brand.getLink()}">${brand.getName()}</option>
            </#list>
        </select>

        <label>Wybór modelu pojazdu</label>
        <select name="models" id="models"></select>

        <label>Wybór wersji pojazdu</label>
        <select name="version" id="version"></select>

    </form>

    <form method="post">
        <button type="submit" class="btn">Idź dalej</button>
    </form>

</div>

</main>

