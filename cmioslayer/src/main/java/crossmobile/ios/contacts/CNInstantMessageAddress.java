/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class CNInstantMessageAddress extends NSObject {

    private String service;
    private String username;

    @CMGetter("@property(readonly, copy, nonatomic) NSString *service;")
    public String service() {
        return service;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *username;")
    public String username() {
        return username;
    }

    @CMConstructor("- (instancetype)initWithUsername:(NSString *)username \n"
            + "                         service:(NSString *)service;")
    public CNInstantMessageAddress(String username, String service) {
        this.username = username;
        this.service = service;
    }

}
