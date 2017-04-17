package Objects.IOStreams;

import java.io.*;

/**
 * Created by Юлия on 14.04.2017.
 */
public class IOExamples {
    public static void main(String[] args) {
        File f1 = new File("D:\\dir1\\doc1.txt");
        File f2 = new File("D:\\dir1\\doc2.txt");
        File f3 = new File("D:\\lorem.txt");

        try {
            CopyFile(f1, f2);
            SplitFile(f3, 1024);
            MergeFile(new File("D:\\lorem1.txt"));
            encryptFile(f3, "oak and acorn");
            encryptFile(new File("D:\\lorem_encrypted.txt"), "oak and acorn");
            encryptFile(new File("D:\\wp.txt"), new File("D:\\lorem.txt"));
            encryptFile(new File("D:\\wp_encrypted.txt"), new File("D:\\lorem.txt"));

            RandomBytesInputStream rio = new RandomBytesInputStream();
            byte[] buf = new byte[1024];
            rio.read(buf);
            SawBytesInputStream sio = new SawBytesInputStream();
            sio.read(buf);

            EncryptStream ein = new EncryptStream(new FileInputStream(f3));
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            int l;
            buf = new byte[1024];
            while ((l = ein.read(buf)) > 0) {
                bout.write(buf, 0, l);
            }
            ein.close();

            DecryptStream dout = new DecryptStream(new FileOutputStream("D:\\dir1\\doc3.txt"));
            dout.write(bout.toByteArray());
            dout.close();

        } catch (IOException e) {
        }
    }

    private static void CopyFile(File f1, File f2) throws IOException {
        try (InputStream in = new FileInputStream(f1);
             OutputStream out = new FileOutputStream(f2);
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            int l;
            byte[] buf = new byte[1024];
            while ((l = in.read(buf)) > 0) {
                bout.write(buf, 0, l);
            }
            out.write(bout.toByteArray());
        }
    }

    private static void SplitFile(File f, int size) throws IOException {
        try (InputStream in = new FileInputStream(f);
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            int l;
            byte[] buf = new byte[1024];
            while ((l = in.read(buf)) > 0) {
                bout.write(buf, 0, l);
            }
            int off = 0;
            int i = 1;
            String path = f.getPath().substring(0, f.getPath().length() - 4);
            String ext = f.getName().substring(f.getName().indexOf('.'));
            while (bout.size() >= off + size) {
                OutputStream out = new FileOutputStream(path + i + ext);
                if (bout.size() >= off + size)
                    out.write(bout.toByteArray(), off, size);
                else
                    out.write(bout.toByteArray(), off, bout.size() - off);
                out.close();
                off += size;
                i++;
            }
        }
    }

    private static void MergeFile(File startFile) throws IOException {
        String path = startFile.getPath().substring(0, startFile.getPath().length() - 5);
        String ext = startFile.getName().substring(startFile.getName().lastIndexOf('.'));
        int i = 1, l;

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        while (true) {
            if (new File(path + i + ext).exists()) {
                byte[] buf = new byte[1024];
                try (InputStream in = new FileInputStream(path + i + ext)) {
                    while ((l = in.read(buf)) > 0) {
                        bout.write(buf, 0, l);
                    }
                    i++;
                }
            } else
                break;

        }
        try (OutputStream out = new FileOutputStream(path + "_merged" + ext)) {
            out.write(bout.toByteArray());
        }
    }


    private static void encryptFile(File f, String password) throws IOException {
        byte[] key = password.getBytes();
        byte[] buf = new byte[1024];
        int l;
        String path = f.getPath().substring(0, f.getPath().length() - 4);
        String ext = f.getName().substring(f.getName().lastIndexOf('.'));

        try (InputStream in = new FileInputStream(f);
             ByteArrayOutputStream bout = new ByteArrayOutputStream();
             OutputStream out = new FileOutputStream(path + "_encrypted" + ext)) {
            while ((l = in.read(buf)) > 0) {
                coding(buf, key);
                bout.write(buf, 0, l);
            }
            out.write(bout.toByteArray());
        }
    }

    private static void encryptFile(File f, File f2) throws IOException {
        int bufSize = f2.length() < 1024 ? (int) f.length() : 1024;
        byte[] bufCode = new byte[bufSize];
        byte[] bufKey = new byte[bufSize];
        int l1, l2, off = bufSize;
        String path = f.getPath().substring(0, f.getPath().length() - 4);
        String ext = f.getName().substring(f.getName().lastIndexOf('.'));

        try (InputStream inCode = new FileInputStream(f);
             InputStream inKey = new BufferedInputStream(new FileInputStream(f2));
             ByteArrayOutputStream bout = new ByteArrayOutputStream();
             OutputStream out = new FileOutputStream(path + "_encrypted" + ext)) {

            inKey.mark(0);

            while (true) {
                l2 = inKey.read(bufKey, 0, off);

                if ((l1 = inCode.read(bufCode, 0, l2)) < 0)
                    break;
                if (l1 < l2)
                    l2 = l1;

                for (int i = 0; i < l2; i++) {
                    bufCode[i] ^= bufKey[i];
                }
                bout.write(bufCode, 0, l2);

                if (l2 < bufSize && l2 > 0 && l2 != off) {
                    if (inKey.markSupported()) {
                        off = bufSize - l2;
                        inKey.reset();
                    }
                } else
                    off = bufSize;

            }
            out.write(bout.toByteArray());
        }
    }

    private static void coding(byte[] code, byte[] key) {
        for (int i = 0; i < code.length; i++) {
            code[i] ^= key[i % key.length];
        }
    }


}


