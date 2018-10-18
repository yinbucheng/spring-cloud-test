package cn.intellif.springnettyserver.handler.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class HandlerMsg3OutHandler extends ChannelOutboundHandlerAdapter {


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>HandlerMsg3Out   "+msg);
       ctx.writeAndFlush(msg);
    }
}
