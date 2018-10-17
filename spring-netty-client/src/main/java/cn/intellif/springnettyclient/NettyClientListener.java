package cn.intellif.springnettyclient;

import cn.intellif.springnettyclient.handler.Msg2ByteHandler;
import cn.intellif.springnettyclient.handler.out.HandlerMsg2OutHandler;
import cn.intellif.springnettyclient.handler.out.HandlerMsg3OutHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
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
                            pipeline.addLast(new Msg2ByteHandler());
                            pipeline.addLast(new HandlerMsg2OutHandler());
                            pipeline.addLast(new HandlerMsg3OutHandler());
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
