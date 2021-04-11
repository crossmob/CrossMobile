package crossmobile.ios.foundation;

import org.crossmobile.bind.system.DispatchQueue;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMFunction;

@CMClass
public final class Dispatch extends NSObject {
    private static final Dispatch mainQueue = new Dispatch(DispatchQueue.createMainRunLoopDispatchQueue());

    private final DispatchQueue dispatchQueue;

    private Dispatch(DispatchQueue dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @CMFunction("id dispatch_get_main_queue(void);")
    public static Dispatch dispatch_get_main_queue() {
        return mainQueue;
    }

    @CMFunction("void dispatch_async(id queue, void (^)(void) block);")
    public void dispatch_async(Runnable block) {
        dispatchQueue.async(block);
    }
}
