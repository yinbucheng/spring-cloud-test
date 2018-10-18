package cn.intellif.springnettyserver;

import cn.intellif.springnettyserver.handler.Byte2MessageHandler;
import cn.intellif.springnettyserver.handler.Msg2ByteHandler;
import cn.intellif.springnettyserver.handler.in.HandlerMsg2InHandler;
import cn.intellif.springnettyserver.handler.in.HandlerMsg3InHandler;
import cn.intellif.springnettyserver.handler.in.StringLineInHandler;
import cn.intellif.springnettyserver.handler.out.HandlerMsg2OutHandler;
import cn.intellif.springnettyserver.handler.out.HandlerMsg3OutHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.LineEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
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
                            pipeline.addLast(new Byte2MessageHandler());
                            pipeline.addLast(new HandlerMsg2InHandler());
                            pipeline.addLast(new HandlerMsg3InHandler());
                            pipeline.addFirst(new HandlerMsg2OutHandler());
                            pipeline.addFirst(new HandlerMsg3OutHandler());
                            pipeline.addFirst(new Msg2ByteHandler());
//                            pipeline.addLast(new StringEncoder());
//                            pipeline.addLast(new LineEncoder());
//                            pipeline.addLast(new LineBasedFrameDecoder(1024));
//                            pipeline.addLast(new StringDecoder());
//                            pipeline.addLast(new StringLineInHandler());

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
