package com.watabou.pixeldungeon.actors.blobs;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.buffs.Awareness;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Hunger;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Poison;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.levels.traps.LightningTrap;
import com.watabou.pixeldungeon.sprites.HeroSprite;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dell Owner on 11/26/2017.
 */
public class WellWaterTest {
    private static Hero hero;
    private static Dungeon dungeon;
    private static Awareness awareness;
    @Before
    public void setUp() throws Exception {
        dungeon = new Dungeon();
        hero = new Hero();
        awareness = new Awareness();
    }

    @Test
    public void waterOfAwarenessTest() {
        WaterOfAwareness water = new WaterOfAwareness();
        water.seed(1,1);
        assert(water.affectHero(hero));
        //awareness duration should be length 2
        assertEquals(awareness.DURATION, 2, 0.0);
    }

    @Test
    public void waterOfHealthTest(){
        WaterOfHealth water = new WaterOfHealth();
        //give the hero a low health
        hero.HP = 1;
        water.affectHero(hero);
        //The hero's health shall be more than one now that they drank the water
        assertTrue(hero.HP > 1);
    }
}