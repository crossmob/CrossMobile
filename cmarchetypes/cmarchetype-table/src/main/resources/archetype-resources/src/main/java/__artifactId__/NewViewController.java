/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.tech
 */

package ${groupId}.${artifactId};

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

        UILabel details_label = new UILabel(new CGRect(50,100,100,50));
        details_label.setText("Details : ");

        UILabel details_text = new UILabel(new CGRect(150,100,width-100,50));
        details_text.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);

        if(model.subtitle != "")
            details_text.setText( String.join(" ", model.subtitle, String.valueOf(model.title.charAt(model.title.length() - 1)) ) );
        else
            details_text.setText("No Subtitle");

        view.addSubview(details_label);
        view.addSubview(details_text);

        setView(view);
    }
}