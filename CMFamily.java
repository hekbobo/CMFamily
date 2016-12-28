package com.cmcm;

import android.content.Context;
import android.content.pm.PackageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by zyb on 2016/12/28.
 *
 */

public class CMFamily {

    private CMFamily(){
    }

    private static final class Holder {
        private static final CMFamily sInstance = new CMFamily();
    }

    public static CMFamily get() {
        return CMFamily.Holder.sInstance;
    }

    /**
     * 返回所有CM家族可升级的app
     * @param context context
     * @param cloud 云控由宿主实现
     * @return
     */
    public List<CMInfo> getAllUpgradeableProduct(Context context, ICloudConfig cloud) {
        if (cloud == null){
            throw new NullPointerException("ICloudConfig Can not be Null");
        }

        detection(context, cloud);

        return new ArrayList<>(mCMInfo);
    }

    private boolean detection(Context context, ICloudConfig i) {

        mCMInfo.clear();

        for (String x : s_cmFamilyPackages) {
            CMInfo info = getCMInfo(context, x);
            if (info == null)
                continue;

            int newestVer = i.getNewestVersion(x);
            if (newestVer > info.getVersionCode()){
                info.setNewestVersion(newestVer);
                mCMInfo.add(info);
            }
        }

        return true;
    }

    private CMInfo getCMInfo(Context context, String packageName) {
        PackageInfo pkgInfo = PackageUtil.getPackageInfo(context, packageName);
        if (pkgInfo != null) {
            return new CMInfo(packageName, pkgInfo.versionCode);
        }
        return null;
    }


    private List<CMInfo> mCMInfo = new ArrayList<>();

    private final String[] s_cmFamilyPackages = new String[]{
            "com.cmcm.locker",
            "com.mobilesrepublic.appy",
            "com.cmcm.indianews_us",
            "com.cleanmaster.security",
            "com.cleanmaster.security_cn",
            "com.cleanmaster.mguard",
            "com.cleanmaster.mguard_x86",
            "com.cleanmaster.mguard_cn",
            "com.ijinshan.kbatterydoctor_en",
            "com.ijinshan.kbatterydoctor",
            "com.ksmobile.launcher",
            "com.boostcharge.standard",
            "com.boostcharge.standard.nongp",
            "com.boostcharge.standard.launcher",
            "com.boostcharge.standard.launcher.nongp",
            "com.boostcharge.samsung",
            "com.cmcm.lite",
            "com.roidapp.photogrid"
    };

}
