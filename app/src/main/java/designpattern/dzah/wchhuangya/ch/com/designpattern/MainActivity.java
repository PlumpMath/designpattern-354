package designpattern.dzah.wchhuangya.ch.com.designpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import designpattern.dzah.wchhuangya.ch.com.designpattern.activity.AdapterPatternActivity;
import designpattern.dzah.wchhuangya.ch.com.designpattern.activity.SimpleFactoryPatternActivity;
import designpattern.dzah.wchhuangya.ch.com.designpattern.activity.StrategyPatternActivity;

public class MainActivity extends BaseActivity {
    public static final String TAG_FACTORY = "TAG_FACTORY";
    public static final String TAG_STRATEGY = "TAG_STRATEGY";
    /** 列表中显示的一级数据 */
    private List<Map<String, Object>> mDataList = new ArrayList<>();
    /** 列表中显示的非一级数据 */
    private Map<String, List<Map<String, Object>>> mDataMap = new HashMap<>();
    /** 键值：标题 */
    public static final String KEY_TITLE = "TITLE";
    /** 键值：Activity的class */
    public static final String KEY_ACTIVITY = "ACTIVITY";
    /** 键值：是否有子列表 */
    public static final String KEY_HAS_CHILD = "HAS_CHILD";
    /** 键值：子列表的TAG */
    public static final String KEY_TAG = "TAG";
    /** 适配器二级目录 TAG */
    public static final String TAG_ADAPTER = "ADAPTER";
    /** 记录访问历史的Stack */
    private Stack<List<Map<String, Object>>> mHistoryStack = new Stack<>();
    /** 标识是否退出的变量 */
    private boolean ifExit = false;

    /** 显示数据的ListView */
    private ListView mListView;
    /** 列表使用的适配器 */
    private SimpleAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        // 初始化一级数据
        initDataList();
        // 初始化一级以下数据
        initDataMap();
        // 记录访问历史的根
        mHistoryStack.push(mDataList);

        // 初始化ListView
        initListView();
    }

    /** 初始化ListView */
    private void initListView() {
        mListView = (ListView) findViewById(R.id.main_listview);

        mAdapter = new SimpleAdapter(MainActivity.this, mDataList, android.R.layout.simple_list_item_1, new String[]{KEY_TITLE}, new int[]{android.R.id.text1});
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> map = mDataList.get(i);

                if (((boolean)map.get(KEY_HAS_CHILD))) { // 如果有下级
                    mDataList = mDataMap.get(map.get(KEY_TAG));
                    mHistoryStack.push(mDataMap.get(map.get(KEY_TAG)));
                    mAdapter = new SimpleAdapter(MainActivity.this, mDataList, android.R.layout.simple_list_item_1, new String[]{KEY_TITLE}, new int[]{android.R.id.text1});
                    mListView.setAdapter(mAdapter);
                } else { // 如果没有下级,直接打开页面
                    if (map.get(KEY_ACTIVITY) instanceof String) {
                        Toast.makeText(MainActivity.this, "功能建设中……", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, (Class<?>) map.get(KEY_ACTIVITY));
                        startActivity(intent);
                    }
                }
            }
        });
    }

    /** 初始化一级数据 */
    private void initDataList() {
        addFirstLevelData("适配器模式", true, "", TAG_ADAPTER);
        addFirstLevelData("工厂模式", true, "", TAG_FACTORY);
        addFirstLevelData("策略模式", true, "", TAG_STRATEGY);
    }

    /** 初始化一级以下的数据 */
    private void initDataMap() {
        initAdapterDataMap();
        initFactoryDataMap();
        initStrategyDataMap();
    }

    /** 初始化适配器二级数据 */
    private void initAdapterDataMap() {
        List<Map<String, Object>> list = new ArrayList<>();

        list.add(addOtherLevelData("类适配器模式", false, "", ""));
        list.add(addOtherLevelData("对象适配器模式", false, AdapterPatternActivity.class, ""));

        mDataMap.put(TAG_ADAPTER, list);
    }

    private void initFactoryDataMap() {
        List<Map<String, Object>> list = new ArrayList<>();

        list.add(addOtherLevelData("简单工厂模式", false, SimpleFactoryPatternActivity.class, ""));

        mDataMap.put(TAG_FACTORY, list);
    }

    private void initStrategyDataMap() {
        List<Map<String, Object>> list = new ArrayList<>();

        list.add(addOtherLevelData("策略模式", false, StrategyPatternActivity.class, ""));

        mDataMap.put(TAG_STRATEGY, list);
    }

    private void addFirstLevelData(String title, boolean hasChild, Object activity, String tag) {
        Map<String, Object> map = new HashMap<>();

        map.put(KEY_TITLE, title);
        map.put(KEY_HAS_CHILD, hasChild);
        map.put(KEY_ACTIVITY, activity);
        map.put(KEY_TAG, tag);

        mDataList.add(map);
    }

    private Map<String, Object> addOtherLevelData(String title, boolean hasChild, Object activity, String tag) {
        Map<String, Object> map = new HashMap<>();

        map.put(KEY_TITLE, title);
        map.put(KEY_HAS_CHILD, hasChild);
        map.put(KEY_ACTIVITY, activity);
        map.put(KEY_TAG, tag);

        return map;
    }


    @Override
    public void onBackPressed() {
        if (mHistoryStack.size() > 1) {
            mHistoryStack.pop();
            mDataList = mHistoryStack.peek();
            mAdapter = new SimpleAdapter(MainActivity.this, mDataList, android.R.layout.simple_list_item_1, new String[]{KEY_TITLE}, new int[]{android.R.id.text1});
            mListView.setAdapter(mAdapter);
        } else {
            if (!ifExit) {
                ifExit = true;
                // ========  显示再按一次的提示  ==============   //
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ifExit = false;
                    }
                }, 2000);
            } else
                super.onBackPressed();
        }
    }
}
