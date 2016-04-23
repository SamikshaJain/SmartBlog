$(document).ready(function() {
	 alert("I am here ");
	 var id = window.location.href.slice(window.location.href.indexOf('?') + 1).split('=');

	 var data = null;
	 var url = "cmad/blogs/" + id[1];


	 $.get(url, function(data){

	     var ith=document.createElement('h2'),
	           its=document.createElement('span'),
	         ita=document.createElement('a'),
	         blogTimeRaw= dataFromTimestamp(data.postDate),
	         dateTxt = blogTimeRaw + "| Posted By",
	         iat=document.createTextNode(data.title),
	         idn=document.createTextNode(dateTxt),
	         brpoint = document.createElement('br'),
	         itp = document.createElement('p'),
	      ipt = document.createTextNode(data.content),
	      itp2 = document.createElement('p'),
	      ita2=document.createElement('a'),
	      ipt2 = document.createTextNode("Read More"),
	      brpoint2 =document.createElement('br'),
	       blogid= data.blogId;

	   ith.appendChild(iat);
	   ith.appendChild(brpoint);
	   its.appendChild(idn);
	   ith.appendChild(its);
	   itp.appendChild(ipt);
	   $(ita2).attr('href','#');
	   $(ita2).attr('class','mylink');
	   $(ita2).attr('id', blogid);
	   ita2.appendChild(ipt2);
	  itp2.appendChild(ita2);

	   $("#left").append(ith).append(itp).append(brpoint2).append(itp2);


	 });

});
function dataFromTimestamp(timestamp){
    var d = new Date(timestamp);

    // Time
    var h = addZero(d.getHours());              //hours
    var m = addZero(d.getMinutes());            //minutes
    var s = addZero(d.getSeconds());            //seconds

    // Date
    var da = d.getDate();                       //day
    var mon = d.getMonth() + 1;                 //month
    var yr = d.getFullYear();                   //year
    var dw = d.getDay();                        //day in week

    // Readable feilds
    months = ["jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"];
    var monName = months[d.getMonth()];         //month Name
    var time = h + ":" + m + ":" + s;           //full time show
    var thisDay = da + "/" + mon + "/" + yr;    //full date show
    var fullTimeValue = thisDay + " " + h +":" + m + ":" + s;
    var dateTime = {
        seconds : s,
        minutes : m,
        hours : h,
        dayInMonth : da,
        month : mon,
        year : yr,
        dayInTheWeek : dw,
        monthName : monName,
        fullTime : time,
        fullDate : thisDay
    };
    return fullTimeValue;

    function addZero(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }
}
