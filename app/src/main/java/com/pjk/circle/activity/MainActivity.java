package com.pjk.circle.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.pjk.circle.R;
import com.pjk.circle.fragment.CircleFragment;
import com.pjk.circle.fragment.FriendFragment;
import com.pjk.circle.fragment.MessageFragment;
import com.pjk.circle.fragment.MineFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Fragment> fragment = new ArrayList<>();
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
    }

    private void initView() {
        fragment.add(new MessageFragment());
        fragment.add(new FriendFragment());
        fragment.add(new CircleFragment());
        fragment.add(new MineFragment());


        radioGroup = (RadioGroup) findViewById(R.id.main_rg);
        radioGroup.setOnCheckedChangeListener(checkListener);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
    }

    /**
     * RadioGroup改变监听
     */
    private RadioGroup.OnCheckedChangeListener checkListener = new RadioGroup.OnCheckedChangeListener() {
        /**
         * @param group         设置了监听的控件
         * @param checkedId     被选中的RadioButton的id
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            View child = group.findViewById(checkedId);

            int index = group.indexOfChild(child);

            Fragment mFragment = fragment.get(index);

            replaceFragment(mFragment);
        }
    };

    /**
     * 替代fragment
     *
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }

}
