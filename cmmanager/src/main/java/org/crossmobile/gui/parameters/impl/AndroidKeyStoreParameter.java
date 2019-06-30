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
 package org.crossmobile.gui.parameters.impl;

 import com.panayotis.hrgui.HiResButton;
 import com.panayotis.hrgui.HiResPanel;
 import org.crossmobile.gui.elements.KeystoreManager;
 import org.crossmobile.gui.parameters.FreeFileParameter;
 import org.crossmobile.gui.utils.Paths;
 import org.crossmobile.gui.utils.Paths.HomeReference;
 import org.crossmobile.prefs.Prefs;
 import org.crossmobile.utils.ParamList;

 import java.awt.event.ActionEvent;
 import java.io.File;

 import static org.crossmobile.utils.ParamsCommon.KEY_STORE;

 public class AndroidKeyStoreParameter extends FreeFileParameter {

     public AndroidKeyStoreParameter(ParamList list) {
         super(list, KEY_STORE.tag(), Prefs.getAndroidKeyLocation(), true, true);
         setButonPanelCallback((HiResPanel buttons) -> {
             HiResButton clear = new HiResButton("Default");
             clear.setOpaque(false);
             clear.addActionListener((ActionEvent ae) -> {
                 setFile(new File(Prefs.getAndroidKeyLocation()));
             });
             buttons.add(clear);
         });
     }

     @Override
     public String getVisualTag() {
         return "Key store location";
     }

     @Override
     public String getValue() {
         String sval = super.getValue();
         if (sval.isEmpty())
             return sval;
         return Paths.getPath(new File(properties.dereferenceValue(sval, true)), HomeReference.PROP_TO_ABS);
     }

     @Override
     protected boolean isFileAccepted(File givenFile) {
         return KeystoreManager.isKeystoreFile(givenFile);
     }
 }
