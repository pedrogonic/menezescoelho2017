/* global fillBlanks, rsvpResult, successTxt */

var count = 1;

$(document).ready(function() { 
    
    if(rsvpResult !== '')
        $('#successMsg').html(rsvpResult + ' ' + successTxt);
    
    $("#rsvpForm").submit(function(e) {
        
        if(!beforeSubmit()) 
            return false;
        
    });
    
    
    $("#add").click(addField);
    
    $("#remove").click(removeField);
    
});

function beforeSubmit() {
    
    $('#submitMsg').attr("disabled", "disabled");
    $("#guestsNames").val("");
    cleanMessages();
    
    var arr = [];
    var ret = true;
    
    $(".rsvpField").each(function (index) {
        if ($(this).val() === "") {
            $('#submitMsg').removeAttr("disabled");
            $('#errorMsg').html(fillBlanks);
            ret = false;
        }
        
        arr.push($(this).val() );
        
    });
    
    $("#guestsNames").val(arr.join(";"));
    
    return ret;
    
}

function addField() {
    
    cleanMessages();
    $("#remove").show("oi");
    count++;
    $("#fieldsDiv").append("<p id='rsvp" + count + "P'><input type=\"text\" id=\"rsvp" + count + "\" class=\"rsvpField\"/>");
    
}

function removeField() {
    
    cleanMessages();
    
    if (count > 1) {
    
        $("#rsvp" + count + "P").remove();
        count--;
        
    }

    if (count === 1) 
        $("#remove").hide();  
    
}

function cleanMessages() {
    
    $('#errorMsg').html('');
    $('#successMsg').html('');
    
}