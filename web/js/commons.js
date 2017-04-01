/* global lang, requestURI, fbName */

$(document).ready(function() {
    
    $('#lang_'+lang).attr('checked',true);
    $('#flag_'+lang).addClass('imgSelected');
    
    // Facebook login, include facebook.js
    fbLogin();
});

function changeLocale(langSel) {
    if (langSel !== lang)
        window.location.href = requestURI +"?lang="+langSel;
}

/* Callback for facebook authentication success */
function grantAccess() {
    
    $('#fbName').html(', ' + fbName);
    
    //TODO let user submit messages and trash his/her messages. 
    
}
