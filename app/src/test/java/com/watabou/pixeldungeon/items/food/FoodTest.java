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
        // ensure food objects contain only the 3 expected actions

        ArrayList<String> actionList = food.actions(hero);
        assertTrue(actionList.contains(Food.AC_DROP));
        assertTrue(actionList.contains(Food.AC_THROW));
        assertTrue(actionList.contains(Food.AC_EAT));
        assertEquals(3, actionList.size());
    }

    @Test
    public void test_execute_warrior() throws Exception {
        hero.add(new Hunger());

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

        FoodValues [] foodValues = new FoodValues[11];

        foodValues[0] = new FoodValues(HeroClass.WARRIOR, 100, 200, 105);
        foodValues[1] = new FoodValues(HeroClass.WARRIOR, 100, 101, 101);
        foodValues[2] = new FoodValues(HeroClass.WARRIOR, 100, 104, 104);
        foodValues[3] = new FoodValues(HeroClass.WARRIOR, 100, 105, 105);
        foodValues[4] = new FoodValues(HeroClass.WARRIOR, 100, 106, 105);
        foodValues[5] = new FoodValues(HeroClass.WARRIOR, 100, 90, 100);

//        foodValues[6] = new FoodValues(HeroClass.ROGUE, 100, 200, 100);
//        foodValues[7] = new FoodValues(HeroClass.ROGUE, 100, 104, 100);
//        foodValues[8] = new FoodValues(HeroClass.ROGUE, 100, 105, 100);
//        foodValues[9] = new FoodValues(HeroClass.ROGUE, 100, 106, 100);
//        foodValues[10] = new FoodValues(HeroClass.ROGUE, 100, 90, 100);


        for (FoodValues fv:foodValues)  {
            hero.heroClass = fv.hClass;
            hero.HP = fv.hp;
            hero.HT = fv.ht;

            food.execute(hero, Food.AC_EAT);
            assertEquals(fv.expected, hero.HP);
        }
//        fail("not implemented");
    }

}