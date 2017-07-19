package com.healthyfish.healthyfish.ui.activity.appointment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.healthyfish.healthyfish.POJO.BeanWeekAndDate;
import com.healthyfish.healthyfish.POJO.Test;
import com.healthyfish.healthyfish.R;
import com.healthyfish.healthyfish.adapter.MainVpAdapter;
import com.healthyfish.healthyfish.ui.fragment.AppointmentTime;
import com.healthyfish.healthyfish.ui.fragment.AppointmentTime2;
import com.healthyfish.healthyfish.ui.fragment.AppointmentTime3;
import com.healthyfish.healthyfish.utils.FixedSpeedScroller;
import com.healthyfish.healthyfish.utils.Utils1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 描述：医生详情页面
 * 作者：WKJ on 2017/7/10.
 * 邮箱：
 * 编辑：WKJ
 */
public class DoctorDetail extends AppCompatActivity {
    private int mPosition = 0;//记录选择预约时间页面的位置
    private FixedSpeedScroller  mScroller;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.civ_doctor)
    CircleImageView civDoctor;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_DepartmentAndTitle)
    TextView tvDepartmentAndTitle;
    @BindView(R.id.tv_doctorCompany)
    TextView tvDoctorCompany;
    @BindView(R.id.ckb_attention)
    CheckBox ckbAttention;
    @BindView(R.id.btn_sendTheMind)
    Button btnSendTheMind;
    @BindView(R.id.appointment_time_vp)
    ViewPager appointmentTimeVp;
    @BindView(R.id.left)
    ImageView left;
    @BindView(R.id.duration)
    TextView duration;
    @BindView(R.id.right)
    ImageView right;
    @BindView(R.id.first)
    ImageView first;
    @BindView(R.id.second)
    ImageView second;
    @BindView(R.id.third)
    ImageView third;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        toolbarTitle.setText("xx医生");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.back_icon);
        }
        fm = this.getSupportFragmentManager();
        ft = fm.beginTransaction();


        initPointmentTime();//初始化预约时间
        pagechange();//页面改动监听
    }



    private void initPointmentTime() {
        List<BeanWeekAndDate> mList = new ArrayList<>();
//        mList.add( new BeanWeekAndDate("2017年7月9日","约满","约满"));
//        mList.add( new BeanWeekAndDate("2017年7月10日","约满","约满"));
//        mList.add( new BeanWeekAndDate("2017年7月11日","1"," 1"));
//        mList.add( new BeanWeekAndDate("2017年7月12日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月13日","约满","约满"));
        mList.add( new BeanWeekAndDate("2017年7月14日","1"," 1"));
        mList.add( new BeanWeekAndDate("2017年7月15日"," 1","下午"));
        mList.add( new BeanWeekAndDate("2017年7月16日","上午","1 "));
        mList.add( new BeanWeekAndDate("2017年7月17日","约满","约满"));
        mList.add( new BeanWeekAndDate("2017年7月18日","上午","下午"));
        mList.add( new BeanWeekAndDate("2017年7月19日","约满"," 1"));
        mList.add( new BeanWeekAndDate("2017年7月20日","1 ","1 "));
        mList.add( new BeanWeekAndDate("2017年7月21日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月22日","上午"," 1"));
        mList.add( new BeanWeekAndDate("2017年7月23日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年7月24日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月25日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月26日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年7月27日","上午","1 "));
        mList.add( new BeanWeekAndDate("2017年7月28日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年7月29日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月30日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年7月31日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年8月01日","上午","1 "));
        mList.add( new BeanWeekAndDate("2017年8月2日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年8月3日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年8月4日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年8月5日","上午","1 "));
        mList.add( new BeanWeekAndDate("2017年8月6日","约满","下午"));
        mList.add( new BeanWeekAndDate("2017年8月7日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年8月8日","上午","约满"));
        mList.add( new BeanWeekAndDate("2017年8月9日","上午","1 "));


        String today = Utils1.getWeekFromStr(mList.get(0).getDate());
        //判断第一个数据是一周的哪一天，在前面补相应的空位
        //确定是具体的星期几之后：
        // 1.先补相应的空位；
        // 2.以星期天为结尾分成3个list分别放到三个fragment初始化视图
        int position =0;//分配list的时候，记录已经分到哪个；
        int firstSize=0;//第一个list真实数据的size
        List<BeanWeekAndDate> list1 = new ArrayList<>();
        switch (today) {
            case "星期一":
                firstSize = 7;
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期二":
                firstSize = 6;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期三":
                //假设是
                firstSize = 5;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                list1.add(new BeanWeekAndDate("星期二",null,"1","1",true));
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期四":
                firstSize = 4;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                list1.add(new BeanWeekAndDate("星期二",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期三",null,"1","1",true));
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期五":
                firstSize = 3;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                list1.add(new BeanWeekAndDate("星期二",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期三",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期四",null,"1","1",true));
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期六":
                firstSize = 2;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                list1.add(new BeanWeekAndDate("星期二",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期三",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期四",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期五",null,"1","1",true));
                initVeiwpageFragment(mList, list1,firstSize);
                break;
            case "星期日":
                firstSize = 1;
                list1.add(new BeanWeekAndDate("星期一",null,"1","1",true));//设置占位用的
                list1.add(new BeanWeekAndDate("星期二",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期三",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期四",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期五",null,"1","1",true));
                list1.add(new BeanWeekAndDate("星期六",null,"1","1",true));
                initVeiwpageFragment(mList, list1,firstSize);
                break;
        }

    }

    private void initVeiwpageFragment(List<BeanWeekAndDate> mList, List<BeanWeekAndDate> list1,int firstSize) {
        int position;
        for (position =0; position<firstSize; position++){
            list1.add(mList.get(position));
        }
        List<BeanWeekAndDate> list2 = new ArrayList<>();
        for (int i = position;i<(position+7);i++){
            list2.add(mList.get(i));
            //position = i+1;
        }
        List<BeanWeekAndDate> list3 = new ArrayList<>();
        for (int j = (position+7);j<(position+14);j++){
            list3.add(mList.get(j));
        }
        Test test1 = new Test();
        test1.setList(list1);
        Test test2 = new Test();
        test2.setList(list2);
        Test test3 = new Test();
        test3.setList(list3);
        List<Fragment> fragments = new ArrayList<>();
        AppointmentTime fragment = new AppointmentTime();
        AppointmentTime2 fragment2 = new AppointmentTime2();
        AppointmentTime3 fragment3 = new AppointmentTime3();

        Bundle bundle1 = new Bundle();     //创建bundle来封装传递给fragment的参数
        bundle1.putSerializable("data",test1);
        fragment.setArguments(bundle1);         //设置传递的对象

        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("data2",test2);
        fragment2.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("data3",test3);
        fragment3.setArguments(bundle3);

        fragments.add(fragment);
        fragments.add(fragment2);
        fragments.add(fragment3);
        appointmentTimeVp.setOffscreenPageLimit(0);
        MainVpAdapter vpAdapter = new MainVpAdapter(getSupportFragmentManager(), fragments);
        appointmentTimeVp.setAdapter(vpAdapter);
        setDirectionIndicator();
    }


    //页面改变是重新设置圆点状态
    private void pagechange() {
        //setViewPagerSwitchingTime();
        appointmentTimeVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPosition = appointmentTimeVp.getCurrentItem();
                setDirectionIndicator();
                reSet();
                switch (position) {
                    case 0:
                        first.setBackgroundResource(R.drawable.green_point);
                        break;
                    case 1:
                        second.setBackgroundResource(R.drawable.green_point);
                        break;
                    case 2:
                        third.setBackgroundResource(R.drawable.green_point);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    //设置viewpager的切换时间
    public void setViewPagerSwitchingTime() {
        Field mField = null;
        try {
            mField =ViewPager.class.getDeclaredField("mScroller");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mField.setAccessible(true);
        mScroller = new FixedSpeedScroller(appointmentTimeVp.getContext(),new AccelerateInterpolator());
        try {
            mField.set(appointmentTimeVp, mScroller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //重置圆点状态
    private void reSet() {
        first.setBackgroundResource(R.drawable.white_point_stroke);
        second.setBackgroundResource(R.drawable.white_point_stroke);
        third.setBackgroundResource(R.drawable.white_point_stroke);
    }

    @OnClick({R.id.left, R.id.right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left:
                if (mPosition > 0) {
                    mPosition--;
                    appointmentTimeVp.setCurrentItem(mPosition);
                    setDirectionIndicator();
                    //mScroller.setmDuration(4* 100);

                }
                break;
            case R.id.right:
                if (mPosition < 2) {
                    mPosition++;
                    appointmentTimeVp.setCurrentItem(mPosition);
                    setDirectionIndicator();
                    //mScroller.setmDuration(4* 100);

                }
                break;
        }
    }

    //设置方向指示器可见与不可见状态
    private void setDirectionIndicator() {
        switch (mPosition) {
            case 0:
                left.setVisibility(View.INVISIBLE);
                break;
            case 1:
                left.setVisibility(View.VISIBLE);
                right.setVisibility(View.VISIBLE);
                break;
            case 2:
                right.setVisibility(View.INVISIBLE);
                break;
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}