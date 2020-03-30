package rdp.common.security;

import static org.junit.Assert.*;

public class Md5Test {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void encrypt() {
        System.out.println(Md5.encrypt());
    }
}