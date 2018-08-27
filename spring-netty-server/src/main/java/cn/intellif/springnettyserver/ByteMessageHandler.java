package cn.intellif.springnettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.LinkedList;
import java.util.List;

public class ByteMessageHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>进入到 Byte2Message中");
       //这里我们认为 \n为结束符
        byteBuf.markReaderIndex();
        List<Byte> buf = new LinkedList<>();
        //获取实际的包的大小
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
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>发现未完整的包.....");
            byteBuf.resetReaderIndex();
        }
    }
}
