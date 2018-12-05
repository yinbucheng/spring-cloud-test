package cn.intellif.springnettyclient.handler.in;

import cn.intellif.springnettyclient.utils.ChannelUtils;
import cn.intellif.springnettyclient.utils.PrintNettyDirectMemory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class StringLineInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("recive msg from service:"+msg);
//        Thread.sleep(1000);
        ctx.writeAndFlush("hi , i have recived your msg ");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(".................channnelActive.....");
        ctx.writeAndFlush("nice good ");
//        ChannelUtils.getInstance().addChannel(ctx.channel());
//        ChannelUtils.getInstance().batchSendMsg();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    try {
//                        Thread.sleep(4000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    PrintNettyDirectMemory.printDirectMemory();
//                }
//            }
//        });
//        thread.start();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println(">>>>>>>>>>>>>>>>>>>>channelInactive......");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exceptionCaught");
        super.exceptionCaught(ctx, cause);
    }
}
