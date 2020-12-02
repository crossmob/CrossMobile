/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;
import org.robovm.objc.block.VoidBlock1;

import static ${groupId}.${artifactId}.I18n._l;

public class ViewController extends UIViewController {

    private UILabel orangeLabel, appleLabel;
    private int orangesV = 0;
    private int basketsV = 0;

    @Override
    public void loadView() {
        UIView mainView = new UIView(new CGRect(0, 0, 320, 400));
        mainView.setBackgroundColor(UIColor.colorWithWhiteAlpha(0.9f, 1));

        // Simple localization
        UILabel simpleInfo = new UILabel(new CGRect(10, 35, 300, 40));
        simpleInfo.setNumberOfLines(2);
        simpleInfo.setFont(UIFont.italicSystemFontOfSize(15));
        simpleInfo.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        simpleInfo.setTextAlignment(NSTextAlignment.Center);
        simpleInfo.setText("Simple localization - change system language");

        UILabel hello = new UILabel(new CGRect(0, 80, 320, 20));
        hello.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        hello.setTextAlignment(NSTextAlignment.Center);
        hello.setText(_l("Hello world"));   // take a note at the _l method!


        // Advances localization with support for plurals
        UILabel advInfo = new UILabel(new CGRect(10, 135, 300, 40));
        advInfo.setNumberOfLines(2);
        advInfo.setFont(UIFont.italicSystemFontOfSize(15));
        advInfo.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        advInfo.setTextAlignment(NSTextAlignment.Center);
        advInfo.setText("Advanced localization - only active under en/el locale");

        appleLabel = new UILabel(new CGRect(20, 215, 320, 20));
        UIView apples = initControls(180, "Apples", this::updateApples);
        updateApples(0);

        orangeLabel = new UILabel(new CGRect(20, 325, 320, 20));
        UIView baskets = initControls(260, "Baskets", basket -> updateOranges(orangesV, basket));
        UIView oranges = initControls(290, "Oranges", orange -> updateOranges(orange, basketsV));
        updateOranges(0, 0);


        mainView.addSubview(hello);
        mainView.addSubview(simpleInfo);
        mainView.addSubview(advInfo);
        mainView.addSubview(appleLabel);
        mainView.addSubview(orangeLabel);
        mainView.addSubview(apples);
        mainView.addSubview(baskets);
        mainView.addSubview(oranges);
        setView(mainView);
    }

    // Localize apple's label
    private void updateApples(int apples) {
        appleLabel.setText(_l("I have some apples", apples));
    }

    // Localize oranges-in-basket's label
    private void updateOranges(int oranges, int baskets) {
        this.orangesV = oranges;
        this.basketsV = baskets;
        orangeLabel.setText(_l("I have some oranges in basket", baskets, oranges));
    }

    private UIView initControls(double y, String name, VoidBlock1<Integer> callback) {
        UIStepper stepper = new UIStepper(new CGRect(0, 0, 100, 20));
        stepper.setMinimumValue(0);
        stepper.setMaximumValue(99);
        stepper.setValue(0);

        UILabel label = new UILabel(new CGRect(110, 0, 150, 20));
        label.setText(name + ": 0");
        stepper.addTarget((c, e) -> {
            int value = (int) Math.round(stepper.value());
            label.setText(name + ": " + value);
            callback.invoke(value);
        }, UIControlEvents.ValueChanged);

        UIView bundle = new UIView(new CGRect(20, y, 260, 30));
        bundle.addSubview(stepper);
        bundle.addSubview(label);
        return bundle;
    }
}
