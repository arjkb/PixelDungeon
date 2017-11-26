package com.watabou.pixeldungeon.items.food;

import com.watabou.pixeldungeon.actors.hero.Hero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by arjun on 25/11/17.
 */
public class FoodTest {

    Hero hero;
    Food food;

    @Before
    public void setUp() throws Exception {
        hero = new Hero();
        food = new Food();
    }

    @After
    public void tearDown() throws Exception {
        hero = null;
        food = null;
    }

    @Test
    public void test_actions() throws Exception {
        // ensure food objects contain only the 3 expected actions

        ArrayList<String> actionList = food.actions(hero);
        assertTrue(actionList.contains(Food.AC_DROP));
        assertTrue(actionList.contains(Food.AC_THROW));
        assertTrue(actionList.contains(Food.AC_EAT));
        assertEquals(3, actionList.size());
    }

    @Test
    public void execute() throws Exception {
    }

}