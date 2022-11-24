import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class RSA {
    private final static int p = 13;
    private final static int q = 29;
    private final static int n = p*q;
    private final static int e = 13;
    private final static int d = 181;

    private Map<Integer, Character> dic;

    public RSA() {
        dic = new HashMap<>();
        dic.put(0, 'A');
        dic.put(1, 'B');
        dic.put(2, 'C');
        dic.put(3, 'D');
        dic.put(4, 'E');
        dic.put(5, 'F');
        dic.put(6, 'G');
        dic.put(7, 'H');
        dic.put(8, 'I');
        dic.put(9, 'J');
        dic.put(10, 'K');
        dic.put(11, 'L');
        dic.put(12, 'M');
        dic.put(13, 'N');
        dic.put(14, 'O');
        dic.put(15, 'P');
        dic.put(16, 'Q');
        dic.put(17, 'R');
        dic.put(18, 'S');
        dic.put(19, 'T');
        dic.put(20, 'U');
        dic.put(21, 'V');
        dic.put(22, 'W');
        dic.put(23, 'X');
        dic.put(24, 'Y');
        dic.put(25, 'Z');
        dic.put(26, ' ');
    }

    public int encode(int m) {
        BigInteger c = BigInteger.valueOf(m);
        BigInteger N = BigInteger.valueOf(n);
        c = (c.pow(e)).mod(N);
        return c.intValue();
    }

    public int encode(char m) {
        int k = getKey(m);
        BigInteger c = BigInteger.valueOf(k);
        BigInteger N = BigInteger.valueOf(n);
        c = (c.pow(e)).mod(N);
        return c.intValue();
    }

    public Character decodeChar(int c) {
        BigInteger N = BigInteger.valueOf(n);
        BigInteger m = BigInteger.valueOf(c);
        m = (m.pow(d)).mod(N);
        int msg = m.intValue();
        return dic.get(msg);
    }

    public int decode(int c) {
        BigInteger N = BigInteger.valueOf(n);
        BigInteger m = BigInteger.valueOf(c);
        m = (m.pow(d)).mod(N);
        return m.intValue();
    }

    private int getKey(Character c) {
        for (Map.Entry<Integer, Character> entry : dic.entrySet()) {
            if (entry.getValue().equals(c)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public void encodeString(String nombre) {
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == ' ') {
                System.out.println();
                continue;
            }
            System.out.print(encode(nombre.charAt(i)) + " ");
        }
    }
}
