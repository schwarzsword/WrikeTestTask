package schwarzkv.util;

public class MailGenerator {
    private static final String POSTFIX = "+wpt@wriketask.qaa";
    private static final int LEN = 6;

    public static String generate() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(LEN);
        for (int i = 0; i < LEN; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        sb.append(POSTFIX);
        return sb.toString();
    }
}
