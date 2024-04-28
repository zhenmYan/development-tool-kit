package com.yzm.structure.adapter.combineadapter;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
