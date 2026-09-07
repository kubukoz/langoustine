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

/** Completion client capabilities
  *
  * @param dynamicRegistration
  *   Whether completion supports dynamic registration.
  *
  * @param completionItem
  *   The client supports the following `CompletionItem` specific capabilities.
  *
  * @param completionItemKind
  *   The client supports the following completion item kinds.
  *
  * @param insertTextMode
  *   Defines how the client handles whitespace and indentation when accepting a
  *   completion item that uses multi line text in either `insertText` or
  *   `textEdit`.
  *
  * since 3.17.0
  *
  * @param contextSupport
  *   The client supports to send additional context information for a
  *   `textDocument/completion` request.
  *
  * @param completionList
  *   The client supports the following `CompletionList` specific capabilities.
  *
  * since 3.17.0
  */
case class CompletionClientCapabilities(
    dynamicRegistration: Option[Boolean] = None,
    completionItem: Option[structures.ClientCompletionItemOptions] = None,
    completionItemKind: Option[structures.ClientCompletionItemOptionsKind] =
      None,
    insertTextMode: Option[enumerations.InsertTextMode] = None,
    contextSupport: Option[Boolean] = None,
    completionList: Option[structures.CompletionListCapabilities] = None
)
object CompletionClientCapabilities
    extends codecs.structures_CompletionClientCapabilitiesCodec
