package com.yzm.structure.adapter.combineadapter;

/**
 * ##### 设计模式 design patterns 适配器代理
 *
 *      1、应用场景
 *          - 接口不兼容
 *              - 老系统存在能用的类，但与新系统接口不一致
 *              - 使用第三方组件，但接口定义与自己要求的不一致
 *
 *      2、分类
 *          - 类适配器模式
 *              - 继承方式，耦合度高
 *          - 对象适配器模式
 *              - 组合或聚合方式，耦合度低
 *
 *      3、与代理的比较
 *          - 相同点
 *              - 都要实现目标类相同的接口
 *              - 都要声明目标对象
 *              - 都要在不修改目标类的基础上增强目标方法
 *          - 不同点
 *              - 目的不同
 *                  - 装饰器模式是为了增强
 *                  - 代理是为了影藏和保护目标对象
 *
 * @author yzm
 * @date 2024/4/28
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

}
