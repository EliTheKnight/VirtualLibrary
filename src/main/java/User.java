import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User {
    private String hashed;
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static User fromHashed(String hashed) {
        User res = new User();
        res.hashed = hashed;
        return res;
    }

    public User(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(password.getBytes());
        this.hashed = bytesToHex(digest.digest());
    }

    public User() {}

    public void updatePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(password.getBytes());
        this.hashed = bytesToHex(digest.digest());
    }

    public static User fromString(String in) {
        String[] fields = in.split(":");
        return fromHashed(fields[0]);
    }

    public boolean checkPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(pass.getBytes());
        return Objects.equals(this.hashed, bytesToHex(digest.digest()));
    }
}
