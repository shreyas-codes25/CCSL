
def gcd(e, z):
    if e == 0:
        return z
    else:
        return gcd(z % e, e)

def mod_inverse(b, m):
    for x in range(1, m):
        if (b * x) % m == 1:
            return x
    return 1

def calc_ed(p, q):
    n = p * q
    phi = (p - 1) * (q - 1)
    e = 2
    while e < phi:
        if gcd(e, phi) == 1:
            break
        e += 1
    d = mod_inverse(e, phi)
    print(f"The public key is: ({e},{n})")
    print(f"The private key is: ({d},{n})")
    return e, d, n

def encrypt(pt, e, n):
    return pow(pt, e, n)

def decrypt(ct, d, n):
    return pow(ct, d, n)

if __name__ == "__main__":
    p = int(input("Enter the value of p: "))
    q = int(input("Enter the value of q: "))
    e, d, n = calc_ed(p, q)
    pt = int(input("Enter the message to be encrypted: "))
    ct = encrypt(pt, e, n)
    print(f"The encrypted message is: {ct}")
    print(f"The decrypted message is: {decrypt(ct, d, n)}")

