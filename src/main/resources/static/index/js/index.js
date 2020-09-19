let isUserLocaleRU

window.onload = function () {
    getUserLocale()
    putActionButton()
}
function sendMessage() {
    let message = {
        "messengerName" : document.getElementById("messengerName").value,
        "messengerLastname" : document.getElementById("messengerLastname").value,
        "messengerEmail" : document.getElementById("messengerEmail").value,
        "messageHeader" : document.getElementById("messageHeader").value,
        "messageSubject" : document.getElementById("messageSubject").value,
        "messageText" : document.getElementById("messageText").value
    }
    $.ajax({
        type: "POST",
        url: "/api/messages/add",
        data: JSON.stringify(message),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });
    alert("Thank you for your message!")
    document.getElementById("messengerName").value = ""
    document.getElementById("messengerLastname").value = ""
    document.getElementById("messengerEmail").value = ""
    document.getElementById("messageHeader").value = ""
    document.getElementById("messageSubject").value = ""
    document.getElementById("messageText").value = ""
}
function goToLoginPage() {
    location.replace("/login")
}
function goToMessagesPage() {
    location.replace("/messages")
}
function putActionButton() {
    $.ajax({
        type: "GET",
        url: "/api/user/isLogged",
        success: function (response) {
            let authActionButtonText, messagesActionButtonText
            if (isUserLocaleRU) {
                authActionButtonText = "Авторизация"
                messagesActionButtonText = "К сообщениям"
            } else {
                authActionButtonText = "Authorization"
                messagesActionButtonText = "Messages"
            }
            let langAndActionButtonsDiv = document.getElementById("langAndActionButtons")
            let currentInnerHTML = langAndActionButtonsDiv.innerHTML
            if (response) {
                langAndActionButtonsDiv.innerHTML = "<button onclick=\"goToMessagesPage()\">" + messagesActionButtonText +"</button>" + currentInnerHTML
            } else {
                langAndActionButtonsDiv.innerHTML = "<button onclick=\"goToLoginPage()\">" + authActionButtonText +"</button>" + currentInnerHTML
            }
        }
    });
}