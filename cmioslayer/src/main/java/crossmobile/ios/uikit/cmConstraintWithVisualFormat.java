/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class cmConstraintWithVisualFormat {

    private boolean parsePredicates(String line, List<Predicate> predicates) {
        List<String> predStr;
        if (line.length() > 2 && line.startsWith("(")) {
            if (!line.endsWith(")")) {
                System.out.println("Syntax Error! " + line);
                return false;
            }
            line = line.substring(1, line.length() - 1);
        }
        predStr = Arrays.asList(line.split(","));
        for (String item : predStr) {
            Pattern pattern = Pattern.compile("^\\s*(==|>=|<=)?([\\w.]+)(@([\\w]+))?\\s*$");
            Matcher matcher = pattern.matcher(item);
            if (!matcher.find())
                return false;
            predicates.add(new Predicate(matcher.group(1), matcher.group(2), matcher.group(4)));
        }
        return true;
    }

    private List<NSLayoutConstraint> constraintsFromPredicates(
            List<Predicate> predicates,
            UIView item1,
            UIView item2,
            Map<String, UIView> views,
            Map<String, Float> metrics,
            boolean vertical,
            int direction) {

        List<NSLayoutConstraint> ret = new ArrayList<>();
        int NSLayoutAttribute1;
        int NSLayoutAttribute2;

        switch (direction) {
            case NSLayoutFormatOptions.DirectionLeadingToTrailing: // default (0)
                NSLayoutAttribute1 = NSLayoutAttribute.Trailing;
                NSLayoutAttribute2 = NSLayoutAttribute.Leading;
                break;
            case NSLayoutFormatOptions.DirectionLeftToRight:
                NSLayoutAttribute1 = NSLayoutAttribute.Right;
                NSLayoutAttribute2 = NSLayoutAttribute.Left;
                break;
            case NSLayoutFormatOptions.DirectionRightToLeft:
                NSLayoutAttribute1 = NSLayoutAttribute.Left;
                NSLayoutAttribute2 = NSLayoutAttribute.Right;
                break;
            default:
                System.out.println("Unknown format direction: " + direction);
                return null;
        }

        for (Predicate predicate : predicates) {
            Object target = null;
            float priority = 1000;
            int relation;
            float constant = 0;

            if (!predicate.target.equals("")) {
                target = views.get(predicate.target);
                if (predicate.target.equals("default"))
                    if (item2 != null && ((UIView) item1).superview().equals(((UIView) item2).superview()))
                        constant = 8;
                    else
                        constant = 20;
                else if (metrics != null && metrics.get(predicate.target) != null)

                    constant = metrics.get(predicate.target);
                else
                    try {
                        constant = Float.parseFloat(predicate.target);
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot parse number from target string: " + constant + predicate.target);
                    }
            }

            if (predicate.priority.equals(""))
                if (metrics != null && metrics.get(predicate.target) != null)
                    priority = metrics.get(predicate.target);
                else {
                    try {
                        priority = Float.parseFloat(predicate.priority);
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot parse number from priority string: " + predicate.priority);
                    }
                    if (priority < 0.0f || priority > 1000.0f) {
                        System.out.println("Priority out of range: " + priority);
                        return null;
                    }
                }

            if (predicate.relation.equals("") || predicate.relation.equals("=="))
                relation = NSLayoutRelation.RelationEqual;
            else if (predicate.relation.equals("<="))
                relation = NSLayoutRelation.LessThanOrEqual;
            else if (predicate.relation.equals(">="))
                relation = NSLayoutRelation.GreaterThanOrEqual;
            else {
                System.out.println("Unknown relation string: " + predicate.relation);
                return null;
            }

            if (item2 != null) {
                int a1 = vertical ? NSLayoutAttribute.Bottom : NSLayoutAttribute1;
                int a2 = vertical ? NSLayoutAttribute.Top : NSLayoutAttribute2;
                if (item1 == item2.superview())
                    a1 = vertical ? NSLayoutAttribute.Top : NSLayoutAttribute2;
                else if (item2 == item1.superview())
                    a2 = vertical ? NSLayoutAttribute.Bottom : NSLayoutAttribute1;

                NSLayoutConstraint c = NSLayoutConstraint.constraintWithItem(item1, a1, relation, item2, a2, 1, -constant);
                c.setPriority(priority);
                ret.add(c);
            } else if (target != null) {
                NSLayoutConstraint c = NSLayoutConstraint.constraintWithItem(item1,
                        vertical ? NSLayoutAttribute.Height : NSLayoutAttribute.Width,
                        relation,
                        target,
                        vertical ? NSLayoutAttribute.Height : NSLayoutAttribute.Width,
                        1,
                        constant);
                c.setPriority(priority);
                ret.add(c);
            } else {
                NSLayoutConstraint c = NSLayoutConstraint.constraintWithItem(item1,
                        vertical ? NSLayoutAttribute.Height : NSLayoutAttribute.Width,
                        relation,
                        null,
                        NSLayoutAttribute.NotAnAttribute,
                        1,
                        constant);
                c.setPriority(priority);
                ret.add(c);
            }
        }
//        for(NSLayoutConstraint r:ret)
//            System.out.println("Align cost : "+r.toString());
        return ret;
    }

    private UIView viewForString(String target, Map<String, UIView> items, UIView superview) {
        UIView item = null;
        if (target.equals("|"))
            if (superview == null)
                return null;
            else
                item = superview;
        else
            item = items.get(target);
        return item;
    }

    List<NSLayoutConstraint> constraintWithVisualFormat(String format, int LayoutFormatOptions, Map<String, Float> metrics, Map<String, UIView> views) {
        UIView superview = null;
        List<Predicate> predList;
        for (UIView item : views.values()) {
            UIView lsuper = item.superview();
            if (superview == null)
                superview = lsuper;
            else if (lsuper != null && !lsuper.equals(superview))
                System.out.println("All views must share the same superview.");
        }
        List<NSLayoutConstraint> result = new ArrayList<>();
        String line = format;
        boolean vertical = false;
        List<List<Predicate>> predicates = new ArrayList<>();
        List<Constraint> constrains = new ArrayList<Constraint>();

        Pattern verizontalpattern = Pattern.compile("^([VH]:).*$");
        Matcher verizontalmatcher = verizontalpattern.matcher(line);

        if (verizontalmatcher.find()) {
            if (verizontalmatcher.group(1).equals("V:"))
                vertical = true;
            line = line.substring(2);
        }
// Match all "]-(1,2,3)-["
        Pattern connectorPattern = Pattern.compile("(]|\\|)([^\\[]*)?(\\[|\\|)");
        Matcher connectorMatcher = connectorPattern.matcher(line);

        while (connectorMatcher.find()) {
            String connector = connectorMatcher.group(2);
            if (connector.equals("")) {
                predList = new ArrayList<>();
                predList.add(new Predicate());
                predicates.add(predList);
            } else if (connector.equals("-")) {
                predList = new ArrayList<>();
                predList.add(new Predicate("default"));
                predicates.add(predList);
            } else if (!connector.startsWith("-") || !connector.endsWith("-") || connector.length() < 3)
                System.out.println("Syntax Error" + connector);

            else {
                predList = new ArrayList<>();
                if (!parsePredicates(connector.substring(1, connector.length() - 1), predList))
                    return null;
                predicates.add(predList);
            }
        }

        Pattern constraintPattern = Pattern.compile("(\\[([^]]*)]|\\|)");
        Matcher constraintMatcher = constraintPattern.matcher(line);

        while (constraintMatcher.find()) {
            String constraint = constraintMatcher.group();
            Pattern rex = Pattern.compile("^\\[([\\w]+)(\\(.*\\))?]$");
            Matcher recm = rex.matcher(constraint);
            if (!recm.find())
                if (constraint.equals("|"))
                    constrains.add(new Constraint(new ArrayList<>(), constraint));
                else
                    return null;
            else {
                String target = recm.group(1);
                String predicate = recm.group(2);
//                System.out.println("target : " + target + " | predicate : " + predicate);
                List<Predicate> localPredicates = new ArrayList<Predicate>();
                if (target.equals(""))
                    return null;
                if (predicate != null) {
                    if (!predicate.startsWith("(") || !predicate.endsWith(")") || predicate.length() < 3)
                        return null;
                    if (!parsePredicates(predicate, localPredicates))
                        return null;
                }
                constrains.add(new Constraint(localPredicates, target));
            }
        }

        if (predicates.size() != constrains.size() - 1)
            return null;
        if (constrains.isEmpty())
            return null;

        List<NSLayoutConstraint> predAry;
        for (int i = 0; i < predicates.size(); i++) {
            UIView item1 = viewForString(constrains.get(i).target, views, superview);
            UIView item2 = viewForString(constrains.get(i + 1).target, views, superview);
            if (item1 == null || item2 == null)
                return null;
            predAry = constraintsFromPredicates(constrains.get(i).predicates, item1, null, views, metrics, vertical, LayoutFormatOptions & NSLayoutFormatOptions.DirectionMask);
            if (predAry == null)
                return null;
            result.addAll(predAry);
        }

        for (int i = 0; i < constrains.size() - 1; i++) {
            UIView item1 = viewForString(constrains.get(i).target, views, superview);
            UIView item2 = viewForString(constrains.get(i + 1).target, views, superview);
            if (item1 == null || item2 == null)
                return null;
            predAry = constraintsFromPredicates(predicates.get(i), item1, item2, views, metrics, vertical, LayoutFormatOptions & NSLayoutFormatOptions.DirectionMask);
            if (predAry == null)
                return null;
            result.addAll(predAry);
        }

        if (LayoutFormatOptions != 0 && !constrains.isEmpty()) {
            switch (LayoutFormatOptions & NSLayoutFormatOptions.AlignmentMask) {
                case NSLayoutFormatOptions.AlignAllLeft:
                case NSLayoutFormatOptions.AlignAllRight:
                case NSLayoutFormatOptions.AlignAllLeading:
                case NSLayoutFormatOptions.AlignAllTrailing:
                case NSLayoutFormatOptions.AlignAllCenterX:
                    if (vertical)
                        return null;
                    break;
                case NSLayoutFormatOptions.AlignAllTop:
                case NSLayoutFormatOptions.AlignAllBottom:
                case NSLayoutFormatOptions.AlignAllCenterY:
                    if (!vertical)
                        return null;
                    break;
                default:
                    return null;
            }

            for (int i = 0; i < constrains.size() - 1; i++) {
                UIView item1 = viewForString(constrains.get(i).target, views, superview);
                UIView item2 = viewForString(constrains.get(i + 1).target, views, superview);

                NSLayoutConstraint aligncost = NSLayoutConstraint.constraintWithItem(item1,
                        LayoutFormatOptions & NSLayoutFormatOptions.AlignmentMask,
                        NSLayoutRelation.RelationEqual,
                        item2,
                        LayoutFormatOptions & NSLayoutFormatOptions.AlignmentMask,
                        1,
                        0);
                result.add(aligncost);
            }
        }
        return result;
    }

    private class Predicate {

        private String relation;
        private String target;
        private String priority;

        public Predicate() {
            this.relation = "==";
            this.priority = "1000";
            this.target = "0";
        }

        public Predicate(String target) {
            this();
            this.target = "default";
        }

        public Predicate(String relation, String target, String priority) {
            this.relation = relation == null ? "" : relation;
            this.priority = priority == null ? "" : priority;
            this.target = target == null ? "" : target;
        }

    }

    private class Constraint {

        private List<Predicate> predicates;
        private String target;

        public Constraint(List<Predicate> predicates, String target) {
            this.predicates = predicates;
            this.target = target;
        }

    }
}
