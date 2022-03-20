/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.coregraphics.GraphicsDrill.*;
import static crossmobile.ios.uikit.UIControlState.*;

@SuppressWarnings("unchecked")
class cmButtonStates {

    private static UIImage thumb;

    private final State[] states = new State[8];
    private byte current = Normal;
    boolean adjustsImageWhenHighlighted = true;
    boolean adjustsImageWhenDisabled = true;
    boolean showsTouchWhenHighlighted = true;

    static UIImage thumb() {
        if (thumb == null)
            thumb = UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + Theme.Images.THUMB_OVER);
        return thumb;
    }

    void setState(byte workState) {
        current |= workState;
    }

    void clearState(byte workState) {
        current &= ~workState;
    }

    private State getState(byte state) {
        if (states[state] == null)
            states[state] = new State(state);
        return states[state];
    }

    String getTitle(byte state) {
        return getItem(state, State.TITLE);
    }

    String getTitle() {
        return getTitle(current);
    }

    void setTitle(byte state, String title, UIFont font) {
        getState(state).setTitle(title, font);
    }

    UIColor getTitleColor(byte state) {
        return getItem(state, State.TITLECOLOR);
    }

    UIColor getTitleColor(UIColor tintColor) {
        UIColor out = getTitleColor(current);
        if (out == null && Theme.Button.IS_TINT_INHERITED && tintColor != null)
            out = new UIColor(Native.graphics().colorWithAlpha(color(tintColor.cgcolor), (current & Highlighted) != 0 ? Theme.Button.HIGHLIGHT_TEXT_FADE : 1));
        return out;
    }

    void setTitleColor(byte state, UIColor titlecolor) {
        getState(state).set(State.TITLECOLOR, titlecolor);
    }

    UIColor getShadowColor() {
        return getShadowColor(current);
    }

    UIColor getShadowColor(byte state) {
        return getItem(state, State.SHADOWCOLOR);
    }

    void setShadowColor(byte state, UIColor shadowColor) {
        getState(state).set(State.SHADOWCOLOR, shadowColor);
    }

    Promise<UIImage> getBack() {
        return getBack(current);
    }

    Promise<UIImage> getBack(byte state) {
        return getItem(state, State.BACKIMG);
    }

    void setBack(byte state, Promise<UIImage> back) {
        getState(state).set(State.BACKIMG, back);
    }

    Promise<UIImage> getFore() {
        return getFore(current);
    }

    Promise<UIImage> getFore(byte state) {
        return getItem(state, State.FOREIMG);
    }

    void setFore(byte state, Promise<UIImage> fore) {
        getState(state).set(State.FOREIMG, fore);
    }

    private <T> T getItem(byte state, byte itemIdx) {
        // Try to fetch item from requestedState
        State requestedState = getState(state);
        Object item = requestedState.get(itemIdx);
        if (item != null || state == 0)
            return (T) item;

        // Item from requested state not found - try to approximate item and create ghost object.
        if ((state & Disabled) != 0) {
            state &= ~Disabled;
            if ((item = getState(state).getGhost(itemIdx, requestedState)) != null)
                return (T) item;
        }

        if ((state & Selected) != 0) {
            state &= ~Selected;
            if ((item = getState(state).getGhost(itemIdx, requestedState)) != null)
                return (T) item;
        }

        if ((state & Highlighted) != 0) {
            state &= ~Highlighted;
            if ((item = getState(state).getGhost(itemIdx, requestedState)) != null)
                return (T) item;
        }
        return null;
    }

    void invalidate() {
        for (State s : states)
            if (s != null) {
                if (s.values[State.BACKIMG] != null)
                    ((Promise<UIImage>) s.values[State.BACKIMG]).destroy();
                if (s.values[State.FOREIMG] != null)
                    ((Promise<UIImage>) s.values[State.FOREIMG]).destroy();
            }
    }

    private final class State {

        private static final byte TITLE = 0;
        private static final byte TITLECOLOR = 2;
        private static final byte SHADOWCOLOR = 3;
        private static final byte BACKIMG = 4;
        private static final byte FOREIMG = 5;
        //
        private final byte stateID;
        private final Object[] values = new Object[6];
        private final byte[] ghost = {NOGHOST, NOGHOST, NOGHOST, NOGHOST, NOGHOST, NOGHOST};

        private State(byte stateID) {
            this.stateID = stateID;
        }

        private void setTitle(String newTitle, UIFont font) {
            values[TITLE] = newTitle;
            ghost[TITLE] = NOGHOST;
            clearGhosts(TITLE);
        }

        private void set(byte item, Object value) {
            values[item] = value;
            ghost[item] = NOGHOST;
            clearGhosts(item);
        }

        private Object get(byte item) {
            return values[item];
        }

        /**
         * This method is called from a ghost state. It will update the
         * requestedState with date from this ghost state.
         */
        private Object getGhost(byte item, State requestedState) {
            Object value = values[item];
            // This ghost state is unable to support the requested state
            if (value == null)
                return null;

            // This ghost state is able to support the requested state
            requestedState.values[item] = value;
            requestedState.ghost[item] = stateID;

            // Specific updates for various items
            if (item == TITLE) {
                // In case of text, make sure to mark width too as ghost
                requestedState.ghost[item] = stateID;
            } else if (item == FOREIMG) {
                // Images are color corrected, so value has to be altered
                if (adjustsImageWhenDisabled && (requestedState.stateID & Disabled) != 0)
                    value = requestedState.values[item] = value;
                else if (adjustsImageWhenHighlighted && (requestedState.stateID & Highlighted) != 0)
                    value = requestedState.values[item] = ((Promise<UIImage>) value).source().cacheAdjusted(1, 0.5);
            } else if (item == BACKIMG)
                // Images are color corrected, so value has to be altered
                if (adjustsImageWhenDisabled && (requestedState.stateID & Disabled) != 0)
                    value = requestedState.values[item] = ((Promise<UIImage>) value).source().cacheAdjusted(0, 1);
                else if (adjustsImageWhenHighlighted && Theme.Button.IS_BACKGROUND_ADJUSTED && (requestedState.stateID & Highlighted) != 0)
                    value = requestedState.values[item] = ((Promise<UIImage>) value).source().cacheAdjusted(1, 0.5);

            return value;
        }

        private void clearGhosts(byte item) {
            for (int i = 0; i < states.length; i++) {
                State cur = states[i];
                if (cur != null && cur.ghost[item] == stateID) {
                    cur.values[item] = null;
                    cur.ghost[item] = NOGHOST;
                }
            }
        }
    }
}
