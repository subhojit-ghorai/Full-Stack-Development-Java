$(".follow-member").click( function(event){
  var button =this;
  //debugger;
  var isFollowed = $(button).hasClass("followed-button");
  if(isFollowed)
  {
    $.ajax({
        type: "POST",
        url: "/user/un-follow-member", // when button is pressed I will create a POST request to this URL.
        data: this.getAttribute("member-id"), //event.target is equivalent to the button.   // I will send this data in the POST request.
        success: function(response){
            if(!!response){
               //alert(response);    // whatever response is coming from the server, I am printing it in the alert message.
               //debugger;
               $(button).removeClass("followed-button");
               button.querySelector("span").innerText = "Follow";
            }
        },
        contentType: 'application/json'
      });
  }
  else
  {
      $.ajax({
        type: "POST",
        url: "/user/follow-member", // when button is pressed I will create a POST request to this URL.
        data: this.getAttribute("member-id"), //event.target is equivalent to the button.   // I will send this data in the POST request.
        success: function(response){
            if(!!response){
               //alert(response);    // whatever response is coming from the server, I am printing it in the alert message.
               //debugger;
               $(button).addClass("followed-button");
               button.querySelector("span").innerText = "UnFollow";
            }
        },
        contentType: 'application/json'
      });
  }
});