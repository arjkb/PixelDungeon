package com.watabou.pixeldungeon.items.food;

import com.watabou.pixeldungeon.actors.buffs.Hunger;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.actors.hero.HeroClass;

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
        // positive test case -- Arjun Krishna Babu

        // ensure food objects contain only the 3 expected actions

        ArrayList<String> actionList = food.actions(hero);
        assertTrue(actionList.contains(Food.AC_DROP));
        assertTrue(actionList.contains(Food.AC_THROW));
        assertTrue(actionList.contains(Food.AC_EAT));
        assertEquals(3, actionList.size());
    }

    @Test
    public void test_execute_warrior() throws Exception {
        // Positive Test Case -- Arjun Krishna Babu

        // ensure Hero's HP values are as expected after eating food.

        class FoodValues    {
            HeroClass hClass;
            int hp;
            int ht;
            int expected;

            FoodValues(HeroClass heroClass, int hp, int ht, int expected)    {
                this.hClass = heroClass;
                this.hp = hp;
                this.ht = ht;
                this.expected = expected;
            }
        }

        FoodValues [] foodValues = new FoodValues[6];

        foodValues[0] = new FoodValues(HeroClass.WARRIOR, 100, 200, 105);
        foodValues[1] = new FoodValues(HeroClass.WARRIOR, 100, 101, 101);
        foodValues[2] = new FoodValues(HeroClass.WARRIOR, 100, 104, 104);
        foodValues[3] = new FoodValues(HeroClass.WARRIOR, 100, 105, 105);
        foodValues[4] = new FoodValues(HeroClass.WARRIOR, 100, 106, 105);
        foodValues[5] = new FoodValues(HeroClass.WARRIOR, 100, 90, 100);

        for (FoodValues fv:foodValues)  {
            hero.add(new Hunger());

            hero.heroClass = fv.hClass;
            hero.HP = fv.hp;
            hero.HT = fv.ht;

            food.execute(hero, Food.AC_EAT);
            assertEquals(fv.expected, hero.HP);
        }
    }

    @Test
    public void test_execute_9() {
        // positive test case -- Arjun Krishna Babu

        // call Food's execute method multiple times.
        // crashes on 10th attempt

        hero.add(new Hunger());

        hero.heroClass = HeroClass.WARRIOR;
        hero.HP = 100;
        hero.HT = 200;

        for (int i = 0; i < 9; i++)    {
            food.execute(hero, Food.AC_EAT);
        }
    }

    @Test
    public void test_execute_10() {
        // positive test case -- Arjun Krishna Babu

        // call Food's execute method multiple times.
        // crashes on 10th attempt

        hero.add(new Hunger());

        hero.heroClass = HeroClass.WARRIOR;
        hero.HP = 100;
        hero.HT = 200;

        for (int i = 0; i < 10; i++)    {
            food.execute(hero, Food.AC_EAT);
        }
    }

}