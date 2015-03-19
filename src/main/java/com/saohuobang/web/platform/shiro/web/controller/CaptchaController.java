//package com.saohuobang.web.platform.shiro.web.controller;
//
//import java.awt.image.BufferedImage;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.saohuobang.web.platform.codeServer.service.inf.CaptchaInf;
//import com.saohuobang.web.platform.utils.ResponseUtil;
//import com.saohuobang.web.platform.utils.StringUtil;
//
//
//
//@Controller
//@RequestMapping(value="/captcha/*")
//public class CaptchaController {
//
//	private static Logger logger= Logger.getLogger(CaptchaController.class);
//
//	@Autowired
//	private CaptchaInf captchaInf;
//
////	public CaptchaController(){
////		logger.info("正在构造验证码控制器...");
////	}
//
//	@RequestMapping(value="verify.do")
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public String verify(HttpServletRequest request,
//			HttpServletResponse response,
//			String captcha,
//			String token,
//			Map model){
//		boolean hasError= false;
//		String msg= null;
//		do{
//			if (StringUtil.isEmpty(captcha)){
//				hasError= true;
//				msg= "未输入验证码";
//				break;
//			}
//			if (StringUtil.isEmpty(token)){
//				hasError= true;
//				msg= "token缺失";
//				break;
//			}
//			//验证码验证
//			boolean captchaPass= false;
//			try {
//				captchaPass = captchaInf.doVerify(captcha, token);
//			} catch (Exception e) {
//				hasError= true;
//				msg= e.getMessage();
//				break;
//			}
//			if (!captchaPass){
//				hasError= true;
//				msg= "验证码错误";
//				break;
//			}
//		}while(false);
//		if (hasError){
//			model.put("msg", String.format("出错了:%s", msg));
//		}else{
//			model.put("msg", "验证成功");
//		}
//		return "verify";
//	}
//
//
//	/**
//	 * 验证码请求接口
//	 * @param request
//	 * @param response
//	 * @param token
//	 * @return
//	 */
//	@RequestMapping(value="captcha.do")
//	public String requestCaptcha(HttpServletRequest request,
//			HttpServletResponse response,
//			String token){
//		if (StringUtil.isEmpty(token)){
//			token= captchaInf.genToken();
//			ResponseUtil.sendJSON(response, token);
//		}else{
//			try{
//				String captcha= captchaInf.getCaptcha(token);
//				//根据明文captcha生成图片
//				BufferedImage img= captchaInf.getCaptchaImg(captcha);
//				//发送图片
//				ResponseUtil.sendImg(response, img, "image/jpeg", "code", "jpg");
//			}catch(Exception e){
//				e.printStackTrace();
//				logger.error(String.format("生成验证码图片出错:%s", e.getMessage()));
//			}
//		}
//		return null;
//	}
//
//}
