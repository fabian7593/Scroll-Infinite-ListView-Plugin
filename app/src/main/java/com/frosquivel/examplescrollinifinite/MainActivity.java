package com.frosquivel.examplescrollinifinite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

//irt com.frosquivel.scrollinfinite.ScrollInfiniteAdapter;
//import com.frosquivel.scrollinfinite.ScrollInfiniteListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Create the relation of your layout and your progress bar
        View footer = getLayoutInflater().inflate(R.layout.progress_bar, null);
        progressBar = (ProgressBar) footer.findViewById(R.id.progressBar);

        //Create the relation of lisView and add progress bar in the footer.
        listView = (ListView) findViewById(R.id.listView);
        listView.addFooterView(footer);

        //For the example only add 100 items in the list.
        List<Object> valueExample = new ArrayList<Object>();
        for(int x=1; x<=100 ; x++){
            valueExample.add(Integer.toString(x) + "     www.frosquivel.com    :D ");
        }

        //create a new instace of ScrollInfiniteAdapter, pass the next values:
        //the current context, the list of values, the layout of the item row of listview, quantity to show the list view in the first load
        //and the quantity of load the list view when the scroll is move to the bottom.

        //The user need to override the getview, for load data in the items of row, remember your data lists are of Object class,
        //you need to convert this in the class that you needed.
        //pd: (is not necesary call the super method)
       /* ScrollInfiniteAdapter adapter = new ScrollInfiniteAdapter(this, valueExample, R.layout.activity_row_item_list, 16, 10){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view=null;
                Object obj = getItem(position);

                if(convertView == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.activity_row_item_list, null);
                    view.setTag(view.findViewById(R.id.textView));
                }else{
                    view = convertView;
                }

                TextView textView = (TextView) view.getTag();
                textView.setText(obj.toString());

                return view;
            }
        };

        //set the adapter in the listView
        listView.setAdapter(adapter);


        //call the new instance class of ScrollInfiniteListener, you need to pass the adapter and the progressBar.
        listView.setOnScrollListener(new ScrollInfiniteListener(adapter, progressBar));

*/
        //in otherwise you call the same class, but you set the delay of progressBar, with another param.
        //like this
        //listView.setOnScrollListener(new ScrollInfiniteListener(adapter,progressBar,600));
    }
}
