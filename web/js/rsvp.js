var count = 1;

$(document).ready(function() { 
    
    $("#rsvpForm").submit(function(e) {
        
        if(!beforeSubmit()) 
            return false;
        
    });
    
    
    $("#add").click(addField);
    
    $("#remove").click(removeField);
    
});

function beforeSubmit() {
    
    $("#guestsNames").val("");
    
    var arr = [];
    var ret = true;
    
    $(".rsvpField").each(function (index) {
        if ($(this).val() === "") {
            //TODO add msg
            console.log("erro");
            ret = false;
        }
        
        arr.push($(this).val() );
        
    });
    
    $("#guestsNames").val(arr.join(";"));
    
    return ret;
    
}

function addField() {
    
    $("#remove").show("oi");
    count++;
    $("#fieldsDiv").append("<input type=\"text\" id=\"rsvp" + count + "\" class=\"rsvpField\"/>");
    
}

function removeField() {
    
    $("#rsvp"+count).remove();
        
    count--;

    if (count === 1) 
        $("#remove").hide();  
    
}