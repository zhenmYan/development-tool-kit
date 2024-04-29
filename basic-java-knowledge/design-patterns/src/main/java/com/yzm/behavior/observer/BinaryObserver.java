package com.yzm.behavior.observer;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class BinaryObserver  extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
