package com.watabou.pixeldungeon.actors.blobs;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Vertigo;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.levels.Level;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Austin Short on 11/26/2017.
 */
public class ParalyticGasTest {
    public static Hero hero;
    public static Dungeon dungeon;
    public static ParalyticGas gas;
    public static Paralysis paralysis;
    @Before
    public void setUp() throws Exception {
        gas = new ParalyticGas();
        dungeon = new Dungeon();
        hero = new Hero();
        dungeon.hero = hero;
        dungeon.hero.pos = 1;

        paralysis = new Paralysis();
    }

    @Test
    public void paryliticGasTest() {
        //put the gas in the location of the hero
        gas.seed(1,1);
        //place the gas at the location of the hero
        float dur = paralysis.duration(hero);
        //Duration of the confusion should be 10
        assertEquals(10, dur, 0.0);
    }


}