/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: ChainOfResponsibilityTest
 * Author:   Jianf
 * Date:     2020/8/19 11:36
 * Description: 责任链模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.responsibility;


/**
 * 〈一句话功能简述〉<br> 
 * 〈责任链模式〉
 *
 * @author Jianf
 * @create 2020/8/19
 * @since 1.0.0
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        //测试示例
        //构造请求
        Request request = new Request.RequestBuilder().frequentOk(false).loggedOn(true).build();
        //构造责任链
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        //测试责任链处理流程、结果
        if(requestFrequentHandler.process(request)){
            System.out.println("正常业务处理...");
        }else{
            System.out.println("访问异常...");
        }
    }
}


//定义一个请求包装类
class Request{
    //模拟一些请求验证操作
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containSensitiveWords;
    private String requestBody;

    private Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containSensitiveWords = containSensitiveWords;
    }

    //使用建造者模式创建对象
    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn){
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk){
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits){
            this.isPermits = isPermits;
            return this;
        }
        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords){
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build(){
            Request request = new Request(loggedOn,frequentOk,isPermits,containsSensitiveWords);
            return request;
        }
     }

     public boolean isLoggedOn(){
        return loggedOn;
     }
     public boolean isFrequentOk(){
        return frequentOk;
     }
     public boolean isPermits(){
        return isPermits;
     }
     public boolean isContainSensitiveWords(){
        return containSensitiveWords;
     }
}

//使用链表形式来实现责任链，责任链抽象
abstract class Handler{
    //责任链的下一个节点
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
    //每个节点都需要处理请求
    abstract boolean process(Request request);
}

//责任链的具体子类
class RequestFrequentHandler extends Handler{
    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        //业务代码
        System.out.println("访问频率控制.");
        if(request.isFrequentOk()){
            //访问正常，传递给责任链的下一个节点
            Handler next = getNext();
            if(null == next){
                return true;
            }
            if(!next.process(request)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}

//登录的处理器
class LoggingHandler extends Handler{
    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证...");
        if(request.isLoggedOn()){
            Handler next = getNext();
            if(null==next){
                return true;
            }
            if(!next.process(request)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}