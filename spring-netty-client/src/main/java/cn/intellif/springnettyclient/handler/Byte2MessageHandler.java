package cn.intellif.springnettyclient.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.LinkedList;
import java.util.List;

public class Byte2MessageHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>进入到 Byte2Message中");
       //这里我们认为 \n为结束符
        byteBuf.markReaderIndex();
        List<Byte> buf = new LinkedList<>();
        int len = byteBuf.writerIndex()-byteBuf.readerIndex();
        int i=0;
        boolean flag = false;
        while(i<len){
            i++;
            byte data = byteBuf.readByte();
            if(data==10){
                flag = true;
                break;
            }
            buf.add(data);
        }
        if(flag){
            int size = buf.size();
            byte[] result = new byte[size];
            for( i=0;i<size;i++){
                result[i]=buf.get(i);
            }
            list.add(new String(result));
        }else{
            byteBuf.resetReaderIndex();
        }
    }


}
