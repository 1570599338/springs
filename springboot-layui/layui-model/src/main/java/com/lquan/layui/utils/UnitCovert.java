package com.lquan.layui.utils;

public class UnitCovert {

    private static int conversion=1024;

    /**
     *
     * @param kb传递的以kb为单位的内存数量
     * @return 返回的String类型的以GB为单位的内存量
     * 将单位为kb的数据转换为单位为GB，并保留两位小数以String类型返回
     */
    public static String kbToGBString(long kb) {
        double gb=kb/(conversion*conversion*conversion*1.0);
        return String.format("%.2f", gb)+"GB";
    }
    /**
     *
     * @param mb传递的以mb为单位的内存数量
     * @return 返回的String类型的以GB为单位的内存量
     * 将单位为mb的数据转换为单位为GB，并保留两位小数以String类型返回
     */
    public  static String mbToGBString(long mb) {
        double gb=mb/(conversion*conversion*1.0);
        return String.format("%.2f", gb)+"GB";
    }
    /**
     *
     * @param Kb传递的以Kb为单位的内存数量
     * @return 返回的String类型的以MB为单位的内存量
     * 将单位为Kb的数据转换为单位为MB，并保留两位小数以String类型返回
     */
    public  static String kbToMBString(long Kb) {
        double gb=Kb/(conversion*conversion*1.0);
        return String.format("%.2f", gb)+"MB";
    }

    public  static String retain2(double n) {
        return String.format("%.2f", n);
    }

}
