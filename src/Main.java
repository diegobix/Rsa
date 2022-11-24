import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RSA rsa = new RSA();
        String nombre = "DIEGO ARENAS SUAREZ";
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == ' ') {
                System.out.println();
                continue;
            }
            System.out.print(rsa.encode(nombre.charAt(i)) + " ");
        }
        int[][] numbers = {
                {228, 0, 275, 225, 367},
                {32, 118, 367, 118, 356},
                {50, 118, 356},
                {225, 100, 225, 17, 275, 47, 275, 47, 118, 356}
        };
        String res = "";
        for (int[] row : numbers) {
            for (int n : row) {
                char c = rsa.decodeChar(n);
                res += c;
            }
            System.out.println(res);
            res = "";
        }

        rsa.encodeString(JOptionPane.showInputDialog("Introduce un texto"));
    }
}
