public class Encapsulation {
    private String secret = "Hidden data";

    public String getSecret() {
        return secret;
    }

    public void setSecret(String newSecret) {
        this.secret = newSecret;
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        System.out.println("Before: " + obj.getSecret());
        obj.setSecret("New secret value");
        System.out.println("After: " + obj.getSecret());
    }
}