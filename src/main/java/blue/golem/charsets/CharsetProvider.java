package blue.golem.charsets;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import blue.golem.charsets.xrosloader.FFXCharset;

public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {

    public static final String FFX_CHARSET_NAME = "final-fantasy-x";

    Map<String, Charset> charsetMap = new HashMap<>();

    public CharsetProvider() {
        super();
        // Add charsets here
        charsetMap.put(FFX_CHARSET_NAME, new FFXCharset(FFX_CHARSET_NAME, null));
    }

    @Override
    public Iterator<Charset> charsets() {
        return charsetMap.values().iterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {
        return charsetMap.get(charsetName);
    }

}
