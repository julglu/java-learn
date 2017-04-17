package Objects.IOStreams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Created by Юлия on 17.04.2017.
 */
public class EncryptStream extends FilterInputStream {
    InputStream in;

    public EncryptStream(InputStream in) {
        super(in);
        this.in = in;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }

        SawBytesInputStream sin=new SawBytesInputStream();
        byte[] key=new byte[len];
        sin.read(key);
        b[off] = (byte)(((byte)c)^key[off]);

        int i = 1;
        try {
            for (; i < len ; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)(((byte)c)^key[off+i]);
            }
        } catch (IOException ee) {
        }
        return i;
    }
}
