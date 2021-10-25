/*
 * Copyright 2021 Damon Yu
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ly40
 * @version 1.0
 * @since 22/10/2021
 */
public class WebServer {
    private ServerSocket serverSocket;
    private String rootDir;
    private int port;

    public WebServer(String rootDir, int port) {
        this.rootDir = rootDir;
        this.port = port;
    }

    public WebServer() {
        this.rootDir = Configuration.DEFAULT_ROOT_DIRECTORY;
        this.port = Configuration.DEFAULT_PORT;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started ... listening on port " + port + " ...");
            Socket conn = null;
            while (true) {
                // waits until client requests a connection, then returns connection (socket)
                try {
                    conn = serverSocket.accept();
                    conn.setSoTimeout(2000);
                    System.out.println("Server got new connection request from " + conn.getInetAddress());
                } catch (IOException ioe) {
                    System.err.println("IO Exception: " + ioe.getMessage());
                }
                // create new handler for this connection
                ConnectionHandler ch = new ConnectionHandler(conn);
                ch.start(); // start handler thread
            }
        } catch (IOException ioe) {
            System.out.println("Oops " + ioe.getMessage());
        }
    }
}
