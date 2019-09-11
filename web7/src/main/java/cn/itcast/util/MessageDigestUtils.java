package cn.itcast.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestUtils {
	// md5加密
	public static String md5(String str) throws NoSuchAlgorithmException {
		if (str==null || "".equals(str) || str=="") {
			return str;
		}
		MessageDigest instance = MessageDigest.getInstance("md5");
		instance.update(str.getBytes());
		return new BigInteger(1, instance.digest()).toString(16);
	}
}
