package com.saohuobang.web.platform.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;


public class ResponseUtil {
	
	
	public static boolean sendMessageNoCache(HttpServletResponse response, String message) {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		StringBuffer sb = new StringBuffer();
		try {
			PrintWriter writer = response.getWriter();
			sb.append(message);
			writer.write(sb.toString());
			response.flushBuffer();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean sendJSON(HttpServletResponse response, Object obj){
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		StringBuffer sb = new StringBuffer();
		try {
			PrintWriter writer = response.getWriter();
			sb.append(JSONUtil.toJSON(obj));
			writer.write(sb.toString());
			response.flushBuffer();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean sendJSONP(HttpServletResponse response, String callBack, Object obj){
		response.setContentType("application/javascript;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		StringBuffer sb = new StringBuffer();
		try {
			PrintWriter writer = response.getWriter();
			sb.append(JSONUtil.toJSONP(callBack, obj));
			writer.write(sb.toString());
			response.flushBuffer();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean sendImg(HttpServletResponse response, BufferedImage buffImg, String mimeType, String fileName, String extName) throws IOException{
		OutputStream out= null;
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment;filename=%s.%s", fileName, extName));
		try {
			out= response.getOutputStream();
			ImageIO.write(buffImg, extName, out);

			return true;
		} catch (IOException e) {
			return false;
		}finally{
			
			if(out!=null)
				out.close();
		}
	}

}
