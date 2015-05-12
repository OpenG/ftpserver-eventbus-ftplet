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

public class FtpEvent {

    private final FtpSession session;
    private final FtpRequest request;

    public FtpEvent(FtpSession session, FtpRequest request) {
        this.session = session;
        this.request = request;
    }

    public FtpSession getSession() {
        return session;
    }

    public FtpRequest getRequest() {
        return request;
    }
}
