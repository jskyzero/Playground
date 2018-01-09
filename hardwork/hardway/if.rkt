#lang scheme
(define (abs x )
  (if (< x 0)
      (- x)
      x))
(abs 1)
(abs (- 1))
(abs 0)