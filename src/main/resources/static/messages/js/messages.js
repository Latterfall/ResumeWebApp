window.onload = function () {
    loadMessages()
}
function deleteMessage(id) {
    $.ajax({
        type: "POST",
        url: "/api/messages/delete/" + id,
        success:
            loadMessages()
    });
}
function loadMessages() {
    $.ajax({
        type: "GET",
        url: "/api/messages/all",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success:
            function(messages) {
                let innerHTML = "";
                messages.forEach(message => {
                    let viewedPicture
                    if (message.viewed) {
                        viewedPicture = "<img src='static/messages/images/messageIsRead.png'>"
                    } else {
                        viewedPicture = "<img src='static/messages/images/messageNotRead.png'>"
                    }
                    innerHTML +=
                        "<div class=\"messageContainer\">" +
                        "    <div class=\"messageImage\">" +
                        viewedPicture +
                        "    </div>" +
                        "    <div class=\"messageHeader\">" +
                        message.messageHeader +
                        "    </div>" +
                        "    <div class=\"messageSubject\">" +
                        message.messageSubject +
                        "    </div>" +
                        "    <div class=\"actionButtons\">" +
                        "        <button onclick='deleteMessage(" + message.id + ")'>Delete</button>" +
                        "    </div>" +
                        "</div>"
                    $(".messagesContainer").html(innerHTML)
                })
            }
    });
}