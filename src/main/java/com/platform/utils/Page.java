package com.platform.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
 
/**
 * 对分页的基本数据进行�?个简单的封装
 */
public class Page<T> {
 
    private int pageNo = 1;//页码，默认是第一�?
    private int pageSize = 10;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页�?
    private List<T> results;//对应的当前页记录
    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成�?个Map对象
    private HttpServletRequest request;//
    public int getPageNo() {
       return pageNo;
    }
 
    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }
 
    public int getPageSize() {
       return pageSize;
    }
 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
 
    public int getTotalRecord() {
       return totalRecord;
    }
 
    public void setTotalRecord(int totalRecord) {
       this.totalRecord = totalRecord;
       //在设置�?�页数的时�?�计算出对应的�?�页数，在下面的三目运算中加法拥有更高的优先级，�?以最后可以不加括号�??
       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
       this.setTotalPage(totalPage);
    }
 
    public int getTotalPage() {
       return totalPage;
    }
 
    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }
 
    public List<T> getResults() {
       return results;
    }
 
    public void setResults(List<T> results) {
       this.results = results;
    }
   
    public Map<String, Object> getParams() {
       return params;
    }
   
    public void setParams(Map<String, Object> params) {
       this.params = params;
    }
 
    public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
              .append(pageSize).append(", results=").append(results).append(
                     ", totalPage=").append(totalPage).append(
                     ", totalRecord=").append(totalRecord).append("]");
       return builder.toString();
    }
 
}
