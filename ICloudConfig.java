package com.cmcm;

/**
 *
 * Created by zyb on 2016/12/28.
 *
 */

public interface ICloudConfig {

    /**
     *
     * @param packageName 。
     * @return 失败请返回 -1
     */
    int getNewestVersion(String packageName);
}
