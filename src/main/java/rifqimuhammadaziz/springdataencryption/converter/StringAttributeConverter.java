package rifqimuhammadaziz.springdataencryption.converter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class StringAttributeConverter implements AttributeConverter<String, String> {

    private static final String AES = "AES";
    private static final byte[] encryptionKey = "my-encryptionKey".getBytes();

    private final Cipher encryptCipher;
    private final Cipher decryptCipher;

    public StringAttributeConverter() throws Exception {
        Key key = new SecretKeySpec(encryptionKey, AES);
        encryptCipher = Cipher.getInstance(AES);
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance(AES);
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    // ENCRYPT
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            return Base64.getEncoder().encodeToString(encryptCipher.doFinal(attribute.getBytes()));
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    // DECRYPT
    @Override
    public String convertToEntityAttribute(String attribute) {
        try {
            return new String(decryptCipher.doFinal(Base64.getDecoder().decode(attribute)));
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
