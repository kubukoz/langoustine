package tests.lsp

import langoustine.lsp.all.*
import langoustine.lsp.runtime.uinteger

object CustomEnumValuesTest extends weaver.FunSuite:
  // Enumerations the spec marks with `supportsCustomValues` must be
  // constructible outside the set of values the specification defines --
  // peers are allowed to send such values over the wire.
  //
  // The underlying value is checked by round-tripping through the JSON
  // codecs, since `raw` is an lsp-internal extension.

  private def encoded[A: io.circe.Encoder](a: A) =
    io.circe.Encoder[A].apply(a)

  test("string enum accepts custom values") {
    val custom = CodeActionKind("mytool.fixAll")

    expect.same(io.circe.Json.fromString("mytool.fixAll"), encoded(custom)) and
      expect(!CodeActionKind.ALL.contains(custom))
  }

  test("predefined entries are still listed in ALL") {
    expect(CodeActionKind.ALL.contains(CodeActionKind.QuickFix)) and
      expect(CodeActionKind.ALL.contains(CodeActionKind.SourceFixAll)) and
      expect(SemanticTokenTypes.ALL.contains(SemanticTokenTypes.variable))
  }

  test("custom value round-trips through JSON") {
    val custom = CodeActionKind("mytool.fixAll")

    expect.same(
      Right(custom),
      io.circe.Decoder[CodeActionKind].decodeJson(encoded(custom))
    )
  }

  test("int enum accepts custom values") {
    expect.same(io.circe.Json.fromInt(-32099), encoded(ErrorCodes(-32099)))
  }

  test("uinteger enum accepts custom values") {
    expect.same(io.circe.Json.fromInt(7), encoded(WatchKind(uinteger(7))))
  }
end CustomEnumValuesTest
