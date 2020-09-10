/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Server
 * Author:   Jianf
 * Date:     2020/9/2 9:41
 * Description: 服务端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jwfy.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务端〉
 *
 * @author Jianf
 * @create 2020/9/2
 * @since 1.0.0
 */
public class Server {

    public void run(int port) throws InterruptedException {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //根据换行符拆分
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            //反序列化
                            ch.pipeline().addLast(new StringDecoder());
                            //具体的业务处理
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    });
            ChannelFuture cf = serverBootstrap.bind(port).sync();
            cf.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Server().run(10002);
    }

}