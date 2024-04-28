package com.yzm.structure.adapter.combineadapter;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
