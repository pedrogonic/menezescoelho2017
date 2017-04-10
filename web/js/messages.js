function changeColor() {
    
    $('#userName').css('color',$('#colorpicker').val());
    
}

$(document).ready(function() { 
    
    $("#postMessageForm").submit(function(e) {

        e.preventDefault();
        //TODO
        console.log("submit");
        return false;

    });
    
});