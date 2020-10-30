package lbk.group.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();
		System.out.println(pEncoder.encode("limont!IFTS5"));
	}

}
