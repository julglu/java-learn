package Objects.IOStreams;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Юлия on 17.04.2017.
 */
public class DecryptStream extends FilterOutputStream {
    OutputStream out;
    public DecryptStream(OutputStream out) {
        super(out);
        this.out=out;
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b,0,b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }

        SawBytesInputStream sin=new SawBytesInputStream();
        byte[] key=new byte[len];
        sin.read(key);

        for (int i = 0 ; i < len ; i++) {
            write(b[off + i]^key[off + i]);
        }
    }
}
