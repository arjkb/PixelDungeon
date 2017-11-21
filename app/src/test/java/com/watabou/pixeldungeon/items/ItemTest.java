package com.watabou.pixeldungeon.items;

import com.watabou.pixeldungeon.actors.hero.Hero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by arjun on 21/11/17.
 */
public class ItemTest {
    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_actions() throws Exception {
        ArrayList<String> actionList = item.actions(new Hero());

        assertTrue(actionList.contains(Item.AC_DROP));
        assertTrue(actionList.contains(Item.AC_THROW));
        assertEquals(2, actionList.size());
    }

}