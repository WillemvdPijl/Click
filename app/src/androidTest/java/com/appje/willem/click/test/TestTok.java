package com.appje.willem.click.test;

import android.test.AndroidTestCase;

import com.appje.willem.click.MainActivity;

import org.junit.Test;

/**
 * Created by Willem on 22/12/2016.
 */
public class TestTok extends AndroidTestCase {

    MainActivity TestMainActivity= new MainActivity();

    @Test
    private void TestTok() throws Throwable{

        TestMainActivity.Tok();

    }

    @Test
    private void TestWegTok() throws Throwable{

        TestMainActivity.Tok();
    }

}
