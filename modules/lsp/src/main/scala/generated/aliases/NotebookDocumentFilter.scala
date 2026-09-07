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

/** A notebook document filter denotes a notebook document by different
  * properties. The properties will be match against the notebook's URI (same as
  * with documents)
  *
  * @since 3.17.0
  */
opaque type NotebookDocumentFilter =
  (structures.NotebookDocumentFilterNotebookType |
    structures.NotebookDocumentFilterScheme |
    structures.NotebookDocumentFilterPattern)
object NotebookDocumentFilter extends codecs.aliases_NotebookDocumentFilter:
  inline def apply(
      v: structures.NotebookDocumentFilterNotebookType
  ): NotebookDocumentFilter = v
  inline def apply(
      v: structures.NotebookDocumentFilterScheme
  ): NotebookDocumentFilter = v
  inline def apply(
      v: structures.NotebookDocumentFilterPattern
  ): NotebookDocumentFilter = v

  extension (v: NotebookDocumentFilter)
    inline def value: (structures.NotebookDocumentFilterNotebookType |
      structures.NotebookDocumentFilterScheme |
      structures.NotebookDocumentFilterPattern) = v

  given Typeable[NotebookDocumentFilter] with
    def unapply(s: Any): Option[s.type & NotebookDocumentFilter] =
      s match
        case c: structures.NotebookDocumentFilterNotebookType =>
          Some(
            c.asInstanceOf[
              s.type & structures.NotebookDocumentFilterNotebookType
            ]
          )
        case c: structures.NotebookDocumentFilterScheme =>
          Some(c.asInstanceOf[s.type & structures.NotebookDocumentFilterScheme])
        case c: structures.NotebookDocumentFilterPattern =>
          Some(
            c.asInstanceOf[s.type & structures.NotebookDocumentFilterPattern]
          )
        case _ => Option.empty
  end given
end NotebookDocumentFilter
