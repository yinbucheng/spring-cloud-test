package cn.intellif.springnettyclient;

import cn.intellif.springnettyclient.handler.Byte2MessageHandler;
import cn.intellif.springnettyclient.handler.Msg2ByteHandler;
import cn.intellif.springnettyclient.handler.in.HandlerMsg2InHandler;
import cn.intellif.springnettyclient.handler.in.HandlerMsg3InHandler;
import cn.intellif.springnettyclient.handler.in.StringLineInHandler;
import cn.intellif.springnettyclient.handler.out.HandlerMsg2OutHandler;
import cn.intellif.springnettyclient.handler.out.HandlerMsg3OutHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
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
public class NettyClientListener  implements InitializingBean{
    @Autowired
    private NettyConfig config;
    private EventLoopGroup worker = new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            bootstrap.group(worker)//
                    .channel(NioSocketChannel.class)//
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                            ChannelPipeline pipeline = nioSocketChannel.pipeline();
                            pipeline.addLast(new Byte2MessageHandler());
                            pipeline.addLast(new HandlerMsg2InHandler());
                            pipeline.addLast(new HandlerMsg3InHandler());
                            pipeline.addFirst(new HandlerMsg3OutHandler());
                            pipeline.addFirst(new HandlerMsg2OutHandler());
                            pipeline.addFirst(new Msg2ByteHandler());
//                            pipeline.addLast(new StringEncoder());
//                            pipeline.addLast(new LineEncoder());
//                            pipeline.addLast(new LineBasedFrameDecoder(1024));
//                            pipeline.addLast(new StringDecoder());
//                            pipeline.addLast(new StringLineInHandler());


                        }
                    });
            System.out.println(".....................客户端已经连接上来了......"+config.getIp()+"  "+config.getPort());
            ChannelFuture sync = bootstrap.connect(config.getIp(), config.getPort()).sync();
            sync.channel().closeFuture();
        }catch (Exception e){
            worker.shutdownGracefully();
        }
    }


    @PreDestroy
    public void close(){
        worker.shutdownGracefully();
    }
}
