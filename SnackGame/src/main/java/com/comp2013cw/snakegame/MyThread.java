//package com.comp2013cw.snakegame;
//
//
//class MyThread extends Thread
//{
//    public MyWindow myWindow;
//
//    public MyThread(MyWindow frame){
//        this.myWindow = frame;
//    }
//
//    @Override
//    public void run()
//    {
//        super.run();
//        while (true)
//        {
//            myWindow.repaint();
//            try
//            {
//                sleep(30);
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//}