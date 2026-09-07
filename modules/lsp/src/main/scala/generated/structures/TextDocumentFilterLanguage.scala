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

/** A document filter where `language` is required field.
  *
  * @since 3.18.0
  *
  * @param language
  *   A language id, like `typescript`.
  *
  * @param scheme
  *   A Uri {@link Uri.scheme scheme}, like `file` or `untitled`.
  *
  * @param pattern
  *   A glob pattern, like **​.{ts,js}. See TextDocumentFilter for examples.
  *
  * since 3.18.0 - support for relative patterns. Whether clients support
  * relative patterns depends on the client capability
  * `textDocuments.filters.relativePatternSupport`.
  */
case class TextDocumentFilterLanguage(
    language: String,
    scheme: Option[String] = None,
    pattern: Option[aliases.GlobPattern] = None
)
object TextDocumentFilterLanguage
    extends codecs.structures_TextDocumentFilterLanguageCodec
