package CodecString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class Coder{
    @Autowired
    protected MyCodec codec;

    protected String secret;
    protected String codingSecret;
    protected String decodingSecret;

    Coder(){
        this.secret = "";
        this.codingSecret = "";
        this.decodingSecret = "";
    }

    public void setSecret(String secret) throws UnsupportedEncodingException {
        this.secret = secret;
        codingSecret = codec.getCodingString(secret);
        decodingSecret = codec.getDecodingString(codingSecret);
    }

    public String getCodingSecret() {
        return codingSecret;
    }

    public String getDecodingSecret() {
        return decodingSecret;
    }

    public String getSecret() {
        return secret;
    }
}
