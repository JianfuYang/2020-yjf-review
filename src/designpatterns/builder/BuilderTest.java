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
package designpatterns.builder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈建造者模式示例〉
 *
 * @author Jianf
 * @create 2020/8/1
 * @since 1.0.0
 */
public class BuilderTest {
    public static void main(String[] args) {

        //建造者模式创建对象；后续需要创建其他的产品时，只需要创建其他的建造者并作为参数传入指导者就行
        ProductBuilder productBuilder = new DefaultConcreteProductBuilder();
        //创建指导者来指导创建
        Director director = new Director(productBuilder);
        Product product = director.makeProduct("productName", "companyName", "part1", "part2", "part3", "part4");
        System.out.println(product);

    }
}


//构建者抽象接口
interface ProductBuilder{
    void buildProductName(String productName);
    void buildcommpanyName(String commpanyName);
    void buildpart1(String part1);
    void buildpart2(String part2);
    void buildpart3(String part3);
    void buildpart4(String part4);
    //.....
    //定义一个创建最终对象的方法
    Product build();
}


//默认的创建创建者，可以有其他创建者
class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String commpanyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildcommpanyName(String commpanyName) {
        this.commpanyName = commpanyName;
    }

    @Override
    public void buildpart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildpart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void buildpart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void buildpart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.commpanyName,this.part1,this.part2,this.part3,this.part4);
    }
}


//指导者
class Director{
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }


    public Product makeProduct(String productName, String commpanyName, String part1, String part2, String part3, String part4){
        builder.buildProductName(productName);
        builder.buildcommpanyName(commpanyName);
        builder.buildpart1(part1);
        builder.buildpart2(part2);
        builder.buildpart3(part3);
        builder.buildpart4(part4);

        Product product = builder.build();
        return product;
    }
}



class Product{

    private String productName;
    private String commpanyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    //....

    public Product(){

    }

    public Product(String productName, String commpanyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.commpanyName = commpanyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCommpanyName() {
        return commpanyName;
    }

    public void setCommpanyName(String commpanyName) {
        this.commpanyName = commpanyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
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

