<#ftl encoding="UTF-8">
<div class="modal" id="login-modal">
    <div class="modalHeader">
        <h3>Sukces, udana próba logowania</h3>
    </div>
    <div class="modalBody">
        <span>Witaj ${user.getName()} !</span>
    </div>
    <div class="modalFooter">
        <form>
            <button type="submit" formaction="/vehicle-choosing">Kontynuuj!</button>
        </form>
    </div>
</div>