package com.platform.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
* @ClassName: SerializableUtils 
* @Description: 序列化
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:13:15 
*
 */
public class SerializableUtils {

//    public static String serialize(Session session) {
//        try {
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(bos);
//            oos.writeObject(session);
//            return Base64.encodeToString(bos.toByteArray());
//        } catch (Exception e) {
//            throw new RuntimeException("serialize session error", e);
//        }
//    }
//    public static Session deserialize(String sessionStr) {
//        try {
//            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
//            ObjectInputStream ois = new ObjectInputStream(bis);
//            return (Session)ois.readObject();
//        } catch (Exception e) {
//            throw new RuntimeException("deserialize session error", e);
//        }
//    }
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列�?
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
}
