/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

/**
 * SKPaymentTransactionObserver class defines an object that is responsible for
 * handling transactions that are removed or updated within the queue.
 */
@CMClass
public interface SKPaymentTransactionObserver {

    /**
     * It is used when one or more transactions of the queue have been updated.
     *
     * @param queue        The queue of the updated transactions.
     * @param transactions The list of the updated transactions.
     */
    @CMSelector("- (void)paymentQueue:(SKPaymentQueue *)queue \n" +
            " updatedTransactions:(NSArray<SKPaymentTransaction *> *)transactions;")
    public abstract void updatedTransactions(SKPaymentQueue queue, List<SKPaymentTransaction> transactions);

    /**
     * It is used when one or more transactions have been removed from the
     * queue.
     *
     * @param queue        The queue of the transactions that have been removed.
     * @param transactions The list of the removed transactions.
     */
    @CMSelector("- (void)paymentQueue:(SKPaymentQueue *)queue \n" +
            " removedTransactions:(NSArray<SKPaymentTransaction *> *)transactions;\n" +
            "")
    default void removedTransactions(SKPaymentQueue queue, List<SKPaymentTransaction> transactions) {
    }

    /**
     * It is used when during transaction an error occurs.
     *
     * @param queue The queue that is involved in the transaction.
     * @param error The error that occurred.
     */
    @CMSelector("- (void)paymentQueue:(SKPaymentQueue *)queue \n" +
            "restoreCompletedTransactionsFailedWithError:(NSError *)error;")
    default void restoreCompletedTransactionsFailedWithError(SKPaymentQueue queue, NSError error) {
    }

    /**
     * It is used when the queue completed the sending restored transactions.
     *
     * @param queue The queue that sent restored transactions.
     */
    @CMSelector("- (void)paymentQueueRestoreCompletedTransactionsFinished:(SKPaymentQueue *)queue;")
    default void restoreCompletedTransactionsFinished(SKPaymentQueue queue) {
    }
}
