package design.example.ngondo.newsfeeds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngondo on 4/27/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    /*
    * Since the adapter cannot return empty items to the view, we need to
    * return items in the getItem() and getCount() methods
    * */
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> mTitle = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    // Method that adds the fragments to the viewpager
    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        mTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
