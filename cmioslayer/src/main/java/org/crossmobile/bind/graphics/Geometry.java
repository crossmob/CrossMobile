/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIEdgeInsets;
import org.crossmobile.bridge.ann.CMPure;

@CMPure(full = true)
public class Geometry {

    public static float distance(CGPoint self, CGPoint other) {
        double dx = self.getX() - other.getX();
        double dy = self.getY() - other.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static boolean similarTo(CGPoint self, CGPoint other, int offset) {
        double dx = other.getX() - self.getX();
        double dy = other.getY() - self.getY();
        dx = dx < 0 ? -dx : dx;
        dy = dy < 0 ? -dy : dy;
        return dx < offset && dy < offset;
    }

    public static double meter(CGPoint point) {
        return Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());
    }

    public static void max(CGSize self, CGSize other) {
        if (other.getHeight() > self.getHeight())
            self.setHeight(other.getHeight());
        if (other.getWidth() > self.getWidth())
            self.setWidth(other.getWidth());
    }

    public static boolean isZero(CGSize self) {
        return self.getWidth() == 0 && self.getHeight() == 0;
    }

    public static boolean isZero(CGRect self) {
        return self.getOrigin().getX() == 0 && self.getOrigin().getY() == 0 && self.getSize().getWidth() == 0 && self.getSize().getHeight() == 0;
    }

    public static CGPoint apply(CGAffineTransform t, CGPoint point) {
        double temp = t.getA() * point.getX() + t.getC() * point.getY() + t.getTx();
        point.setY(t.getB() * point.getX() + t.getD() * point.getY() + t.getTy());
        point.setX(temp);
        return point;
    }

    public static CGSize apply(CGAffineTransform t, CGSize size) {
        double temp = t.getA() * size.getWidth() + t.getC() * size.getHeight() + t.getTx();
        size.setHeight(t.getB() * size.getWidth() + t.getD() * size.getHeight() + t.getTy());
        size.setWidth(temp);
        return size;
    }

    public static CGSize copy(CGSize self) {
        return new CGSize(self.getWidth(), self.getHeight());
    }

    public static CGPoint copy(CGPoint self) {
        return new CGPoint(self.getX(), self.getY());
    }

    public static CGRect copy(CGRect self) {
        return new CGRect(self.getOrigin().getX(), self.getOrigin().getY(), self.getSize().getWidth(), self.getSize().getHeight());
    }

    public static CGAffineTransform copy(CGAffineTransform self) {
        return new CGAffineTransform(self.getA(), self.getB(), self.getC(), self.getD(), self.getTx(), self.getTy());
    }

    public static CGSize set(CGSize self, CGSize other) {
        self.setWidth(other.getWidth());
        self.setHeight(other.getHeight());
        return self;
    }

    public static CGPoint set(CGPoint self, CGPoint other) {
        self.setX(other.getX());
        self.setY(other.getY());
        return self;
    }

    public static CGRect set(CGRect self, CGRect other) {
        self.getOrigin().setX(other.getOrigin().getX());
        self.getOrigin().setY(other.getOrigin().getY());
        self.getSize().setWidth(other.getSize().getWidth());
        self.getSize().setHeight(other.getSize().getHeight());
        return self;
    }

    public static CGRect set(CGRect self, double x, double y, double width, double height) {
        self.getOrigin().setX(x);
        self.getOrigin().setY(y);
        self.getSize().setWidth(width);
        self.getSize().setHeight(height);
        return self;
    }

    public static CGAffineTransform set(CGAffineTransform self, CGAffineTransform other) {
        self.setA(other.getA());
        self.setB(other.getB());
        self.setC(other.getC());
        self.setD(other.getD());
        self.setTx(other.getTx());
        self.setTy(other.getTy());
        return self;
    }

    public static UIEdgeInsets set(UIEdgeInsets self, UIEdgeInsets other) {
        self.setTop(other.getTop());
        self.setRight(other.getRight());
        self.setBottom(other.getBottom());
        self.setLeft(other.getLeft());
        return self;
    }
}
