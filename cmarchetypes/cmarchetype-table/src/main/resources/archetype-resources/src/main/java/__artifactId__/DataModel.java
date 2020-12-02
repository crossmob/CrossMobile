/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

public class DataModel {
    public final String title;
    public final String subtitle;

    @SuppressWarnings("WeakerAccess")
    public DataModel(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle == null ? "" : subtitle;
    }
}
