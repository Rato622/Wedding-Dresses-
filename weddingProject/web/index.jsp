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
    <h1><a href="index.html"></a> </h1>
    
         <div class="menu_block">
           <nav  class="" >
            <ul class="sf-menu">
                   <li class="current"><a href="index.jsp">Home</a></li>
                   <li><a href="ProductServlet">Dresses</a></li>
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
         
        <ul class="carousel1">
            <li><div><img src="images/slide1.jpg" alt=""></div>
          </li>
          <li><div><img src="images/slide2.jpg" alt=""></div>
                  </li>
          
                  <li><div><img src="images/slider4.jpg" alt=""></div>
                  </li>
                  
                  <li><div><img src="images/vintage/3.jpg" alt=""></div>
                  </li>
                  
                  <li><div><img src="images/vintage/Vintage-Wedding-Dresses1-400x600.jpg" alt=""></div>
                  </li>
          
        </ul>
        <a href="#" class="prev"></a><a href="#" class="next"></a>
    </div>
 </div>
<!--=======content================================-->

<div class="content page1"><div class="ic"></div>
  <div class="container_12">
      <div class="grid_7">
        <h2>Welcome</h2>
        <div class="page1_block col1">
          
          <div class="extra_wrapper">
            
          </div>
          <div class="clear"></div>
        </div>
      </div>
      <div class="grid_5">
        <h2>Features</h2>
        <ol>
          <li>Morden wedding dresses</li>
          <li>Traditional wedding dresses</li>
          <li>Vintage wedding dresses</li>
        </ol>
      </div>
      <div class="clear"></div>
      <div class="grid_12">
        <div class="hor_separator"></div>
      </div>
      <div class="grid_12">
        <div class="car_wrap">
        
      </div>
      
    </div>
    <div class="clear"></div>
   
      
    </div>
  </div>
</div>
<!--==============================footer=================================-->
</body>
</html>