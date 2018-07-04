package by.it.shumilov.jd01_02;


//import org.apache.commons.codec.Decoder;
//import org.apache.commons.codec.Encoder;
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_256;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, DigestException {

        String sha256 = MessageDigestAlgorithms.SHA_256;
        String test = DigestUtils.sha256Hex("test");
        System.out.println(test);

/*
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        final Base64 base64 = new Base64();
        System.out.println(new String(base64.encode("Testtesre".getBytes())));
        md.update("".getBytes());

        final byte[] enbytes = base64.encode(md.digest());
        //MessageDigest tc1 = (MessageDigest) md.clone();
        //byte[] toChapter1Digest = tc1.digest();

        System.out.println(new String(enbytes));

*/
    }
}
