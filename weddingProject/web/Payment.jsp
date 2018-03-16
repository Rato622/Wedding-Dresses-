<%@page import="Pojos.Items"%>
<%@page import="java.util.List"%>
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
      <SCRIPT LANGUAGE="JavaScript">
function checkIt(evt) {
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
       var status = "Quantity field accepts numbers only."
        alert(status);
        return false
    }
    
    return true
}
</SCRIPT>
    <style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:13px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
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
                   <li><a href="#">Profile</a></li>
                   <li><a href="client.jsp">Dresses</a></li>
                  <%  List shopcart=(List) session.getAttribute("shopcart"); 
                  int num=0;
                  if(shopcart!=null)
                 {
                      for(int x=0;x<shopcart.size();x++)
                                                   {
                          num++;
                          
                      }
                      
}
%>
                   <li><a href="#">(<%=num%>)Cart</a></li>
                   <li><a href="LogoutServlet">Logout</a></li>
                 </ul>
              </nav>
           <div class="clear"></div>
           </div>
           <div class="clear"></div>
      </div>
    </div>
</header>
 <div >
    <div>
        <br/>
        <br/>
        <center><b><h1 style="font-weight: bold;">Payment Message</h1><b><hr/><br/></center>
                   
                       <%
         String message=(String)request.getAttribute("error");
         if (message!=null)
         {
        %>
        <font color='red'><%=message%></font>
        <%
         }
        %>
                    <form action="printInvoiceServlet" method="post">
                 
        <p><input type="submit" name="decision" value="Print Invoice"/></p>
                    </form>
        
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

