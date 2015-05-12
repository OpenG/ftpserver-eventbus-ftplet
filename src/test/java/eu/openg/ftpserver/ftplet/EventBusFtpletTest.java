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

package eu.openg.ftpserver.ftplet;

import eu.openg.ftpserver.FtpServerEventBus;
import eu.openg.ftpserver.ftplet.event.RenameEndEvent;
import eu.openg.ftpserver.ftplet.event.UploadEndEvent;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventBusFtpletTest {

    private FtpSession session;
    private FtpRequest request;
    private FtpServerEventBus eventBus;
    private EventBusFtplet ftplet;

    @Before
    public void setUp() throws Exception {
        session = mock(FtpSession.class);
        request = mock(FtpRequest.class);
        eventBus = mock(FtpServerEventBus.class);
        ftplet = new EventBusFtplet(eventBus);
    }

    @Test
    public void shouldImplementFtplet() {
        assertThat(new EventBusFtplet(null), is(instanceOf(Ftplet.class)));
    }

    @Test
    public void onUploadEndShouldPublishUploadEndEvent() throws FtpException, IOException {
        ftplet.onUploadEnd(session, request);
        verify(eventBus).publish(new UploadEndEvent(session, request));
    }

    @Test
    public void onRenameEndShouldPublishRenameEndEvent() throws FtpException, IOException {
        ftplet.onRenameEnd(session, request);
        verify(eventBus).publish(new RenameEndEvent(session, request));
    }
}
