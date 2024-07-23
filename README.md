# vernam-cipher

Vernam Cipher creates a one time pad and enciphered value of the same length as the incoming data. It can be a full document or a credit card number Encipherment is faster and more secure than encryption but the trade off is more storage space and separate storage locations.

# panda-cipher

Uses the vernam-cipher to encipher and decipher incoming PANs. When doing an encipherment, the data returned consists of:

Token: BIN+rndm+lastFour
BIN: the bin number
lastFour: last four digits of the PAN
Panda: the padded PAN
OTP: The One Time Pad

## Perfect Secrecy

Used by the US and USSR in the cold war, the Vernam Cipher was an unbreakable method of enciphering and deciphering messages. Unlike many common encryption methods, it doesn't use an algorithm to obscure the data or make it difficult to figure out. There isn't a common key or password which, once gained, will reveal all the data. It is considered "infomation-theoretically secure" - perfect secrecy.

Instead it uses a fast and simple method of generating random numbers and letters which are added to the original. If the result after addtion is found to be larger than the maximum value, the modulo of the total set size is used to wrap the results. To decipher, one simply subtracts the keys or one time pad from the enciphered value (see the wiki link below for more information).

Because the cipher is based on addition/subtraction, it is extremely fast in operation.

As a practical matter it means that data stored at rest is junk and random data. The enciphered data is as random as the pad that enciphered it. Both the one time pad and the enciphered data are required in order to restore the original message. By storing the values in separate databases, it thwarts hacking while making its use in any integration both simple and fast. The only time the data exists is when it is reconstructed on the wire during processing.

The current implementation uses Java SecureRandom for its random generator. During the encryption process, some random digits are thrown out as a result of processing. Even if a weaker PRNG were used, the store for random one time pads would be informationally incomplete making it impossible to determine the random stream. Finally, it must be noted that the one time pads, after generation, will be stored in a database which will result in generation order being lost which makes it impossible to reconstruct the stream. Even if the one time pads or their enciphered twin were published in clear text on the web, no useful data could be extracted - perfect secrecy.

"This is a very strong notion of security first developed during WWII by Claude Shannon and proved, mathematically, to be true for the one-time pad by Shannon about the same time. His result was published in the Bell Labs Technical Journal in 1949. Properly used, one-time pads are secure in this sense even against adversaries with infinite computational power.

Claude Shannon proved, using information theory, that the one-time pad has a property he termed perfect secrecy; that is, the ciphertext gives absolutely no additional information about the plaintext. This is because, given a truly random key that is used only once, a ciphertext can be translated into any plaintext of the same length, and all are equally likely. Thus, the a priori probability of a plaintext message M is the same as the a posteriori probability of a plaintext message M given the corresponding ciphertext"

https://en.wikipedia.org/wiki/One-time_pad
