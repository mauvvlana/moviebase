package com.maul.moviebase.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class StackWidget extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemote(this.getApplicationContext(), intent);
    }
}
