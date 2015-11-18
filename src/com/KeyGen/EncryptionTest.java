package com.KeyGen;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Hex;

import com.til.keys.decryptor.TILDecryptor;
import com.til.keys.encryptor.TILEncryptor;
import com.til.keys.generator.TILKeyPairGenerator;
import com.til.keys.interfaces.KeyGenerator;
import com.til.keys.utils.TILKeyGenUtils;

public class EncryptionTest {

	public static void main(String[] args) throws Exception {

		KeyGenerator gen = TILKeyPairGenerator.getInstance();

		String secret = "$$ecret#or@riginalEquipment||\\//||anufacturer**";
		String PUB_PATH = "F:/keys/pub.der";
		String PRI_PATH = "F:/keys/pvt.der";
		/*PubPrivKeyPair keyPair = gen.generateKeys(secret, PUB_PATH, PRI_PATH);
		
		PrivateKey pvtKey = keyPair.getPrivateKey();
		PublicKey pubKey = keyPair.getPublicKey();
		
		System.out.println("Printing Pub Key");
		System.out.println(pubKey);
		
		System.out.println("Printing Private Key");
		System.out.println(pvtKey);*/
		
		
		
		/*
		 * The above public and private keys contain exponent and modulus, 
		 * It is possible to create public key and private key from the modulus and exponent by the following
		 * PublicKey publickey=PublicPrivKeyUtils.getPublicKey (public_modulus, public_exponent);
		 * PrivateKey privatekey=PublicPrivKeyUtils.getPrivateKey (private_modulus, private_exponent);
		 */

		PublicKey p=TILKeyGenUtils.getPublicKey(new BigInteger("98934414844637753265523060404905914897364188981397020156787059139491561977644707854217953723399628056245147242783145399191825066862405032912850067799741009565571204625193735194032719020574252370061308430724643920598928163285475046425273527905192455461381916818133569129208969945626625522173997634375727595463"), new BigInteger("65537"));
		/*PrivateKey pk=TILKeyGenUtils.getPrivateKeyFromFile(PRI_PATH);*/
		
		String encryptedData = TILEncryptor.getInstance().encryptData(
				"MyDevice", getPublic(PUB_PATH));
		String decryptedData = TILDecryptor.getInstance().decryptData(
				encryptedData, getPrivate(PRI_PATH));
		
		
		

		System.out.println("encrypted string  is "+ encryptedData);
		System.out.println("decryptedString is " + decryptedData);

		/*
		 * openssl pkcs8 -nocrypt -inform der < pvt.der > pvt.pem 	=> converts pvt der file to a pem file, so that it can be used by all applications 
		 * openssl rsa -pubin -inform der < pub.der > pub.pem 		=> converts pub der file to a pem file, so that it can be used by all applications
		 * 
		 * openssl rsautl -encrypt -inkey pub.pem -pubin -in enc.txt -out enc.dat 	=> encrypts the string in enc.txt to enc.dat file. 
		 * openssl rsautl -decrypt -inkey pvt.pem -in enc.dat 						=> decrypts the enc.dat file to appropriate string.
		 * 
		 */

		// System.out.println((Base64.encode(getBytes("D:/workspace/TimesSSO/keys/toi/enc.dat"))));;

		/*
		 * byte[] bts =Hex.decodeHex(
		 * "41b42b77fd0f6d5a8486e5030af625af2e3f76551d627b48136004603ecb98c1160f20562b55cd07695052bd0f67541e968df7859f820cb8fa818a786f70d47285c97b1e1589029e71e6f200f790f5c185edf06c0d164618dc647be3d3740149aba5c769bae195764150559156056954a6778c7d4e9685dfc2ff3f7c139ab25d"
		 * .toCharArray()); Cipher cipher = Cipher.getInstance("RSA");
		 * cipher.init(Cipher.DECRYPT_MODE,
		 * getPrivate("D:/workspace/TimesSSO/keys/et/pvt_et.der")); byte[]
		 * decryptedData = cipher.doFinal(bts);
		 * System.out.println("Result=="+new String(decryptedData));
		 */
		/*
		 * char[] encryptedTranspherable =
		 * Hex.encodeHex(getBytes("D:/workspace/TimesSSO/keys/toi/enc.dat"));
		 * System.out.println(encryptedTranspherable);
		 * 
		 * /*byte[] dataToEncrypt = getBytes("E:/keys/enc.dat"); Cipher cipher =
		 * Cipher.getInstance("RSA"); cipher.init(Cipher.DECRYPT_MODE,
		 * getPrivate("E:/keys/pvt.der")); byte[] decryptedData =
		 * cipher.doFinal(dataToEncrypt); System.out.println(new
		 * String(decryptedData));
		 */

		// System.out.println(encryptDataWithPublicKey("DE77FC0B-531E-4E81-BF04-EA041E45384E",
		// getPublic("D:/workspace/TimesSSO/keys/et/pub_et.der")));

		/*
		 * String privFilePath = "E:/keys/pvt.der";
		 * 
		 * BufferedInputStream bis = null; File privKeyFile = new
		 * File(privFilePath); try { bis = new BufferedInputStream(new
		 * FileInputStream(privKeyFile)); } catch(FileNotFoundException e) {
		 * throw new Exception("Could not locate keyfile at '" + privFilePath +
		 * "'", e); } byte[] privKeyBytes = new byte[(int)privKeyFile.length()];
		 * bis.read(privKeyBytes); bis.close(); KeyFactory keyFactory =
		 * KeyFactory.getInstance("RSA"); KeySpec ks = new
		 * PKCS8EncodedKeySpec(privKeyBytes); RSAPrivateKey privKey =
		 * (RSAPrivateKey) keyFactory.generatePrivate(ks);
		 * 
		 * System.out.println("private modulues => " + privKey.getModulus());
		 * System.out.println("private exponent => " +
		 * privKey.getPrivateExponent());
		 */

		/*
		 * String pubFilePath = "E:/keys/pub.pem"; File pubKeyFile = new
		 * File(pubFilePath); BufferedInputStream bis = null;
		 * 
		 * try { bis = new BufferedInputStream(new FileInputStream(pubKeyFile));
		 * } catch(FileNotFoundException e) { throw new
		 * Exception("Could not locate keyfile at '" + pubFilePath + "'", e); }
		 * 
		 * byte[] publicKeyBytes = new byte[(int)pubKeyFile.length()];
		 * bis.read(publicKeyBytes); bis.close();
		 * 
		 * KeyFactory keyFactory = KeyFactory.getInstance("RSA"); KeySpec ks =
		 * new RSAPublicKeySpec(publicKeyBytes); RSAPrivateKey publicKey =
		 * (RSAPrivateKey) keyFactory.generatePublic(ks);
		 * 
		 * System.out.println("public modulues => " + publicKey.getModulus());
		 * System.out.println("public exponent => " +
		 * publicKey.getPrivateExponent());
		 */

		/*
		 * String privateKeyFileName = "E:/keys/pvt.der"; String str =
		 * IOUtils.toString(new FileInputStream(privateKeyFileName)); byte[]
		 * privKeyByteArray = str.getBytes();
		 */
		/*
		 * Path path = Paths.get(privateKeyFileName); byte[] privKeyByteArray =
		 * Files.readAllBytes(path);
		 */

		/*
		 * PKCS8EncodedKeySpec keySpec = new
		 * PKCS8EncodedKeySpec(privKeyByteArray);
		 * 
		 * KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		 * 
		 * PrivateKey myPrivKey = keyFactory.generatePrivate(keySpec);
		 * 
		 * System.out.println("Algorithm: " + myPrivKey.getAlgorithm());
		 */

		/*
		 * String privateKeyPEM = IOUtils.toString(new
		 * FileInputStream("E:/keys/pvt.der"));
		 * 
		 * byte[] encoded = privateKeyPEM.getBytes(); KeyFactory kf =
		 * KeyFactory.getInstance("RSA"); PKCS8EncodedKeySpec keySpec = new
		 * PKCS8EncodedKeySpec(encoded); RSAPrivateKey privKey = (RSAPrivateKey)
		 * kf.generatePrivate(keySpec); System.out.println(privKey);
		 */

	}

	public static String encryptDataWithPublicKey(String txt, PublicKey pubKey)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		byte[] dataToEncrypt = txt.getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] encryptedData = cipher.doFinal(dataToEncrypt);
		char[] encryptedTranspherable = Hex.encodeHex(encryptedData);
		return new String(encryptedTranspherable);
	}

	public static byte[] getBytes(String fileName) {
		File f = new File(fileName);
		FileInputStream fis;
		byte[] keyBytes = null;
		try {
			fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			keyBytes = new byte[(int) f.length()];
			dis.readFully(keyBytes);
			dis.close();
			return keyBytes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyBytes;

	}

	public static PublicKey getPublic(String filename) throws Exception {

		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static PrivateKey getPrivate(String filename) throws Exception {

		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PrivateKey myPrivKey = keyFactory.generatePrivate(keySpec);

		return myPrivKey;
	}

	public static PublicKey getPublicFromBytes(byte[] keyBytes)
			throws Exception {

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

}
