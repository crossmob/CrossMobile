/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.backend.android;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import crossmobile.ios.coregraphics.$coregraphics;
import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.bind.graphics.AbstractImageBridge;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.robovm.objc.block.VoidBlock1;

import java.io.*;

import static android.app.Activity.RESULT_OK;
import static org.crossmobile.bind.graphics.ImageBridgeConstants.*;
import static org.crossmobile.bind.system.SystemUtilities.closeR;
import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(depends = @CMLibDepends(groupId = "com.android.support",
        pluginName = "support-core-utils",
        version = "26.1.0", target = ANDROID, isCMPlugin = false))
public class AndroidImageBridge extends AbstractImageBridge {

    private static final int IMAGE_STREAM_BUFFER_SIZE = 16384;

    @Override
    @SuppressWarnings({"UseSpecificCatch"})
    public NativeBitmap retrieve(String name) {
        String lowCase = name.toLowerCase();
        Bitmap bitmap = null;
        InputStream stream = null;
        try {
            if (lowCase.startsWith(SYSNAME)) {
                name = name.substring(SYSSIZE);
                int id = AndroidFileBridge.getResourceID("drawable", name);
                if (id != 0)
                    bitmap = BitmapFactory.decodeStream(stream = MainActivity.current.getResources().openRawResource(id));
            } else if (lowCase.startsWith(APPNAME)) {
                name = name.substring(APPSIZE);
                stream = MainActivity.current.getAssets().open(name);
                if (stream != null)
                    bitmap = BitmapFactory.decodeStream(stream);
            } else if (Native.file().fileExists(name)) {
                bitmap = BitmapFactory.decodeFile(name);
                int degrees = findOrientationDegreesAndCloseStream(name);
                if (degrees != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(degrees);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        } catch (IOException ex) {
            bitmap = null;
        } finally {
            closeR(stream);
        }
        return bitmap == null ? null : new AndroidBitmap(bitmap);
    }

    private int findOrientationDegreesAndCloseStream(String filename) {
        int orientation;
        try {
            switch (new ExifInterface(filename).getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    orientation = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    orientation = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    orientation = 270;
                    break;
                default:
                    orientation = 0;
            }
        } catch (IOException ignore) {
            orientation = 0;
        }
        return orientation;
    }

    @Override
    protected boolean sysImageNeedsExtension() {
        return false;
    }

    @Override
    public void fillStreamAndClose(NativeBitmap nativebitmap, int method, double quality, OutputStream out) throws IOException {
        Bitmap bitmap = ((AndroidBitmap) nativebitmap).bitmap;
        try {
            Bitmap.CompressFormat compress = method == JPEG ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            if (!bitmap.compress(compress, (int) (quality * 100), out))
                throw new IOException("Unable to compress image with type " + (method == PNG ? "PNG" : "JPEG"));
        } finally {
            closeR(out);
        }
    }

    @Override
    public NativeBitmap stretch(NativeBitmap bitmap, int top, int right, int bottom, int left, int reqX, int reqY) {
        Bitmap in = ((AndroidBitmap) bitmap).bitmap;
        int origX = in.getWidth();
        int origY = in.getHeight();

        Bitmap out = Bitmap.createBitmap(reqX, reqY, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(out);

        canvas.drawBitmap(in, new Rect(0, 0, left, top), new Rect(0, 0, left, top), null);
        canvas.drawBitmap(in, new Rect(origX - right, 0, origX, top), new Rect(reqX - right, 0, reqX, top), null);
        canvas.drawBitmap(in, new Rect(0, origY - bottom, left, origY), new Rect(0, reqY - bottom, left, reqY), null);
        canvas.drawBitmap(in, new Rect(origX - right, origY - bottom, origX, origY), new Rect(reqX - right, reqY - bottom, reqX, reqY), null);

        canvas.drawBitmap(in, new Rect(left, 0, origX - right, top), new Rect(left, 0, reqX - right, top), null);
        canvas.drawBitmap(in, new Rect(left, origY - bottom, origX - right, origY), new Rect(left, reqY - bottom, reqX - right, reqY), null);
        canvas.drawBitmap(in, new Rect(0, top, left, origY - bottom), new Rect(0, top, left, reqY - bottom), null);
        canvas.drawBitmap(in, new Rect(origX - right, top, origX, origY - bottom), new Rect(reqX - right, top, reqX, reqY - bottom), null);

        canvas.drawBitmap(in, new Rect(left, top, origX - right, origY - bottom), new Rect(left, top, reqX - right, reqY - bottom), null);

        return new AndroidBitmap(out);
    }

    @Override
    public NativeBitmap adjustColor(NativeBitmap bitmap, double saturation, double brightness) {
        if (saturation < 0)
            saturation = 0;
        if (saturation > 1)
            saturation = 1;
        if (brightness < 0)
            brightness = 0;
        if (bitmap == null)
            return null;
        Bitmap in = ((AndroidBitmap) bitmap).bitmap;
        Bitmap out = Bitmap.createBitmap(in.getWidth(), in.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(out);
        Paint p = new Paint();
        ColorMatrix cm = new ColorMatrix();
        double base = brightness * (saturation + (1 - saturation) / 3);
        double other = brightness * (1 - saturation) / 3;
        cm.set(new float[]{
                (float) base, (float) other, (float) other, 0, 0,
                (float) other, (float) base, (float) other, 0, 0,
                (float) other, (float) other, (float) base, 0, 0,
                0, 0, 0, 1, 0
        });
        p.setColorFilter(new ColorMatrixColorFilter(cm));
        c.drawBitmap(in, 0, 0, p);
        return new AndroidBitmap(out);
    }

    @Override
    public NativeBitmap masked(NativeBitmap bitmap, int color) {
        if (bitmap == null)
            return null;
        Bitmap in = ((AndroidBitmap) bitmap).bitmap;
        Bitmap out = Bitmap.createBitmap(in.getWidth(), in.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(out);
        Paint p = new Paint();
        p.setColorFilter(new LightingColorFilter(0, color));
        p.setAlpha(color >>> 24);
        c.drawBitmap(in, 0, 0, p);
        return new AndroidBitmap(out);
    }

    @Override
    public NativeBitmap create(int width, int height) {
        return new AndroidBitmap(Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888));
    }

    @Override
    public void requestCamera(VoidBlock1<CGImage> filepathResult) {
        AndroidPermissions.current().requestPermissions(notGranted -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (notGranted.isEmpty() && takePictureIntent.resolveActivity(MainActivity.current.getPackageManager()) != null) {
                // Create output image file
                String rawPhotoPath = Native.file().getRandomLocation();
                File photoFile = new File(rawPhotoPath);
                Uri photoURI = AndroidFileBridge.getExternalUri(photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                ActivityResultListener activityResult = new ActivityResultListener() {
                    @Override
                    public void result(int resultCode, Intent data) {
                        MainActivity.current.getStateListener().unregister(this);
                        CGImage cgimage = resultCode == RESULT_OK
                                ? $coregraphics.cgimage(rawPhotoPath, null)
                                : null;
                        if (cgimage == null && photoFile.isFile())
                            photoFile.delete();
                        filepathResult.invoke(cgimage);
                    }
                };
                int reqCode = MainActivity.current.getStateListener().register(activityResult);
                MainActivity.current.startActivityForResult(takePictureIntent, reqCode);
            } else filepathResult.invoke(null);
        }, AndroidPermission.CAMERA);
    }

    @Override
    public void requestPhotoAlbum(VoidBlock1<CGImage> result) {
        ActivityResultListener activityResult = new ActivityResultListener() {
            @Override
            public void result(int resultCode, Intent data) {
                CGImage cgimage = null;
                if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                    MainActivity.current.getStateListener().unregister(this);
                    Uri uri = data.getData();
                    String photoPath = Native.file().getRandomLocation();
                    File photoFile = new File(photoPath);
                    try {
                        Native.file().copyStreamAndClose(MainActivity.current.getContentResolver().openInputStream(uri), new FileOutputStream(photoFile), IMAGE_STREAM_BUFFER_SIZE);
                        cgimage = $coregraphics.cgimage(photoPath, null);
                    } catch (IOException ex) {
                        if (photoFile.exists())
                            photoFile.delete();
                    }
                }
                result.invoke(cgimage);
            }
        };

        Intent photoChooserIntent = new Intent();
// Show only images, no videos or anything else
        photoChooserIntent.setType("image/*");
        photoChooserIntent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        // MainActivity.current.startActivityForResult(Intent.createChooser(photoChooserIntent, "Select Picture"), PICK_IMAGE_REQUEST);

        int reqCode = MainActivity.current.getStateListener().register(activityResult);
        //MainActivity.current.startActivityForResult(takePictureIntent, );
        if (photoChooserIntent.resolveActivity(MainActivity.current.getPackageManager()) != null)
            MainActivity.current.startActivityForResult(photoChooserIntent, reqCode);

    }

    @Override
    public boolean supportsCamera(ImageSource source) {
        switch (source) {
            case FRONT:
                return MainActivity.current().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
            case BACK:
                return MainActivity.current().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
            case LIBRARY:
            case ALBUM:
                return true;
            default:
                return false;
        }
    }
}
