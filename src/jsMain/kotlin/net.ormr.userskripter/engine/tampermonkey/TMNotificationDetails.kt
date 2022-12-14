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

public external interface TMNotificationDetails {
    public var text: String
    public var title: String?
    public var image: String?
    public var highlight: Boolean

    @JsName("silent")
    public var isSilent: Boolean
    public var timeout: Double

    @JsName("ondone")
    public var onDone: (() -> Unit)?

    @JsName("onclick")
    public var onClick: (() -> Unit)?
}