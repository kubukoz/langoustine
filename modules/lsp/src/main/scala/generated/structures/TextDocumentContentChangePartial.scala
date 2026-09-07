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
  * @param range
  *   The range of the document that changed.
  *
  * @param rangeLength
  *   The optional length of the range that got replaced.
  *
  * @deprecated
  *   use range instead.
  *
  * @param text
  *   The new text for the provided range.
  */
case class TextDocumentContentChangePartial(
    range: structures.Range,
    rangeLength: Option[runtime.uinteger] = None,
    text: String
)
object TextDocumentContentChangePartial
    extends codecs.structures_TextDocumentContentChangePartialCodec
