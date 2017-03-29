/* global lang, requestURI */

$(document).ready(function() {
    $('#lang_'+lang).attr('checked',true);
});

function changeLocale(langSel) {
    if (langSel !== lang)
        window.location.href = requestURI +"?lang="+langSel;
}
