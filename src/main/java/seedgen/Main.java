package seedgen;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * A seed generator for IOTA. 
 * 
 * @author eukaryote
 *
 */
public class Main {
	static final String TRYTE_ALPHABET = "9ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final int SEED_LEN = 81;
	
	public static void main(String[] args) {
		// our secure randomness source
		SecureRandom sr;
		try {
			sr = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			// this should not happen!
			e.printStackTrace();
			return;
		}
		
		// the resulting seed
		StringBuilder sb = new StringBuilder(SEED_LEN);
		
		for(int i = 0; i < SEED_LEN; i++) {
			int n = sr.nextInt(27);
			char c = TRYTE_ALPHABET.charAt(n);
			
			sb.append(c);
		}
		
		System.out.println(sb.toString());
		
		// clear StringBuilder just in case. 
		for(int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, (char) 0);
		}
	}

}
