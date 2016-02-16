package com.frosquivel.scrollinfinite;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by          Fabián Rosales Esquivel
 * Visit my web page   http://www.frosquivel.com
 * Visit my blog       http://www.frosquivel.com/blog
 * Created Date        on 2/15/16
 * This is an android library to have infinite scrolling method.
 * This is the ScrollInfiniteAdater class, you need to override the getView function
 * for load data in the item of the listview.
 */
public class ScrollInfiniteAdapter extends ArrayAdapter<Object> {

    //the values that you need to shown in the listview.
    private List<Object> values;
    // this value is calculate with a math min, dont worry to this :D.
    private int totalCount;
    //Show step by step the quantity of item to show, when the scroll get to the "final".
    private int stepByStep;
    //The quantity of item if you need to show in the first chargue.
    private int firstCountToShow;

    /**
     * This is the constructor method of the class
     * @param context the context that you come, to call the super of the class.
     * @param values the list of items that you need to load in the listview
     * @param rowlayout the layout of row items, to call the super of the class
     * @param firstCountToShow the quantity that you need to show in the first load of the listview
     * @param stepByStep the quantity that you need to load when the user get in the "final" of the list.
     */
    public ScrollInfiniteAdapter(Activity context, List<Object> values,int rowlayout, int firstCountToShow, int stepByStep) {
        super(context, rowlayout, values);
        this.values = values;
        this.firstCountToShow = Math.min(firstCountToShow, values.size()); //don't try to show more views than we have
        this.totalCount = this.firstCountToShow;
        this.stepByStep = stepByStep;
    }

    /**
     * @return the quantity of items showing in the list view.
     */
    @Override
    public int getCount() {
        return totalCount;
    }

    /**
     * This method override is for load the data of the list in the items of the listview,
     * but in this case you have to write this override when you create a intance of this class.
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        return view;
    }

    /**
     * If the values list have more data to shown return true, against of this return false
     */
    public boolean showMore(){
        if(totalCount == values.size()) {
            return true;
        }else{
            totalCount = Math.min(totalCount + stepByStep, values.size()); //don't go past the end
            notifyDataSetChanged(); //notify when the data count has changes.
            return endReached();
        }
    }

    /**
     * @return true if then entire data set is being displayed, false otherwise
     */
    public boolean endReached(){
        return totalCount == values.size();
    }

    /**
     * reset the count number
     */
    public void reset(){
        totalCount = firstCountToShow;
        notifyDataSetChanged();
    }
}
