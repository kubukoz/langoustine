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

/** Result of the `workspace/textDocumentContent` request.
  *
  * @since 3.18.0
  *
  * @param text
  *   The text content of the text document. Please note, that the content of
  *   any subsequent open notifications for the text document might differ from
  *   the returned content due to whitespace and line ending normalizations done
  *   on the client
  */
case class TextDocumentContentResult(
    text: String
)
object TextDocumentContentResult
    extends codecs.structures_TextDocumentContentResultCodec
