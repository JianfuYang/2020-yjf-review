/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: BuilderTest
 * Author:   Jianf
 * Date:     2020/8/1 17:37
 * Description: 建造者模式示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.builder.v2;

/**
 * 〈一句话功能简述〉<br> 
 * 〈建造者模式示例〉
 *
 * @author Jianf
 * @create 2020/8/1
 * @since 1.0.0
 */
public class BuilderTest2 {
    public static void main(String[] args) {

        Product product= new Product.Builder().productName("xxxname").commpanyName("xxxcommpany").part1("xxx1").part2("xxx2").part3("xxx3").part4("xxx4").build();
        System.out.println(product);

    }
}





class Product{

    private final String productName;
    private final String commpanyName;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;
    //....


    public Product(String productName, String commpanyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.commpanyName = commpanyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    //通过静态内部类
    static class Builder{
        private  String productName;
        private  String commpanyName;
        private  String part1;
        private  String part2;
        private  String part3;
        private  String part4;

        //让对象每次都返回自己，以实现链式调用
        public Builder productName(String productName){
            this.productName = productName;
            return this;
        }
        public Builder commpanyName(String commpanyName){
            this.commpanyName = commpanyName;
            return this;
        }
        public Builder part1(String part1){
            this.part1 = part1;
            return this;
        }
        public Builder part2(String part2){
            this.part2 = part2;
            return this;
        }
        public Builder part3(String part3){
            this.part3 = part3;
            return this;
        }
        public Builder part4(String part4){
            this.part4 = part4;
            return this;
        }

        //对象构建
        Product build(){
            Product product = new Product(this.productName,this.commpanyName,this.part1,this.part2,this.part3,this.part4);
            return product;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", commpanyName='" + commpanyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}

