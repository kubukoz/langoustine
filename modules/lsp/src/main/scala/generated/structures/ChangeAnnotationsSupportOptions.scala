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

/** @since 3.18.0
  *
  * @param groupsOnLabel
  *   Whether the client groups edits with equal labels into tree nodes, for
  *   instance all edits labelled with "Changes in Strings" would be a tree
  *   node.
  */
case class ChangeAnnotationsSupportOptions(
    groupsOnLabel: Option[Boolean] = None
)
object ChangeAnnotationsSupportOptions
    extends codecs.structures_ChangeAnnotationsSupportOptionsCodec
