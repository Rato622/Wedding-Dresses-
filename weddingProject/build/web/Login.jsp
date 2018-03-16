<!DOCTYPE html>
<html lang="en">
     <head>
     <title>Home</title>
     <meta charset="utf-8">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/slider.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/sForm.js"></script>
     <script src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
     <script src="js/tms-0.4.1.js"></script>
     <script>
      $(window).load(function(){
      $('.slider')._TMS({
              show:0,
              pauseOnHover:false,
              prevBu:'.prev',
              nextBu:'.next',
              playBu:false,
              duration:800,
              preset:'fade', 
              pagination:true,//'.pagination',true,'<ul></ul>'
              pagNums:false,
              slideshow:8000,
              numStatus:false,
              banners:false,
          waitBannerAnimation:false,
        progressBar:false
      })  
      });
      
     $(window).load (
    function(){$('.carousel1').carouFredSel({auto: false,prev: '.prev',next: '.next', width: 960, items: {
      visible : {min: 1,
       max: 4
},
height: 'auto',
 width: 240,

    }, responsive: false, 
    
    scroll: 1, 
    
    mousewheel: false,
    
    swipe: {onMouse: false, onTouch: false}});
    
    
    });      

     </script>
    
     </head>
     <body>
       <div class="main">
<!--==============================header=================================-->
 <header> 
  <div class="container_12">
    <div class="grid_12">
    <h1><a href="index.html"><img src="images/logo.png" alt="EXTERIOR"></a> </h1>
    
         <div class="menu_block">
           <nav  class="" >
            <ul class="sf-menu">
                   <li class="current"><a href="index.jsp">Home</a></li>
                   <li><a href="#">Dresses</a></li>
                   <li><a href="Login.jsp">Login</a></li>
                   <li><a href="#">About us</a></li>
                   <li><a href="#">Contact us</a></li>
                 </ul>
              </nav>
           <div class="clear"></div>
           </div>
           <div class="clear"></div>
      </div>
    </div>
</header>
 <div class="slider-relative">
    <div class="slider-block">
        <br/>
        <br/>
        <center><b><h1 style="font-weight: bold;">Existing User:Login</h1><b><hr/><br/></center>
                     <%
         String message=(String)request.getAttribute("error");
         if (message!=null)
         {
        %>
                    <p align="center"><font color='red'><%=message%></font></p>
        <%
         }
        %>
                    <center><fieldset>
                        <legend></legend>
                        <form action="LoginServlet" method="Post">
                            Username :<input type="text" name="username" /><br/>
                            <p></p>
                            Password :<input type="password" name="password" /><br/>
                            <br/>
                            <p style="font-size: 17px;">Not register? Click <a href="">here</a>&nbsp;&nbsp; |&nbsp;&nbsp;
                            Forgot? Click <a href="">here</a></p>
                            <input type='submit' name="decision"  value="Login"/>
                        </form>
                    </fieldset>
                    </center>
    </div>
 </div>
<!--=======content================================-->

<div class="content page1"><div class="ic"></div>
 
      
    </div>
  </div>
</div>
<!--==============================footer=================================-->

<footer>    
  <div class="container_12">
    <div class="grid_12">
     Zazu's wedding dresses © 2013  &nbsp;&nbsp; |&nbsp;&nbsp;
    </div>
    <div class="clear"></div>
  </div>
</footer>
</body>
</html>