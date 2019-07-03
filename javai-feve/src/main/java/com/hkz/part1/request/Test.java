package com.hkz.part1.request;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:46
 */
public class Test {
    PrintRequestProcessor printRequestProcessor;
    public Test(){
        SaveRequestProcessor saveRequestProcessor = new SaveRequestProcessor();
        saveRequestProcessor.start();
        printRequestProcessor = new PrintRequestProcessor(saveRequestProcessor);
        printRequestProcessor.start();
    }
    public static void main(String[] args) {
        Request request = new Request();
        request.setName("hkz");
        new Test().doTest(request);
    }

    private void doTest(Request request) {
        for (int i = 0; i< 10; i++){
            printRequestProcessor.processRequest(request);
        }
    }
}
