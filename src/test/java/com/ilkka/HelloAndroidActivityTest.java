package com.ilkka;

import com.xtremelabs.robolectric.*;

import org.junit.*;
import org.junit.runner.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.IsNull.*;

import static org.mockito.Mockito.*;

import android.net.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.message.*;
import org.apache.http.*;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

	@Test
	public void shouldGetStuffFromInternet() throws Exception {
		AndroidHttpClient mockClient = mock(AndroidHttpClient.class);
		when(mockClient.execute(any(HttpGet.class))).thenReturn(new BasicHttpResponse(new ProtocolVersion("HTTP", 1, 1), 200, "OK"));

		HelloAndroidActivity activity = new HelloAndroidActivity();
		activity.setHttpClient(mockClient);
		activity.onCreate(null);

		verify(mockClient).execute(any(HttpUriRequest.class));
		assertThat(activity.response(), notNullValue());
		assertEquals(activity.response().getStatusLine().getStatusCode(), 200);
	}
}
