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
