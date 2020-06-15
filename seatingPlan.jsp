<%-- 
    Document   : seatingPlan
    Created on : May 2, 2020, 8:58:26 PM
    Author     : abc
--%>

<%@page import="newpackage.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <style>
        body {
            background-image: url('paper.gif');
            background-color: black;
        }

        table {
            width: 100%;
        }

        th, td {
            padding: 15px;
        }

        .seats {
            background-color: #37BF91;
            padding: 10px;
            text-align: center;
            font-size: 16px;
            margin: 2px 2px;
            cursor: pointer;
            border-radius: 10px;
            width: 60px;
            height: 40px;
        }

        .next {
            padding: 10px;
            text-align: center;
            font-size: 16px;
            margin: 2px 2px;
            cursor: pointer;
            border-radius: 10px;
            width: 60px;
            height: 40px;
            margin-left: 150px;
            background-color: #810829;
        }

        .screen {
            border: 2px solid black;
            border-radius: 10px;
            margin-left: 300px;
            margin-right: 300px;
            text-align: center;
            color: black;
            background-color: silver;
        }

        .totalseats {
            border: 2px solid black;
            border-radius: 10px;
            width: 20%;
            margin-left: 150px;
            padding: 20px;
            text-align: left;
            color: black;
            background-color: #810829;
            font-size: large;
        }
        .container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 35px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  margin-bottom: 10px;
  background-color: #37BF91;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: red;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
    right: 10px;
  left: 10px;
  top: 8px;
  width: 8px;
  height: 20px;
  margin-left: 5px;
  border: solid black;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}
    </style>

</head>
<body>
    <br><br><br><br>
    <p class="screen">SCREEN</p>
    <br><br><br><br>
    
    
   <form name="formname" method="post" action="seatingPlanServlet">
    <%
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
    Hall h=obj.getTicket().getSchedule().getHall();
%>
        <table>
        <%for(int i=0;i<h.getMaxSeats();i++)
        {%>
        <tr>
            <%for(int j=0;j<10;j++)
            {
                if(h.SeatBookedOrNot(i+1)==true)
                {%>
                    <!--<th><button class="seats"  type="button" style="background-color:red; "><%=(i+1)%></button></th>-->
                
                <th><label class="container">
                <input type="checkbox" name="checkbox"  onclick="return false;" checked >
                 <span class="checkmark seats"></span>
                        </label></th>
                <%}
                else
                {
                    String ii=String.valueOf(i+1);%>
                    <th><label class="container">
                <input type="checkbox" name="checkbox" value="<%=ii%>" >
                 <span class="checkmark seats"></span>
                        </label></th>
                <%}
                
                i++;
            }
            i--;%>
             
                
        </tr>
        <%}%>
</table>


    <!--CHECKING SEAT COUNT-->
    
    
    <br><br>
        <button type="submit" class="next" formaction="seatingPlanServlet">Next</button>
    </form>


</body>
</html>
