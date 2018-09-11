<#ftl encoding='UTF-8'>

<main>
    <h3 class="title-bar">Wybierz interesujące cię części : </h3>
    <div class="container-fluid">
        <form method="post" class="vehicle">
            <label>Wybór marki pojazdu</label>
            <select name="brands" id="brands">
            <#list categories as category>
                <option value="${category.getLink()}">${category.getName()}</option>
            </#list>
            </select>

            <label>Wybór modelu pojazdu</label>
            <select name="models" id="models"></select>

            <label>Wybór wersji pojazdu</label>
            <select name="version" id="version"></select>

            <label>Wybór kategorii</label>
            <select name="category" id="category"></select>

            <label>Wybór podkategorii</label>
            <select name="subcategory" id="subcategory"></select>
            <select name="subcategory" id="subcategory2"></select>
            <select name="subcategory" id="subcategory3"></select>
        </form>

    </div>

</main>