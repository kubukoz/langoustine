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

/** Describes the currently selected completion item.
  *
  * @since 3.18.0
  *
  * @param range
  *   The range that will be replaced if this completion item is accepted.
  *
  * @param text
  *   The text the range will be replaced with if this completion is accepted.
  */
case class SelectedCompletionInfo(
    range: structures.Range,
    text: String
)
object SelectedCompletionInfo
    extends codecs.structures_SelectedCompletionInfoCodec
