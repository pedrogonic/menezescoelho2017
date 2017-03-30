/* global lang, requestURI */

$(document).ready(function() {
    $('#lang_'+lang).attr('checked',true);
    $('#flag_'+lang).addClass('imgSelected');
});

function changeLocale(langSel) {
    if (langSel !== lang)
        window.location.href = requestURI +"?lang="+langSel;
}
