package cn.intellif.springnettyserver.handler.in;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HandlerMsg3InHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>HandlerMsg3In "+msg);
        // 通知执行下一个InboundHandler
        ctx.fireChannelRead(msg);
        Thread.sleep(5000);
        ctx.writeAndFlush("ha \n");
    }


}
