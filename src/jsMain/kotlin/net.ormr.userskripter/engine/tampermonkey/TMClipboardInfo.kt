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

import net.ormr.userskripter.js.UnsafeJs
import net.ormr.userskripter.js.jsObject

public external interface TMClipboardInfo {
    public var type: String

    @JsName("mimetype")
    public var mimeType: String
}

@OptIn(UnsafeJs::class)
public fun TMClipboardInfo(type: String, mimeType: String): TMClipboardInfo = jsObject {
    this.type = type
    this.mimeType = mimeType
}