package cn.intellif.springnettyserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Msg2ByteHandler extends MessageToByteEncoder{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>msg2byte encode");
        String msg = (String) o;
        byte[] temps = msg.getBytes();
        byteBuf.writeBytes(temps);
//        channelHandlerContext.writeAndFlush(temps);
    }


}
