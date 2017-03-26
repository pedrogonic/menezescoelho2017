/* global lang, requestURI */

$(document).ready(function() {
    $('#lang_'+lang).attr('checked',true);
});

function changeLocale() {
    var selection = $('input[name=lang]:checked').val();
    if (selection !== lang)
        window.location.href = requestURI +"?lang="+selection;
}
