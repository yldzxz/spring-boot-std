package com.hkz.part1.request;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:33
 */
public class SaveRequestProcessor extends Thread implements RequestProcessor{
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    @Override
    public void run() {
        while (true){
            try {
                Request request = requests.take();
                System.out.println("save request "+ request.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
