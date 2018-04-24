package com.jjkj.administrator.storecontrollersystem;

import org.junit.Test;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final char[] UrlEncoder = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F'};
    private static final char[] UrlDncoder = {
            ';',
            '&'
    };

    @Test
    public void addition_isCorrect() throws IOException {
        String code =
                "7L0HYBxJliUmL23Ke39K9UrX4HShCIBgEyTYkEAQ7MGIzeaS7B1pRyMpqyqBymVWZV1mFkDM7Z28995777333nvvvfe6O51OJ/ff/z9cZmQBbPbOStrJniGAqsgfP358Hz8ifo1f89f4NX6N/5se/MTzG/1a9M+L19dNmy/GT7M2G6U/mddNUS0/2x/v4L9RerIu23Wdf7bM122dlaP05XpSFtPfK79+U73Nl59NHjzI7k/vf7r78N5+vnPw8NcF8N/Sg8n/vM7bX5s+/2319/GrfFG1xfJCu/ux33tRvp7O80X2G9JvT4vz88/rbPFr/5q/5m+igLQd8P0xAPr1fh3659/57R//Hu8WZXqpOH+0O975KM2X02pGoD/7aN2eb+9++tHvcfQbJ4/fNY8a7iAtZp999CK/Ukw+SgnCsvnsI/3l0Tv6fd62q0d3715dXY2v7o2r+uLu3s7O7t3f+4vngqRpu2hmBIU6qpcKvdleFNO6aqrzdntaLR5Ru21p9RFhkabAIy/zRb5s02W2yENUpOWjs0Y/+eyjtl7n9vPn1TQr6RUBJcCok1WZv3tzvcr1U/18XhXTPF0Uyy+n03VNgyLSLLJ35q/1clKtl7N8ZoCZF0PsnqyLZpk3zRfZ0m843Lf7tsl/0ZrmovvVDb2cPf0obQngZx8BRFvTRNrxt1l9kbcv6JVmlU1BiM747t6iL7z+s9zF6/zdz3IP363qt8Qj/kAIeP6mWDhu+UY6elLU7fyH0tPJummrRV7/rDPA6fKiLJr5D4EPXmRtcZm/LAnAz3JPL/OKJPFnuZMvsrousgu/m0lVlTmphm+0n7OnJ1k9+1kezPM8q5cM9We1m9erfFpkZdFe/yx3dDxlbUyMnf9sk+5NXu7+7Hex97PcxfFsVpPJ+Vnu5Wm+yuoWH/wsdwQj/LPcxes2a9c/2wQjxzCr3/4sd/LVytiwps0WK1+hZU3+6f6TYpnV199sn6/n6/bLtc8GPyvK82VW0x8/TIfKGO7jyeXPck+9sQHeN9jn47sAEnNb+Zu4u8tfKZ72Y2nPLrh+FoXQeVf65zji6Nf7dSnA+Qt/ncczioUu6kfyI1t8ncBD3xEQN71jOtq+3P3o6LELTo4ee3RPFSuEUt7Hu5b0dXX1ZT3La5A5ePPs6dGDB/d39h/fDT98jGk62n18l38+Jg/66D//y//Wx3fxy2Pj7R7t7ew+2N55uL2z+2Z3/9G9vUc7e+O9g092Dh7t7Dy+a5s9dr7k0Xe+eLq39+k9ngHv48fGmTk6z8omf3zX/v24oxyOjvmZ78+/PP3s8d3ut49Vrg0c86fFgcTi6L/+s//0/+ov/wf/87/hj/7P/7g/8z//w//W/+zv+Xvwv7/7T/qv/o4//D//u/4QhxjaBpShv/wpuNvhhqNfB7FwJ0ZGZPzr/f5fZD9d1fSjWOIHgSxnP/b7v8ovCzShFr/Gb0APwmk8/7c+v+H/EwAA//8=";
    }


    public String EscapeStringInternal(String data, boolean b) {
        byte[] bytes = data.getBytes();
        StringBuilder builder = new StringBuilder(bytes.length);
        for (byte aByte : bytes) {
            byte num = aByte;
            char ch = (char) aByte;
            if (num > 127 || num < 32 || (int) ch == 37 || b && isSafe(ch)) {
                HexEscape8(builder, ch);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    private boolean isSafe(char ch) {
        if (ch >= 97 && ch <= 122 || ch >= 65 && ch <= 90 || ch >= 48 && ch <= 57) {
            return true;
        }
        switch (ch) {
            case '!':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '-':
            case '.':
            case '_':
                return true;
            default:
                return false;
        }
    }

    private void HexEscape8(StringBuilder sb, char ch) {
        sb.append('%');
        sb.append(UrlEncoder[ch >> 4 & 15]);
        sb.append(UrlEncoder[ch & 15]);
    }
}