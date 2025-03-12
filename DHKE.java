import java.util.Scanner;
import java.math.BigInteger;
class DHKE {

    private static BigInteger power(BigInteger a, BigInteger b, BigInteger p) {
        if (b.equals(BigInteger.ONE))
            return a;
        else
        return a.modPow(b, p);
    }

    public static void main(String[] args) {
        BigInteger P, G, x, a, y, b, ka, kb;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter value of p:" );
        P = s.nextBigInteger();

        

        System.out.println("Enter value of G:" );
        G = s.nextBigInteger();

        
        System.out.println("Enter value of Private key of a :" );
        a = s.nextBigInteger();

        x = power(G, a, P);

        
        System.out.println("Enter value of private ket of b:" );
        b = s.nextBigInteger();

        y = power(G, b, P);

        ka = power(y, a, P);
        kb = power(x, b, P);

        System.out.println("Secret key for the A is:"+ ka);
        System.out.println("Secret key for the B is:"+ kb);
        s.close();
    }
}
