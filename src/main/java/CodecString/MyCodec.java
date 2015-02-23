package CodecString;

/*
 * gradle_1.CodecString
 * 
 * Created by Marolok - Bocharov Pavel
 * 
 * Version - 1.0
 *
 * Date - 23.02.2015
 * 
 * License from MarCOM
 */

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class MyCodec {
    protected Base64 base;

    MyCodec(){
        this.base = new Base64();
    }

    /**
     * Кодирует сообщение(secret).
     * @param secret
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public String getCodingString(String secret) throws UnsupportedEncodingException {
        byte[] secretByte = secret.getBytes("UTF8");
        byte[] secretEncode = base.encode(secretByte);
        return new String(secretEncode,"UTF8");
    }

    /**
     * Декодирует сообщение(secret).
     * @param secret
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getDecodingString(String secret) throws UnsupportedEncodingException {
        byte[] secretByte = secret.getBytes("UTF8");
        byte[] secretDecode = base.decode(secretByte);
        return new String(secretDecode,"UTF8");
    }
}
