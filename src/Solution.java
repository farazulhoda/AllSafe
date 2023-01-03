import java.io.*;
import java.util.*;
public class Solution
    {
        public static final String alpha =  "abcdefghijklmnopqrstuvwxyz";

        public static String encrypt(String message, int shiftKey)
        {
            message =   message.toLowerCase();
            String cipherTexString  =   "";
            for(int i=0; i< message.length(); i++)
            {
                int charPosition    =   alpha.indexOf(message.charAt(i));
                int keyVal  =   (shiftKey   +   charPosition)   %   26;
                char replaceVal =   alpha.charAt(keyVal);
                ciperText += replaceVal;
            }
            return cipherText;
        }
        public static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            String message = new String();
            int key = 0;
            System.out.print("Enter the String for Encryption: ");
            message = sc.next();

            System.out.println("\n\nEnter Shift Key: ");
            key = sc.nextInt();
            System.out.println("\nEncrypted msg:" + encrypt(message, key));
        }
    }