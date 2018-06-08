/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author vvaldez
 */
public class MD5 {

    /**
     * @param args the command line arguments
     */
    
    public static String getMD5(String input) {
 try {
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] messageDigest = md.digest(input.getBytes());
 BigInteger number = new BigInteger(1, messageDigest);
 String hashtext = number.toString(16);

 while (hashtext.length() < 32) {
 hashtext = "0" + hashtext;
 }
 return hashtext;
 }
 catch (NoSuchAlgorithmException e) {
 throw new RuntimeException(e);
 }
 }
    
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
            System.out.print("Introduzca texto: ");
            s = sc.nextLine();
            
            System.out.println("La clave encriptada es "+getMD5(s));
    }
    
}
