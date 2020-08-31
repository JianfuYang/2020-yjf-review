/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: MyClassLoader
 * Author:   Jianf
 * Date:     2020/8/31 8:58
 * Description: 自定义类加载器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义类加载器〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
public class MyClassLoader extends ClassLoader{
    //指定路径
    private String path;

    public MyClassLoader(String classPath){
        path = classPath;
    }

    /**
     * 重写findClass方法
     * @param name 这个类的全路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class log = null;
        //获取该class文件字节码数组
        byte[] classData = getData();

        if(classData != null){
            //将class的字节码数组转换成Class类的实例
            log = defineClass(name,classData,0,classData.length);
            System.out.println("使用自定义类加载器...");
        }
        return log;
    }

    /**
     * 将class文件转化为字节码数组
     * 在getData里面可以做很多事情，比如加密解密之类都是可以的
     * @return
     */
    private byte[] getData(){
        File file = new File(path);
        if(file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try{
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int size = 0;
                while((size=in.read(buffer))!= -1){
                    out.write(buffer,0,size);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }
    }

}