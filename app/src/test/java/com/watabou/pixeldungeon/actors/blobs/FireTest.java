package com.watabou.pixeldungeon.actors.blobs;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Burning;
import com.watabou.pixeldungeon.actors.hero.Hero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Austin Short on 11/26/2017.
 */
public class FireTest {
    private static Hero hero;
    private static Dungeon dungeon;
    private static Fire fire;
    @Before
    public void setUp() throws Exception {
        fire = new Fire();
        dungeon = new Dungeon();
        hero = new Hero();
        dungeon.hero = hero;
        dungeon.hero.pos = 1;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fireTest() {
        //put the fire in the same location as the hero
        fire.seed(1,1);
        Buff.affect( hero, Burning.class ).reignite( hero );
        assertTrue(hero.buffs().toArray()[0] instanceof Burning);
    }

}