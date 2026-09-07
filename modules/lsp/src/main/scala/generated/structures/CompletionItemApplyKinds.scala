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

/** Specifies how fields from a completion item should be combined with those
  * from `completionList.itemDefaults`.
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
  * @since 3.18.0
  *
  * @param commitCharacters
  *   Specifies whether commitCharacters on a completion will replace or be
  *   merged with those in `completionList.itemDefaults.commitCharacters`.
  *
  * If ApplyKind.Replace, the commit characters from the completion item will
  * always be used unless not provided, in which case those from
  * `completionList.itemDefaults.commitCharacters` will be used. An empty list
  * can be used if a completion item does not have any commit characters and
  * also should not use those from
  * `completionList.itemDefaults.commitCharacters`.
  *
  * If ApplyKind.Merge the commitCharacters for the completion will be the union
  * of all values in both `completionList.itemDefaults.commitCharacters` and the
  * completion's own `commitCharacters`.
  *
  * since 3.18.0
  *
  * @param data
  *   Specifies whether the `data` field on a completion will replace or be
  *   merged with data from `completionList.itemDefaults.data`.
  *
  * If ApplyKind.Replace, the data from the completion item will be used if
  * provided (and not `null`), otherwise `completionList.itemDefaults.data` will
  * be used. An empty object can be used if a completion item does not have any
  * data but also should not use the value from
  * `completionList.itemDefaults.data`.
  *
  * If ApplyKind.Merge, a shallow merge will be performed between
  * `completionList.itemDefaults.data` and the completion's own data using the
  * following rules:
  *
  *   - If a completion's `data` field is not provided (or `null`), the entire
  *     `data` field from `completionList.itemDefaults.data` will be used as-is.
  *   - If a completion's `data` field is provided, each field will overwrite
  *     the field of the same name in `completionList.itemDefaults.data` but no
  *     merging of nested fields within that value will occur.
  *
  * since 3.18.0
  */
case class CompletionItemApplyKinds(
    commitCharacters: Option[enumerations.ApplyKind] = None,
    data: Option[enumerations.ApplyKind] = None
)
object CompletionItemApplyKinds
    extends codecs.structures_CompletionItemApplyKindsCodec
