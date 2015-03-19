	$().ready(function() {		
		$(".menu_list").click(function(){
			 $(".menu_list.active").each(function(){
				 $(this).attr("class", "menu_list");				    
			 });
			 $(this).attr("class", "menu_list active");			
		});	
	});		
	