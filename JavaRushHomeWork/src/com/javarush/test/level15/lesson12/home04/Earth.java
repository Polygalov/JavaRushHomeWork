package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Andy on 13.02.2016.
 */
public class Earth implements Planet{
        private static Earth instance_e;

        private Earth(){}

        public static Earth getInstance(){
            if(instance_e == null){
                instance_e = new Earth();
            }
            return instance_e;
        }
}