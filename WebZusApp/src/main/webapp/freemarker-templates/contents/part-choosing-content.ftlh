<#ftl encoding='UTF-8'>

<main>
    <h3 class="title-bar">Wybierz interesujące cię części : </h3>
    <div class="container-fluid">
        <form method="post" class="vehicle">
            <label>Wybór kategorii pojazdu</label>
            <select name="category" id="category">
            <#list categories as category>
                <option value="${category.getLink()}">${category.getName()}</option>
            </#list>
            </select>

            <label>Wybór podkategorii</label>
            <select name="subcategory" id="subcategory"></select>
            <select name="subcategory" id="subcategory2"></select>
            <select name="subcategory" id="subcategory3"></select>
        </form>

    </div>

</main>