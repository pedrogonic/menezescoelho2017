/* global FB, fbID, contextPath */

var fbName;
var fbUserID;
var fbUserImg = contextPath + '/img/icons/fb-no-profile.jpg';

window.fbAsyncInit = function() {
    FB.init({
      appId      : fbID,
      cookie     : true,
      xfbml      : true,
      version    : 'v2.8'
    });
    FB.AppEvents.logPageView();
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
};

(function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));
   
function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
}
   
function statusChangeCallback(response) {
//    console.log(response);
    if (response.status === 'connected') {
      facebookAPI();
    } else {
      console.log('please login!');
    }
}

function facebookAPI() {
    console.log('Welcome!  Fetching your information.... ');
    
    /* Getting Facebook Info */
    FB.api('/me', function(response) {
        
        fbName = response.name;
        fbUserID = response.id;
        console.log('Successful login for: ' + fbName + ', userID: ' + fbUserID);
        $('#fbName').html(', ' + fbName);
        
        /* Gettign User's profile picture */ 
        FB.api("/" + fbUserID + "/picture", function (response) {
                
            if (response && !response.error) {
                fbUserImg = response.data.url;
            }

//            var img = "<img src='" + fbUserImg + "' />";
//            $('#fbImg').html(img);

        });

        /* Grant access to submit button */
        //TODO
        
    });
}