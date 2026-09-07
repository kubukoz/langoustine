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
package aliases

import langoustine.*
import runtime.{*, given}
import io.circe.*
import scala.reflect.*

/** An event describing a change to a text document. If only a text is provided
  * it is considered to be the full content of the document.
  */
opaque type TextDocumentContentChangeEvent =
  (structures.TextDocumentContentChangePartial |
    structures.TextDocumentContentChangeWholeDocument)
object TextDocumentContentChangeEvent
    extends codecs.aliases_TextDocumentContentChangeEvent:
  inline def apply(
      v: structures.TextDocumentContentChangePartial
  ): TextDocumentContentChangeEvent = v
  inline def apply(
      v: structures.TextDocumentContentChangeWholeDocument
  ): TextDocumentContentChangeEvent = v

  extension (v: TextDocumentContentChangeEvent)
    inline def value: (structures.TextDocumentContentChangePartial |
      structures.TextDocumentContentChangeWholeDocument) = v

  given Typeable[TextDocumentContentChangeEvent] with
    def unapply(s: Any): Option[s.type & TextDocumentContentChangeEvent] =
      s match
        case c: structures.TextDocumentContentChangePartial =>
          Some(
            c.asInstanceOf[s.type & structures.TextDocumentContentChangePartial]
          )
        case c: structures.TextDocumentContentChangeWholeDocument =>
          Some(
            c.asInstanceOf[
              s.type & structures.TextDocumentContentChangeWholeDocument
            ]
          )
        case _ => Option.empty
  end given
end TextDocumentContentChangeEvent
