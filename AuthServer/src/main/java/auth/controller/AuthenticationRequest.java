package auth.controller;
public class AuthenticationRequest {
	
	private String username;
    private String password;
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }

    public AuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
