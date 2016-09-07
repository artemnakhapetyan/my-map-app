/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acdc.my.map.app.utils.spatial;

import java.util.Random;

/**
 *
 * @author acdc
 */
public class RandomUtils {

    public static double myRandom(double min, double max) {
         double diff = max - min;
        return min + Math.random( ) * diff;
    }
    
    /*public static void main(String[] args){
        
        System.out.println(myRandom(44.61269, 44.98640));
        
    }*/

}
