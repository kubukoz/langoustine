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

/** A notebook document filter where `pattern` is required field.
  *
  * @since 3.18.0
  *
  * @param notebookType
  *   The type of the enclosing notebook.
  *
  * @param scheme
  *   A Uri {@link Uri.scheme scheme}, like `file` or `untitled`.
  *
  * @param pattern
  *   A glob pattern.
  */
case class NotebookDocumentFilterPattern(
    notebookType: Option[String] = None,
    scheme: Option[String] = None,
    pattern: aliases.GlobPattern
)
object NotebookDocumentFilterPattern
    extends codecs.structures_NotebookDocumentFilterPatternCodec
