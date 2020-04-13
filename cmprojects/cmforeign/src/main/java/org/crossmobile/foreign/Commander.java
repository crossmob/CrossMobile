// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.foreign;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;

public class Commander {

    private static final int INVALID_EXIT_VALUE = Integer.MIN_VALUE;
    private static final Charset ENCODING = StandardCharsets.UTF_8;
    private static final boolean AS_WINDOWS = System.getProperty("os.name", "unknown").toLowerCase().startsWith("windows");

    private final List<String> command = new ArrayList<>();

    private final Map<String, String> envp = new HashMap<>();
    private Consumer<String> outS, errS;
    private Consumer<Character> outC, errC;
    private Writer outW, errW;
    private Runnable start;
    private Consumer<Integer> finish;
    private File currentDir;
    private Process proc;
    private BufferedWriter bufferin = null;
    private OutputProxy procout = null;
    private OutputProxy procerr = null;
    private int exit_value = INVALID_EXIT_VALUE;
    private boolean output_is_terminated = true;
    private boolean debug = false;
    private Thread waitThread;
    private String pid;

    public Commander(List<String> command) {
        for (String candidate : command)
            if (candidate != null)
                this.command.add(candidate);
    }

    public Commander(String... command) {
        this(Arrays.asList(command));
    }

    public void setOutListener(Consumer<String> out) {
        this.outS = out;
        this.outC = null;
        this.outW = null;
    }

    public void setCharOutListener(Consumer<Character> out) {
        this.outC = out;
        this.outS = null;
        this.outW = null;
    }

    public void setOutWriter(Writer out) {
        this.outW = out;
        this.outS = null;
        this.outC = null;
    }

    public void setErrListener(Consumer<String> err) {
        this.errS = err;
        this.errC = null;
        this.errW = null;
    }

    public void setCharErrListener(Consumer<Character> err) {
        this.errC = err;
        this.errS = null;
        this.errW = null;
    }

    public void setErrWriter(Writer err) {
        this.errW = err;
        this.errS = null;
        this.errC = null;
    }

    public void setStartListener(Runnable start) {
        this.start = start;
    }

    public void setEndListener(Consumer<Integer> finish) {
        this.finish = finish;
    }

    public void setCurrentDir(File cdir) {
        if (proc != null)
            throw new RuntimeException("Command already running");
        this.currentDir = cdir;
    }

    public void setPID(String pid) {
        this.pid = pid;
    }

    public static boolean needsPID() {
        return AS_WINDOWS;
    }

    public void appendEnvironmentalParameters(Map<String, String> params) {
        if (proc != null)
            throw new RuntimeException("Command already running");
        this.envp.putAll(params);
    }

    public void appendEnvironmentalParameter(String name, String value) {
        if (proc != null)
            throw new RuntimeException("Command already running");
        this.envp.put(name, value);
    }

    public synchronized void exec() {
        if (proc != null)
            throw new RuntimeException("Command already running");
        exit_value = INVALID_EXIT_VALUE;
        proc = null;
        waitThread = null;
        try {
            if (debug)
                Log.info("( " + environmentToString() + pathToString() + commandToString() + ")");
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(currentDir);
            pb.environment().putAll(envp);
            if (start != null)
                start.run();
            proc = pb.start();
            bufferin = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream(), ENCODING));
            procout = new OutputProxy(true);
            procerr = new OutputProxy(false);
            output_is_terminated = false;
            procout.worker.start();
            procerr.worker.start();
        } catch (IOException ex) {
            sendLine("Process can not start: " + ex.getMessage(), errS, errC);
            if (finish != null)
                finish.accept(INVALID_EXIT_VALUE);
        }
    }

    public boolean isActive() {
        return proc != null;
    }

    public void sendLine(String line) {
        if (bufferin == null) {
            sendLine("Request to send data inappropriate: process not active", errS, errC);
            return;
        }
        if (line == null)
            return;
        try {
            bufferin.write(line);
            bufferin.newLine();
            bufferin.flush();
        } catch (IOException ex) {
        }
    }

    public void terminateInput() {
        if (bufferin != null)
            try {
                bufferin.close();
            } catch (IOException ex) {
            }
        bufferin = null;
    }

    private synchronized void doWaitFor() {
        if (proc == null)
            return;
        try {
            proc.waitFor();
        } catch (InterruptedException ex) {
        }
        try {
            exit_value = proc.exitValue();
        } catch (Exception e) {
            exit_value = 0;
        }
        proc = null;
    }

    public void waitFor() {
        if (proc == null || waitThread != null)
            return;

        /*
         * Use this thread trick, to suspend this thread until the streams have
         * finished executing. Thus, first is "finish" CallBack being informed
         * and then waitFor exits. A new thread is required since we want to
         * catch InterruptedExceptions only for the waitThread, not the current
         * thread.
         */
        waitThread = new Thread() {

            @SuppressWarnings("SleepWhileInLoop")
            @Override
            public void run() {
                doWaitFor();    // will also nullify `proc`
                try {
                    while (!output_is_terminated && !waitThread.isInterrupted())
                        Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        };
        waitThread.start();
        try {
            waitThread.join();
        } catch (InterruptedException ex) {
        }
        waitThread = null;
    }

    @SuppressWarnings("UseSpecificCatch")
    private void doKill() {
        try {
            if (proc != null)
                if (AS_WINDOWS && pid != null)
                    new ProcessBuilder("taskkill", "/PID", pid, "/T", "/F").start().waitFor();
                else
                    proc.destroy();
            pid = null;
        } catch (Exception e) {
        }
    }

    public void kill() {
        doKill();
        waitFor();
    }

    public int exitValue() {
        if (exit_value == INVALID_EXIT_VALUE)
            throw new IllegalThreadStateException("Unable to retrieve exit value");
        return exit_value;
    }

    private synchronized void doInterrupt() {
        if (waitThread != null)
            waitThread.interrupt();
    }

    private synchronized void outputTerminated(OutputProxy proxy) {
        /*
         * Do not care if it is already nulled
         */
        if (procout == null && procerr == null)
            return;

        if (proxy == procout)
            procout = null;
        if (proxy == procerr)
            procerr = null;
        if (procerr != null || procout != null)
            return;

        /*
         * Kill after both streams have ended
         */
        output_is_terminated = true;
        terminateInput();
        doKill();
        doWaitFor();
        if (finish != null)
            finish.accept(exit_value);
        doInterrupt();
    }

    @Override
    public String toString() {
        return commandToString();
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private String commandToString() {
        StringBuilder out = new StringBuilder();
        for (String part : command)
            if (part != null)
                out.append(escapeIfRequired(part)).append(" ");
        return out.toString();
    }

    private String environmentToString() {
        StringBuilder out = new StringBuilder();
        if (envp != null && !envp.isEmpty())
            for (String name : envp.keySet())
                out.append(name).append("=").append(escapeIfRequired(envp.get(name))).append("; ");
        return out.toString();
    }

    private String pathToString() {
        if (currentDir != null)
            return "cd " + escapeIfRequired(currentDir.getAbsolutePath()) + "; ";
        return "";
    }

    private String escapeIfRequired(String input) {
        if (input.contains(" "))
            return "'" + input + "'";
        else
            return input;
    }

    private class OutputProxy {

        private final BufferedReader in;
        private final Thread worker;
        private final Consumer<String> listenS;
        private final Consumer<Character> listenC;
        private final Writer listenW;

        private OutputProxy(boolean asInput) {
            if (asInput) {
                in = new BufferedReader(new InputStreamReader(proc.getInputStream(), ENCODING));
                listenS = outS;
                listenC = outC;
                listenW = outW;
            } else {
                in = new BufferedReader(new InputStreamReader(proc.getErrorStream(), ENCODING));
                listenS = errS;
                listenC = errC;
                listenW = errW;
            }
            worker = new Thread() {
                @Override
                public void run() {
                    String line;
                    int c;
                    try {
                        if (listenC != null)
                            while ((c = in.read()) >= 0 && !isInterrupted())
                                listenC.accept((char) c);
                        else if (listenW != null)
                            while ((c = in.read()) >= 0 && !isInterrupted())
                                listenW.write(c);
                        else // without `else if', to make sure that the output is consumed
                            while ((line = in.readLine()) != null && !isInterrupted())
                                if (listenS != null)
                                    listenS.accept(line);
                    } catch (IOException ignored) {
                    } finally {
                        try {
                            in.close();
                        } catch (IOException ignored) {
                        }
                    }
                    outputTerminated(OutputProxy.this);
                }
            };
        }
    }

    private static void sendLine(String what, Consumer<String> stringStream, Consumer<Character> charStream) {
        if (stringStream != null)
            stringStream.accept(what);
        else if (charStream != null)
            for (char c : what.toCharArray())
                charStream.accept(c);
    }
}
