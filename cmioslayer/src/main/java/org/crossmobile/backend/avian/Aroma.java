package org.crossmobile.backend.avian;

public class Aroma {
    public static void main(String[] args) {
        SDLWindow window = new SDLWindow("Aroma");
        window.setSize(600, 400);
        // SDLEvent event = new SDLEvent();
        SkCanvas skia = new SkCanvas(window);
        SkFont font = new SkFont("Ubuntu", 50);

        skia.clear(0xFFFFFFFF);

        skia.setLineWidth(10);
        skia.setLineJoin(SkCanvas.ROUND_JOIN);
        skia.setDrawColorWithColor(0xFFFF0000);
        skia.drawRect(50, 50, 100, 120);

        skia.setFillColorWithColor(0xFF0000FF);
        skia.fillRect(50, 50, 100, 120);

        skia.setFont(font);
        skia.setDrawColorWithColor(0xFF00FF00);
        skia.showTextAtPoint(200, 50, "Hi Skia!");

//        SkBitmap bitmap = new SkBitmap(new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        });
//        skia.drawBitmap(bitmap, 350, 50, 200, 200);

        while (true) {
            AvianGraphicsBridge.pollSDLEvents();
            window.update();
        }
    }
}
