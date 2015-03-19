$(function () {
    fnNav();
    fnStore();
    fnNavActive();
});

function fnNavActive(){
	 $(".list.nostyle").click(function(){
			 $(".list.nostyle.active").each(function(){
				 $(this).attr("class", "list nostyle");				    
			 });
			 $(this).attr("class", "list nostyle active");			
	});
}

function fnNav(){
    $(".account_wrap").mouseover(function(){
      $(".account_wrap").addClass("account_hover");
      $(".account_name .triangle").addClass("tri_top").removeClass("tri_down");
    });

    $(".account_wrap").mouseleave(function(){
      $(".account_wrap").removeClass("account_hover");

      $(".account_name .triangle").addClass("tri_down").removeClass("tri_top");
    });
}
function fnStore(){
    $(".btn_addnewstore").click(function(){
      $("#pop_newstore").show();
    });
    $(".bg_mask,.close").click(function(){
      $(".pop_wrap").hide();
    });
}
