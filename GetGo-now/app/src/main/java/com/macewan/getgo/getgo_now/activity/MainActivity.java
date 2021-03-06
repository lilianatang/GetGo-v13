package com.macewan.getgo.getgo_now.activity;

import com.macewan.getgo.getgo_now.UIPages.ResultPage;
import com.macewan.getgo.getgo_now.UIPages.SearchPage;
import com.macewan.getgo.getgo_now.helper.*;
import com.macewan.getgo.getgo_now.activity.*;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.helper.SQLiteHandler;
import com.macewan.getgo.getgo_now.helper.SessionManager;
import com.macewan.getgo.getgo_now.adapter.*;
import com.macewan.getgo.getgo_now.courses_drop_down.CoursesActivity;
import com.macewan.getgo.getgo_now.helper.*;
import com.macewan.getgo.getgo_now.fragments.*;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.macewan.getgo.getgo_now.R;

public class MainActivity extends AppCompatActivity {
	/* for Log Out */
	private SQLiteHandler db;
	private SessionManager session;
	private static final String TAG = "MainActivity";

	private SectionsPageAdapter mSectionsPageAdapter;

	private ViewPager mViewPager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.container);
		setupViewPager(mViewPager);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(mViewPager);


		tabLayout.getTabAt(0).setIcon(R.drawable.ic_assignment);
		tabLayout.getTabAt(1).setIcon(R.drawable.ic_autorenew);
		tabLayout.getTabAt(2).setIcon(R.drawable.ic_attach_file);

		BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
		BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
		Menu menu = bottomNavigationView.getMenu();
		MenuItem menuItem = menu.getItem(0);
		menuItem.setChecked(true);

		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()){
					case R.id.ic_arrow:
						Intent intent0 = new Intent(MainActivity.this, LoginActivity.class);
						startActivity(intent0);
						break;

					case R.id.ic_books:
						Intent intent2 = new Intent(MainActivity.this, CoursesActivity.class);
						startActivity(intent2);
						break;

					case R.id.ic_center_focus:
						Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
						startActivity(intent3);
						break;
				}


				return false;
			}
		});

	}

	/**
	 * Logging out the user. Will set isLoggedIn flag to false in shared
	 * preferences Clears the user data from sqlite users table
	 * */
	private void logoutUser() {
		session.setLogin(false);

		db.deleteUsers();

		// Launching the login activity
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}

	private void setupViewPager(ViewPager viewPager) {
		SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
		adapter.addFragment(new Tab1Fragment());
		adapter.addFragment(new Tab2Fragment());
		adapter.addFragment(new Tab3Fragment());
		viewPager.setAdapter(adapter);
	}

}
