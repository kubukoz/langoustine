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
  * @param snippetSupport
  *   Client supports snippets as insert text.
  *
  * A snippet can define tab stops and placeholders with `$1`, `$2` and
  * `${3:foo}`. `$0` defines the final tab stop, it defaults to the end of the
  * snippet. Placeholders with equal identifiers are linked, that is typing in
  * one will update others too.
  *
  * @param commitCharactersSupport
  *   Client supports commit characters on a completion item.
  *
  * @param documentationFormat
  *   Client supports the following content formats for the documentation
  *   property. The order describes the preferred format of the client.
  *
  * @param deprecatedSupport
  *   Client supports the deprecated property on a completion item.
  *
  * @param preselectSupport
  *   Client supports the preselect property on a completion item.
  *
  * @param tagSupport
  *   Client supports the tag property on a completion item. Clients supporting
  *   tags have to handle unknown tags gracefully. Clients especially need to
  *   preserve unknown tags when sending a completion item back to the server in
  *   a resolve call.
  *
  * since 3.15.0
  *
  * @param insertReplaceSupport
  *   Client support insert replace edit to control different behavior if a
  *   completion item is inserted in the text or should replace text.
  *
  * since 3.16.0
  *
  * @param resolveSupport
  *   Indicates which properties a client can resolve lazily on a completion
  *   item. Before version 3.16.0 only the predefined properties `documentation`
  *   and `details` could be resolved lazily.
  *
  * since 3.16.0
  *
  * @param insertTextModeSupport
  *   The client supports the `insertTextMode` property on a completion item to
  *   override the whitespace handling mode as defined by the client (see
  *   `insertTextMode`).
  *
  * since 3.16.0
  *
  * @param labelDetailsSupport
  *   The client has support for completion item label details (see also
  *   `CompletionItemLabelDetails`).
  *
  * since 3.17.0
  */
case class ClientCompletionItemOptions(
    snippetSupport: Option[Boolean] = None,
    commitCharactersSupport: Option[Boolean] = None,
    documentationFormat: Option[Vector[enumerations.MarkupKind]] = None,
    deprecatedSupport: Option[Boolean] = None,
    preselectSupport: Option[Boolean] = None,
    tagSupport: Option[structures.CompletionItemTagOptions] = None,
    insertReplaceSupport: Option[Boolean] = None,
    resolveSupport: Option[structures.ClientCompletionItemResolveOptions] =
      None,
    insertTextModeSupport: Option[
      structures.ClientCompletionItemInsertTextModeOptions
    ] = None,
    labelDetailsSupport: Option[Boolean] = None
)
object ClientCompletionItemOptions
    extends codecs.structures_ClientCompletionItemOptionsCodec
