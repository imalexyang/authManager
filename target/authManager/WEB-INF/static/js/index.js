	function iFrameHeight() {
	    var ifm = document.getElementById("iframe");
	    if(ifm ==null){return;}
	    var subWeb = document.frames ? document.frames["iframe"].document : ifm.contentDocument;
	    if (ifm != null && subWeb != null) {
	         ifm.height = subWeb.body.scrollHeight;
	    }
	}
	function changeMain(){		
		$("#iframe").attr("src",$("#imframe").contents().find(".menu_list:first a").attr("href"));
	}
	$().ready(function() {		
		$(".menu_list").click(function(){
			 $(".menu_list.active").each(function(){
				 $(this).attr("class", "menu_list");				    
			 });
			 $(this).attr("class", "menu_list active");			
		});	
	});