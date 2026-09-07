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

/** An inline completion item represents a text snippet that is proposed inline
  * to complete text that is being typed.
  *
  * @since 3.18.0
  *
  * @param insertText
  *   The text to replace the range with. Must be set.
  *
  * @param filterText
  *   A text that is used to decide if this inline completion should be shown.
  *   When `falsy` the {@link InlineCompletionItem.insertText} is used.
  *
  * @param range
  *   The range to replace. Must begin and end on the same line.
  *
  * @param command
  *   An optional {@link Command} that is executed *after* inserting this
  *   completion.
  */
case class InlineCompletionItem(
    insertText: (String | structures.StringValue),
    filterText: Option[String] = None,
    range: Option[structures.Range] = None,
    command: Option[structures.Command] = None
)
object InlineCompletionItem extends codecs.structures_InlineCompletionItemCodec
