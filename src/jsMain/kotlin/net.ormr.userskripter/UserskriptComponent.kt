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

package net.ormr.userskripter

import org.kodein.di.DI
import org.kodein.di.instance

public abstract class UserskriptComponent : UserskriptAwareDI {
    final override val di: DI get() = super.di

    public val userskript: Userskript<*, *> by instance()

    public val userskriptId: String by instance(tag = "userskriptId")
}