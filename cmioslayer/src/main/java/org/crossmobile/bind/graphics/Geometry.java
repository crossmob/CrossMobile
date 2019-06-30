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
package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIEdgeInsets;

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

    public static boolean equals(CGPoint self, CGPoint other) {
        return other.getX() == self.getX() && other.getY() == self.getY();
    }

    public static boolean equals(CGSize self, CGSize other) {
        return other.getWidth() == self.getWidth() && other.getHeight() == self.getHeight();
    }

    public static boolean equals(UIEdgeInsets self, UIEdgeInsets other) {
        return self.getLeft() == other.getLeft() &&
                self.getTop() == other.getTop() &&
                self.getRight() == other.getRight() &&
                self.getBottom() == other.getBottom();
    }

    public static boolean equals(CGRect self, CGRect other) {
        return other.getOrigin().getX() == self.getOrigin().getX() && other.getOrigin().getY() == self.getOrigin().getY() &&
                other.getSize().getWidth() == self.getSize().getWidth() && other.getSize().getHeight() == self.getSize().getHeight();
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

    public static CGAffineTransform set(CGAffineTransform source, CGAffineTransform destination) {
        destination.setA(source.getA());
        destination.setB(source.getB());
        destination.setC(source.getC());
        destination.setD(source.getD());
        destination.setTx(source.getTx());
        destination.setTy(source.getTy());
        return destination;

    }

    public static String toString(CGAffineTransform self) {
        return self.getA() + "," + self.getC() + "," + self.getTx() + ":" + self.getB() + "," + self.getD() + "," + self.getTy();
    }
}
