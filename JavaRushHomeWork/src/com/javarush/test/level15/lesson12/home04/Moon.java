package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Andy on 13.02.2016.
 */
public class Moon implements Planet{
        private static Moon instance_m;

        private Moon(){}

        public static Moon getInstance(){
            if(instance_m == null){
                instance_m = new Moon();
            }
            return instance_m;
        }
}