/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

public class AndroidInputConnection extends BaseInputConnection {

    private SpannableStringBuilder _editable;

    public AndroidInputConnection(View targetView, boolean fullEditor) {
        super(targetView, fullEditor);
    }

    @Override
    public Editable getEditable() {
        if (_editable == null)
            _editable = (SpannableStringBuilder) Editable.Factory.getInstance().newEditable("Placeholder");
        return _editable;
    }

    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        _editable.append(text);
        return true;
    }
}
