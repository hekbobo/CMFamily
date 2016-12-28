package com.cmcm;

/**
 * Created by zyb on 2016/12/28.
 */

class CMInfo {

    private String mPackageName ;
    private int mCurrentVersionCode;
    private int mNewestVersion;

    CMInfo(String packageName, int version ){
        mPackageName = packageName;
        mCurrentVersionCode = version;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public int getVersionCode() {
        return mCurrentVersionCode;
    }

    public void setPackageName(String mPackageName) {
        this.mPackageName = mPackageName;
    }

    public void setCurrentVersionCode(int mCurrentVersionCode) {
        this.mCurrentVersionCode = mCurrentVersionCode;
    }

    public void setNewestVersion(int mNewestVersion) {
        this.mNewestVersion = mNewestVersion;
    }
}
