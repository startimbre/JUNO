<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Progressive sign up </title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

	  <link rel="stylesheet" href="resources/amado/css/regi-style.css">
  
</head>

<body>

     <div class="container">
            <div class="navigation">
                <ol>
                    <li><a href="#"  data-ref="name">Name</a></li>
                    <li><a href="#"  data-ref="uname">Username</a></li>
                    <li><a href="#"  data-ref="email">Email</a></li>
                    <li><a href="#"   data-ref="viewpswd">Password</a></li>
                    <li><a href="#"  data-ref="phone">Phone</a></li>
                </ol>
            </div>
            <form id="sign-form" class="sign-form">
                <ol class="questions">
                    <li>
                        <span><label for="name">名前を入力してください。</label></span>
						<input class="active" id="name" name="name" type="text" placeholder="Enter your full name" autofocus/>
                    </li>
                    <li>
				        <span><label for="uname">& IDを入力してください。</label></span>
                        <input id="uname" name="username" type="text" placeholder="Enter a username" autofocus/>
					</li>
                    <li>
				        <span><label for="email">メールアドレスを入力してください。</label></span>
                        <input id="email" name="email" type="text" placeholder="Email"  autofocus/>
					</li>
                    <li>
                        <span><label for="password">PassWordを入力してください。</label></span>
                        <input id="viewpswd" name="password" type="text" placeholder="this your password"/>
                        <input id="password" name="password" type="password" placeholder="make sure you dont forget" autofocus/>
                        <span id="show-pwd" class="view"></span>
					</li>
                    <li>
                        <span><label for="phone">電話番号を入力してください。</label></span>
                            <select name="countryCode" class="country"  >
                                <option data-countryCode="JP" value="81">(+81) JAPAN </option>
                                <option data-countryCode="GB" value="44">(+44) UK </option>
                                <option data-countryCode="US" value="1">(+1) USA </option>
                                <optgroup label="Other countries">
                                   <option data-countryCode="DZ" value="213"> (+213)Algeria</option>
                                   <option data-countryCode="AD" value="376"> (+376) Andorra</option>
                                   <option data-countryCode="AO" value="244">(+244) Angola </option>
                                   <option data-countryCode="AI" value="1264"> (+1264) Anguilla</option>
                                   <option data-countryCode="AG" value="1268">(+1268) Antigua &amp; Barbuda </option>
                                   <option data-countryCode="AR" value="54">(+54) Argentina </option>
                                   <option data-countryCode="AM" value="374"> (+374) Armenia</option>
                                   <option data-countryCode="AW" value="297">(+297) Aruba </option>
                                   <option data-countryCode="AU" value="61"> (+61) Australia</option>
                                   <option data-countryCode="AT" value="43">(+43) Austria </option>
                                   <option data-countryCode="AZ" value="994"> (+994) Azerbaijan</option>
                                   <option data-countryCode="BS" value="1242">(+1242)Bahamas </option>
                                </optgroup>
                            </select>
                            <input id="phone" name="phone" type="text" autofocus/>
                    </li>
                    <li><p style="margin-top: 45px;font-size: 32pt;float:right">
                        <a href="#" style="color:white;text-decoration:none" id="signup">sign up</a></p>    </li>
                
                    
                </ol>
                <div id="next-page" alt="Kiwi standing on oval"></div>
                <div class="error-message"></div>
                
            </form>
        <h1 id="wf" style="opacity:0;width: 600px; margin-top:1.1em;display:none; margin-bottom:1em">
        <a href="index.do">Thank you</a></h1>
 		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script>

  

    <script src="resources/amado/js/register.js"></script>




</body>

</html>