package org.crossmobile.backend.avian;

import java.io.IOException;
import java.io.InputStream;

public class Aroma {

    static void fireMouseEvent(SDLMouseEvent event) {
        if (event.type == SDLMouseEvent.MOUSEMOTION)
            System.out.println("Mouse motion: " + event.getX() + "," + event.getY());
        if (event.type == SDLMouseEvent.MOUSEBUTTON)
            System.out.println("Mouse button down: " + event.getX() + "," + event.getY());
    }

    static void fireWindowEvent(SDLWindowEvent event) {
        if (event.type == SDLWindowEvent.WINDOWEVENT) {
            if (event.mask == SDLWindowEvent.CLOSE)
                System.out.println("Window close");
        }
    }

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

        SDLEvent event;
        while (true) {
            while ((event = (SDLEvent) AvianGraphicsBridge.pollSDLEvents()) != null) {
                if (event instanceof SDLMouseEvent)
                    fireMouseEvent((SDLMouseEvent) event);
                if (event instanceof SDLWindowEvent)
                    fireWindowEvent((SDLWindowEvent) event);
            }
            window.update();
        }
    }
}
