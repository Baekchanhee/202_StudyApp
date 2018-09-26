package cau.study_202.member;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cau.study_202.R;
import cau.study_202.Search_Studyboard;

public class MemberActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    MemberAdapter myAdapter;
    MemberList mMemberList = new MemberList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_member_list);

        //화면회전 금지
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        //Toolbar 적용하기 위해서 .HomeActivity Theme 제거(AndroidManifest에서)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_member);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RecycleView이용 멤버 생성
        mRecyclerView = findViewById(R.id.recycle_member);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //실험용 데이터
        mMemberList.addMember(new Member("baekinhyuk","백인혁","Inhyuk","01012345678","bih94@hanmail.net","1994-06-18"));
        mMemberList.addMember(new Member("UserId","백인혁2","Inhyuk3","01012345678","bih94@hanmail2.net","1994-06-18"));
        mMemberList.addMember(new Member("baekinhyu2k","백인혁3","Inhyuk4","01012345678","bih94@hanmail3.net","1994-06-18"));
        mMemberList.addMember(new Member("baekinhyu2k","백인혁4","Inhyuk4","01012345678","bih94@hanmail3.net","1994-06-18"));
        mMemberList.addMember(new Member("baekinhyu2k","백인혁5","Inhyuk4","01012345678","bih94@hanmail3.net","1994-06-18"));
        mMemberList.addMember(new Member("baekinhyu2k","백인혁6","Inhyuk4","01012345678","bih94@hanmail3.net","1994-06-18"));
        mMemberList.addMember(new Member("baekinhyu2k","백인혁7","Inhyuk4","01012345678","bih94@hanmail3.net","1994-06-18"));

        myAdapter = new MemberAdapter(mMemberList);

        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_member);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_right, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_searchstudy) {
            Intent i = new Intent(MemberActivity.this,
                    Search_Studyboard.class);
            startActivity(i);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_viewstudy) {

        } else if (id == R.id.nav_member) {

        } else if (id == R.id.nav_attendence) {

        } else if (id == R.id.drawer_menu_profile) {

        } else if (id == R.id.drawer_menu_login) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_member);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    return true;
                case R.id.bottom_nav_room_list:
                    return true;
                case R.id.bottom_nav_reserved_list:
                    return true;
            }
            return false;
        }
    };
}
