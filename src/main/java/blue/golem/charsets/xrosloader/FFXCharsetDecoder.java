package blue.golem.charsets.xrosloader;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class FFXCharsetDecoder extends CharsetDecoder {

    public FFXCharsetDecoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        try {
            while (in.hasRemaining()) {
                int b = in.get() & 0xff;
                char ch = FFXCharset.INT_TO_CHAR_MAP.getOrDefault(b, (char) b);
                out.put(ch);
            }
        } catch (BufferOverflowException ex) {
            return CoderResult.OVERFLOW;
        }

        return CoderResult.UNDERFLOW;
    }

}
