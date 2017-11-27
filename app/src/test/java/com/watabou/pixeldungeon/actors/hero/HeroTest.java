package com.watabou.pixeldungeon.actors.hero;

import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Shadows;
import com.watabou.pixeldungeon.items.rings.Ring;
import com.watabou.pixeldungeon.items.rings.RingOfShadows;
import com.watabou.pixeldungeon.items.weapon.missiles.Dart;
import com.watabou.pixeldungeon.levels.traps.LightningTrap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Austin Short on 11/26/2017.
 */
public class HeroTest {

    @Test
    public void TestHeroRest(){
        Hero hero = new Hero();
        //The hero's health is not full
        hero.restoreHealth = false;
        //the hero rests untill healthy
        hero.rest(true);
        //The hero shall have restored health after resting
        assertEquals(hero.restoreHealth, true);
    }

    @Test
    public void TestHeroDamage(){
        Hero hero = new Hero();
        //restore the hero's health
        hero.restoreHealth = true;
        int originalHP = hero.HP;
        //hurt the hero with lightning
        hero.damage(10, LightningTrap.LIGHTNING);
        assertEquals(originalHP-10, hero.HP);
        //their health should no longer be restored
        assertFalse(hero.restoreHealth);
    }

    @Test
    public void TestStealth(){
        Hero hero = new Hero();
        int stealth = hero.stealth();
        //Initial stealth should be zero
        assertEquals(stealth, 0);

        //We give the hero the ring of shadows
        hero.belongings.ring1 = new RingOfShadows();
        hero.belongings.ring1.activate( hero );

        //The hero's stealth goes up by one with the ring
        stealth = hero.stealth();
        assertEquals(stealth, 1);
    }

    @Test
    public void TestDeath(){
        Hero hero = new Hero();
        //The hero is alive at first
        assertTrue(hero.isAlive());
        //critical damage to the hero
        hero.damage(hero.HP,LightningTrap.LIGHTNING);
        //The hero should be dead after the critical hit
        assertFalse(hero.isAlive());
    }

    @Test
    public void TestNegativeDamage(){
        Hero hero = new Hero();
        int originalHP = hero.HP;
        hero.damage(-10, LightningTrap.LIGHTNING);
        assertTrue(hero.HP <= originalHP);
    }

}