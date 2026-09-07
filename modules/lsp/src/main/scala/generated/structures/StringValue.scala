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

/** A string value used as a snippet is a template which allows to insert text
  * and to control the editor cursor when insertion happens.
  *
  * A snippet can define tab stops and placeholders with `$1`, `$2` and
  * `${3:foo}`. `$0` defines the final tab stop, it defaults to the end of the
  * snippet. Variables are defined with `$name` and `${name:default value}`.
  *
  * @since 3.18.0
  *
  * @param kind
  *   The kind of string value.
  *
  * @param value
  *   The snippet string.
  */
case class StringValue(
    kind: "snippet",
    value: String
)
object StringValue extends codecs.structures_StringValueCodec
