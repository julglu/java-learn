package Objects.IOStreams;

import java.util.Random;

/**
 * Created by Юлия on 17.04.2017.
 */
public class SawBytesInputStream {
    byte val = 0;

    public void read(byte[] buf) {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = val;
            if (val == Byte.MAX_VALUE)
                val = 0;
            else
                val++;
        }
    }
}
