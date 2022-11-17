/*
 * Copyright 2022 Oliver Berg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ormr.userskripter.engine.tampermonkey

import kotlinx.coroutines.await
import net.ormr.userskripter.engine.ScriptEngineTamperMonkey
import net.ormr.userskripter.engine.greasemonkey.GrantGMSetClipboard
import net.ormr.userskripter.engine.greasemonkey.GrantGMXmlHttpRequest
import net.ormr.userskripter.js.UnsafeJs
import net.ormr.userskripter.js.jsObject

// we can't define this in 'TMInfo.Script' because @JsName("run-at") is invalid
public inline val TMInfo.ScriptMetadata.runAt: String
    get() = this.asDynamic()["run-at"].unsafeCast<String>()

@GrantTMGetTab
@GrantTMSaveTab
@ScriptEngineTamperMonkey
// TODO: check if this actually works like it should
public suspend inline fun TamperMonkey.mutateTabObject(scope: dynamic.() -> Unit) {
    val tabObject = getTabObject().await()
    scope(tabObject)
    saveTabObject(tabObject).await()
}

@OptIn(UnsafeJs::class)
@GrantGMSetClipboard
@ScriptEngineTamperMonkey
public suspend inline fun TamperMonkey.setClipboard(data: String, builder: TMClipboardInfo.() -> Unit) {
    setClipboard(data, jsObject(builder)).await()
}

@OptIn(UnsafeJs::class)
@GrantGMXmlHttpRequest
@ScriptEngineTamperMonkey
public suspend inline fun TamperMonkey.xmlHttpRequest(
    builder: TMXmlHttpRequestDetails<Nothing?>.() -> Unit,
): TMXmlHttpRequestResponse<Nothing?> = xmlHttpRequest(jsObject(builder)).await()

@OptIn(UnsafeJs::class)
@GrantGMXmlHttpRequest
@ScriptEngineTamperMonkey
public suspend inline fun <C> TamperMonkey.xmlHttpRequest(
    builder: TMXmlHttpRequestDetails<C>.() -> Unit,
): TMXmlHttpRequestResponse<C> = xmlHttpRequest(jsObject(builder)).await()