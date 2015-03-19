package com.platform.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.platform.utils.Page;

/** 
* @ClassName: BaseControl 
* @Description: TODO(Base�?) 
* @author lis
* @date 2014-8-29 上午11:41:31 
*  
*/
public class PageUtil{
	private static int pageSize = 10;//每页条数
	private int pageNumber =1 ;//
	/** 
	* @Title: getSession 
	* @Description: TODO 取session
	* @author lis
	* @param @return 
	* @return HttpSession 
	* @throws 
	*/ 
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}

	/** 
	* @Title: getRequest 
	* @Description: TODO 取request
	* @author lis
	* @param @return 
	* @return HttpServletRequest 
	* @throws 
	*/ 
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest();
	}
	
	
	/**
	 * 
	* @Title: buidPagebean 
	* @Description: TODO 
	* @author wangwl
	* @param @param request
	* @param @return 
	* @return Page<T> 
	* @throws
	 */
	public static Page buidPagebean(HttpServletRequest request,Map<String, Object> map) {
		if(map == null){
			map = new HashMap<String, Object>();
		}
		int pageNumber=1;
		int pageSize=10;
		if(request.getParameter("pageNo")!=null){
			pageNumber=Integer.parseInt(request.getParameter("pageNo").trim());//页码
		}
		if(request.getParameter("pageSize")!=null){
			pageSize=Integer.parseInt(request.getParameter("pageSize").trim());//每页显示几条	
		}
		Iterator it = request.getParameterMap().keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String values[] = request.getParameterValues(key);
			if (values.length == 1) {
				map.put(key, values[0].trim());
			} else {
				map.put(key, values);
			}
		}
		Page pagebean = new Page();
		pagebean.setPageNo(pageNumber);
		pagebean.setPageSize(pageSize);
		pagebean.setParams(map);
		pagebean.setRequest(request);
		
		return pagebean;
	}

	/**
	 * 
	* @Title: buildGrid 
	* @Description: TODO 
	* @author wangwl
	* @param @param pagebean 
	* @return void 
	* @throws
	 */
	public static void buildGrid(Page pagebean) {
		int pageNo=pagebean.getPageNo();//当前�?
		int pageCount=pagebean.getTotalPage();//总页�?
		int recordCount=pagebean.getTotalRecord();//总记录数
		HttpServletRequest request=pagebean.getRequest();
		
		StringBuffer _params = new StringBuffer();
		Iterator it2 = pagebean.getParams().keySet().iterator();
		while (it2.hasNext()) {
			String key = (String) it2.next();
			if (!key.equals("pageNo"))
				_params.append("&"+key).append("=").append(pagebean.getParams().get(key));
		}

		String path = request.getRequestURI();
		String nextPage = "下一�?";

		String previousPage = "上一�?";

		StringBuffer num = new StringBuffer();

		int showNumCount = 10;
		int count = 0;
		int pageIndex = 1;
		String firstPage = "首页";
		String lastPage = "末页";
		//String pageno = request.getParameter("currentPage");
		if (pageNo>0) {
			pageIndex =pageNo;
		} else
			pageIndex = 1;
			

		if (pageCount < 1 && recordCount > 0) {
			pageCount = (int) (recordCount % pageSize == 0 ? recordCount
					/ pageSize : (recordCount / pageSize + 1));
		}

		if (recordCount < 1) {
			//recordCount = 1;
			pageCount = 1;
			pageIndex = 1;
		}
		if (pageIndex > pageCount) {
			pageIndex = (int) pageCount;
		}
		count = (int) pageCount;

		String temp = "?";
		if (path.indexOf("?") > 0) {
			temp = "&";
		}

//		firstPage = "<a href=\"" + path + temp + _params
//				+ "&currentPage=1\">首页</a>";
		if(count == 1 || pageIndex==1)
			firstPage="#";
		else
			firstPage = path + temp + _params+ "&pageNo=1";
		
//		lastPage = "<a href=\"" + path + temp + _params + "&currentPage="
//				+ count + "\">末页</a>";
		if(count == 1 || pageIndex==count)
			lastPage="#";
		else
			lastPage =  path + temp + _params + "&pageNo="	+ count;
		if (pageIndex > 1)
//			previousPage = "<a href=\"" + path + temp + _params
//					+ "&currentPage=" + (pageIndex - 1) + "\" >上一�?</a>";
		previousPage =  path + temp + "&pageNo=" + (pageIndex - 1);
		else
//			previousPage = "上一�?";
			previousPage = "#";

		if (pageIndex >= count)
//			nextPage = "下一�?";
			nextPage = "#";
		else
//			nextPage = "<a href=\"" + path + temp + _params + "&currentPage="
//					+ (pageIndex + 1) + "\" >下一�?</a>";
			nextPage = path + temp + "&pageNo="+ (pageIndex + 1) ;

		int startNo = 1;
		int endNo = 0;

		if ((pageIndex - showNumCount / 2) <= 0) {
			startNo = 1;
			endNo = pageIndex;
		} else if (pageIndex - showNumCount / 2 > 0) {
			startNo = pageIndex - showNumCount / 2;
			endNo = pageIndex;
		}

		for (int i = startNo; i < endNo; i++) {
			num.append("<a href=\"" + path + temp + _params + "&pageNo="
					+ i + "\">" + i + "</a>&nbsp;");
		}

		for (int i = pageIndex; i <= count && i < pageIndex + showNumCount / 2; i++) {
			if (i == pageIndex)
				num.append("&nbsp;" + i);
			else
				num.append("&nbsp;<a href=\"" + path + temp + _params
						+ "&pageNo=" + i + "\">" + i + "</a>");
		}
		firstPage= firstPage.replace("?&", "?");
		previousPage= previousPage.replace("?&", "?");
		nextPage= nextPage.replace("?&", "?");
		lastPage= lastPage.replace("?&", "?");
		String goPage =  path + temp + "&pageNo=";
		goPage= goPage.replace("?&", "?");
		
		String pageTag = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
		
		pageTag="<span class=\"page_nav_area\">" +
				"<a class=\"btnp btnp_default page_prev\" href=\"javascript:topage(1);\"><i class=\"arrow\"></i></a>" +
				"<span class=\"page_num\">" +
				" <label>"+pageIndex+"</label>" +
				"<span class=\"num_gap\">/</span>" +
						"<label>"+pageCount+"</label></span>" +
						"<a class=\"btnp btnp_default page_next\" href=\"javascript:topage(2);\"><i class=\"arrow\"></i></a></span>" +
						"<span class=\"goto_area\"><input id=\"textfield\" type=\"text\">" +
						"<a class=\"btnp btnp_default page_go\" href=\"javascript:gopage();\">跳转</a></span>"+
		
		"<script type=\"text/javascript\">"+
        "  function gopage(){"+
       "   var num = document.getElementById(\"textfield\").value;"+
        "  if (!num) {"+
         "     alert('页码不能为空');"+
        "      document.getElementById(\"textfield\").value='';"+
//        "      return false;"+
        "  } else if (isNaN(num)) {"+
        "      alert('你输入的页码不是数字，请输入数字');"+
         "     document.getElementById(\"textfield\").value='';"+
//         "     return false;"+
        "  } else if (num <= 0 ) {"+
         "     alert('�?要输入大�?0的数�?');"+
         "     document.getElementById(\"textfield\").value='';"+
//         "     return false;"+
        "  }else if (num >"+pageCount +") {"+
         "     alert('�?要输入小于�?�页的数�?');"+
//         "     return false;"+
        "  }else{"+
        " var form=document.getElementById(\"hiddenForm\");"+
        "form.action='"+goPage+"'+num;form.submit();"+
         " }"+

          "}"+
          
		"  function topage(flag){"+
			" var form=document.getElementById(\"hiddenForm\");"+
			"if(flag==1){" +//上一�?
			"form.action='"+previousPage+"';" +
			"}else if(flag==2){form.action='"+nextPage+"';}"+//下一�?
		 	"form.submit(); "+
		
		   "}"+
        "  </script>";
		
		String formPage="<form method=\"post\" id='hiddenForm'>";
		Iterator it3 = pagebean.getParams().keySet().iterator();
		while (it3.hasNext()) {
			String key = (String) it3.next();
			formPage=formPage+" <input type=\"hidden\" name='"+key+"' id='"+key+"' value='"+pagebean.getParams().get(key)+"'>";
		}
		formPage=formPage+"</form>";
		pageTag=pageTag+formPage;
		request.setAttribute("pagetag", pageTag);
		//request.setAttribute("list", ms);
	}
}
