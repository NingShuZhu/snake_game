package pkg;


class MyThread extends Thread
{
    public MyFrame myFrame;

    public MyThread(MyFrame frame){
        this.myFrame = frame;
    }

    @Override
    public void run()
    {
        super.run();
        while (true)
        {
            myFrame.repaint();
            try
            {
                sleep(30);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}