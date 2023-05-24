package blue.golem.charsets.xrosloader;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public class FFXCharsetEncoder extends CharsetEncoder {
    public FFXCharsetEncoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    @Override
    protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
        try {
            while (in.hasRemaining()) {
                char ch = in.get();
                int index = FFXCharset.CHAR_TO_INT_MAP.getOrDefault(ch, -1);

                if(index == -1) {
                    out.put((byte) ch);
                } else {
                    out.put((byte) index);
                }

            }
        } catch (BufferOverflowException ex) {
            return CoderResult.OVERFLOW;
        }

        return CoderResult.UNDERFLOW;
    }

}
