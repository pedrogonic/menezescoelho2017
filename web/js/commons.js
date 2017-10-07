/* global lang, requestURI, fbName, fbUserImg */

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
    
    // Hide button
    $('#fbLoginButton').hide();
    
    // Welcome
    $('#fbName').html(', ' + fbName);
    
    // Message
    var pic = '<img id="userPic" class="fbProfilePic" src="' + fbUserImg + '"/>';
    $('#userPic').html(pic);
    $('#userName').html(fbName);
    $('#userInfo').show();
    $('#submitMsg').attr('disabled', false);
    $('#submitMsg').val('Enviar');
    $('#submitRSVP').attr('disabled', false);
    $('#submitRSVP').val('Enviar');
    
    //location.reload();
    
}
