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

/** A document filter denotes a document by different properties like the
  * {@link TextDocument.languageId language}, the {@link Uri.scheme scheme} of
  * its resource, or a glob-pattern that is applied to the
  * {@link TextDocument.fileName path}.
  *
  * Glob patterns can have the following syntax:
  *   - `*` to match zero or more characters in a path segment
  *   - `?` to match on one character in a path segment
  *   - `**` to match any number of path segments, including none
  *   - `{}` to group sub patterns into an OR expression. (e.g. `**​.{ts,js}`
  *     matches all TypeScript and JavaScript files)
  *   - `[]` to declare a range of characters to match in a path segment (e.g.,
  *     `example.[0-9]` to match on `example.0`, `example.1`, …)
  *   - `[!...]` to negate a range of characters to match in a path segment
  *     (e.g., `example.[!0-9]` to match on `example.a`, `example.b`, but not
  *     `example.0`)
  *
  * @sample
  *   A language filter that applies to typescript files on disk:
  *   `{ language: 'typescript', scheme: 'file' }`
  * @sample
  *   A language filter that applies to all package.json paths:
  *   `{ language: 'json', pattern: '**package.json' }`
  *
  * @since 3.17.0
  */
opaque type TextDocumentFilter =
  (structures.TextDocumentFilterLanguage | structures.TextDocumentFilterScheme |
    structures.TextDocumentFilterPattern)
object TextDocumentFilter extends codecs.aliases_TextDocumentFilter:
  inline def apply(
      v: structures.TextDocumentFilterLanguage
  ): TextDocumentFilter = v
  inline def apply(v: structures.TextDocumentFilterScheme): TextDocumentFilter =
    v
  inline def apply(
      v: structures.TextDocumentFilterPattern
  ): TextDocumentFilter = v

  extension (v: TextDocumentFilter)
    inline def value: (structures.TextDocumentFilterLanguage |
      structures.TextDocumentFilterScheme |
      structures.TextDocumentFilterPattern) = v

  given Typeable[TextDocumentFilter] with
    def unapply(s: Any): Option[s.type & TextDocumentFilter] =
      s match
        case c: structures.TextDocumentFilterLanguage =>
          Some(c.asInstanceOf[s.type & structures.TextDocumentFilterLanguage])
        case c: structures.TextDocumentFilterScheme =>
          Some(c.asInstanceOf[s.type & structures.TextDocumentFilterScheme])
        case c: structures.TextDocumentFilterPattern =>
          Some(c.asInstanceOf[s.type & structures.TextDocumentFilterPattern])
        case _ => Option.empty
  end given
end TextDocumentFilter
