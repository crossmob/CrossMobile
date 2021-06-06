package org.crossmobile.backend.aroma;

public class SkPaint  extends NativeElement {

  static final byte FILL = 0;
  static final byte STROKE = 1;
  static final byte FILL_AND_STROKE = 2;

  SkPaint() {
    super(initPaint());
  }

  @Override
  protected void destroy(long peer) {
    destroyPaint(peer);
  }

  public void setStyle(byte style) {
    setStyle(this.peer, style);
  }

  public void setStrokeWidth(double width) {
    setStrokeWidth(this.peer, width);
  }

  public void setColor(int color) {
    setColor(this.peer, color);
  }

  public void setAntiAlias(boolean shouldAntiAlias) {
    setAntialias(this.peer, shouldAntiAlias);
  }

  public void setAlpha(double alpha) {
    setAlpha(this.peer, alpha);
  }

  public void setStrokeJoin(byte strokeJoim) {
    setStrokeJoin(this.peer, strokeJoim);
  }

  public void setStrokeCap(byte strokeCap) {
    setStrokeCap(this.peer, strokeCap);
  }

  private static native long initPaint();

  private static native void destroyPaint(long paint);

  private static native void setStyle(long paint, byte style);

  private static native void setStrokeWidth(long paint, double width);

  private static native void setColor(long paint, int color);

  private static native void setAntialias(long paint, boolean shouldAntiAlias);

  private static native void setAlpha(long paint, double alpha);

  private static native void setStrokeJoin(long paint, byte strokeJoin);

  private static native void setStrokeCap(long paint, byte strokeCap);
}