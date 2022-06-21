package blue.golem.charsets.xrosloader;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.HashMap;
import java.util.Map;

public class XrosLoaderCharsetEncoder extends CharsetEncoder {

    private static Map<Character, Integer> charLookup = new HashMap<>();

    static {
        for (int i = 0; i < XrosLoaderCharset.CHARMAP.length; ++i) {
            char ch = XrosLoaderCharset.CHARMAP[i];
            if (ch != 0) {
                charLookup.putIfAbsent(ch, i);
            }
        }
    }

    public XrosLoaderCharsetEncoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    @Override
    protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
        try {
            while (in.hasRemaining()) {
                char ch = in.get();
                Integer index = charLookup.get(ch);
                if (index == null) {
                    // return CoderResult.unmappableForLength(1);

                    // Just put back out as is
                    out.put((byte) ch);
                } else {
                    out.put(index.byteValue());
                }
            }
        } catch (BufferOverflowException ex) {
            return CoderResult.OVERFLOW;
        }

        return CoderResult.UNDERFLOW;
    }

}
