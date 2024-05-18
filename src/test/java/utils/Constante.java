package utils;

public class Constante {

	private String useremail = "bartazouhair@gmail.com";
	private String password = "Zouhair.100";

	public Constante() {
	}

	public Constante(String useremail, String password) {
		super();
		this.useremail = useremail;
		this.password = password;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseemail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Constante [username=" + useremail + ", password=" + password + ", getUsername()=" + getUseremail()
				+ ", getPassword()=" + getPassword() + "]";
	}

}
