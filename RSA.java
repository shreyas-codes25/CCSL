
import java.math.BigInteger;
import java.util.*;
class Algorithm{
    static int n=0;
    static int e;
    static int d;
    void calcED(int p, int q){
        n = p*q;
        int phi = (p-1)*(q-1);
        e = 2;
        while(e<phi){
            
            if(gcd(e,phi)==1){
                break;
            }
            e++;
        }
        d = modInverse(e,phi);
        System.out.println("The public key is: ("+e+","+n+")");
        System.out.println("The private key is: ("+d+","+n+")");

    }
	static int gcd(int e, int z)
	{
		if (e == 0)
			return z;
		else
			return gcd(z % e, e);
	}
    //[(phi +i)+1]/e
    int modInverse(int b, int m) {
        for (int x = 1; x < m; x++) {
            if ((b * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    int encrypt(int pt) {
        return BigInteger.valueOf(pt).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).intValue();
    }

    
    int decrypt(int ct) {
        return BigInteger.valueOf(ct).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).intValue();
    }

}


public class RSA{
    public static void main(String args[]){
        Algorithm a = new Algorithm();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of p:");
        int p = sc.nextInt();
        System.out.println("Enter the value of q:");
        int q = sc.nextInt();
        a.calcED(p,q);
        System.out.println("Enter the message to be encrypted:");
        int pt = sc.nextInt();
        int ct = a.encrypt(pt);
        System.out.println("The encrypted message is: "+ct);
        System.out.println("The decrypted message is: "+a.decrypt(ct));
        sc.close();
    }
}

