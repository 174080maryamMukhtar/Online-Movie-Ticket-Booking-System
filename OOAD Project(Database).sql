use master
go
drop database ooad
go
create database ooad
go

use ooad
go


create table [Users]	--done
(
  name varchar(10),
  Usertype varchar(10),
  age int,
  username varchar(10),
  [password] varchar(8),
  email varchar(30),
  contactNumber varchar(11), 
)
GO

drop table Users

create table Genre  --done
(
  genreID int primary key,
  genreName varchar(20)
)
GO

create table Movies		--done
(
  movieID int primary key,
  genreid int foreign key references Genre (genreID),
  --Feedback int foreign key references feedback(fid),
  title varchar(50),
  [description] varchar(500)
 
)
GO
create table feedback	--done
(
	--fid int primary key,
	movieID int foreign key references Movies (movieID),
	username varchar(10),
	rating int,
	review varchar(30),
)
GO

create table Cinemas		--done
(
  cinemaID int primary key,
  cinemaName varchar(20),
  location varchar(50),
  contactNum varchar(20),
  email varchar(30),
  pricePerTicket int,
  --scheduleid int foreign key references Schedule(scheduleID),
   --movieid int foreign key references Movies(movieID)
)
GO
drop table Cinemas

create table Slot   --done
(
  slotID int primary key,
  startTime varchar(20),
  endTime varchar(20)
)
GO


create table Schedule   --done
(		
	scheduleID INT PRIMARY KEY,
	dday varchar(10),
	genreid int foreign key references Genre(genreID),
	movieid int foreign key references Movies(movieID),
	slotid int foreign key references Slot(slotID),
	--hallid int foreign key references Hall(hallid),
	cinemaid int foreign key references Cinemas(cinemaID)
)
GO
drop table Schedule

create table Hall  --done
(
	hallid int primary key,
	BookedSeats int,
	MaxSeats int,
	scheduleID int foreign key references Schedule (scheduleid)
)
Go
drop table Hall

create table Seats   --done
(
 hallID int foreign key references Hall (hallid), 
 seatNo int,
 [status] int, --take 0 as false and 1 as true
)
GO
--create table Ticket	--done
--(
--  ticketid int identity(1,1) primary key,
--  balance float,
--  noOfSeats int,
--  movie int foreign key references Movies(movieID),
--  cinema int foreign key references Cinemas(cinemaID),
--  slot int foreign key references Slot(slotID),
--  countstatic int,
--)
--GO


--Create table OnlineMovieTicketingSystem --done
--(
--	OMTid int primary key,
--	cinemalist int foreign key references Cinemas(cinemaID),
--	movieList int foreign key references Movies(movieID),
--	registeredUsers int foreign key references Registration(regID),
--	currentUser int foreign key references [Users](UserId),
--	ticket int foreign key references Ticket(ticketID),
--	genreList int foreign key references Genre(genreId)
--)
--GO

-------------------------------------------------DATA INSERTION-----------------------------------------


insert into Users values
('Ali', 'customer',  20, 'ali10','ali', 'ali@gmail.com', 03312345678),
('Bilal', 'customer',25, 'bilal20', 'bilal', 'bilal@gmail.com', 03317987658),
('Haris', 'customer',40,'haris23', 'haris', 'Haris@gmail.com', 03312345671),
('Laiba', 'customer',20,'laiba10', 'laiba', 'Laiba@gmail.com', 03315466363),
('Hira', 'customer', 21, 'hira10', 'hira', 'Hira@gmail.com', 03377777661),
('Muaviya','customer', 20,'muaviya11','muaviya', 'Muaviya@gmail.com', 02314997764),
('Maryam','customer',21,'maryam25','maryam','maryammukhtar@gmail.com',03334444444),
('Sana','admin',21,'sana21','sana','sana@gmail.com',03331452369)
 
 GO
 truncate table users
 
insert into Genre values
  (1, 'Horror'),
  (2,'Comedy'),
  (3,'Action'),
  (4,'Animated'),
  (5,'Romance')
  
GO

insert into Movies values
(1,1,'A Quiet Place','If they hear you, they hunt you. A family must live in silence to avoid mysterious creatures that hunt by sound.'),
(2,1,'Bird Box','When a mysterious force decimates the population, only one thing is certain -- if you see it, you die'),
(3,2,'The Hangover','Two days before his wedding, Doug and three friends drive to Las Vegas for a wild and memorable stag party.'),
(4,2,'Just Go With It','His heart recently broken, plastic surgeon Danny Maccabee pretends to be married so he can enjoy future dates with no strings attached'),
(5,3,'Fast and Furious 8','With Dom and Letty married, Brian and Mia retired and the rest of the crew exonerated, the globe-trotting team has found some semblance of a normal life.'),
(6,3,'Avengers: End Game','Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle.'),
(7,4,'Coco','Despite his family generations-old ban on music, young Miguel dreams of becoming an accomplished musician like his idol Ernesto de la Cruz.'),
(8,4,'Up','Carl Fredricksen, a 78-year-old balloon salesman, is about to fulfill a lifelong dream.'),
(9,5,'Her','A sensitive and soulful man earns a living by writing personal letters for other people.'),
(10,5,'Your Name','Two teenagers share a profound, magical connection upon discovering they are swapping bodies.')
go

insert into feedback values
(1, 'ali10', 4, 'Good movie'),
(1, 'maryam25', 5, 'Good movie'),
(2, 'bilal20', 5, 'Excellent movie'),
(2, 'sana21', 5, 'Very Nice movie'),
(3, 'haris23', 2, 'Poor movie'),
(3, 'hira10', 1, 'Bad movie'),
(4, 'hira10', 3, 'Just an average movie'),
(4, 'muaviya11', 4, 'Good movie'),
(5, 'laiba10', 5, 'Excellent movie'),
(5, 'maryam25', 5, 'Great Movie'),
(6, 'muaviya11', 1, 'Very bad movie'),
(6, 'sana21', 2, 'Not Good movie'),
(7, 'maryam25', 4, 'Good movie'),
(8, 'sana21', 3, 'Just a normal movie'),
(9, 'muaviya11', 1, 'Pathetic movie'),
(10, 'sana21', 4, 'Nice movie')
go

truncate table feedback


insert into Cinemas values
(1, 'Universal Cinemas', 'Johar Town', '0333-333333', 'universalcinemas@gmail.com', 300),
(2, 'Cinepax' , 'Walton Rd', '0333-444444', 'packagescinema@gmail.com',400),
(3, 'Cinestar' , 'Township', '0333-555555', 'cinemastar@gmail.com',500),
(4, 'Super Cinema' , 'Canal Bank Rd', '0333-666666', 'supercinema@gmail.com',300)
go


insert into Slot values
(1, '9 a.m', '12 p.m'),
(2, '1 p.m', '4 p.m'),
(3, '5 p.m', '8 p.m'),
(4, '9 p.m', '12 a.m')
go


insert into Schedule values

-----------------------Cinema 1------------------------

(1,'Monday',1,1,1,1),
(2, 'Monday',1,2,2,1),
(3, 'Monday',2,3,3,1),
(4, 'Monday',2,4,4,1),

(5, 'Tuesday',1,1,1,1),
(6, 'Tuesday',1,2,2,1),
(7, 'Tuesday',3,5,3,1),
(8, 'Tuesday',3,6,4,1),

(9, 'Wednesday',2,3,1,1),
(10, 'Wednesday',2,4,2,1),
(11, 'Wednesday',3,5,3,1),
(12, 'Wednesday',3,6,4,1),

(13, 'Thursday',3,5,1,1),
(14, 'Thursday',3,6,2,1),
(15, 'Thursday',4,7,3,1),
(16, 'Thursday',4,8,4,1),

(17, 'Friday',3,5,1,1),
(18, 'Friday',3,6,2,1),
(19, 'Friday',5,9,3,1),
(20, 'Friday',5,10,4,1),

--(21, 'Saturday',4,7,1,1),
--(22, 'Saturday',4,8,2,1),
--(23, 'Saturday',5,9,3,1),
--(24, 'Saturday',5,10,4,1),
--(25, 'Sunday',2,3,1,1),
--(26, 'Sunday',2,4,2,1),
--(27, 'Sunday',1,1,3,1),
--(28, 'Sunday',1,2,4,1),

-----------------------Cinema 2------------------------

(21,'Monday',1,1,1,2),
(22, 'Monday',1,2,2,2),
(23, 'Monday',2,3,3,2),
(24, 'Monday',2,4,4,2),

(25, 'Tuesday',1,1,1,2),
(26, 'Tuesday',1,2,2,2),
(27, 'Tuesday',3,5,3,2),
(28, 'Tuesday',3,6,4,2),

(29, 'Wednesday',2,3,1,2),
(30, 'Wednesday',2,4,2,2),
(31, 'Wednesday',3,5,3,2),
(32, 'Wednesday',3,6,4,2),

(33, 'Thursday',3,5,1,2),
(34, 'Thursday',3,6,2,2),
(35, 'Thursday',4,7,3,2),
(36, 'Thursday',4,8,4,2),

(37, 'Friday',3,5,1,2),
(38, 'Friday',3,6,2,2),
(39, 'Friday',5,9,3,2),
(40, 'Friday',5,10,4,2),

--(49, 'Saturday',4,7,1,2),
--(50, 'Saturday',4,8,2,2),
--(51, 'Saturday',5,9,3,2),
--(52, 'Saturday',5,10,4,2),

--(53, 'Sunday',2,3,1,2),
--(54, 'Sunday',2,4,2,2),
--(55, 'Sunday',1,1,3,2),
--(56, 'Sunday',1,2,4,2),


-----------------------Cinema 3------------------------

(41,'Monday',1,1,1,3),
(42, 'Monday',1,2,2,3),
(43, 'Monday',2,3,3,3),
(44, 'Monday',2,4,4,3),

(45, 'Tuesday',1,1,1,3),
(46, 'Tuesday',1,2,2,3),
(47, 'Tuesday',3,5,3,3),
(48, 'Tuesday',3,6,4,3),

(49, 'Wednesday',2,3,1,3),
(50, 'Wednesday',2,4,2,3),
(51, 'Wednesday',3,5,3,3),
(52, 'Wednesday',3,6,4,3),

(53, 'Thursday',3,5,1,3),
(54, 'Thursday',3,6,2,3),
(55, 'Thursday',4,7,3,3),
(56, 'Thursday',4,8,4,3),

(57, 'Friday',3,5,1,3),
(58, 'Friday',3,6,2,3),
(59, 'Friday',5,9,3,3),
(60, 'Friday',5,10,4,3),

--(77, 'Saturday',4,7,1,3),
--(78, 'Saturday',4,8,2,3),
--(79, 'Saturday',5,9,3,3),
--(80, 'Saturday',5,10,4,3),
--(81, 'Sunday',2,3,1,3),
--(82, 'Sunday',2,4,2,3),
--(83, 'Sunday',1,1,3,3),
--(84, 'Sunday',1,2,4,3),


-----------------------Cinema 4------------------------

(61,'Monday',1,1,1,4),
(62, 'Monday',1,2,2,4),
(63, 'Monday',2,3,3,4),
(64, 'Monday',2,4,4,4),

(65, 'Tuesday',1,1,1,4),
(66, 'Tuesday',1,2,2,4),
(67, 'Tuesday',3,5,3,4),
(68, 'Tuesday',3,6,4,4),

(69, 'Wednesday',2,3,1,4),
(70, 'Wednesday',2,4,2,4),
(71, 'Wednesday',3,5,3,4),
(72, 'Wednesday',3,6,4,4),

(73, 'Thursday',3,5,1,4),
(74, 'Thursday',3,6,2,4),
(75, 'Thursday',4,7,3,4),
(76, 'Thursday',4,8,4,4),

(77, 'Friday',4,7,1,4),
(78, 'Friday',4,8,2,4),
(79, 'Friday',5,9,3,4),
(80, 'Friday',5,10,4,4)

--(105, 'Saturday',5,9,1,4),
--(106, 'Saturday',5,10,2,4),
--(107, 'Saturday',1,1,3,4),
--(108, 'Saturday',1,2,4,4),
--(109, 'Sunday',2,3,1,4),
--(110, 'Sunday',2,4,2,4),
--(111, 'Sunday',4,7,3,4),
--(112, 'Sunday',4,8,4,4)




insert into Hall values  
(1, 0, 50, 1),
(2, 0, 50, 2),
(3, 0, 50, 3),
(4, 0, 50, 4),
(5, 0, 50, 5),
(6, 0, 50, 6),
(7, 0, 50, 7),
(8, 0, 50, 8),
(9, 0, 50, 9),
(10, 0, 50, 10),
(11, 0, 50, 11),
(12, 0, 50, 12),
(13, 0, 50, 13),
(14, 0, 50, 14),
(15, 0, 50, 15),
(16, 0, 50, 16),
(17, 0, 50, 17),
(18, 0, 50, 18),
(19, 0, 50, 19),
(20, 0, 50, 20),
(21, 0, 50, 21),
(22, 0, 50, 22),
(23, 0, 50, 23),
(24, 0, 50, 24),
(25, 0, 50, 25),
(26, 0, 50, 26),
(27, 0, 50, 27),
(28, 0, 50, 28),
(29, 0, 50, 29),
(30, 0, 50, 30),
(31, 0, 50, 31),
(32, 0, 50, 32),
(33, 0, 50, 33),
(34, 0, 50, 34),
(35, 0, 50, 35),
(36, 0, 50, 36),
(37, 0, 50, 37),
(38, 0, 50, 38),
(39, 0, 50, 39),
(40, 0, 50, 40),
(41, 0, 50, 41),
(42, 0, 50, 42),
(43, 0, 50, 43),
(44, 0, 50, 44),
(45, 0, 50, 45),
(46, 0, 50, 46),
(47, 0, 50, 47),
(48, 0, 50, 48),
(49, 0, 50, 49),
(50, 0, 50, 50),
(51, 0, 50, 51),
(52, 0, 50, 52),
(53, 0, 50, 53),
(54, 0, 50, 54),
(55, 0, 50, 55),
(56, 0, 50, 56),
(57, 0, 50, 57),
(58, 0, 50, 58),
(59, 0, 50, 59),
(60, 0, 50, 60),
(61, 0, 50, 61),
(62, 0, 50, 62),
(63, 0, 50, 63),
(64, 0, 50, 64),
(65, 0, 50, 65),
(66, 0, 50, 66),
(67, 0, 50, 67),
(68, 0, 50, 68),
(69, 0, 50, 69),
(70, 0, 50, 70),
(71, 0, 50, 71),
(72, 0, 50, 72),
(73, 0, 50, 73),
(74, 0, 50, 74),
(75, 0, 50, 75),
(76, 0, 50, 76),
(77, 0, 50, 77),
(78, 0, 50, 78),
(79, 0, 50, 79),
(80, 0, 50, 80)

--(81, 0, 50, 81),
--(82, 0, 50, 82),
--(83, 0, 50, 83),
--(84, 0, 50, 84),
--(85, 0, 50, 85),
--(86, 0, 50, 86),
--(87, 0, 50, 87),
--(88, 0, 50, 88),
--(89, 0, 50, 89),
--(90, 0, 50, 90),
--(91, 0, 50, 91),
--(92, 0, 50, 92),
--(93, 0, 50, 93),
--(94, 0, 50, 94),
--(95, 0, 50, 95),
--(96, 0, 50, 96),
--(97, 0, 50, 97),
--(98, 0, 50, 98),
--(99, 0, 50, 99),
--(100, 0, 50, 100),
--(101, 0, 50, 101),
--(102, 0, 50, 102),
--(103, 0, 50, 103),
--(104, 0, 50, 104),
--(105, 0, 50, 105),
--(106, 0, 50, 106),
--(107, 0, 50, 107),
--(108, 0, 50, 108),
--(109, 0, 50, 109),
--(110, 0, 50, 110),
--(111, 0, 50, 111),
--(112, 0, 50, 112)


--seats insertion

--Cinema Hall 1

--insert into Seats (seatNo, cinemaId, status) values (1, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (2, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (3, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (4, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (5, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (6, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (7, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (8, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (9, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (10, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (11, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (12, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (13, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (14, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (15, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (16, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (17, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (18, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (19, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (20, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (21, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (22, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (23, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (24, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (25, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (26, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (27, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (28, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (29, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (30, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (31, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (32, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (33, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (34, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (35, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (36, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (37, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (38, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (39, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (40, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (41, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (42, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (43, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (44, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (45, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (46, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (47, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (48, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (49, 1, 0);
--insert into Seats (seatNo, cinemaId, status) values (50, 1, 0);


----CINEMA1 HALL 2
--insert into Seats (seatNo, cinemaId, status) values (1, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (2, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (3, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (4, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (5, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (6, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (7, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (8, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (9, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (10, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (11, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (12, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (13, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (14, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (15, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (16, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (17, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (18, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (19, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (20, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (21, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (22, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (23, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (24, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (25, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (26, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (27, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (28, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (29, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (30, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (31, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (32, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (33, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (34, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (35, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (36, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (37, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (38, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (39, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (40, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (41, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (42, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (43, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (44, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (45, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (46, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (47, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (48, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (49, 2, 0);
--insert into Seats (seatNo, cinemaId, status) values (50, 2, 0);


----Cinema Hall 3
--insert into Seats (seatNo, cinemaId, status) values (1, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (2, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (3, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (4, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (5, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (6, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (7, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (8, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (9, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (10, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (11, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (12, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (13, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (14, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (15, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (16, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (17, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (18, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (19, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (20, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (21, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (22, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (23, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (24, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (25, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (26, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (27, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (28, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (29, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (30, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (31, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (32, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (33, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (34, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (35, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (36, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (37, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (38, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (39, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (40, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (41, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (42, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (43, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (44, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (45, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (46, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (47, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (48, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (49, 3, 0);
--insert into Seats (seatNo, cinemaId, status) values (50, 3, 0);


----Cinema Hall 4
--insert into Seats (seatNo, cinemaId, status) values (1, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (2, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (3, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (4, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (5, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (6, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (7, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (8, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (9, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (10, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (11, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (12, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (13, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (14, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (15, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (16, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (17, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (18, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (19, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (20, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (21, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (22, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (23, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (24, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (25, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (26, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (27, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (28, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (29, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (30, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (31, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (32, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (33, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (34, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (35, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (36, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (37, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (38, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (39, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (40, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (41, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (42, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (43, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (44, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (45, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (46, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (47, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (48, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (49, 4, 0);
--insert into Seats (seatNo, cinemaId, status) values (50, 4, 0);

--------------------------------------------------------------------------------



select * from Cinemas
select * from Movies
select * from Genre
select * from Slot
select * from [Users]
select * from Seats
select * from schedule
select * from hall