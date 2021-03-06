# [Scroll Infinite ListView](https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin)

This is a plugin of Infinite Sroll in the ListView Android.
<br><br>

## SDK
* It requires **14+ API**.
* The compile version is **API 23**.
* It requires **android support v7 (Toolbar)**.

<br><br>

## Getting Started

### Download Sources
use git (sourcetree or others)

```bash
git clone https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin.git
```

Or download from [Here](https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin/zipball/master)

And another type download by Bintray from [ ![Download](https://api.bintray.com/packages/fabian7593/maven/Scroll-Infinite/images/download.svg) ](https://bintray.com/fabian7593/maven/Scroll-Infinite/_latestVersion)

<br><br>
### How to use

If you want use this library, you only have to download Scroll Infinite List View project, import it into your current project and add this project as a library in your android project settings. But this is also boring.

If you prefer it for fastest and easier add library to your project, you can use the gradle dependency, you have to add these lines in your build.gradle file:

```bash
repositories {
....
    jcenter()
}

dependencies {
....
    compile 'com.frosquivel:scrollinfinite:2.0'
}
```

<br><br>
## Usage
The method of use this is the next.
You don't need the Adapter class for your list view, only need, the progress bar, and the Listview in your layout.<br>

####Description Example
This example have any quantity of objects in a Array Adapter, this array adapter was added in your list view ListView

####The layout example
![LayoutExample](scroll.jpg)



####Code Implementation
This is only for example, you need to convert the Object for the respective class do you need, in this case, String.
You need override the getView for add data into GUI component of the cell of listView.
<br>
The variable YourObjectList is a List, for this example:
```bash
List<Object> YourObjectList = new ArrayList<Object>();
        for(int x=1; x<=100 ; x++){
            YourObjectList.add(Integer.toString(x) + "     www.frosquivel.com    :D ");
        }
```

<br>
And the implementation is, first realize the import

```bash
import com.frosquivel.scrollinfinite.ScrollInfiniteAdapter;
import com.frosquivel.scrollinfinite.ScrollInfiniteListener;
```

<br>
and second create an instance:

```bash
 ScrollInfiniteAdapter adapter = new ScrollInfiniteAdapter(this, YourObjectList, R.layout.activity_row_item_list, 16, 10){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // this is only for example you need to convert the Object for the respective class, in this case, String
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

        listView.setAdapter(adapter);
        listView.setOnScrollListener(new ScrollInfiniteListener(adapter, progressBar));
```


<br><br>
##Documentation
All the code has a internal documentation for more explanation of this example.

<br><br>
##Preview of Example
![alt tag](https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin/blob/master/video.gif)


<br><br>
## License
Source code can be found on [github](https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin)<br>
Licenced under [APACHE 2.0](http://www.apache.org/licenses/LICENSE-2.0).
<br><br>

## About Developer
Developed by [Fabian Rosales](http://www.frosquivel.com)<br>
Known as [Frosquivel Developer](http://www.frosquivel.com)<br>
Web Page [www.frosquivel.com](http://www.frosquivel.com)<br>
Blog (Spanish) [www.frosquivel.com/blog](http://www.frosquivel.com/blog)<br>


