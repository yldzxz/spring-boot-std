package com.hkz.part1.request;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:34
 */
public class PrintRequestProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    private final RequestProcessor nextRequestProcessor;

    public PrintRequestProcessor(RequestProcessor nextRequestProcessor) {
        this.nextRequestProcessor = nextRequestProcessor;
    }

    @Override
    public void run() {
        while(true){
            try {
                Request request = requests.take();
                System.out.println("print request " + request.getName());
                nextRequestProcessor.processRequest(request);
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
