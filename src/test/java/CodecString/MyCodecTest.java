package CodecString;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

public class MyCodecTest extends TestCase {
    @Autowired
    protected MyCodec myCodec;

    @Test
    public void testCodec() throws UnsupportedEncodingException {
        String secret = "MarolokString";
        //Кодируем
        String codingSecret = myCodec.getCodingString(secret);
        //Декодируем
        String decodingSecret = myCodec.getDecodingString(codingSecret);
        //Сравниваем
        Assert.assertArrayEquals("Неправильно кодировал/декодировал.",secret.getBytes(),decodingSecret.getBytes());
    }

}