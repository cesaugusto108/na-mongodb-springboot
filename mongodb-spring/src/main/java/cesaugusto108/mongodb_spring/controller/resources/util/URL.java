package cesaugusto108.mongodb_spring.controller.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParameter(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
