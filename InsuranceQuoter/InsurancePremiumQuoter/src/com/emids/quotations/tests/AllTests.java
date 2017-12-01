package com.emids.quotations.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Shekhar Arya
 * 
 * Runs all Unit tests as a test suite
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CharacteristicsTest.class, HabitsTest.class, HealthTest.class })
public class AllTests {

}
