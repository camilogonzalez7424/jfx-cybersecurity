package model;

import javafx.scene.control.Alert;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


public class FileEncryptorDecryptor {

    private static final String ALGORITHM = "AES";
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;


    public void encryptFile(String inputFile, String outputFile, String password)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        byte[] salt = generateSalt();

        SecretKey secretKey = generateSecretKey(password, salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
        byte[] encryptedContent = cipher.doFinal(fileContent);

        byte[] fileHash = calculateHash(fileContent);

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile))) {
            outputStream.write(salt);
            outputStream.write(fileHash);
            outputStream.write(encryptedContent);
        }
    }

    public void decryptFile(String inputFile, String outputFile, String password) {

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile))) {
            byte[] salt = new byte[16];
            inputStream.readFully(salt);

            byte[] fileHash = new byte[32];
            inputStream.readFully(fileHash);

            byte[] encryptedContent = new byte[inputStream.available()];
            inputStream.readFully(encryptedContent);

            SecretKey secretKey = generateSecretKey(password, salt);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedContent = cipher.doFinal(encryptedContent);

            byte[] decryptedHash = calculateHash(decryptedContent);

            if (!MessageDigest.isEqual(fileHash, decryptedHash)) {
                throw new IllegalStateException("El archivo ha sido modificado y no se puede descifrar correctamente.");
            }

            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                outputStream.write(decryptedContent);
                System.out.println("Archivo descifrado correctamente.");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Diálogo de información...");
                alert.setHeaderText("Los hash SHA-256 coinciden");
                alert.setContentText("Archivo descifrado correctamente. :)");
                alert.showAndWait();

            }
        } catch (BadPaddingException e) {
            System.out.println("Falta la contraseña y/o es incorrecta");

        }catch (IOException e) {
            System.out.println("IOException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e) {
            System.out.println("InvalidKeySpecException");

        } catch (NoSuchPaddingException e) {
            System.out.println("NoSuchPaddingException");

        } catch (InvalidKeyException e) {
            System.out.println("InvalidKeyException");

        } catch (IllegalBlockSizeException e) {
            System.out.println("IllegalBlockSizeException");

        }
    }

    private static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static SecretKey generateSecretKey(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    private static byte[] calculateHash(byte[] content) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        return digest.digest(content);
    }
}
