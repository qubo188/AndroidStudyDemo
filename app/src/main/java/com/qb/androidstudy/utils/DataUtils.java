package com.qb.androidstudy.utils;

import java.util.ArrayList;

/**
 * 项目名称：AndroidStudy
 * 类描述：
 * 创建人：qubo
 * 创建时间：2015/11/3 0003 下午 3:04
 */
public class DataUtils {

    /**
     * @param length
     * @return  Generate Data
     */
    public static ArrayList<String> generateData(int length){

        ArrayList<String> data = new ArrayList<String>();

        for (int i = 0; i < length; i++) {
            data.add("数据 <" + i + ">");
        }

        return data;
    }


}
