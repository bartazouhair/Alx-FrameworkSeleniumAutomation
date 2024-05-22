package utils;

public class Constante {

    // User email
    private String useremail = "bartazouhair@gmail.com";
    
    // User password
    private String password = "Zouhair.100";
    
    // Path to the image file
    private String image = "C:\\Users\\zbarta\\Documents\\BARTA ZOUHAIR\\Capgemini Zouhair Barta\\Stage PFE\\Me\\Photo.png";

    // Default constructor
    public Constante() {
    }

    // Parameterized constructor
    public Constante(String useremail, String password, String image) {
        super();
        this.useremail = useremail;
        this.password = password;
        this.image = image;
    }

    // Getter for user email
    public String getUseremail() {
        return useremail;
    }

    // Setter for user email
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for image path
    public String getImage() {
        return image;
    }

    // Setter for image path
    public void setImage(String image) {
        this.image = image;
    }

    // Override toString method to provide string representation of the object
    @Override
    public String toString() {
        return "Constante [useremail=" + useremail + ", password=" + password + ", image=" + image + "]";
    }
}