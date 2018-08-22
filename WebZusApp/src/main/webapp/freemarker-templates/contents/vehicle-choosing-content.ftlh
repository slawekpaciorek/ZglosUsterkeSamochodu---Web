<#ftl encoding='UTF-8'>

<main>
<h3>Wybierz swoje auto : </h3>
<div class="container-fluid">
    <form method="post">
        <select id="brands">
            <#list brandList as brand>
                <option value="${brand.getLink()}">${brand.getName()}</option>
            </#list>
        </select>
        <select name="models" id="models">
            <#--<#list modelssList as model>-->
                <#--<option value="${model.getLink()}">${model.getName()}</option>-->
            <#--</#list>-->
        </select>
        <select name="version" id="version">
            <#--<#if versionList??>-->
                        <#--<#list versionList as version>-->
                                <#--<option value="${version.getLink()}">${version.getName()}</option>-->
                        <#--</#list>-->
            <#--</#if>-->
        </select>
    </form>

    <#if car??>
        <div>
           <h4>Marka pojazdu : ${car.getBrand().getName()}</h4>
            <h4>Model pojazdu : ${car.getModel().getName()}</h4>
            <h4>Wersja silnika : ${car.getVersion().getName()}</h4>
            <h4>Lata produkcji : ${car.getModel().getStart_year()} - ${car.getModel().getEnd_year()}</h4>
        </div>
    </#if>

</div>

</main>

