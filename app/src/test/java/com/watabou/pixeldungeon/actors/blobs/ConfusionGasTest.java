package com.watabou.pixeldungeon.actors.blobs;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Vertigo;
import com.watabou.pixeldungeon.actors.hero.Hero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Austin Short on 11/26/2017.
 */
public class ConfusionGasTest {
    private static Hero hero;
    private static Dungeon dungeon;
    private static ConfusionGas gas;
    private static Vertigo vertigo;
    @Before
    public void setUp() throws Exception {
        gas = new ConfusionGas();
        dungeon = new Dungeon();
        hero = new Hero();
        dungeon.hero = hero;
        dungeon.hero.pos = 1;
        vertigo = new Vertigo();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConfusionGasVertigoAffect() {
        //place the gas at the location of the hero
        gas.seed(1,1);
        float dur = vertigo.duration(hero);
        //Duration of the confusion should be 10
        assertEquals(10, dur, 0.0);
    }

}