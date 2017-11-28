package com.watabou.pixeldungeon.actors.blobs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun on 19/11/17.
 */
public class BlobTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBlobShapes()    {
        Blob testBlob = new Blob();
        //Create the blob at cell 1
        testBlob.seed(1,1);
        //This blob should be size 1
        assertEquals(testBlob.volume,1);
        //Clear the blob
        testBlob.clear(1);
        //the blob should now be gone
        assertEquals(testBlob.volume,0);
        //We should not be able to create a blob of size -1
        testBlob.seed(1,-1);
        assertEquals(testBlob.volume,0);
    }
}