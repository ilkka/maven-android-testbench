package com.ilkka;

import org.junit.*;
import org.junit.runner.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsEqual.*;

import mockit.*;

import com.xtremelabs.robolectric.*;

import android.net.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.message.*;
import org.apache.http.*;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

	@Mocked AndroidHttpClient mock;

	@Test
	public void trueShouldNotBeFalse() throws Exception {
		new Expectations() {
			{
				mock.execute((HttpUriRequest) any);
				result = new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1), 200, "OK");
			}
		};
		assertEquals(new String("x").charAt(0), 'x');
	}
}
