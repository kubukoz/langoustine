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

/** Represents a collection of {@link CompletionItem completion items} to be
  * presented in the editor.
  *
  * @param isIncomplete
  *   This list it not complete. Further typing results in recomputing this
  *   list.
  *
  * Recomputed lists have all their items replaced (not appended) in the
  * incomplete completion sessions.
  *
  * @param itemDefaults
  *   In many cases the items of an actual completion result share the same
  *   value for properties like `commitCharacters` or the range of a text edit.
  *   A completion list can therefore define item defaults which will be used if
  *   a completion item itself doesn't specify the value.
  *
  * If a completion list specifies a default value and a completion item also
  * specifies a corresponding value, the rules for combining these are defined
  * by `applyKinds` (if the client supports it), defaulting to
  * ApplyKind.Replace.
  *
  * Servers are only allowed to return default values if the client signals
  * support for this via the `completionList.itemDefaults` capability.
  *
  * since 3.17.0
  *
  * @param applyKind
  *   Specifies how fields from a completion item should be combined with those
  *   from `completionList.itemDefaults`.
  *
  * If unspecified, all fields will be treated as ApplyKind.Replace.
  *
  * If a field's value is ApplyKind.Replace, the value from a completion item
  * (if provided and not `null`) will always be used instead of the value from
  * `completionItem.itemDefaults`.
  *
  * If a field's value is ApplyKind.Merge, the values will be merged using the
  * rules defined against each field below.
  *
  * Servers are only allowed to return `applyKind` if the client signals support
  * for this via the `completionList.applyKindSupport` capability.
  *
  * since 3.18.0
  *
  * @param items
  *   The completion items.
  */
case class CompletionList(
    isIncomplete: Boolean,
    itemDefaults: Option[structures.CompletionItemDefaults] = None,
    applyKind: Option[structures.CompletionItemApplyKinds] = None,
    items: Vector[structures.CompletionItem]
)
object CompletionList extends codecs.structures_CompletionListCodec
