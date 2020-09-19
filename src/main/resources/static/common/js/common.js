function changeLangToRU() {
    window.location.replace('?lang=ru');
}
function changeLangToEN() {
    window.location.replace('?lang=en');
}
function getUserLocale() {
    $.ajax({
        type: "GET",
        url: "/api/locale",
        success: function (locale) {
            if (locale === "ru") {
                isUserLocaleRU = true
            } else {
                isUserLocaleRU = false
            }
        }
    })
}