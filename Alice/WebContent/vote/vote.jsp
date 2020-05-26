<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>이달의 회원</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#add').click(function(){
		location.href="check.do";
	});
});
</script>
<body class="w3-content" style="max-width: 1200px">

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top"
		style="z-index: 3; width: 250px" id="mySidebar">
		<div class="w3-container w3-display-container w3-padding-16">
			<i onclick="w3_close()"
				class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
			<h3 class="w3-wide">
				<b>touch your hand javava</b>
			</h3>
		</div>
		<div class="w3-padding-64 w3-large w3-text-grey"
			style="font-weight: bold">
			<a href="#" class="w3-bar-item w3-button">Free Board</a> <a href="#"
				class="w3-bar-item w3-button">Trainer Board</a> <a href="#"
				class="w3-bar-item w3-button">Client Info</a> <a href="#"
				class="w3-bar-item w3-button">Notice</a>
		</div>
		<a href="#footer" class="w3-bar-item w3-button w3-padding">Contact</a>
		<a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding"
			onclick="document.getElementById('newsletter').style.display='block'">Newsletter</a>
		<a href="#footer" class="w3-bar-item w3-button w3-padding">Subscribe</a>
	</nav>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Push down content on small screens -->
		<div class="w3-hide-large" style="margin-top: 83px"></div>

		<!-- Top header -->
		<header class="w3-container w3-xlarge">
			<p class="w3-left">WelCome This Place!!!</p>
			<p class="w3-right">
				<i class="fa fa-shopping-cart w3-margin-right"></i> <i
					class="fa fa-search"></i>
			</p>
		</header>

		<!-- Image header -->
		<div class="w3-display-container w3-container">
			<div class="w3-display-topleft w3-text-white"
				style="padding: 24px 48px; display: none;">
				<h1 class="w3-jumbo w3-hide-small">New arrivals</h1>
				<h1 class="w3-hide-large w3-hide-medium">New arrivals</h1>
				<h1 class="w3-hide-small">COLLECTION 2016</h1>
				<p style="display:none;">
					<a href="#jeans"
						class="w3-button w3-black w3-padding-large w3-large">SHOP NOW</a>
				</p>
			</div>
		</div>

		<div class="w3-container w3-text-grey" id="jeans" style="background-color:#000; width: 100%;">
            <div style="width:50%; float: left;"><p style="color:#fff; display: block; font-weight:bold;">이달의 회원</p></div>
            <!--<div style="width:50%; float: left;"><p style="text-align: right; font-size:13px; color:#fff; margin-top: 15px;"><a href="#" style="text-decoration: none;">더보기 +</a></p></div>-->
		</div>
		<div class="w3-button" id="add">신청하기</div>
		<!-- Product grid -->
		<div class="w3-row w3-grayscale" style="padding-top:10px; margin-bottom: 40px;">
			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원1<br>
						<b>He is Strong</b><br>
						<b>PLACE: GURO</b>
                    </p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<div class="w3-display-container">
						<img src="http://placehold.it/205?text=sample" style="width: 100%">
					</div>
					<p>
						회원2<br>
						<b>fx search</b><br>
						<b>MASTER</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원3<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원4<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원5<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원6<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원7<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원8<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원9<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원10<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원11<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원12<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원13<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원14<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원15<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원16<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원17<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원18<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원19<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
            <div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원20<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
            
        </div>
			
			<!--<div class="w3-container w3-text-grey" id="jeans" style="background-color:#000; width: 100%;">
                <div style="width:50%; float: left;"><p style="color:#fff; display: block; font-weight:bold;">이달의 트레이너</p></div>
                <div style="width:50%; float: left;"><p style="text-align: right; font-size:13px; color:#fff; margin-top: 15px;"><a href="#" style="text-decoration: none;">더보기 +</a></p></div>
		    </div>-->
			
			<!--<div class="w3-row w3-grayscale" style="padding-top:10px;">
			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너1<br>
						<b>He is Strong</b><br>
						<b>PLACE: GURO</b>
                    </p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<div class="w3-display-container">
						<img src="http://placehold.it/205?text=sample" style="width: 100%">
					</div>
					<p>
						트레이너2<br>
						<b>fx search</b><br>
						<b>MASTER</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너3<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너4<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
			</div>-->
			
		</div>

		<!-- Subscribe section -->
		<!--<div class="w3-container w3-black w3-padding-32" style="margin-top:20px;">
			<h1>JOIN HEALTH?</h1>
			<p>To get special offers and VIP treatment:</p>
			<p>
				<input class="w3-input w3-border" type="text"
					placeholder="Enter e-mail" style="width: 100%">
			</p>
			<button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
		</div>-->

		<!-- Footer -->
		<footer class="w3-padding-64 w3-light-grey w3-small w3-center"
			id="footer">
			<div class="w3-row-padding">
				<div class="w3-col s4">
					<h4>Contact</h4>
					<p>Questions? Go ahead.</p>
					<form action="/action_page.php" target="_blank">
						<p>
							<input class="w3-input w3-border" type="text" placeholder="Name"
								name="Name" required>
						</p>
						<p>
							<input class="w3-input w3-border" type="text" placeholder="Email"
								name="Email" required>
						</p>
						<p>
							<input class="w3-input w3-border" type="text"
								placeholder="Subject" name="Subject" required>
						</p>
						<p>
							<input class="w3-input w3-border" type="text"
								placeholder="Message" name="Message" required>
						</p>
						<button type="submit" class="w3-button w3-block w3-black">Send</button>
					</form>
				</div>

				<div class="w3-col s4">
					<h4>About</h4>
					<p>
						<a href="#">About us</a>
					</p>
					<p>
						<a href="#">We're hiring</a>
					</p>
					<p>
						<a href="#">Support</a>
					</p>
					<p>
						<a href="#">Find store</a>
					</p>
					<p>
						<a href="#">Shipment</a>
					</p>
					<p>
						<a href="#">Payment</a>
					</p>
					<p>
						<a href="#">Gift card</a>
					</p>
					<p>
						<a href="#">Return</a>
					</p>
					<p>
						<a href="#">Help</a>
					</p>
				</div>

				<div class="w3-col s4 w3-justify">
					<h4>Store</h4>
					<p>
						<i class="fa fa-fw fa-map-marker"></i> Company Name
					</p>
					<p>
						<i class="fa fa-fw fa-phone"></i> 0044123123
					</p>
					<p>
						<i class="fa fa-fw fa-envelope"></i> ex@mail.com
					</p>
					<h4>We accept</h4>
					<p>
						<i class="fa fa-fw fa-cc-amex"></i> Amex
					</p>
					<p>
						<i class="fa fa-fw fa-credit-card"></i> Credit Card
					</p>
					<br> <i
						class="fa fa-facebook-official w3-hover-opacity w3-large"></i> <i
						class="fa fa-instagram w3-hover-opacity w3-large"></i> <i
						class="fa fa-snapchat w3-hover-opacity w3-large"></i> <i
						class="fa fa-pinterest-p w3-hover-opacity w3-large"></i> <i
						class="fa fa-twitter w3-hover-opacity w3-large"></i> <i
						class="fa fa-linkedin w3-hover-opacity w3-large"></i>
				</div>
			</div>
		</footer>

		<div class="w3-black w3-center w3-padding-24">
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				title="W3.CSS" target="_blank" class="w3-hover-opacity">w3.css</a>
		</div>

		<!-- End page content -->
	</div>

	<!-- Newsletter Modal -->
	<div id="newsletter" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="padding: 32px">
			<div class="w3-container w3-white w3-center">
				<i
					onclick="document.getElementById('newsletter').style.display='none'"
					class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
				<h2 class="w3-wide">NEWSLETTER</h2>
				<p>Join our mailing list to receive updates on new arrivals and
					special offers.</p>
				<p>
					<input class="w3-input w3-border" type="text"
						placeholder="Enter e-mail">
				</p>
				<button type="button"
					class="w3-button w3-padding-large w3-red w3-margin-bottom"
					onclick="document.getElementById('newsletter').style.display='none'">Subscribe</button>
			</div>
		</div>
	</div>

	<script>
		// Accordion 
		function myAccFunc() {
			var x = document.getElementById("demoAcc");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		// Click on the "Jeans" link on page load to open the accordion for demo purposes
		document.getElementById("myBtn").click();

		// Open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}
	</script>

</body>
</html>