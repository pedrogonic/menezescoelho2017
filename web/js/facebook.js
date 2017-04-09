/* global FB, fbID, contextPath, defaultFbUserImg */

(function(d, s, id){
    
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
    
 }(document, 'script', 'facebook-jssdk'));

function userLoggedIn () {
    
    if (fbUserID === '')
        return false;
    return true;
    
}

function fbLogin () {
    
    if (!userLoggedIn()) {

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

    } else { grantAccess(); }
    
}
   
function checkLoginState() {
    
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
    
}
   
function statusChangeCallback(response) {
    
    if (response.status === 'connected') {
      facebookAPI();
    } else {
      console.log('please login!');
    }
    
}

function facebookAPI() {
    
    console.log('Welcome!  Fetching your information.... ');
    
    /* Getting Facebook Info */
    FB.api('/me?fields=id,name,email', function(response) {
        
        console.log(response);
        
        fbName = response.name;
        fbUserID = response.id;
        fbEmail = response.email;
        console.log('Successful login for: ' + fbName 
                + ', userID: ' + fbUserID 
                + ', email: ' + fbEmail);
        
        fbUserImg = defaultFbUserImg;
        
        /* Getting User's profile picture */ 
        FB.api("/" + fbUserID + "/picture", function (response) {
                
            if (response && !response.error) {
                console.log('Profile picture OK!');
                fbUserImg = response.data.url;
            }

            saveInSession();
            grantAccess();

        });

    });
    
}

function saveInSession() {
    
    $.ajax({
        
        url: contextPath + '/Authentication',
        method: 'POST',
        data: { 
            'fbUserID' : fbUserID,
            'fbName' : fbName,
            'fbEmail' : fbEmail,
            'fbUserImg' : fbUserImg
        },
        datatype: 'json'
        
    }).done(console.log('FB information saved in session!'));
    
}