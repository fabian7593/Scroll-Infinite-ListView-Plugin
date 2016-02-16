package com.frosquivel.scrollinfinite;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

/**
 * Created by          Fabián Rosales Esquivel
 * Visit my web page   http://www.frosquivel.com
 * Visit my blog       http://www.frosquivel.com/blog
 * Created Date        on 2/15/16
 * This is an android library to have infinite scrolling method.
 * This is the ScrollInfiniteListener class.
 * This listen for a scroll movement to the bottom
 */
public class ScrollInfiniteListener implements AbsListView.OnScrollListener {

    //The adapter of scroll infinite
    ScrollInfiniteAdapter adapter;
    //A variable handler for have a proccess in second plain.
    private Handler handler;
    //A simple progress bar :D
    private ProgressBar progressBar;
    //The variable to post delay in miliseconds of the load of other items.
    private int postDelay;


    /**
     * The construct method of ScrollInfiniteListener
     * @param adapter your ScrollInfiniteAdapter
     * @param progressBar your ProgressBar
     */
    public ScrollInfiniteListener(ScrollInfiniteAdapter adapter,ProgressBar progressBar){
        this.adapter = adapter;
        this.progressBar = progressBar;
        this.handler = new Handler();
        this.postDelay = 300;
    }

    /**
     * Another construct method of ScrollInfiniteListener with post delay variable
     * @param adapter your ScrollInfiniteAdapter
     * @param progressBar your ProgressBar
     * @param postDelayed int of post delay of charge.
     */
    public ScrollInfiniteListener(ScrollInfiniteAdapter adapter,ProgressBar progressBar,int postDelayed){
        this.adapter = adapter;
        this.progressBar = progressBar;
        this.handler = new Handler();
        this.postDelay = postDelayed;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //check if we've reached the bottom
        if(firstVisibleItem + visibleItemCount == totalItemCount && !adapter.endReached() && !hasCallback){
            //show more item with the post delay that you defined
            handler.postDelayed(showMore, this.postDelay);
            hasCallback = true;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {}

    //create a thread with a handler to show the progress bar load...
    private boolean hasCallback;
    private Runnable showMore = new Runnable(){
        public void run(){
            boolean noMoreToShow = adapter.showMore(); //show more items in the listview
            progressBar.setVisibility(noMoreToShow? View.GONE : View.VISIBLE);
            hasCallback = false;
        }
    };

}
