package com.orchid0809.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by orchid0809 on 2018/9/12.
 */
public class NIOServer {

    private int port;

    private SocketAddress socketAddress;

    private Selector selector;

    public NIOServer(int port) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

         this.socketAddress = new InetSocketAddress(this.port);

        serverSocketChannel.bind(this.socketAddress);
        serverSocketChannel.configureBlocking(false);

         this.selector = Selector.open();

        serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);

    }

    public void listener() throws IOException {

        while (true){
            int wait = this.selector.select();
            if(wait == 0){
                continue;
            }
            Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                selectionKeys.remove(selectionKey);
                process(selectionKey);
            }
        }
    }

    private void process(SelectionKey selectionKey) {

        if(selectionKey.isReadable()){

        }else  if(selectionKey.isWritable()){

        }
    }


    public static void main(String[] args) {

    }
}
