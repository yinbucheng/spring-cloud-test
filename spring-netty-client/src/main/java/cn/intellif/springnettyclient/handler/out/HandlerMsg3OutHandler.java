package cn.intellif.springnettyclient.handler.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class HandlerMsg3OutHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>进入到 HandlerMsg3Out.....");
//        super.write(ctx, msg, promise);
        ctx.writeAndFlush(msg);
    }
}
