 /* (c) 2019 by Panayotis Katsaloulis
  *
  * CrossMobile is free software; you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, version 2.
  *
  * CrossMobile is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * You should have received a copy of the GNU General Public License
  * along with CrossMobile; if not, write to the Free Software
  * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
