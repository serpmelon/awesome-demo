package com.togo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * @author : taiyn
 * Date    : 2020/12/24
 * Time    : 9:23 下午
 * ---------------------------------------
 * Desc    :
 */
public class HelloServerDemo {
    public static final int SERVER_PORT = 9099;

    public void startServer() {
        try {
            System.out.println("server start ....");
            TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server happened error!!!");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloServerDemo server = new HelloServerDemo();
        server.startServer();
    }
}