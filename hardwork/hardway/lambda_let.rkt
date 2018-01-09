#lang racket
(define (f x y)
  (define (square x) (* x x ))
  (let ((a (+ 1 (* x y)))
        (b (- 1 y)))
    (+ (* x (square a))
       (* y b)
       (* a b))))
(f 1 2)