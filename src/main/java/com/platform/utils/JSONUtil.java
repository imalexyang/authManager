package com.platform.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jackson.type.TypeReference;




public class JSONUtil {
	
	private static Logger logger= Logger.getLogger(JSONUtil.class);
	
	private static ObjectMapper objectMapper;
	
	/**
	 * 懒惰单例模式得到ObjectMapper实例
	 * 此对象为Jackson的核�?
	 */
	private static ObjectMapper getMapper(){
		if (objectMapper== null){
			synchronized (JSONUtil.class) {
				objectMapper= new ObjectMapper();
				//当找不到对应的序列化器时 忽略此字�?
				objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
				//使Jackson JSON支持Unicode编码非ASCII字符
				CustomSerializerFactory serializerFactory= new CustomSerializerFactory();
				serializerFactory.addSpecificMapping(String.class, new StringUnicodeSerializer());
				objectMapper.setSerializerFactory(serializerFactory);
				//支持结束
			}
		}
		return objectMapper;
	}
	
	/**
	 * 将生成的JSON字符串流式输出到sw,
	 * 输出完毕后将其关�?, 使用toString()方法得到�?终字符串
	 */
	public static StringWriter sw= null;
	
	/**
	 * 创建JSON处理器的静�?�方�?
	 * @param content JSON字符�?
	 * @return
	 */
	private static JsonParser getParser(String content){
		try{
			return getMapper().getJsonFactory().createJsonParser(content);
		}catch (IOException ioe){
			return null;
		}
	}
	
	/**
	 * 创建JSON生成器的静�?�方�?, 使用标准输出
	 * @return
	 */
	private static JsonGenerator getGenerator(StringWriter sw){
		try{
			return getMapper().getJsonFactory().createJsonGenerator(sw);
		}catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * JSON对象序列�?
	 */
	public static String toJSON(Object obj){
		StringWriter sw= new StringWriter();
		JsonGenerator jsonGen= getGenerator(sw);
		if (jsonGen== null){
			try {
				sw.close();
			} catch (IOException e) {
			}
			return null;
		}		
		try {
			//由于在getGenerator方法中指定了OutputStream为sw
			//因此调用writeObject会将数据输出到sw
			jsonGen.writeObject(obj);
			//由于采用流式输出 在输出完毕后务必清空缓冲区并关闭输出�?
			jsonGen.flush();
			jsonGen.close();
			return sw.toString();
		} catch (JsonGenerationException jge) {
			logger.error("JSON生成错误" + jge.getMessage());
		} catch (IOException ioe) {
			logger.error("JSON输入输出错误" + ioe.getMessage());
		}
		return null;		
	}
	
	/**
	 * 生成JSONP
	 * @param callBack 回调函数�?
	 * @param obj 要序列化的数据对�?
	 * @return JSONP
	 */
	public static String toJSONP(String callBack, Object obj){
		String json= toJSON(obj);
		String retVal= String.format("%s(%s)", callBack, json);
		return retVal;
	}
	
	/**
	 * JSON对象反序列化
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJSON(String json, Class<T> clazz) {
		try {
			JsonParser jp= getParser(json);
			return jp.readValueAs(clazz);
		} catch (JsonParseException jpe){
			logger.error(String.format("反序列化失败, 错误原因:%s", jpe.getMessage()));
		} catch (JsonMappingException jme){
			logger.error(String.format("反序列化失败, 错误原因:%s", jme.getMessage()));	
		} catch (IOException ioe){
			logger.error(String.format("反序列化失败, 错误原因:%s", ioe.getMessage()));
		}
		return null;
	}
	
	/**
	 * 从JSON反序列化�? 对象 针对容器对象定制
	 * �?:
	 * JSONUtil.fromJSONtoList(jsonStr, new TypeReference<List<SysSlideAD>>(){});
	 * @param json
	 * @param t
	 * @return
	 */
	public static <T> T fromJSON(String json, TypeReference<T> typeReference){
		try {
			return getMapper().readValue(json, typeReference);
		} catch (JsonParseException jpe){
			logger.error(String.format("反序列化失败, 错误原因:%s", jpe.getMessage()));
		} catch (JsonMappingException jme){
			logger.error(String.format("反序列化失败, 错误原因:%s", jme.getMessage()));	
		} catch (IOException ioe){
			logger.error(String.format("反序列化失败, 错误原因:%s", ioe.getMessage()));
		}
		return null;
	}
}
