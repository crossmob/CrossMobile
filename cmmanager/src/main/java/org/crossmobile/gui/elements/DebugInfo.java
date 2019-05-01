package org.crossmobile.gui.elements;

public class DebugInfo {
    public final String output;
    public final String error;
    public final String appId;

    public DebugInfo(String output, String error, String appId) {
        this.output = output;
        this.error = error;
        this.appId = appId;
    }

    public static boolean streamsHaveTraces(String... texts) {
        for (String text : texts)
            for (String line : text.split("[\n|\r]"))
                if (line.trim().startsWith("at crossmobile.ios."))
                    return true;
        return false;
    }

    public interface Provider {
        DebugInfo getDebugInfo();
    }

    public interface Consumer {
        void updateTo(String outStream, String errorStream);
    }
}
