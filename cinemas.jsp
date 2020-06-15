<%-- 
    Document   : cinemas
    Created on : Apr 30, 2020, 11:17:00 PM
    Author     : abc
--%>

<%@page import="java.util.*"%>
<%@page import="newpackage.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" class="csstransforms csstransforms3d csstransitions"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--meta name="description" content="Jim’s Mowing - your trusted brand for professional gardening servicese and professional lawn mowing  across Australia.">-->
    <meta name="keywords" content="gardening, gutter cleaning, hedge trimming, hedging and pruning, lawn mowing franchise sale, lawn care business for sale, lawn mowing, sydney, melbourne, brisbane, perth, hobart, adelaide, darwin, gold coast, noosa.">
    <title>Movie Ticket Booking.</title>
    <link href="content/Movie Ticket Booking._files/css/bootstrap.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/css/font-awesome.min.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/css/animate.min.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/css/prettyPhoto.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/css/main.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/css/responsive.css" rel="stylesheet">
    <script src="content/Movie Ticket Booking._files/jquery.js.download"></script>
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/css/dataTables.responsive.css">
    
    <link href="content/Movie Ticket Booking._files/css" rel="stylesheet" type="text/css">

    <!--  Quantcast Tag -->
   
    <!-- End Quantcast Tag -->
</head>
<!--/head-->

<body class="homepage" style="">
    <!-- Google Tag Manager -->
    <noscript>l 
        <iframe src="//www.googletagmanager.com/ns.html?id=GTM-MLDN5B" height="0" width="0" class="hidden"></iframe>
    </noscript>
   
    <!-- End Google Tag Manager -->
    <div class="topbar">
        <div class="container-fluid text-center">
            <div class="row">
                <div class="col-sm-3">
                    <div class="wow fadeInDown animated animated animated" data-wow-duration="1000ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 1000ms; animation-delay: 300ms; animation-name: fadeInDown;"> <img src="content/Movie Ticket Booking._files/logo1.png" alt="Logo" class="logo1 img-responsive"> </div>
                </div>
                <div class="col-sm-offset-4 col-sm-5">
                    <div class="wow fadeInDown animated animated animated" data-wow-duration="1000ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 1000ms; animation-delay: 300ms; animation-name: fadeInDown;">
                      
                </div>
                <div class="col-sm-3">
                    <div class="col-sm-12">
                        <div class="wow fadeInRight animated animated animated" data-wow-duration="1000ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;">
                            

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end of top bar -->
    <div class="search-container" style="overflow: hidden;
  background-color: #e9e9e9;float:center;margin-right: 16px;
  margin-left: 16px;
  background: black;
  font-size: 17px;
  border: 1px solid black;
  border-radius: 10px;
  cursor: pointer;">
    <form  method="post" action="searchMovieByNameServlet">
      <input style="padding: 6px;margin-top: 8px; font-size: 17px;border: 1px solid black;border-radius: 10px;" type="text" placeholder="Search Movie By Name" name="search">
      <button style="float:right; padding: 6px 6px; background-color: black;border: none;" type="submit">
        <img src="content/search1.png" alt="image"style="height: 30px;width:30px;">
      </button>
    </form>
  </div>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class=""></li>
            <li data-target="#myCarousel" data-slide-to="1" class=""></li>
            <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="3" class=""></li>          
			
            
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item"> <img src="content/Movie Ticket Booking._files/a1.jpg" alt="images">
                <div class="carousel-caption">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="carousel-content center centered">
                                <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                               	</h2> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item"> <img src="content/Movie Ticket Booking._files/a2.jpg" alt="images">
                <div class="carousel-caption">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="carousel-content center centered">
                                <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                                </h2> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item active"> <img src="content/Movie Ticket Booking._files/a5.jpg" alt="images">
                <div class="carousel-caption">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="carousel-content center centered">
                                <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                               					</h2> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item"> <img src="content/Movie Ticket Booking._files/a6.jpg" alt="images">
                <div class="carousel-caption">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="carousel-content center centered">
                                <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                          							</h2> </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
        <!-- Left and right controls -->

    </div>

    <div style="padding-top:25px;" id="services-summry">
        <div class="container">
            <form method="post" action="cinemasServlet">
            <div class="row" style="text-align:center">
                <div class="col-md-6 col-sm-4  wow fadeInDown animated animated animated" data-wow-duration="200ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 200ms; animation-delay: 200ms">
                    <!--<div class="feature-wrap">

                        <!--<br> <button style="background-color: black; border: none;" formaction="genre.jsp"><a  href="genre.jsp"><img src="content/Movie Ticket Booking._files/universal.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        </button>
                        <br><input  name="act" value="universal" type="image" src="content/Movie Ticket Booking._files/universal.jpg" alt="image" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image">
                    </div>
                    <h2>Universal Cinema</h2>-->
                    
                    <div class="feature-wrap">

                        <br> <img src="content/Movie Ticket Booking._files/universal.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        
                        <br><input  name="universal" value="Universal Cinema" type="submit" style="background-color: black; border: none; color: white; font-size: 20px;">
                    </div>
     
                </div>
                <div class="col-md-6 col-sm-4  wow fadeInDown animated animated animated" data-wow-duration="200ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 200ms; animation-delay: 200ms;">
                    <!--<div class="feature-wrap">

                        <!--<br> <button style="background-color: black; border: none;" formaction="genre.jsp"><a  href="genre.jsp"><img src="content/Movie Ticket Booking._files/Cinepax_logo.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="imag" formaction="genre.jsp"><a  href="genre.jsp"><img src="e"></a> 
                        </button>
                    <br><input  name="act" value="cinepax" type="image" src="content/Movie Ticket Booking._files/Cinepax_logo.jpg" alt="image" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image">
                    </div>
                    <h2>Cinepax</h2>-->
                    
                    <div class="feature-wrap">

                        <br> <img src="content/Movie Ticket Booking._files/Cinepax_logo.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        
                        <br><input  name="cinepax" value="Cinepax" type="submit" style="background-color: black; border: none; color: white; font-size: 20px;">
                    </div>
     
                </div>
                <div class="col-md-6 col-sm-4  wow fadeInDown animated animated animated" data-wow-duration="200ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 200ms; animation-delay: 200ms;">
                    <!--<div class="feature-wrap">
                        <!--<br> <button style="background-color: black; border: none;" formaction="genre.jsp"><a  href="genre.jsp"><img src="content/Movie Ticket Booking._files/cinestar.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        </button>
                        <br><input  name="act" value="cinestar" type="image" src="content/Movie Ticket Booking._files/cinestar.jpg" alt="image" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image">
                    </div>
                    <h2>Cinestar</h2>-->
                   <div class="feature-wrap">

                        <br> <img src="content/Movie Ticket Booking._files/cinestar.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        
                        <br><input  name="cinestar" value="CineStar" type="submit" style="background-color: black; border: none; color: white; font-size: 20px;">
                    </div>
                    

                </div>
                <div class="col-md-6 col-sm-4  wow fadeInDown animated animated animated" data-wow-duration="200ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 200ms; animation-delay: 200ms;">
                    <!--<div class="feature-wrap">
                        <!--<br><button style="background-color: black; border: none;" formaction="genre.jsp"><a  href="genre.jsp"> <img src="content/Movie Ticket Booking._files/supercinema.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"> </a>
                        </button>
                        <br><input  name="act" value="super" type="image" src="content/Movie Ticket Booking._files/supercinema.jpg" alt="image" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image">
                        
                    </div>
                    <h2>Super Cinema</h2>-->
                   <div class="feature-wrap">

                        <br> <img src="content/Movie Ticket Booking._files/supercinema.jpg" class="img-responsive img-thumbnail centerd" style="max-width:330px;min-width:330px;max-height:180px;min-height:180px" alt="image"></a>
                        
                        <br><input  name="super" value="Super Cinema" type="submit" style="background-color: black; border: none; color: white; font-size: 20px;">
                    </div>
                    
            
                </div>
               
            </div>
           </form>
        </div>
         
    </div>
	
	
    <br>  <br>
	
	<div style="border:6px double #660C23;height: 200px;"><h2 style="margin-left: 550px;font-size: 30px;font-family: serif;">Top Rated Movies</h2>
		<ul style="list-style-type: circle;margin-left: 30px;margin-top:20px;color: white;">
                        <%OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
                        ArrayList<Movie> m=obj.displayTopRatedMovies();
                        %>
                        <%for (int i=0;i<m.size();i++)
                        {%>
                            <li style="font-size: 25px;padding: 8px; font-family: serif;"><%=m.get(i).getTitle()%></li>
                        <%}%>
        
		</ul>
	</div>
    <div style="padding-top:45px; background: #660C23;"></div>
        

    

    
    <!--/#services-->
 <section id="footer-bg">
		<!-- footer -->
		        <footer class="gardener">
			                <div class="container">
                    <div>
					              
                       <div id="bunch_services_posts-2" class="col-lg-3 col-md-4 col-sm-6 col-xs-6 widget footer-widget widget_bunch_services_posts">		
		<div class="part2">
		<h3>We provide following services: </h3>		        
           	<!-- Title -->
				
                <ul class="quick-links">
				
									<li><a href="content/Movie Ticket Booking._files/my.html#">Movies</a></li>
									<li><a href="content/Movie Ticket Booking._files/my.html#">Food</a></li>
									<li><a href="content/Movie Ticket Booking._files/my.html#">Shopping</a></li>
									<li><a href="content/Movie Ticket Booking._files/my.html#">Free Membership</a></li>
                                    <li><a href="content/Movie Ticket Booking._files/my.html#">Discount Offers</a></li>
								</ul>
			
        		</div>
                           
		
		</div>
                 
       
                        
                        <div id="bunch_get_in_touch-2" class="col-lg-3 col-md-4 col-sm-6 col-xs-6 widget footer-widget widget_bunch_get_in_touch">      		
			<div class="widget">
                <h3>Get in Touch</h3>                <ul class="contact-info">
                    <li>
                        <div class="icon-box">
                            <i class="fa fa-map-marker"></i>
                        </div>
                        <div class="content">
                            <p>Lahore, Pakistan</p>
                        </div>
                    </li>
                    <li>
                        <div class="icon-box">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="content phone">
                            <p>1300 927 493</p>
                        </div>
                    </li>
                  
                </ul>
            </div> <!-- /.widget -->
            
        </div><div id="bunch_footer_image-2" class="col-lg-3 col-md-4 col-sm-6 col-xs-6">		
		
            	          
		</div>                    </div>
                </div>
                    </footer> <!-- /footer -->
				
        <!-- #bottom-bar -->
		        <div id="bottom-bar" class="gardener">
			<div class="container">
				<div class="">
					<!-- .copyright -->
					<div class="copyright col-sm-6">
												                            <ul class="social ">
                                                                    <li><a href="content/Movie Ticket Booking._files/my.html#" class="hvr-radial-out"><i class="fa fa-facebook"></i></a></li>
                                                                    <li><a href="content/Movie Ticket Booking._files/my.html#" class="hvr-radial-out"><i class="fa fa-twitter"></i></a></li>
                                                                    <li><a href="content/Movie Ticket Booking._files/my.html#" class="hvr-radial-out"><i class="fa fa-google-plus"></i></a></li>
                                                                    <li><a href="content/Movie Ticket Booking._files/my.html#" class="hvr-radial-out"><i class="fa fa-linkedin"></i></a></li>
                                                            </ul>
                        												
					</div> <!-- /.copyright -->
					<!-- .credit -->
					<div class="credit col-sm-6">
						<p>Copyright © Midtown Cinema. All rights reserved.
</p>
					</div> <!-- /.credit -->
				</div>
			</div> 
		</div><!-- /#bottom-bar -->
            </section>   
    
    
    <!--/#footer-->
    <script src="content/Movie Ticket Booking._files/bootstrap.min.js.download"></script>
    <script src="content/Movie Ticket Booking._files/jquery.prettyPhoto.js.download"></script>
    <script src="content/Movie Ticket Booking._files/jquery.isotope.min.js.download"></script>
    <script src="content/Movie Ticket Booking._files/main.js.download"></script>
    <script src="content/Movie Ticket Booking._files/wow.min.js.download"></script>
    <script src="content/Movie Ticket Booking._files/app.js.download"></script>
    <script src="content/Movie Ticket Booking._files/jquery.validate.js.download"></script>
    <script src="content/Movie Ticket Booking._files/jquery.dataTables.js.download"></script>
    <script src="content/Movie Ticket Booking._files/dataTables.bootstrap.js.download"></script>
    <script src="content/Movie Ticket Booking._files/dataTables.responsive.js.download"></script>
    <script src="content/Movie Ticket Booking._files/app.js.download"></script>


</div></body></html>