<%-- 
    Document   : newjsp
    Created on : May 2, 2020, 9:50:07 PM
    Author     : abc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="newpackage.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <style>
        body {
            background-color: black;
        }

        .Cinema {
            position: absolute;
            top: 30%;
            left: 40%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 18px;
        }

        .Movie {
            position: absolute;
            top: 40%;
            left: 40%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 18px;
        }

        .Starttime {
            position: absolute;
            top: 50%;
            left: 40%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 18px;
        }

        .TotalSeats {
            position: absolute;
            top: 60%;
            left: 40%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 18px;
        }

        .Balance {
            position: absolute;
            top: 70%;
            left: 40%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 18px;
        }

        .button {
            padding: 10px 20px;
            font-size: 18px;
            text-align: center;
            cursor: pointer;
            outline: none;
            color: #fff;
            background-color: #CA2F2F;
            border: none;
            border-radius: 15px;
            box-shadow: 0 6px #999;
            margin-left: 650px;
        }

            .button:hover {
                background-color: #B31C1C
            }

            .button:active {
                background-color: #B31C1C;
                box-shadow: 0 5px #666;
                transform: translateY(4px);
            }
    </style>
</head>
<body>
<%OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();

%>
    <div class="container">
        <img src="content/download.png" alt="Ticket" style="background-repeat:no-repeat;height:600px;width: 700px;margin-left: 350px;margin-top: 100px;">
        <div class="Cinema">
            <h2>Cinema:   <%=obj.getTicket().getCinema().getName()%></h2>
        </div>
        <br>

        <div class="Movie">
            <h2>Movie:   <%=obj.getTicket().getMovie().getTitle()%></h2>
        </div>
        <br>

        <div class="Starttime">
            <h2>Start Time:   <%=obj.getTicket().getSlot().getStartTime()%></h2>
        </div>
        <br>

        <div class="TotalSeats">
            <h2>Total Seats:   <%=obj.getTicket().getNoOfSeats()%></h2>
        </div>
        <br>
        <div class="seats">
            <% ArrayList<Integer> l=obj.getTicket().getSeats();
            for(int i=0;i<l.size();i++)
            {%>
            <h2>Seat Number: <%=l.get(i)%></h2>
            <%}%>
        </div>
        <br>
        
        <div class="day">
            
            <h2>Day: <%=obj.getTicket().getDay()%></h2>
            
        </div>
        <br>
        <div class="Balance">
            <%String day=obj.getTicket().getDay();
            if(day.equals("Wednesday"))
{%>
<p>You have been provided with Student Offer Discount (10%)</p>
<%}
else if(day.equals("Friday"))
{%>
<p>You have been provided with Jummah Discount (30%)</p>
<%}
else if(day.equals("Sunday"))
{%>
<p>You have been provided with Family Day Discount (20%)</p>
<%}%>

<h2>Balance:   <%=obj.getTicket().calculateBalance()%></h2>
        </div>

        <br>
    </div>
    <form action="login.jsp">
        <button type="submit" class="button">Logout</button>
    </form>

</body>
</html>
