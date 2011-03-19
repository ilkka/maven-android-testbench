package com.ilkka;

import com.xtremelabs.robolectric.*;

import org.junit.*;
import org.junit.runner.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsEqual.*;

import static org.mockito.Mockito.*;

import android.net.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.message.*;
import org.apache.http.*;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

	@Test
	public void trueShouldNotBeFalse() throws Exception {
		AndroidHttpClient mockClient = mock(AndroidHttpClient.class);
		when(mockClient.execute(new HttpGet("http://www.example.com/"))).thenReturn(new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1), 200, "OK"));
		assertEquals(new String("x").charAt(0), 'x');
	}
}
