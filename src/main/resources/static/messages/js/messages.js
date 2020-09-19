let isUserLocaleRU

window.onload = function () {
    getUserLocale()
    getMessages()
}
function deleteMessage(id) {
    $.ajax({
        type: "POST",
        url: "/api/messages/delete/" + id,
        success: function () {
            getMessages()
        }
    });
}
function getMessages() {
    $.ajax({
        type: "GET",
        url: "../api/messages/all",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (messages) {
            putMessagesInDocument(messages)
            let buttonText
            if (isUserLocaleRU) {
                buttonText = "Вернуться на главную страницу"
            } else {
                buttonText = "Go back to main page"
            }
            let messageFooter =
                "<div class='messageFooter'>" +
                    "<button onclick='replaceToIndexPage()'>" +
                        buttonText +
                    "</button>" +
                "</div>"
            $(".messagesContainer").append(messageFooter)
        }
    });
}
function getMessage(storyId) {
    $.ajax({
        type: "POST",
        url: "/api/messages/setViewed/" + storyId + "/true",
        success: function () {
            $.ajax({
                type: "GET",
                url: "../api/messages/" + storyId,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (message) {
                    $(".messagesContainer").empty()
                    putMessageInDocument(message, false)
                    addSetNotViewedButtonToMessage(storyId)
                    addTextAndFooterToMessage(message)
                }
            });
        }
    });
}
function addSetNotViewedButtonToMessage(storyId) {
    let setNotViewedButtonText
    if (isUserLocaleRU) {
        setNotViewedButtonText = "В непрочитанные"
    } else {
        setNotViewedButtonText = "Set not viewed"
    }
    let setMessageIsNotViewed =
        "<button onclick='setMessageIsNotViewed(" + storyId + ")'>" +
            setNotViewedButtonText +
        "</button>"
    $(".messagesContainer .actionButtons").append(setMessageIsNotViewed)
}
function addTextAndFooterToMessage(message) {
    let fromLabelText, messageTextLabelText, goBackButtonText
    if (isUserLocaleRU) {
        fromLabelText = "От:"
        messageTextLabelText = "Текст сообщения:"
        goBackButtonText = "Вернуться назад"
    } else {
        fromLabelText = "From:"
        messageTextLabelText = "Message text:"
        goBackButtonText = "Go back"
    }
    let messageText =
        "<div class='messageText'>" +
            "<h2>" +
                fromLabelText +
            "</h2>" +
            message.messengerName + " " + message.messengerLastname + ", " + message.messengerEmail +
            "<h2>" +
                messageTextLabelText +
            "</h2>" +
            message.messageText +
        "</div>"
    let messageFooter =
        "<div class='messageFooter'>" +
            "<button onclick='getMessages()'>" +
                goBackButtonText +
            "</button>" +
        "</div>"
    $(".messagesContainer").append(messageText).append(messageFooter)
}
function putMessagesInDocument(messages) {
    $(".messagesContainer").empty()
    messages.forEach(message => {
        putMessageInDocument(message, true)
    })
}
function putMessageInDocument(message, needToAddLink) {
    let isMessageViewedPictureLink
    if (message.viewed) {
        isMessageViewedPictureLink = "<img src='static/messages/images/messageIsViewed.png'>"
    } else {
        isMessageViewedPictureLink = "<img src='static/messages/images/messageNotViewed.png'>"
    }
    let linkToTheMessage
    if (needToAddLink) {
        linkToTheMessage =
            "<a onclick='getMessage(" + message.id + ")'>" +
                message.messageHeader +
            "</a>"
    } else {
        linkToTheMessage = message.messageHeader
    }
    let deleteButtonText
    if (isUserLocaleRU) {
        deleteButtonText = "Удалить"
    } else {
        deleteButtonText = "Delete"
    }
    let innerHTML =
        "<div class=\"messageContainer\">" +
            "<div class=\"messageImage\">" +
                isMessageViewedPictureLink +
            "</div>" +
            "<div class=\"messageHeader\">" +
                linkToTheMessage +
            "</div>" +
            "<div class=\"messageSubject\">" +
                message.messageSubject +
            "</div>" +
            "<div class=\"actionButtons\">" +
                "<button onclick='deleteMessage(" + message.id + ")'>" + deleteButtonText + "</button>" +
            "</div>" +
        "</div>"
    $(".messagesContainer").append(innerHTML)
}
function setMessageIsNotViewed(storyId) {
    $.ajax({
        type: "POST",
        url: "/api/messages/setViewed/" + storyId + "/false",
        success: function () {
            $(".messagesContainer .messageImage").html("<img src='static/messages/images/messageNotViewed.png'>")
        }
    });
}
function replaceToIndexPage() {
    location.replace("/..")
}