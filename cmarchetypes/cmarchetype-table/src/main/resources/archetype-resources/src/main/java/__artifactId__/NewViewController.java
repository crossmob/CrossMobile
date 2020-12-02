/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;

public class NewViewController extends UIViewController {
    private final DataModel model;

    public NewViewController(DataModel model){
        this.model = model;
    }

    @Override
    public void loadView(){
        float width = (float) UIScreen.mainScreen().bounds().getSize().getWidth();

        UIView view = new UIView();
        view.setBackgroundColor(UIColor.whiteColor());

        UILabel detailsLabel = new UILabel(new CGRect(50,100,100,50));
        detailsLabel.setText("Details : ");

        UILabel detailsText = new UILabel(new CGRect(150,100,width-100,50));
        detailsText.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);

        if(model.subtitle != "")
            detailsText.setText(model.subtitle + " " + model.title.charAt(model.title.length() - 1));
        else
            detailsText.setText("No Subtitle");

        view.addSubview(detailsLabel);
        view.addSubview(detailsText);

        setView(view);
    }
}
