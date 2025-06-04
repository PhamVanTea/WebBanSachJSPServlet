package util;

import java.security.MessageDigest;
import java.util.Base64;


public class MaHoa {
	//mã hóa sha-1
	public static String toSHA1(String str) {
		String salt = "dhsjkajs@hdjnkmsnan$ckaVFsjh#dkasdaPsdcvxead";
		String result = null;
		
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] hashBytes = md.digest(dataBytes);
			result = Base64.getEncoder().encodeToString(hashBytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("123456"));
	}
}
