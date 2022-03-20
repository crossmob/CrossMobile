/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.uikit.UIView.DelegateViews;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bind.graphics.anim.curve.CommonInterpolations;
import org.crossmobile.bind.graphics.anim.curve.InterpolationCurve;
import org.crossmobile.bind.graphics.anim.Animator;
import org.crossmobile.bind.graphics.anim.AnimationAction;
import org.crossmobile.bridge.Native;
import org.robovm.objc.block.VoidBlock1;

import java.util.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.coregraphics.GraphicsDrill.selfRotateScaleTranslate;
import static crossmobile.ios.uikit.UIViewAnimationCurve.*;
import static crossmobile.ios.uikit.UIViewAnimationTransition.*;

class cmViewAnimation implements AnimationAction {

    private static final boolean ignoreSmartTransformation = true;

    private final Set<AnimationTuple> tuples = Collections.synchronizedSet(new HashSet<>());
    private VoidBlock1<Boolean> delegate;
    private double delay = 0;
    private double repeats = 0;
    private boolean ping_pong = false;
    private InterpolationCurve animationCurve = CommonInterpolations.Linear;
    private double duration = GraphicsBridgeConstants.DefaultAnimationDuration;
    private UIView parent;
    private Collection<DelegateViews> viewEnter;
    private Collection<DelegateViews> viewLeave;
    private Collection<UIView> viewFrames;  // Might not needed -- might be supported by setFrame itself
    private AnimationTransition animationTransition = AnimationTransition.None;

    void setAlpha(UIView view, double to) {
        if (view.alpha != to)
            tuples.add(new AlphaTuple(view, to));
    }

    void setBackground(UIView view, int to) {
        UIColor bgcolor = view.backgroundColor();
        if (bgcolor != null && color(bgcolor.cgcolor) != to)
            tuples.add(new BackgroundTuple(view, to));
    }

    void setFrame(UIView view, CGRect to) {
        // Set frame ONLY when setAnimationTransition is not set!
        if (parent == null)
            setFrameImpl(view, to);
    }

    // Recycle original frame
    private void setFrameImpl(UIView view, CGRect to) {
        if (to != null && !view.frame().equals(to)) {
            if (viewFrames == null)
                viewFrames = new LinkedHashSet<>();
            viewFrames.add(view);
            tuples.add(new FrameTuple(view, to));
        }
    }

    // Recycle original transformation
    void setTransformation(UIView view, CGAffineTransform to) {
        CGAffineTransform from = view.transform;
        if (from == null && (to == null || to.isIdentity()))
            return;
        if (from == null)
            from = CGAffineTransform.identity();
        if (to == null)
            to = CGAffineTransform.identity();
        if (from.equals(to))
            return;
        double from_th1 = Math.atan(from.getC() / from.getD());
        double from_th2 = Math.atan(-from.getB() / from.getA());
        double to_th1 = Math.atan(to.getC() / to.getD());
        double to_th2 = Math.atan(-to.getB() / to.getA());
        if (ignoreSmartTransformation || Math.abs(from_th1 - from_th2) > 0.00001f || Math.abs(to_th1 - to_th2) > 0.00001f)
            tuples.add(new SimpleTransformationTuple(view, from.getA(), from.getB(), from.getC(), from.getD(), from.getTx(),
                    from.getTy(), to.getA() - from.getA(), to.getB() - from.getB(), to.getC() - from.getC(), to.getD() - from.getD(), to.getTx() - from.getTx(), to.getTy() - from.getTy()));
        else {
            double fromSx = (from.getA() > 0 ? 1 : -1) * Math.sqrt(from.getA() * from.getA() + from.getC() * from.getC());
            double fromSy = (from.getD() > 0 ? 1 : -1) * Math.sqrt(from.getB() * from.getB() + from.getD() * from.getD());
            double toSx = (to.getA() > 0 ? 1 : -1) * Math.sqrt(to.getA() * to.getA() + to.getC() * to.getC());
            double toSy = (to.getD() > 0 ? 1 : -1) * Math.sqrt(to.getB() * to.getB() + to.getD() * to.getD());
            tuples.add(new SmartTransformationTuple(view, from_th1, fromSx, fromSy, from.getTx(), from.getTy(),
                    to_th1 - from_th1, toSx - fromSx, toSy - fromSy, to.getTx() - from.getTx(), to.getTy() - from.getTy()));
        }
    }

    boolean viewToEnter(DelegateViews dv) {
        if (areParentsCompatible(dv)) {
            if (viewEnter == null)
                viewEnter = new HashSet<>();
            viewEnter.add(dv);
            return true;
        }
        return false;
    }

    boolean viewToLeave(DelegateViews dv) {
        if (areParentsCompatible(dv)) {
            if (viewLeave == null)
                viewLeave = new HashSet<>();
            viewLeave.add(dv);
            return true;
        }
        return false;
    }

    private boolean areParentsCompatible(DelegateViews dv) {
        UIView commonParent = dv.anyParent();
        if (commonParent == null)
            return false;
        if (this.parent == null) {
            this.parent = commonParent;
            return true;
        } else
            return this.parent == commonParent;
    }

    void setDuration(double d) {
        this.duration = d;
    }

    void setDelay(double delay) {
        if (delay < 0)
            delay = 0;
        this.delay = delay;
    }

    void setDelegate(VoidBlock1<Boolean> delegate) {
        this.delegate = delegate;
    }

    void setCurve(int animationCurve) {
        switch (animationCurve) {
            case EaseIn:
                this.animationCurve = CommonInterpolations.EaseIn;
                break;
            case EaseOut:
                this.animationCurve = CommonInterpolations.EaseOut;
                break;
            case EaseInOut:
                this.animationCurve = CommonInterpolations.EaseInOut;
                break;
            case Linear:
                this.animationCurve = CommonInterpolations.Linear;
                break;
            default:
        }
    }

    public void setParent(UIView parent) {
        if (this.parent != null)
            throw new RuntimeException("Only one UIView allowed under setAnimationTransition");
        this.parent = parent;
        if (this.parent == null)
            throw new NullPointerException("UIView under setAnimationTransition could not be null");
    }

    public void setTransition(int animationTransition) {
        switch (animationTransition) {
            case FlipFromLeft:
                this.animationTransition = AnimationTransition.Left;
                break;
            case FlipFromRight:
                this.animationTransition = AnimationTransition.Right;
                break;
            case CurlUp:
            case FlipFromTop:
                this.animationTransition = AnimationTransition.Up;
                break;
            case CurlDown:
            case FlipFromBottom:
                this.animationTransition = AnimationTransition.Down;
                break;
            case CrossDissolve:
            case None:
            default:
                this.animationTransition = AnimationTransition.None;
        }
    }

    void setRepeats(double repeatCount) {
        if (repeatCount < 0)
            repeatCount = 0;
        this.repeats = repeatCount;
    }

    void setAutoReverse(boolean repeatAutoreverses) {
        this.ping_pong = repeatAutoreverses;
    }

    void commit() {
        if (delay > 0)
            NSTimer.scheduledTimerWithTimeInterval(delay, i -> Animator.add(this, animationCurve, duration, repeats, ping_pong), null, false);
        else
            Animator.add(this, animationCurve, duration, repeats, ping_pong);
    }

    @Override
    public void start() {
        // Add pending entering/leaving view animations
        if (parent != null) {
            if (viewEnter != null)
                for (DelegateViews dv : viewEnter) {
                    dv.delegateBefore();
                    setFrameImpl(dv.view(), animationTransition.enterView(dv.view(), parent));
                    dv.doAdd();
                }
            if (viewLeave != null)
                for (DelegateViews dv : viewLeave) {
                    dv.delegateBefore();
                    setFrameImpl(dv.view(), animationTransition.exitView(dv.view(), parent));
                }
        }
    }

    @Override
    public void apply(double progress) {
        try {
            for (AnimationTuple tuple : tuples)
                tuple.applyAt(progress);
        } catch (ConcurrentModificationException ex) {
            Native.system().error("Concurrent Animation modification", null);
            Native.graphics().refreshDisplay();
        }
    }

    @Override
    public void end() {
        if (parent != null) {
            if (viewLeave != null)
                for (DelegateViews dv : viewLeave) {
                    dv.doRemove();
                    dv.delegateAfter();
                }
            if (viewEnter != null)
                for (DelegateViews dv : viewEnter)
                    dv.delegateAfter();
        }
        if (viewFrames != null)
            for (UIView view : viewFrames)
                view.updateConstraints();
        if (delegate != null)
            delegate.invoke(true);
    }

    private interface AnimationTransition {

        AnimationTransition None = new NoneTransition();
        AnimationTransition Left = new FlipFromLeftTransition();
        AnimationTransition Right = new FlipFromRightTransition();
        AnimationTransition Up = new CurlUpTransition();
        AnimationTransition Down = new CurlDownTransition();

        CGRect enterView(UIView view, UIView parent);

        CGRect exitView(UIView view, UIView parent);
    }

    private abstract static class AnimationTuple {

        abstract void applyAt(double interpolatedTime);
    }

    private static class AlphaTuple extends AnimationTuple {

        private final UIView view;
        private final double from;
        private final double delta;

        private AlphaTuple(UIView view, double to) {
            this.view = view;
            this.from = view.alpha;
            this.delta = to - this.from;
        }

        @Override
        void applyAt(double interpolatedTime) {
            view.alpha = from + delta * interpolatedTime;
        }
    }

    private static class BackgroundTuple extends AnimationTuple {

        private final UIView view;
        private final int aF;
        private final int rF;
        private final int gF;
        private final int bF;
        private final int aD;
        private final int rD;
        private final int gD;
        private final int bD;

        private BackgroundTuple(UIView view, int to) {
            int from = color(view.backgroundColor().cgcolor);

            this.view = view;
            this.aF = (from >>> 24) & 0xFF;
            this.rF = (from >>> 16) & 0xFF;
            this.gF = (from >>> 8) & 0xFF;
            this.bF = from & 0xFF;
            this.aD = (to >>> 24) & 0xFF - this.aF;
            this.rD = (to >>> 16) & 0xFF - this.rF;
            this.gD = (to >>> 8) & 0xFF - this.gF;
            this.bD = to & 0xFF - this.bF;
        }

        @Override
        void applyAt(double interpolatedTime) {
            int aC = (int) (aF + aD * interpolatedTime);
            int rC = (int) (rF + rD * interpolatedTime);
            int gC = (int) (gF + gD * interpolatedTime);
            int bC = (int) (bF + bD * interpolatedTime);
            view.setBackgroundColorImpl(new UIColor((aC << 24) & (rC << 16) & (gC << 8) & bC));
        }
    }

    private static class FrameTuple extends AnimationTuple {

        private final UIView view;
        private final double fromX;
        private final double fromY;
        private final double fromHeight;
        private final double fromWidth;
        private final double deltaX;
        private final double deltaY;
        private final double deltaHeight;
        private final double deltaWidth;

        private FrameTuple(UIView view, CGRect to) {
            this.view = view;
            fromX = view.cframe().getOrigin().getX();
            fromY = view.cframe().getOrigin().getY();
            fromWidth = view.cframe().getSize().getWidth();
            fromHeight = view.cframe().getSize().getHeight();
            deltaX = to.getOrigin().getX() - view.cframe().getOrigin().getX();
            deltaY = to.getOrigin().getY() - view.cframe().getOrigin().getY();
            deltaWidth = to.getSize().getWidth() - view.cframe().getSize().getWidth();
            deltaHeight = to.getSize().getHeight() - view.cframe().getSize().getHeight();
        }

        @Override
        void applyAt(double interpolatedTime) {
            view.setFrameImpl(
                    fromX + deltaX * interpolatedTime,
                    fromY + deltaY * interpolatedTime,
                    fromWidth + deltaWidth * interpolatedTime,
                    fromHeight + deltaHeight * interpolatedTime);
            view.setNeedsLayout();
        }
    }

    private static abstract class TransformationTuple extends AnimationTuple {

        private final UIView view;
        private CGAffineTransform transfV;
        CGAffineTransform transf;

        TransformationTuple(UIView view) {
            this.view = view;
            transfV = CGAffineTransform.identity();
            transf = CGAffineTransform.identity();
        }

        @Override
        final void applyAt(double interpolatedTime) {
            CGAffineTransform swap = transfV;
            applyAt(transf, interpolatedTime);
            view.setTransformImpl(transfV = transf);
            transf = swap;
        }

        abstract void applyAt(CGAffineTransform transf, double interpolatedTime);
    }

    private static class SimpleTransformationTuple extends TransformationTuple {

        private final double fromA;
        private final double fromB;
        private final double fromC;
        private final double fromD;
        private final double fromTx;
        private final double fromTy;

        private final double deltaA;
        private final double deltaB;
        private final double deltaC;
        private final double deltaD;
        private final double deltaTx;
        private final double deltaTy;

        SimpleTransformationTuple(UIView view, double fromA, double fromB, double fromC, double fromD, double fromTx, double fromTy, double deltaA, double deltaB, double deltaC, double deltaD, double deltaTx, double deltaTy) {
            super(view);
            this.fromA = fromA;
            this.fromB = fromB;
            this.fromC = fromC;
            this.fromD = fromD;
            this.fromTx = fromTx;
            this.fromTy = fromTy;
            this.deltaA = deltaA;
            this.deltaB = deltaB;
            this.deltaC = deltaC;
            this.deltaD = deltaD;
            this.deltaTx = deltaTx;
            this.deltaTy = deltaTy;
        }

        @Override
        void applyAt(CGAffineTransform transf, double interpolatedTime) {
            transf.setA(fromA + deltaA * interpolatedTime);
            transf.setB(fromB + deltaB * interpolatedTime);
            transf.setC(fromC + deltaC * interpolatedTime);
            transf.setD(fromD + deltaD * interpolatedTime);
            transf.setTx(fromTx + deltaTx * interpolatedTime);
            transf.setTy(fromTy + deltaTy * interpolatedTime);
        }
    }

    private static class SmartTransformationTuple extends TransformationTuple {

        private final double fromTheta;
        private final double fromSx;
        private final double fromSy;
        private final double fromTx;
        private final double fromTy;

        private final double deltaTheta;
        private final double deltaSx;
        private final double deltaSy;
        private final double deltaTx;
        private final double deltaTy;

        SmartTransformationTuple(UIView view, double fromTheta, double fromSx, double fromSy, double fromTx, double fromTy, double deltaTheta, double deltaSx, double deltaSy, double deltaTx, double deltaTy) {
            super(view);
            this.fromTheta = fromTheta;
            this.fromSx = fromSx;
            this.fromSy = fromSy;
            this.fromTx = fromTx;
            this.fromTy = fromTy;
            this.deltaTheta = deltaTheta;
            this.deltaSx = deltaSx;
            this.deltaSy = deltaSy;
            this.deltaTx = deltaTx;
            this.deltaTy = deltaTy;
        }

        @Override
        void applyAt(CGAffineTransform transf, double interpolatedTime) {
            selfRotateScaleTranslate(transf,
                    fromTheta + deltaTheta * interpolatedTime,
                    fromSx + deltaSx * interpolatedTime, fromSy + deltaSy * interpolatedTime,
                    fromTx + deltaTx * interpolatedTime, fromTy + deltaTy * interpolatedTime);
        }
    }

    private static class NoneTransition implements AnimationTransition {

        @Override
        public CGRect enterView(UIView view, UIView parent) {
            return null;
        }

        @Override
        public CGRect exitView(UIView view, UIView parent) {
            return null;
        }
    }

    private static class FlipFromLeftTransition implements AnimationTransition {

        @Override
        public CGRect enterView(UIView view, UIView parent) {
            CGRect last = view.frame();
            view.setFrameImpl(view.cframe().getOrigin().getX() - parent.cframe().getSize().getWidth(), view.cframe().getOrigin().getY(), view.cframe().getSize().getWidth(), view.cframe().getSize().getHeight());
            return last;
        }

        @Override
        public CGRect exitView(UIView view, UIView parent) {
            CGRect last = view.frame();
            last.getOrigin().setX(last.getOrigin().getX() + parent.cframe().getSize().getWidth() / 2);
            return last;
        }
    }

    private static class FlipFromRightTransition implements AnimationTransition {

        @Override
        public CGRect enterView(UIView view, UIView parent) {
            CGRect last = view.frame();
            view.setFrameImpl(view.cframe().getOrigin().getX() + parent.cframe().getSize().getWidth(), view.cframe().getOrigin().getY(), view.cframe().getSize().getWidth(), view.cframe().getSize().getHeight());
            return last;
        }

        @Override
        public CGRect exitView(UIView view, UIView parent) {
            CGRect last = view.frame();
            last.getOrigin().setX(last.getOrigin().getX() - (parent.cframe().getSize().getWidth() / 2));
            return last;
        }
    }

    private static class CurlUpTransition implements AnimationTransition {

        @Override
        public CGRect enterView(UIView view, UIView parent) {
            CGRect last = view.frame();
            view.setFrameImpl(view.cframe().getOrigin().getX() + parent.cframe().getSize().getWidth(), view.cframe().getOrigin().getY(), view.cframe().getSize().getWidth(), view.cframe().getSize().getHeight());
            return last;
        }

        @Override
        public CGRect exitView(UIView view, UIView parent) {
            CGRect last = view.frame();
            last.getOrigin().setX(last.getOrigin().getX() - parent.cframe().getSize().getWidth());
            return last;
        }
    }

    private static class CurlDownTransition implements AnimationTransition {

        @Override
        public CGRect enterView(UIView view, UIView parent) {
            CGRect last = view.frame();
            view.setFrameImpl(view.cframe().getOrigin().getX() - parent.cframe().getSize().getWidth(), view.cframe().getOrigin().getY(), view.cframe().getSize().getWidth(), view.cframe().getSize().getHeight());
            return last;
        }

        @Override
        public CGRect exitView(UIView view, UIView parent) {
            CGRect lastpos = view.frame();
            lastpos.getOrigin().setX(lastpos.getOrigin().getX() + parent.cframe().getSize().getWidth());
            return lastpos;
        }
    }
}
