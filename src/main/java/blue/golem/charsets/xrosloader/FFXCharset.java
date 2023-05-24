package blue.golem.charsets.xrosloader;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Scanner;

public class FFXCharset extends Charset {

    // Note: Ideographic space has been swapped out for regular space to make
    // reading strings easier
    static final HashMap<Integer, Character> INT_TO_CHAR_MAP = new HashMap<>();
    static final HashMap<Character, Integer> CHAR_TO_INT_MAP = new HashMap<>();

    static {
        InputStream is = FFXCharset.class.getResourceAsStream("/ffx_en.tbl");
        try (Scanner scanner = new Scanner(is)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int position = Integer.parseInt(line.substring(0, 2), 16);
                char character = line.charAt(3);
                INT_TO_CHAR_MAP.put(position, character);
                CHAR_TO_INT_MAP.put(character, position);
            }
        }
    }

    public FFXCharset(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    @Override
    public boolean contains(Charset cs) {
        // This charset doesn't really contain any other charset, so only return true
        // for itself
        return name().equals(cs.name());
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new FFXCharsetDecoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new FFXCharsetEncoder(this);
    }

}
