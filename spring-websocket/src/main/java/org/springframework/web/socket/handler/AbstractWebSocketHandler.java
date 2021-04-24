/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.socket.handler;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * A convenient base class for {@link WebSocketHandler} implementation with empty methods.
 *
 * @author Rossen Stoyanchev
 * @author Phillip Webb
 * @since 4.0
 */
public abstract class AbstractWebSocketHandler implements WebSocketHandler {

	/** 连接建立后置处理 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	}

	/** */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message instanceof TextMessage) {
			handleTextMessage(session, (TextMessage) message);
		}
		else if (message instanceof BinaryMessage) {
			handleBinaryMessage(session, (BinaryMessage) message);
		}
		else if (message instanceof PongMessage) {
			handlePongMessage(session, (PongMessage) message);
		}
		else {
			throw new IllegalStateException("Unexpected WebSocket message type: " + message);
		}
	}

	/** 处理文本消息 */
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}

	/** 处理二进制消息 */
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
	}

	/** 处理心跳消息 */
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
	}

	/** 处理传输层错误 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	}

	/** 连接关闭后置处理 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}

	/** 是否支持部分消息 */
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
