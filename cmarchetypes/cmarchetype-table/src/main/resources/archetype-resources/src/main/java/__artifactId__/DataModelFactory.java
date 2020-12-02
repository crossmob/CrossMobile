/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.foundation.NSBundle;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSJSONSerialization;
import crossmobile.ios.foundation.NSObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataModelFactory extends NSObject {

    public static List<DataModel> getData() {
        NSData jsonData = NSData.dataWithContentsOfFile(NSBundle.mainBundle().pathForResource("data", "json"));
        @SuppressWarnings("unchecked")
        List<Map<String, String>> rawData = (List<Map<String, String>>) NSJSONSerialization.JSONObjectWithData(jsonData, 0, null);
        List<DataModel> result = new ArrayList<>();
        for (Map<String, String> entry : rawData)
            result.add(new DataModel(entry.get("title"), entry.get("sub")));
        return result;
    }
}
