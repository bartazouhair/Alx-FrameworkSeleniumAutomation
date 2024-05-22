package utils;

public class Constante {

	private String useremail = "bartazouhair@gmail.com";
	private String password = "Zouhair.100";
	private String image = "C:\\Users\\zbarta\\Documents\\BARTA ZOUHAIR\\Capgemini Zouhair Barta\\Stage PFE\\Me\\BARTA Zouhair.jpg";

	public Constante() {
	}

	public Constante(String useremail, String password, String image) {
		super();
		this.useremail = useremail;
		this.password = password;
		this.image = image;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Constante [useremail=" + useremail + ", password=" + password + ", image=" + image + "]";
	}

}
