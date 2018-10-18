package cn.intellif.springnettyclient.handler.in;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class StringLineInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("recive msg from service:"+msg);
        Thread.sleep(1000);
        ctx.writeAndFlush("hi , i have recived your msg ");
    }
}
