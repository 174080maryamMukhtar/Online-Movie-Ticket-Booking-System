<%-- 
    Document   : schedule
    Created on : May 1, 2020, 11:05:42 PM
    Author     : abc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="newpackage.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- saved from url=(0108)file:///C:/Users/Dua/OneDrive/Desktop/web%20development/paul-mowing-final-html_css/Paul-Mowing-HTML/my.html# -->
<html lang="en" class="csstransforms csstransforms3d csstransitions">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--meta name="description" content="Jim’s Mowing - your trusted brand for professional gardening servicese and professional lawn mowing  across Australia.">-->
    <meta name="keywords" content="gardening, gutter cleaning, hedge trimming, hedging and pruning, lawn mowing franchise sale, lawn care business for sale, lawn mowing, sydney, melbourne, brisbane, perth, hobart, adelaide, darwin, gold coast, noosa.">
    <title>Movie Ticket Booking.</title>
    <link href="content/Movie Ticket Booking._files/bootstrap.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/font-awesome.min.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/animate.min.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/prettyPhoto.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/main.css" rel="stylesheet">
    <link href="content/Movie Ticket Booking._files/responsive.css" rel="stylesheet">
    <script src="content/Movie Ticket Booking._files/jquery.js.download"></script>
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="content/Movie Ticket Booking._files/dataTables.responsive.css">

    <link href="content/Movie Ticket Booking._files/css" rel="stylesheet" type="text/css">

    <style>
            center {
                font-size: 50px;
                font-weight: 600;
                font-family: 'Open Sans', sans-serif;
                color: white;
            }

            body {
                background-color: black;
                <!-- background-image: url('bg.jpg'); -->
            }


            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                right: 0;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

                .dropdown-content a {
                    color: black;
                    padding: 12px 16px;
                    text-decoration: none;
                    display: block;
                }

                    .dropdown-content a:hover {
                        background-color: #f1f1f1;
                    }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #A75444;
            }

            .dropbtn {
                background-color: #1D3B59;
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
                cursor: pointer;
                margin: 70px;
            }

                .dropbtn:hover, .dropbtn:focus {
                    background-color: #494A4B;
                }

            .btn-group {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #7F8A90;
                min-width: 160px;
                overflow: auto;
                box-shadow: 0px 16px 16px 0px rgba(0,0,0,0.2);
            }

                .dropdown-content a {
                    color: black;
                    padding: 12px 16px;
                    text-decoration: none;
                    display: block;
                }

                    .dropdown-content a:hover {
                        background-color: #67BCE7
                    }

            .show {
                display: block;
            }

            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                color: black;
            }

            tr:nth-child(even) {
                background-color: #8FA3AD;
            }
        </style>
</head>
<!--/head-->

<body class="homepage" style="">
    <!-- Google Tag Manager -->
    <noscript>
        l
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
 
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span><span class="white-text">Menu</span> </button>
                </div>
                <div class="collapse navbar-collapse navbar-left">
                    <ul class="nav navbar-nav">
                    </ul>
                </div>
            </div>
        </nav>
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
                <div class="item">
                    <img src="content/Movie Ticket Booking._files/a1.jpg" alt="images">
                    <div class="carousel-caption">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="carousel-content center centered">
                                    <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="content/Movie Ticket Booking._files/a2.jpg" alt="images">
                    <div class="carousel-caption">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="carousel-content center centered">
                                    <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item active">
                    <img src="content/Movie Ticket Booking._files/a5.jpg" alt="images">
                    <div class="carousel-caption">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="carousel-content center centered">
                                    <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="content/Movie Ticket Booking._files/a6.jpg" alt="images">
                    <div class="carousel-caption">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="carousel-content center centered">
                                    <h2 class="animation animated-item-1 wow fadeInRight animated animated animated" style="color: rgb(255, 255, 255); visibility: visible; animation-duration: 1000ms; animation-delay: 500ms; animation-name: fadeInRight;" data-wow-duration="1000ms" data-wow-delay="500ms">
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Left and right controls -->
          
        </div>
        
  <%ArrayList<ArrayList> s=(ArrayList)request.getAttribute("schedule");
                    ArrayList<String> day=new ArrayList<String>();
            day.add("Monday");
            day.add("Tuesday");
            day.add("Wednesday");
            day.add("Thursday");
            day.add("Friday");
  %>
        
            <h2></h2>
            <h2></h2>
            <center>MOVIE SCHEDULE</center>
            <h2></h2>
            <h2></h2>
            <h2></h2>
            <h2></h2>
            <h2></h2>

            
    <%for(int i=0;i<s.size();i++)       //Weekday
    {%>
                    <div class="dropdown" style=" padding:0 0px;">
                <button class="dropbtn"><%=day.get(i)%></button>
                <div class="dropdown-content" style="left:0;">
                    <form method="post" action="scheduleServlet">
                    <table>
                        <tr>
                            <th>MOVIE</th>
                            <th>START TIME</th>

                        </tr>
                        <%
                            
                            ArrayList<Schedule> ss=s.get(i);
                       
                        
        for(int j=0;j<ss.size();j++)      //Slot
        {%>
        
            <tr>
                <th><%=ss.get(j).getMovie().getTitle()%></th>
                <th><%=ss.get(j).getSlot().getStartTime()%></th>
                <!--<th><button style="background-color: #8FA3AD; border: none;" formaction="DetailsOfSelectedMovie.jsp"><a href="DetailsOfSelectedMovie.jsp"><input style="color: black;" type="button" value="Book Now"></a></button></th>-->
            
                <%
                //request.getSession().setAttribute("day",d);
                 
                String ssize=String.valueOf(ss.size());
                request.getSession().setAttribute("size", ssize);
                String jj=String.valueOf(j);
                String ii=String.valueOf(i);
                %>
            <input type="hidden" name="mov" value="<%=ss.get(j).getMovie().getTitle()%>" >
            <input type="hidden" name="sl" value="<%=ss.get(j).getSlot().getStartTime()%>" >
                <input type="hidden" name="day" value="<%=ii%>" >
                <!--<th><input name="=jj%>" style="color: black;" type="submit" value="View Seating Plan"></th>-->
            </tr>
        <%}%>
            </table>
                    </form>
            </div>
            </div>
    <%}
    %>


       
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


    </div>
</body>
</html>