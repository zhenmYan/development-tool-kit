package com.yzm.found.builder;

/**
 * description: 这是构建者模式的一种扩展类型
 *
 *          链式的对对象进行属性的赋值
 *
 *          lombok的@Builder注解
 *
 *          优点是可读性高
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Phone {

    private String name;
    private String price;
    private String screen;

    private Phone(Builder builder){
        this.name = builder.name;
        this.price = builder.price;
        this.screen = builder.screen;
    }

    public static final class Builder{

        private String name;
        private String price;
        private String screen;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder price(String price){
            this.price = price;
            return this;
        }

        public Builder screen(String screen){
            this.screen = screen;
            return this;
        }

        public Phone build(){
            this.screen = screen;
            return new Phone(this);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setScreen(String screen) {
            this.screen = screen;
        }

    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", screen='" + screen + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Phone phone = new Builder()
                .name("华为")
                .price("6499")
                .screen("曲面屏")
                .build();

        System.out.println(phone.toString());
    }
}
