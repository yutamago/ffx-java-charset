package blue.golem.charsets;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class CharsetTest
{
    CharsetProvider charsetProvider;
    Charset ffxCharset;

    @Before
    public void before() {
        this.charsetProvider = new CharsetProvider();
        this.ffxCharset = this.charsetProvider.charsetMap.get(CharsetProvider.FFX_CHARSET_NAME);
    }


    @Test
    public void shouldEncode()
    {
        String originalString = "Submerged Ruins";
        ByteBuffer encodedString = this.ffxCharset.encode(originalString);

        assertEquals((byte) 0x62, encodedString.get()); // S
        assertEquals((byte) 0x84, encodedString.get()); // u
        assertEquals((byte) 0x71, encodedString.get()); // b
        assertEquals((byte) 0x7c, encodedString.get()); // m
        assertEquals((byte) 0x74, encodedString.get()); // e
        assertEquals((byte) 0x81, encodedString.get()); // r
        assertEquals((byte) 0x76, encodedString.get()); // g
        assertEquals((byte) 0x74, encodedString.get()); // e
        assertEquals((byte) 0x73, encodedString.get()); // d
        assertEquals((byte) 0x3a, encodedString.get()); // " "
        assertEquals((byte) 0x61, encodedString.get()); // R
        assertEquals((byte) 0x84, encodedString.get()); // u
        assertEquals((byte) 0x78, encodedString.get()); // i
        assertEquals((byte) 0x7d, encodedString.get()); // n
        assertEquals((byte) 0x82, encodedString.get()); // s
    }

    @Test
    public void shouldDecode()
    {
        ByteBuffer originalBytes = ByteBuffer.wrap(new byte[] {
                (byte) 0x62,
                (byte) 0x84,
                (byte) 0x71,
                (byte) 0x7c,
                (byte) 0x74,
                (byte) 0x81,
                (byte) 0x76,
                (byte) 0x74,
                (byte) 0x73,
                (byte) 0x3a,
                (byte) 0x61,
                (byte) 0x84,
                (byte) 0x78,
                (byte) 0x7d,
                (byte) 0x82,
        });

        String decodedString = this.ffxCharset.decode(originalBytes).toString();

        assertEquals("Submerged Ruins", decodedString);
    }
}
