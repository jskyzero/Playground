#lang scheme
(define (GCD a b )
  (if (= b 0)
      a
      (GCD b (remainder a b))))
(GCD 15 3)