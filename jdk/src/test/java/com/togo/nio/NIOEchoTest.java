package com.togo.nio;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : taiyn
 * Date    : 2021/2/9
 * Time    : 10:28 上午
 * ---------------------------------------
 * Desc    :
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NIOEchoTest {

    Process server;
    NIOEchoClient client;

    @BeforeAll
    public void setup() throws IOException {

        server = NIOEchoServer.start();
        client = NIOEchoClient.start();
    }

    @Test
    public void givenServerClient_whenServerEchosMessage_thenCorrect() {

        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
    }

    @AfterAll
    public void teardown() throws IOException {

        server.destroy();
        NIOEchoClient.stop();
    }
}