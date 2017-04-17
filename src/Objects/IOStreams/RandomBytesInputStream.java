package Objects.IOStreams;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/*
 * Created by Юлия on 17.04.2017.
 */
public class RandomBytesInputStream /*extends InputStream*/{
    //@Override
    public void read(byte[] buf) {
        Random rnd=new Random();
        rnd.nextBytes(buf);
        //return 0;
    }
}
