package com.shurrik.action;

import com.shurrik.utils.FileHelper;

import java.io.File;

/**
 * Created by lip on 2015-12-18.
 */
public class MvnDependencyAction {
    public static void main(String[] args) {

        String filePath = MvnDependencyAction.class.getClassLoader().getResource("").getPath();

        String content = FileHelper.readFileByLines(filePath+File.separator+"mvndependency.txt");
        System.out.println(content);
        content = content.replaceAll(" ","").replaceAll("\t","");
        String[] arr = content.split(",");
        for(String str:arr)
        {
//            System.out.println(str);
            System.out.println(render(str));
        }
    }
    public static String render(String str)
    {
        str = str.replaceAll("\"","");

        String[] arr = str.split(":");

        String groupId = arr[1];
        String artifactId = arr[2];
        String version = arr[0];

        if(arr[0].contains("-"))
        {
            version = arr[0].split("-")[0];
        }
        version = "${"+version+".versions}";

        String tpl = "\t\t\t<dependency>\n" +
                "\t\t\t\t<groupId>"+groupId+"</groupId>\n" +
                "\t\t\t\t<artifactId>"+artifactId+"</artifactId>\n" +
                "\t\t\t\t<version>"+version+"</version>\n" +
                "\t\t\t</dependency>";
        return tpl;
    }
}
