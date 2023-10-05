import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
        System.out.println("--------Vigenere Cipher Encryptor---------\n");
        Scanner in = new Scanner(System.in);

        // User chooses if they want to encrypt or decrypt
        System.out.println("Press 1 to encrypt message or Press 2 to decrypt message");
        int input = in.nextInt();
        in.nextLine(); // Consume the newline character

        if (input == 1) {
            System.out.println("Enter the key in UPPER CASE: ");
            String key = in.nextLine().toUpperCase();
            System.out.println("Enter the message that you would like to be encrypted by using Vigenere Cipher: ");
            String Emessage = in.nextLine().toUpperCase();
            String encryptMessage = encrypt(Emessage, key);
            System.out.println("The encrypted message is: " + encryptMessage);

        } else if (input == 2) {
            System.out.println("Enter the key in UPPER CASE: ");
            String key = in.nextLine().toUpperCase();
            System.out.println("Enter the message that you would like to be decrypted by using Vigenere Cipher: ");
            String Dmessage = in.nextLine().toUpperCase();
            String DecryptMessage = decrypt(Dmessage, key);
            System.out.println("The decrypted message is: " + DecryptMessage);
        } else {
            System.out.println("Wrong input");
        }
        in.close();
    }

    // Encryption using ASCII decode
    public static String encrypt(String Message, String key) {
        String Emessage = "";
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            Emessage += (char) (((letter - 65) + (key.charAt(j) - 65)) % 26 + 65);
            j = ++j % key.length();
        }
        return Emessage;
    }

    // Decryption using ASCII decode
    public static String decrypt(String Message, String key) {
        String Dmessage = "";
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            Dmessage += (char) ((letter - key.charAt(j) + 26) % 26 + 65);
            j = ++j % key.length();
        }
        return Dmessage;
    }
}
