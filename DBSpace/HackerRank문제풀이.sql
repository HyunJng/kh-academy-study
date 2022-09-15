select bookname, length(bookname)
from book
order by length(bookname)ASC, bookname DESC ;

select bookname, lengthb(bookname)from book order by length(bookname);

select bookname, length(bookname)
from book
where length(bookname) = (select max(length(bookname)) from book)
order by length(bookname);

select city, length(city)
from station
where length(city) = max(length(city));