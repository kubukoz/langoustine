/*
 * Copyright 2022 Neandertech
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

// format:off
package langoustine.lsp
package structures

import langoustine.*
import runtime.{*, given}

/** The client supports the following `CompletionList` specific capabilities.
  *
  * @since 3.17.0
  *
  * @param itemDefaults
  *   The client supports the following itemDefaults on a completion list.
  *
  * The value lists the supported property names of the
  * `CompletionList.itemDefaults` object. If omitted no properties are
  * supported.
  *
  * since 3.17.0
  *
  * @param applyKindSupport
  *   Specifies whether the client supports `CompletionList.applyKind` to
  *   indicate how supported values from `completionList.itemDefaults` and
  *   `completion` will be combined.
  *
  * If a client supports `applyKind` it must support it for all fields that it
  * supports that are listed in `CompletionList.applyKind`. This means when
  * clients add support for new/future fields in completion items the MUST also
  * support merge for them if those fields are defined in
  * `CompletionList.applyKind`.
  *
  * since 3.18.0
  */
case class CompletionListCapabilities(
    itemDefaults: Option[Vector[String]] = None,
    applyKindSupport: Option[Boolean] = None
)
object CompletionListCapabilities
    extends codecs.structures_CompletionListCapabilitiesCodec
