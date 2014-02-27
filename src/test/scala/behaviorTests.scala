package edu.luc.cs.cs372.expressionsAlgebraic

import org.scalatest.FunSuite
import scalaz.syntax.equal._
import scalaz.std.anyVal._ // for assert_=== to work on Int

class behaviorTests extends FunSuite {

  import scalamu.ToMuOps
  import behaviors._

  test("evaluate works") {
    fixtures.complex1 cata evaluate assert_=== -1
    fixtures.complex2 cata evaluate assert_=== 0
  }

  test("size works") {
    fixtures.complex1 cata size assert_=== 9
    fixtures.complex2 cata size assert_=== 10
  }

  test("depth works") {
    fixtures.complex1 cata depth assert_=== 4
    fixtures.complex2 cata depth assert_=== 5
  }

  test("equality works") {
    import structures._
    import structures.ExprFactory._
    (Constant(3): ExprF[Int]) assert_=== (Constant(3): ExprF[Int])
    constant(3) assert_=== constant(3)
    uminus(constant(3)) assert_=== uminus(constant(3))
  }
}