/* global bPopupConfirmClose, confirmDeletionMsg, contextPath */

/* Changes username's color in new message */
function changeColor() {
    
    $('#userName').css('color',$('#colorpicker').val());
    
}

$(document).ready(function() { 
    
    /* Front end check for message body */
    $("#postMessageForm").submit(function(e) {

        if ( $("#newMsgBody").val() === "" ) {
            return false;
        }
        
        return true;

    });
    
    /* Apply masonry library */
    $('.mural').masonry({
        // options
        itemSelector: '.msg',
        gutter: 10
    });
    
});


/**
 * Submits delete message form
 * @param {String} messageID
 */
function trash (messageID) {
    
    $("#deleteMessageID").val(messageID);
    $("#deleteMessageForm").submit();
    
}

/* Opens popup for deletion confirmation */
function confirmTrash (messageID) {
    
    bPopupConfirm(confirmDeletionMsg, trash, [messageID]);
    
}