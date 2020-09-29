// Initiating slider
document.addEventListener( 'DOMContentLoaded', function () {
	new Splide( '.splide' ).mount();
} );



// Smooth moving to the anchor link
$(document).on('click', 'a[href^="#"]', function (event) {
    event.preventDefault();

    $('html, body').animate({
        scrollTop: $($.attr(this, 'href')).offset().top
    }, 500);
});



// Zoom-in-out of image when focusing the corresponding text block
$(document).ready(function() {
    setZoomingElement("#biographyIntroductionImage")
    setFlickeringElement("#biographyIntroductionHeaderCard")

    setZoomingElement("#biographyEarlyYearsImage")
    setFlickeringElement("#biographyEarlyYearsTextCard")

    setFlickeringElement("#biographyStudyingHeaderCard")
    setZoomingElement("#biographyStudyingHeaderImage")
    setFlickeringElement("#biographyStudyingTextCard")

    setZoomingElement("#biographyWorkingImage")
    setFlickeringElement("#biographyWorkingTextCard")

    setZoomingElement("#biographyCodingImage")
});



function setZoomingElement(elementId) {
    $(elementId).mouseover(function() {
        $(elementId).css("transform", "scale(1.1)");
    });
    $(elementId).mouseout(function() {
        $(elementId).css("transform", "scale(1)");
    });
}
function setFlickeringElement(elementId) {
    $(elementId).mouseover(function() {
        $(elementId).css("filter", "brightness(110%)");
    });
    $(elementId).mouseout(function() {
        $(elementId).css("filter", "brightness(100%)");
    });
}
function setZoomingElements(elementOneId, elementTwoId) {
    $(elementOneId).mouseover(function() {
        $(elementTwoId).css("transform", "scale(1.1)");
    });
    $(elementOneId).mouseout(function() {
        $(elementTwoId).css("transform", "scale(1)");
    })
}



function sendMessage() {
    let messageSubjectInput = $("#messageSubject")
    let messengerNameInput = $("#messengerName")
    let messengerLastnameInput = $("#messengerLastname")
    let messengerEmailInput = $("#messengerEmail")
    let messengerCompanyInput = $("#messengerCompany")
    let messageTextInput = $("#messageText")

    let message = {
        "messageSubject" : messageSubjectInput[0].value,
        "messengerName" : messengerNameInput[0].value,
        "messengerLastname" : messengerLastnameInput[0].value,
        "messengerEmail" : messengerEmailInput[0].value,
        "messengerCompany" : messengerCompanyInput[0].value,
        "messageText" : messageTextInput[0].value
    }
    console.log(message)
    $.ajax({
        type: "POST",
        url: "/api/messages/add",
        data: JSON.stringify(message),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });

    alert("MESSAGE WAS SENT")

    messageSubjectInput.value = ""
    messengerNameInput.value = ""
    messengerLastnameInput.value = ""
    messengerEmailInput.value = ""
    messengerCompanyInput.value = ""
    messageTextInput.value = ""
}