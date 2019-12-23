package com.example.practiceexampleforwipro;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.practiceexampleforwipro.utils.CommonDataUtility;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NetworkCheckTest {

    @Test
    public void networkStatusReturnsboolen(){
        boolean value =  CommonDataUtility.isConnected(InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertEquals(true,value);
    }

}
