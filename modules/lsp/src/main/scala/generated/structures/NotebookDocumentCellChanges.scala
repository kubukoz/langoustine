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

/** Cell changes to a notebook document.
  *
  * @since 3.18.0
  *
  * @param structure
  *   Changes to the cell structure to add or remove cells.
  *
  * @param data
  *   Changes to notebook cells properties like its kind, execution summary or
  *   metadata.
  *
  * @param textContent
  *   Changes to the text content of notebook cells.
  */
case class NotebookDocumentCellChanges(
    structure: Option[structures.NotebookDocumentCellChangeStructure] = None,
    data: Option[Vector[structures.NotebookCell]] = None,
    textContent: Option[Vector[structures.NotebookDocumentCellContentChanges]] =
      None
)
object NotebookDocumentCellChanges
    extends codecs.structures_NotebookDocumentCellChangesCodec
