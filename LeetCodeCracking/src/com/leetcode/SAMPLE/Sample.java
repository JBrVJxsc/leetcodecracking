package com.leetcode.SAMPLE;

import com.leetcode.base.Parameter;
import com.leetcode.interfaces.IAlgorithm;
import com.leetcode.onlinejudge.BaseAlgorithm;

import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Who on 2014/5/23.
 */
public class Sample extends BaseAlgorithm implements IAlgorithm {

    @Override
    public long getID() {
        //Get new ID by running the Common Commands. It is in the bottom of the combobox when running the project.
        //Bigger ID, topper in the combobox.
        return Long.MIN_VALUE + 1;
    }

    @Override
    public String getName() {
        //This name will be shown in the combobox.
        return "Sample Name";
    }

    @Override
    public String getSummary() {
        //This summary will be shown in the console area of the main form.
        return "Sample Summary";
    }

    @Override
    public void run() {
        //Every algorithm runs in this method.

        //Print everything you want to print, by using only one method: print;
        //Show a message box, by using method: show.
        show("Print String.");
        print("Print everything you want to print.");
        //Print Object.
        Object object = new Object() {
            @Override
            public String toString() {
                return "Print me, I am an object.";
            }
        };
        show("Print Object.");
        print(object);
        //Print Array.
        int[] array = new int[10];
        show("Print Array.");
        print(array);
        //Print ArrayList.
        ArrayList<Point> arrayList = new ArrayList<Point>();
        arrayList.add(new Point(123, 321) {
            @Override
            public String toString() {
                return x + ", " + y;
            }
        });
        arrayList.add(new Point(1234, 3210) {
            @Override
            public String toString() {
                return x + ", " + y;
            }
        });
        show("Print ArrayList.");
        print(arrayList);
        //Print \n.
        print();

        //Asking for a run-time parameter setting, by using method: set.
        int defaultNumber = 999;
        String defaultName = "Xu ZHANG";
        Parameter<Integer> integerParameter = new Parameter<Integer>(defaultNumber, "Number");
        Parameter<String> stringParameter = new Parameter<String>(defaultName, "Name");
        //Show the parameter setting form.
        show("Set Number.");
        set(integerParameter);
        //Use the parameter by their getValue method.
        print("You typed in:\n" + integerParameter.getValue());
        show("Set Name.");
        set(stringParameter);
        print("You typed in:\n" + stringParameter.getValue());

        print();
        //Set timer. Timer bases on the stack, so you can nest the timer in another timer scope.
        //Set timer on.
        show("Test timer.");
        timerOn();
        timerOn();
        timerOn();
        //Set timer off.
        print("3 th Timer off. Time has past " + timerOff() + " ms.");
        print("2 th Timer off. Time has past " + timerOff() + " ms.");
        print("1 th Timer off. Time has past " + timerOff() + " ms.");
    }
}