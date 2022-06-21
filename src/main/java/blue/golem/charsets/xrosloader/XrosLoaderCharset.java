package blue.golem.charsets.xrosloader;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class XrosLoaderCharset extends Charset {

    // Note: Ideographic space has been swapped out for regular space to make
    // reading strings easier
    static final char[] CHARMAP = {
            '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0',
            'が', 'ぎ', 'ぐ', 'げ', 'ご', 'ざ', 'じ', 'ず', 'ぜ', 'ぞ', 'だ', 'ぢ', 'づ', 'で', 'ど', '\0',
            ' ', '！', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '．', '／',
            '０', '１', '２', '３', '４', '５', '６', '７', '８', '９', '\0', '\0', '\0', '\0', '\0', '？',
            '\0', 'Ａ', 'Ｂ', 'Ｃ', 'Ｄ', 'Ｅ', 'Ｆ', 'Ｇ', 'Ｈ', 'Ｉ', 'Ｊ', 'Ｋ', 'Ｌ', 'Ｍ', 'Ｎ', 'Ｏ',
            'Ｐ', 'Ｑ', 'Ｒ', 'Ｓ', 'Ｔ', 'Ｕ', 'Ｖ', 'Ｗ', 'Ｘ', 'Ｙ', 'Ｚ', '\0', '\0', '\0', '\0', '\0',
            'ば', 'び', 'ぶ', 'べ', 'ぼ', 'ぱ', 'ぴ', 'ぷ', 'ぺ', 'ぽ', 'ヴ', 'ガ', 'ギ', 'グ', 'ゲ', 'ゴ',
            'ザ', 'ジ', 'ズ', 'ゼ', 'ゾ', 'ダ', 'ヂ', 'ヅ', 'デ', 'ド', 'バ', 'ビ', 'ブ', 'ベ', 'ボ', '\0',
            'パ', 'ピ', 'プ', 'ペ', 'ポ', '\0', 'を', 'ぁ', 'ぃ', 'ぅ', 'ぇ', 'ぉ', 'ゃ', 'ゅ', 'ょ', 'っ',
            '\0', 'あ', 'い', 'う', 'え', 'お', 'か', 'き', 'く', 'け', 'こ', 'さ', 'し', 'す', 'せ', 'そ',
            '\0', '\0', '\0', '\0', '\0', '\0', 'ヲ', 'ァ', 'ィ', 'ゥ', 'ェ', 'ォ', 'ャ', 'ュ', 'ョ', 'ッ',
            'ー', 'ア', 'イ', 'ウ', 'エ', 'オ', 'カ', 'キ', 'ク', 'ケ', 'コ', 'サ', 'シ', 'ス', 'セ', 'ソ',
            'タ', 'チ', 'ツ', 'テ', 'ト', 'ナ', 'ニ', 'ヌ', 'ネ', 'ノ', 'ハ', 'ヒ', 'フ', 'ヘ', 'ホ', 'マ',
            'ミ', 'ム', 'メ', 'モ', 'ヤ', 'ユ', 'ヨ', 'ラ', 'リ', 'ル', 'レ', 'ロ', 'ワ', 'ン', '\0', '\0',
            'た', 'ち', 'つ', 'て', 'と', 'な', 'に', 'ぬ', 'ね', 'の', 'は', 'ひ', 'ふ', 'へ', 'ほ', 'ま',
            'み', 'む', 'め', 'も', 'や', 'ゆ', 'よ', 'ら', 'り', 'る', 'れ', 'ろ', 'わ', 'ん', '\0', '█',
    };

    public XrosLoaderCharset(String canonicalName, String[] aliases) {
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
        return new XrosLoaderCharsetDecoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return null;
    }

}
