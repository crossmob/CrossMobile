package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.bind.graphics.NativePath;

public class SkPath extends NativeElement implements NativePath {

    public SkPath() {
        super(init());
    }

    @Override
    public void addPath(NativePath path, CGAffineTransform transform) {
    }

    @Override
    public void moveTo(double x, double y) {
        moveTo(this.peer, x, y);
    }

    @Override
    public void lineTo(double x, double y) {
    }

    @Override
    public void quadTo(double x1, double y1, double x2, double y2) {
        quadTo(this.peer, x1, y1, x2, y2);
    }

    @Override
    public void cubicTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {

    }

    @Override
    public void arcTo(double x, double y, double xRadius, double yRadius, double startAngle, double extend) {
    }

    @Override
    public void addEllipse(double x, double y, double width, double height) {
    }

    @Override
    public void close() {
        close(this.peer);
    }

    // TODO: why this is here?
    public void reset() {
        reset(this.peer);
    }

    private static native long init();

    @Override
    protected native void destroy(long peer);

    private static native void moveTo(long peer, double x, double y);

    private static native void quadTo(long peer, double x1, double y1, double x2, double y2);

    private static native void close(long peer);

    private static native void reset(long peer);
}