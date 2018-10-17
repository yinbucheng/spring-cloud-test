package cn.intellif.springnettyclient.handler.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class HandlerMsg2OutHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>进入到HandlerMsg2Out........");
        super.write(ctx, msg, promise);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("hello word \n good hahah \n");
        Thread.sleep(100);
        ctx.writeAndFlush("this is test,");
        Thread.sleep(3000);
        ctx.writeAndFlush(",this content is big hahahha,");
        ctx.writeAndFlush(" test for message end \n");
    }
}
