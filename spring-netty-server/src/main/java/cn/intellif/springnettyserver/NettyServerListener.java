package cn.intellif.springnettyserver;

import cn.intellif.springnettyserver.handler.ByteMessageHandler;
import cn.intellif.springnettyserver.handler.in.HandlerMsg2InHandler;
import cn.intellif.springnettyserver.handler.in.HandlerMsg3InHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class NettyServerListener implements InitializingBean{
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    EventLoopGroup boss = new NioEventLoopGroup();
    EventLoopGroup work = new NioEventLoopGroup();
    @Autowired
    private NettyConfig nettyConfig;


    @PreDestroy
    public void close(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>消耗netty 服务端");
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }


    public void start(){
        try {
            int port = nettyConfig.getPort();
            serverBootstrap.group(boss, work)//
                    .channel(NioServerSocketChannel.class)//
                    .option(ChannelOption.SO_KEEPALIVE, true)//
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                            ChannelPipeline pipeline = nioSocketChannel.pipeline();
                            pipeline.addLast(new ByteMessageHandler());
                            pipeline.addLast(new HandlerMsg2InHandler());
                            pipeline.addLast(new HandlerMsg3InHandler());
                        }
                    });
           ChannelFuture f = serverBootstrap.bind(port).sync();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>服务端netty启动.............."+port);
           f.channel().closeFuture().sync();
        }catch (Exception e){
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}
