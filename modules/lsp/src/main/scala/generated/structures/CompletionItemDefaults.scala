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

/** In many cases the items of an actual completion result share the same value
  * for properties like `commitCharacters` or the range of a text edit. A
  * completion list can therefore define item defaults which will be used if a
  * completion item itself doesn't specify the value.
  *
  * If a completion list specifies a default value and a completion item also
  * specifies a corresponding value, the rules for combining these are defined
  * by `applyKinds` (if the client supports it), defaulting to
  * ApplyKind.Replace.
  *
  * Servers are only allowed to return default values if the client signals
  * support for this via the `completionList.itemDefaults` capability.
  *
  * @since 3.17.0
  *
  * @param commitCharacters
  *   A default commit character set.
  *
  * since 3.17.0
  *
  * @param editRange
  *   A default edit range.
  *
  * since 3.17.0
  *
  * @param insertTextFormat
  *   A default insert text format.
  *
  * since 3.17.0
  *
  * @param insertTextMode
  *   A default insert text mode.
  *
  * since 3.17.0
  *
  * @param data
  *   A default data value.
  *
  * since 3.17.0
  */
case class CompletionItemDefaults(
    commitCharacters: Option[Vector[String]] = None,
    editRange: Option[
      (structures.Range | structures.EditRangeWithInsertReplace)
    ] = None,
    insertTextFormat: Option[enumerations.InsertTextFormat] = None,
    insertTextMode: Option[enumerations.InsertTextMode] = None,
    data: Option[io.circe.Json] = None
)
object CompletionItemDefaults
    extends codecs.structures_CompletionItemDefaultsCodec
