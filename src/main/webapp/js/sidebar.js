    function opennav1(){
    	document.getElementById("mySidebar1").style.height = "50px";
    	document.getElementById("mySidebar2").style.height = "50px";
    	document.getElementById("charchange1").innerHTML="<a onclick='closenav1()' style='cursor: pointer;'>活动经历<label id='charchange1'>&rtrif;</label></a>";
    }
    function closenav1(){
    	document.getElementById("mySidebar1").style.height = "0px";
    	document.getElementById("mySidebar2").style.height = "0px";
    	document.getElementById("charchange1").innerHTML="<a onclick='opennav1()' style='cursor: pointer;'>活动经历<label id='charchange1'>&dtrif;</label></a>";
    }
    function opennav2(){
    	document.getElementById("mySidebar3").style.height = "50px";
    	document.getElementById("mySidebar4").style.height = "50px";
    	document.getElementById("charchange2").innerHTML="<a onclick='closenav2()' style='cursor: pointer;'>获奖情况<label id='charchange2'>&rtrif;</label></a>";
    }
    function closenav2(){
    	document.getElementById("mySidebar3").style.height = "0px";
    	document.getElementById("mySidebar4").style.height = "0px";
    	document.getElementById("charchange2").innerHTML="<a onclick='opennav2()' style='cursor: pointer;'>获奖情况<label id='charchange2'>&dtrif;</label></a>";
    }