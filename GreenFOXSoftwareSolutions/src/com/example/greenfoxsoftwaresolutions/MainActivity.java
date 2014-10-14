package com.example.greenfoxsoftwaresolutions;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

public class MainActivity extends FragmentActivity implements TabListener {

	ViewPager vp;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		vp = (ViewPager) findViewById(R.id.pager);
		vp.setAdapter(new MyAdapter(getSupportFragmentManager()));

		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				if(arg0 == ViewPager.SCROLL_STATE_IDLE){
					
				}
				if(arg0 == ViewPager.SCROLL_STATE_DRAGGING){
					
				}
				if(arg0 == ViewPager.SCROLL_STATE_SETTLING){
					
				}
			}
		});
		
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Tab 1");
		tab1.setTabListener(this);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Tab 2");
		tab2.setTabListener(this);

		ActionBar.Tab tab3 = actionBar.newTab();
		tab3.setText("Tab 3");
		tab3.setTabListener(this);

		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Log.d("VIVZ", "onTabSelected at " + " position " + tab.getPosition()
		//		+ " name " + tab.getText());
		vp.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Log.d("VIVZ", "onTabUnselected at " + " position " + tab.getPosition()
		//		+ " name " + tab.getText());

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Log.d("VIVZ", "onTabReselected at " + " position " + tab.getPosition()
		//		+ " name " + tab.getText());
	}

}

class MyAdapter extends FragmentPagerAdapter {
	public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub

		Fragment fragment = null;
		if (arg0 == 0) {
			fragment = new HomeFragment();
		}
		if (arg0 == 1) {
			fragment = new ProjectsFragment();
		}
		if (arg0 == 2) {
			fragment = new ContactFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
