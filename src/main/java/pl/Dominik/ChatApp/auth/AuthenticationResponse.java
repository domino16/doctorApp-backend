package pl.Dominik.ChatApp.auth;




public class AuthenticationResponse {

    private String idToken;
    private String email;

    private String expiresIn;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse( String idToken, String email, String expiresIn) {
        this.idToken = idToken;
        this.email = email;
        this.expiresIn = expiresIn;


    }



    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }


}
