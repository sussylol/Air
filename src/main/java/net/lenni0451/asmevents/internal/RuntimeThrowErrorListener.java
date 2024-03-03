package net.lenni0451.asmevents.internal;

import net.lenni0451.asmevents.IErrorListener;

public class RuntimeThrowErrorListener implements IErrorListener {

    @Override
    public void onException(Throwable t) {
        System.err.println(t.getMessage());
    }

}
