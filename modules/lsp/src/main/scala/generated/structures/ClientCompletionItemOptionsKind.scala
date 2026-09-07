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

/** @since 3.18.0
  *
  * @param valueSet
  *   The completion item kind values the client supports. When this property
  *   exists the client also guarantees that it will handle values outside its
  *   set gracefully and falls back to a default value when unknown.
  *
  * If this property is not present the client only supports the completion
  * items kinds from `Text` to `Reference` as defined in the initial version of
  * the protocol.
  */
case class ClientCompletionItemOptionsKind(
    valueSet: Option[Vector[enumerations.CompletionItemKind]] = None
)
object ClientCompletionItemOptionsKind
    extends codecs.structures_ClientCompletionItemOptionsKindCodec
