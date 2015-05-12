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
import eu.openg.ftpserver.ftplet.event.FtpEvent;
import org.apache.ftpserver.ftplet.*;

import java.io.IOException;

import static org.apache.ftpserver.ftplet.FtpletResult.DEFAULT;

public class EventBusFtplet extends DefaultFtplet {

    private final FtpServerEventBus eventBus;

    public EventBusFtplet(FtpServerEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public FtpletResult onUploadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        eventBus.publish(new FtpEvent(session, request));
        return DEFAULT;
    }
}
