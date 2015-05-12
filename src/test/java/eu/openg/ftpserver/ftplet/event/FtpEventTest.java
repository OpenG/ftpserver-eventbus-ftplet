/*
 * Copyright 2015 OpenG (Atvira Karta, LLC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.openg.ftpserver.ftplet.event;

import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class FtpEventTest {

    @Test
    public void shouldHaveASession() {
        FtpSession session = mock(FtpSession.class);
        final FtpEvent event = new FtpEvent(session, null);
        assertThat(event.getSession(), is(instanceOf(FtpSession.class)));
        assertThat(event.getSession(), is(equalTo(session)));
    }

    @Test
    public void shouldHaveARequest() {
        FtpRequest request = mock(FtpRequest.class);
        final FtpEvent event = new FtpEvent(null, request);
        assertThat(event.getRequest(), is(instanceOf(FtpRequest.class)));
        assertThat(event.getRequest(), is(equalTo(request)));
    }
}
