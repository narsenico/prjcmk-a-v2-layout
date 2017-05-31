package it.amonshore.prjcmkv2;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by narsenico on 31/05/17.
 */

class GroupListHelper {

    static class GroupItemViewHolder extends RecyclerView.ViewHolder {
        GroupItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class GroupListAdapter extends RecyclerView.Adapter<GroupListHelper.GroupItemViewHolder> {

    }

    private GroupListHelper() {

    }

}
