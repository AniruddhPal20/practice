package com.example.practiceexampleforwipro;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.practiceexampleforwipro.utils.Helper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NetworkCheckTest {

    @Test
    public void networkStatusReturnsboolen(){
        boolean value =  Helper.isConnected(InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertEquals(true,value);
    }

}
