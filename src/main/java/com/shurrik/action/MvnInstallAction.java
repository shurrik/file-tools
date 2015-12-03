package com.shurrik.action;

import com.shurrik.utils.FileHelper;

/**
 * Created by crv on 2015-12-01.
 */
public class MvnInstallAction {
    public static void main(String[] args) {
        String content = FileHelper.readFileByLines("d:/lib.txt");
        String[] arr = content.split(",");
        for(String str:arr)
        {
            String[] ar = str.split(":");
            System.out.println(render(ar));
//            for(String a:ar)
//            {
//                System.out.println(a);
//            }
        }
    }

    public static String render(String[] arr)
    {
        String groupId = arr[0];
        String artifactId = arr[1];
        String packaging = arr[2];
        String version = arr[3];
        String uploadPath = "D:\\lib\\";

//        mvn install:install-file -Dfile=D:\lib\asm-4.0.jar -DgroupId=net.sf.json-lib -DartifactId=JxPlatform -Dversion=1.0.0 -Dpackaging=jar
        String tpl = "mvn install:install-file -Dfile="+uploadPath+artifactId+"-"+version+"."+packaging+" -DgroupId="+groupId+" -DartifactId="+artifactId+" -Dversion="+version+" -Dpackaging="+packaging+" -DgeneratePom=true";
        return tpl;
    }
}
