/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.foundation.NSIndexPath;
import crossmobile.ios.uikit.*;

import java.util.List;

public class ViewController extends UIViewController implements UITableViewDelegate, UITableViewDataSource {
    private List<DataModel> items = DataModelFactory.getData();

    @Override
    public void loadView() {
        UITableView tableView = new UITableView();
        tableView.setDelegate(this);
        tableView.setDataSource(this);
        setView(tableView);
    }

    @Override
    public UITableViewCell cellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell tvc = tableView.dequeueReusableCellWithIdentifier("ID");
        return tvc != null ? tvc : new UITableViewCell(UITableViewCellStyle.Subtitle, "ID");
    }

    @Override
    public void willDisplayCell(UITableView tableview, UITableViewCell cell, NSIndexPath indexPath) {
        DataModel item = items.get(indexPath.row());
        cell.textLabel().setText(item.title);
        cell.detailTextLabel().setText(item.subtitle);
    }

    @Override
    public void didSelectRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
        DataModel item = items.get(indexPath.row());
        navigationController().pushViewController(new NewViewController(item), true);
    }

    @Override
    public int numberOfSectionsInTableView(UITableView table) {
        return 1;
    }

    @Override
    public int numberOfRowsInSection(UITableView tableView, int section) {
        return items.size();
    }
}
