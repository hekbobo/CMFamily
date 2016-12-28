package com.cmcm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

public class PackageUtil {


    public static PackageInfo getPackageInfo(Context context, String pkgName) {
        if (TextUtils.isEmpty(pkgName)) {
            return null;
        }

        try {
            PackageInfo pkgInfo = context.getPackageManager().getPackageInfo(pkgName, 0);
            if (pkgInfo != null) {
                return pkgInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean isPkgInstalled(Context context, String pkgName) {
        return getPackageInfo(context, pkgName) != null;
    }

    public static int getVersionCode(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            return -1;
        }
    }
}
