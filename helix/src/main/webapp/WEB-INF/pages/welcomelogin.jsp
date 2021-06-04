<html>
  <head>
  <script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"></script>
  <style>
    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');

    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      user-select: none;
    }

    body {
      display: flex;
      justify-content: center;
      font-family: 'Kumbh Sans', sans-serif;
      background-image: url(https://images.unsplash.com/photo-1568035315233-41f17f324cb0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80);
      background-position: center;
      background-size: cover;
      height: 1200px;
    }

    .login {
      position: fixed;
      display: flex;
      flex-direction: column;
      align-items: center;
      margin: 15px 0;
      width: 380px;
      padding: 30px;
      background-color: rgba(0, 0, 0, 0.7);
      color: white;
      font-family: 'Montserrat',sans-serif;
      box-shadow: -4px 4px 12px 1px rgba(0,0,0,0.4);
    }

    .login header {
      margin-bottom: 25px;
      font-weight: 600;
      font-size: 33px;
      font-weight: 600;
      margin: 0 0 35px 0;
    }

    .field {
      background-color: #fff;
      width: 100%;
      margin-bottom: 15px;
      display: flex;
    }

    .field span {
      color: #222;
      width: 40px;
      line-height: 45px;
      text-align: center;
    }

    .field input {
      width: 100%;
      height: 45px;
      font-size: 1.1rem;
      padding: 5px;
      color: #34495e;
      border: none;
    }

    .field input::placeholder {
      color: #95a5a6;
    }

    input:focus, input:active, input:hover {
      outline: none;
    }

    .forgot-password {
      width: 100%;
      margin-bottom: 15px;
    }

    .forgot-password a {
      color: #FFF;
      text-decoration: none;
    }

    .forgot-password a:hover {
      text-decoration: underline;
    }

    .submit {
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100%;
      height: 45px;
      margin-bottom: 45px;
      font-family: 'Poppins',sans-serif;
      font-size: 1.2rem;
      color: #fff;
      background-color: #0074D9;
      border: none;
      transition: all 0.2s linear;
    }

    .submit:hover {
       cursor: pointer;
       background-color: #0070d1;
    }

    .login-form-copy {
      margin-bottom: 15px;
    }

    .login-form__sign-up {
      text-decoration: none;
      color: #3498db;
    }

    .login-form__sign-up:hover {
      text-decoration: underline;
    }

    .social-icons {
      display: flex;
      width: 100%;
      justify-content: space-between;
      padding-bottom: 15px;
    }

    .social-icon {
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 1.4rem;
      width: 50px;
      height: 50px;
      border-radius: 50%;
      cursor: pointer;
      margin-bottom: 35px;
    }

    .facebook {
      background-color: #3b5998;
    }

    .instagram {
      background-color: #F56040;
    }

    .twitter {
      background-color: #00acee;
    }

    .google {
      background-color: #DB4437;
    }

    .linkedin {
      background-color: #2867B2;
    }
  </style>
  </head>
  <body>
    <form action="/" class="login">
      <header>Login</header>
      <div class="field"><span class="fa fa-envelope"></span><input id = "signup-email" type="text" placeholder="Email Address"></div>
      <div class="field"><span class="fa fa-lock"></span><input id = "signup-password" type="password" placeholder="Password"></div>
      <p style="color:red ; display:none" id = "signup-error"></p>
      <button type="button" class="submit" id = "btn-signup">Login</button>
    </form>

    <script>
    function validateSignUpForm()
    {
        var email = $("#signup-email").val();
        var password = $("#signup-password").val();
        var error = "";


        if(!email)
        {
            error += "Email is empty";
        }
        if(!password)
        {
            error += "Password is empty";
        }
        if((!!password) && (password.length< 3))
        {
            error += "Password Length must be greater than 3 characters ";
        }

        $("#signup-error").html(error);
        if(error.length>0)
        {
            return false;
        }
        return true;
    }

    $("#btn-signup").click(
        function(){
            var isvalidform = validateSignUpForm();
            if(isvalidform)
            {
                $("#signup-error").hide();

                var email = $("#signup-email").val();
                var password = $("#signup-password").val();

                var user = {"email":email,"password":password};

                $.ajax({
                  type: "POST",
                  url: "/login/welcome",
                  data: JSON.stringify(user),
                  success: function(response){
                        if(response.is_logged_in == true){
                            location.href = "/user/welcome";
                        }
                        else
                        {
                            $("#signup-password").val("");
                            $("#signup-error").html(response.message);
                            $("#signup-error").show();
                        }
                  },
                  contentType: "application/json"
                });
            }
            else
            {
                $("#signup-error").show();
            }
        }
    );
    </script>
  </body>
</html>