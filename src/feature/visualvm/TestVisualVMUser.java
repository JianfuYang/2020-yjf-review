/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: TestVisualVMUser
 * Author:   Jianf
 * Date:     2020/8/29 11:20
 * Description: VisualVM测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.visualvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈VisualVM测试〉
 *
 * @author Jianf
 * @create 2020/8/29
 * @since 1.0.0
 */


public class TestVisualVMUser {
    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num)throws InterruptedException{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i=0;i>=0;i++){
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}

