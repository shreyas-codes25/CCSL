from Crypto.Cipher import AES

key = b'C&F)H@McQf9TjWnZr'[:16]

data = input("Enter the text to encrypt: ").encode()

cipher = AES.new(key, AES.MODE_EAX)
nonce = cipher.nonce
ciphertext, tag = cipher.encrypt_and_digest(data)

print("\nCipher text:", ciphertext.hex())

cipher = AES.new(key, AES.MODE_EAX, nonce=nonce)
plaintext = cipher.decrypt_and_verify(ciphertext, tag)

print("Decrypted text:", plaintext.decode())
