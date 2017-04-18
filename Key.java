import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Key {

	public static String generate(String name, int space) {
		String sha1 = sha1_Base2(name);
		int characters = (int) (Math.log(space)/Math.log(2));
		characters = Math.min(characters, sha1.length());
		return sha1.substring(sha1.length()-characters-1, sha1.length());
	}
	
	public static boolean between(String k, String f, String t) {
		float key = Float.parseFloat(k);
		float from = Float.parseFloat(f);
		float to = Float.parseFloat(t);
		
		if(from > to) {
			return key > from || key <= to;
		}else if(from < to)
			return key > from && key <= to;
		else
			return true;		
	}
	
	private static String sha1_Base2(String s) {
		String sha1 = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(s.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString(result[i], 2).substring(1));
			}
			sha1 = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sha1;
	}


	private static String sha1_Base16(String s) {
		String sha1 = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(s.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString(result[i], 16).substring(1));
			}
			sha1 = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sha1;
	}

	public static String generate_Base16(String name, int space) {
		String sha1 = sha1_Base16(name);
		int characters = (int) (Math.log(space)/Math.log(2));
		characters = Math.min(characters, sha1.length());
		return sha1.substring(Math.max(0, sha1.length()-characters-1), sha1.length());
	}
}
