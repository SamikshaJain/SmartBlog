$(document).ready(function() {
	 alert("I am here ");
	 $.ajax({
		    url: 'cmad/blogs', // returns "[1,2,3,4,5,6]"
		    dataType: 'json', // jQuery will parse the response as JSON
		    success: function (outputfromserver) {

		    	$.each(outputfromserver, function(index, data) {
		    		
		    		var 	brpoint = document.createElement('br'),
		    		ith = document.createElement('h2'),
		    		ita=document.createElement('a'),
		    		its=document.createElement('span'),
		    		ita=document.createTextNode(data.title),
		    		username = data.username,
		    		blogTime= dataFromTimestamp(data.postdate),
		    	     dateTxt = blogTime + "| Posted By " + username,
		    	     its=document.createTextNode(dateTxt);
		    		
		    		 $(its).attr('class','small');
		    		 ith.appendChild(ita);
		    		 ith.appendChild(brpoint);
		    		 ith.appendChild(its);

			    	 
			    	 var itp = document.createElement('p'),
			    	 ipt = document.createTextNode(data.content),
		    	     itp2 = document.createElement('p'),
		    	     ita2=document.createElement('a'),
		    	     ipt2 = document.createTextNode("Read More"),
		    	     brpoint2 =document.createElement('br'),
		    	      blogid= data.blogId;
			    	 
			    	 itp.appendChild(ipt);
			    	  $(ita2).attr('href','#');
			    	  $(ita2).attr('class','mylink');
			    	  $(ita2).attr('id', blogid);
			    	  ita2.appendChild(ipt2);
			    	 itp2.appendChild(ita2);
			    	 
			    	  $("#left").append(ith).append(itp).append(brpoint2).append(itp2);
		    	
		        });
		    }
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
