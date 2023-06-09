package org.example.utilities;

import java.io.IOException;
import java.io.OutputStream;

public class CombinedOutputStream extends OutputStream {
    private final OutputStream outputStream1;
    private final OutputStream outputStream2;

    public CombinedOutputStream(OutputStream outputStream1, OutputStream outputStream2) {
        this.outputStream1 = outputStream1;
        this.outputStream2 = outputStream2;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream1.write(b);
        outputStream2.write(b);
    }
}

