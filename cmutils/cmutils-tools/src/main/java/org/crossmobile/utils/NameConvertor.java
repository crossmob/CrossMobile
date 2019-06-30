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
package org.crossmobile.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class NameConvertor {

    private static final Pattern diacritical = Pattern.compile("[\\p{InCombiningDiacriticalMarks}]");

    public static String unicodeToAsciiID(String input) {
        input = diacritical.matcher(Normalizer.normalize(input, Normalizer.Form.NFD)).replaceAll("");
        StringBuilder out = new StringBuilder();
        for (char c : input.toCharArray())
            switch (c) {
                case 'α':
                    out.append('a');
                    break;
                case 'Α':
                    out.append('A');
                    break;
                case 'β':
                    out.append('b');
                    break;
                case 'Β':
                    out.append('B');
                    break;
                case 'γ':
                    out.append('g');
                    break;
                case 'Γ':
                    out.append('G');
                    break;
                case 'δ':
                    out.append('d');
                    break;
                case 'Δ':
                    out.append('D');
                    break;
                case 'ε':
                    out.append('e');
                    break;
                case 'Ε':
                    out.append('E');
                    break;
                case 'ζ':
                    out.append('z');
                    break;
                case 'Ζ':
                    out.append('Z');
                    break;
                case 'η':
                    out.append('i');
                    break;
                case 'Η':
                    out.append('I');
                    break;
                case 'θ':
                    out.append("th");
                    break;
                case 'Θ':
                    out.append("TH");
                    break;
                case 'ι':
                    out.append('i');
                    break;
                case 'Ι':
                    out.append('I');
                    break;
                case 'κ':
                    out.append('k');
                    break;
                case 'Κ':
                    out.append('K');
                    break;
                case 'λ':
                    out.append('l');
                    break;
                case 'Λ':
                    out.append('L');
                    break;
                case 'μ':
                    out.append('m');
                    break;
                case 'Μ':
                    out.append('M');
                    break;
                case 'ν':
                    out.append('n');
                    break;
                case 'Ν':
                    out.append('N');
                    break;
                case 'ξ':
                    out.append("ks");
                    break;
                case 'Ξ':
                    out.append("KS");
                    break;
                case 'ο':
                    out.append('o');
                    break;
                case 'Ο':
                    out.append('O');
                    break;
                case 'π':
                    out.append('p');
                    break;
                case 'Π':
                    out.append('P');
                    break;
                case 'ρ':
                    out.append('r');
                    break;
                case 'Ρ':
                    out.append('R');
                    break;
                case 'σ':
                    out.append('s');
                    break;
                case 'Σ':
                    out.append('S');
                    break;
                case 'τ':
                    out.append('t');
                    break;
                case 'Τ':
                    out.append('T');
                    break;
                case 'υ':
                    out.append('y');
                    break;
                case 'Υ':
                    out.append('Y');
                    break;
                case 'φ':
                    out.append('f');
                    break;
                case 'Φ':
                    out.append('F');
                    break;
                case 'χ':
                    out.append('x');
                    break;
                case 'Χ':
                    out.append('X');
                    break;
                case 'ψ':
                    out.append("ps");
                    break;
                case 'Ψ':
                    out.append("PS");
                    break;
                case 'ω':
                    out.append('o');
                    break;
                case 'Ω':
                    out.append('O');
                    break;
                default:
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '.' || c == '_')
                        out.append(c);
            }
        return out.toString();
    }

    public static String unicodeToID(String company, String name) {
        company = unicodeToAsciiID(company);
        name = unicodeToAsciiID(name);
        String id = company + "." + name;
        id = id.replaceAll("\\s+", "_").replaceAll("\\.+", ".").replaceAll("_+", "_");
        if (id.startsWith("."))
            id = id.substring(1);
        if (id.endsWith("."))
            id = id.substring(0, id.length() - 1);
        return id.toLowerCase();
    }
}
