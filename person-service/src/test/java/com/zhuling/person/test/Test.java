package com.zhuling.person.test;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File dir = new File("/Users/zhuling/projects/actionsoft/release/doccenter/com.actionsoft.apps.addons.invoice/invoicePDF/admin/c9c38bf1-7c30-0001-b4aa-72ad17cf35e0");
        String s = queryFileRealName(dir, "888_999.png");
        String s2 = queryFileRealName(dir, "222_999.png");
        System.out.println(s);
        System.out.println(s2);
    }

    public static String queryFileRealName(File dcContext, String fileName) {
        File filePath = new File(dcContext.getPath());        //获取其file对象
        File[] fs = filePath.listFiles();    //遍历path下的文件和目录，放在File数组中
        // 判断该文件目录下是否存在PDF或者OFD生成的。存在则直接获取该文件名
        //遍历File[]数组
        for (File f : fs) {
            if (!f.isDirectory()) {
                String s1 = f.toString();
                System.out.println("#文件路径#:" + s1);
                //   if (s1.endsWith("ofd") || s1.endsWith("pdf")) { s1.contains(dcContext.getFileName().replace(".png", ".ofd")) ||
                String replaceName = fileName.replace("_999.png", "").replace("_1.png", "");
                System.out.println("#替换路径#:" + replaceName);
                if ((s1.endsWith(".pdf") || s1.endsWith(".PDF")) && s1.contains(replaceName)) {
                    return f.getName();
                }
            }
        }
        return null;
    }
}
