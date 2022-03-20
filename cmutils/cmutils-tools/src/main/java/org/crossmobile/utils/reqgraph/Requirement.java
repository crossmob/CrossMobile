/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.reqgraph;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Requirement<T> {

    private final Collection<Requirement<T>> requirements = new LinkedHashSet<>();
    private final T data;

    public Requirement(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setRequires(Requirement<T> req) {
        if (req.requires(this)) // a path with opposite direction exists
            throw new RuntimeException("Requirement cycle detected");
        requirements.add(req);
    }

    public void setRequiredBy(Requirement<T> req) {
        req.setRequires(this);
    }

    public boolean requires(Requirement<T> req) {
        if (equals(req))
            return true;
        for (Requirement<T> child : requirements)
            if (child.requires(req))
                return true;
        return false;
    }

    public boolean requiredBy(Requirement<T> req) {
        return req.requires(this);
    }

    public Collection<Requirement<T>> listRequirements() {
        Collection<Requirement<T>> reqs = new LinkedHashSet<>();
        appendReqs(reqs);
        return reqs;
    }

    private void appendReqs(Collection<Requirement<T>> reqs) {
        for (Requirement<T> r : requirements)
            r.appendReqs(reqs);
        if (!reqs.contains(this))
            reqs.add(this);
    }

    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }

    @Override
    public int hashCode() {
        return 19 + Objects.hashCode(this.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Requirement<?> other = (Requirement<?>) obj;
        return Objects.equals(this.data, other.data);
    }

    public String toStringWithReqs() {
        StringBuilder out = new StringBuilder();
        for (Requirement<T> req : requirements)
            out.append(", ").append(req.toStringWithReqs());
        return toString() + (out.length() > 0 ? "[" + out.substring(2) + "]" : "");
    }

}
