function changeLangToRU() {
    window.location.replace('?lang=ru');
}
function changeLangToEN() {
    window.location.replace('?lang=en');
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