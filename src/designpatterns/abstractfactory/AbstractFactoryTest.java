/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: AbstractFactoryTest
 * Author:   Jianf
 * Date:     2020/7/31 22:42
 * Description: 抽象工厂模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.abstractfactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈抽象工厂模式〉
 *
 * @author Jianf
 * @create 2020/7/31
 * @since 1.0.0
 */
public class AbstractFactoryTest {
    /**
     * 场景：开发一个数据库接口，mysql,oracle....
     * 连接connection,command...
     *
     */

    public static void main(String[] args) {

        //业务流程
        IDatabaseUtils iDatabaseUtils = new OracleDataBaseUtils();
        IConnection connection=iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();

    }

}

//定义接口规范，多个接口
//连接接口
interface IConnection{
    void connect();
}

//命令接口
interface ICommand{
    void command();
}

//数据库接口，数据库接口可以获取连接对象和命令对象
interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}



//MySQL的支持
class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connected...");
    }
}

class MysqlCommand implements ICommand{
    @Override
    public void command() {
        System.out.println("mysql command...");
    }
}

//mysql接口
class MysqlDataBaseUtils implements IDatabaseUtils{
    @Override
    public IConnection getConnection() {

        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


//对Oracle的支持
class OracleConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println("oracle connect...");
    }
}

class OracleCommand implements ICommand{
    @Override
    public void command() {
        System.out.println("oracle command...");
    }
}

class OracleDataBaseUtils implements IDatabaseUtils{
    @Override
    public IConnection getConnection() {

        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}

