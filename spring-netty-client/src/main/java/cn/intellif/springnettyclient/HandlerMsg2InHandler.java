package cn.intellif.springnettyclient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HandlerMsg2InHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>HandlerMsage2In....."+msg);
        // 通知执行下一个InboundHandler
        ctx.fireChannelRead(msg);
    }
}
