package it.amonshore.prjcmkv2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by narsenico on 31/05/17.
 */

public abstract class DataProvider {

    interface OnNotificationListener {

        void onComicsAdded(Comics ...comics);

        void onComicsRemoved(Comics ...comics);

        void onComicsUpdated(Comics ...comics);
    }

    private ArrayList<OnNotificationListener> mOnNotificationListeners;

    protected DataProvider() {
        mOnNotificationListeners = new ArrayList<>();
    }

    protected List<OnNotificationListener> getOnNotificationListeners() {
        return mOnNotificationListeners;
    }

    public void addOnNotificaitonListener(OnNotificationListener listener) {
        mOnNotificationListeners.add(listener);
    }

    public void removeNotificationListener(OnNotificationListener listener) {
        mOnNotificationListeners.remove(listener);
    }
}
