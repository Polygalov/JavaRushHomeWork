package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Andy on 16.06.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state;
        state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState())
            {

                state = thread.getState();
                System.out.println(thread.getState());
            }
        }
    }
}

